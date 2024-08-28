package ru.kuvaev.freelance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuvaev.freelance.models.Task;

import java.util.List;

@Repository
public interface TaskRepos extends JpaRepository <Task, Integer>{

     List<Task> findByTitle(String title);
}
