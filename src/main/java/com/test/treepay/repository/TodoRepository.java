package com.test.treepay.repository;

import com.test.treepay.domain.Todo;
import org.springframework.data.repository.CrudRepository;


public interface TodoRepository extends CrudRepository<Todo, Long> {
}
