package ru.kuvaev.freelance.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    Integer id;

    @Column(name = "Title")
    String title;

    @Column(name = "Discription")
    String bodyDescription; // Исправлено название поля

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "Users", // Имя таблицы связи
//            joinColumns = @JoinColumn(name = "task_id"), // Столбец в User_Tasks, который ссылается на id задачи
//            inverseJoinColumns = @JoinColumn(name = "user_id") // Столбец в User_Tasks, который ссылается на id пользователя
//    )
//    Set<User> users; // Использование Set для избежания дубликатов

    @ManyToOne
    @JoinColumn(name = "user_id") // Указываем столбец, через который происходит связь
    private User user; // Добавляем поле для связи с пользователем

    @Column(name = "Coast")
    String coast;

    @Column(name = "Coast_type")
    String coastType;
}
