package com.lianxun.activititest6;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "activiti")
public class ActivitiController {
	@Autowired
    private ActivitiService service;

    @RequestMapping(value = "start", method = RequestMethod.GET)
    public String start() {
        return service.start();
    }

    @RequestMapping(value = "task", method = RequestMethod.GET)
    public List<TaskRepresentation> getTask(@RequestParam(value = "uid") String uid) {
        List<Task> tasks = service.getTask(uid);
        List<TaskRepresentation> dtos = new ArrayList<>();
        for (Task task : tasks) {
            dtos.add(new TaskRepresentation(task.getId(), task.getName()));
        }
        return dtos;
    }
}
