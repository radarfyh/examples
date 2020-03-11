var app=angular.module("myApp",[]);
app.controller("userController",function ($scope,$http) {
    $scope.vacTaskList = [];
    $scope.queryTasks = function () {
        $http.get(
            "/activiti/task?uid=admin"
        ).then(function (response) {
            $scope.vacTaskList = response.data;
            $scope.title = "任务数量为：";
            $scope.number=$scope.vacTaskList.length;
        })
    };
})
