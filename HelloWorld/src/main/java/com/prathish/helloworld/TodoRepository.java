package com.prathish.helloworld;

import com.prathish.helloworld.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface TodoRepository extends JpaRepository<Todo, Long> {

}
