package com.lianxun.activititest6;

import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivitiService {
	@Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    public String start() {
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("myProcess");
        return instance.getId();
    }

    public List<Task> getTask(String uid) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(uid).list();
        return tasks;
    }
}
