package ru.kuvaev.freelance.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Integer id;

    @Column(name = "Name")
    String name;

    @Column(name = "Password")
    String password;

//    @ManyToMany(mappedBy = "Tasks") // Отношение многие ко многим, обратная сторона
//    private Set<Task> tasks; // Использование Set для избежания дубликатов

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // mappedBy указывает на поле в классе Task, которое является владельцем связи
    private Set<Task> tasks = new HashSet<>();

}
