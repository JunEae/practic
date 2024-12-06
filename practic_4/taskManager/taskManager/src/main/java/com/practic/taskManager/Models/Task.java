package com.practic.taskManager.Models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    @JsonBackReference
    private Account account;
    @NotBlank(message = "Название задачи не может быть пустым")
    private String title;
    @NotBlank(message = "Описание задачи не может быть пустым")
    private String body;
    @NotNull(message = "Статус не может быть пустым")
    private Boolean completed;
}