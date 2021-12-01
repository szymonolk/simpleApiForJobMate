package com.example.simpleApiForJobMate.service;

import com.example.simpleApiForJobMate.model.TaskModel;
import com.example.simpleApiForJobMate.model.enums.TaskStatus;
import com.example.simpleApiForJobMate.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskModel> findAllTasks(){
        return taskRepository.findAll();
    }

    public TaskModel createNewTask(TaskModel taskModel){
        return taskRepository.save(taskModel);
    }

    public Optional<TaskModel> findById(Long id){
        return taskRepository.findById(id);
    }

    public List<TaskModel> findByStatus(TaskStatus status){
        return taskRepository.findByTaskStatus(status);
    }

    public String removeById(Long id){
        taskRepository.deleteById(id);
        return "Record has been deleted successfully!";
    }

    public TaskModel updateTask(TaskModel taskModel, Long id){
        return taskRepository.save(taskModel);
    }
}
