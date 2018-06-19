package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Override
    List<Task> findAll();
    @Override
    Task save(Task task);
//    @Override
    Optional<Task> findById(Long id);
    @Override
    void delete(Long id);
}

