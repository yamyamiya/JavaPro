package de.telran.lesson3.repository_layer.jpa;

import de.telran.lesson3.domain_layer.entity.jpa.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaTaskRepository extends JpaRepository<Task, Integer> {

    @Query(value = "SELECT * FROM task order by id desc limit 5;", nativeQuery = true)
    List<Task> lastFiveTasks();


}
