package com.example.simpleApiForJobMate.controller;

import com.example.simpleApiForJobMate.model.TaskModel;
import com.example.simpleApiForJobMate.model.enums.TaskStatus;
import com.example.simpleApiForJobMate.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/task")
@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("all")
    public List<TaskModel> findAllTasks(){
        return taskService.findAllTasks();
    }

    @PostMapping("create")
    public TaskModel createNewTask(@RequestBody TaskModel taskModel){
        return taskService.createNewTask(taskModel);
    }

    @GetMapping("findbyid/{id}")
    public Optional<TaskModel> findById(@PathVariable Long id){
        return taskService.findById(id);
    }

    @GetMapping("findbystatus/{status}")
    public List<TaskModel> findByStatus(@PathVariable TaskStatus status){
        return taskService.findByStatus(status);
    }

    @DeleteMapping("delete/{id}")
    public String removeById(@PathVariable Long id){
       return taskService.removeById(id);
    }

    @PutMapping("update/{id}")
    public TaskModel updateTask(@RequestBody TaskModel taskModel, @PathVariable Long id){
        return taskService.updateTask(taskModel, id);
    }
}
