package com.prathish.helloworld.repository;

import com.prathish.helloworld.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo, Long> {

}
