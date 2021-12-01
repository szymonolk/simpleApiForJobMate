package com.example.simpleApiForJobMate.repository;

import com.example.simpleApiForJobMate.model.TaskModel;
import com.example.simpleApiForJobMate.model.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    List<TaskModel> findByTaskStatus(TaskStatus status);

}
