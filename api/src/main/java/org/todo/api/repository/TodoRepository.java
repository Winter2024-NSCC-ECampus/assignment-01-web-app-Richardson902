package org.todo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.todo.api.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
