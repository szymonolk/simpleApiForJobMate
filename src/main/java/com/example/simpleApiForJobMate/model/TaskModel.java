package com.example.simpleApiForJobMate.model;
import com.example.simpleApiForJobMate.model.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy.MM.dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private Date creationDateTime;

    @Setter
    @Size(min = 5, max = 100, message = "Title must be between 10 and 100 characters!")
    private String taskTitle;

    @Setter
    @Size(min = 10, max = 255, message = "Title must be between 10 and 255 characters!")
    private String taskDescription;

    @Setter
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @PrePersist
    protected void onCreate() {
        creationDateTime = new Date();
    }
}
