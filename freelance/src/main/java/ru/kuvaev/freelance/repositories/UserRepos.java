package ru.kuvaev.freelance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuvaev.freelance.models.User;

import java.util.List;

@Repository
public interface UserRepos extends JpaRepository<User, Integer> {
    List<User> findByName(String name);
}
