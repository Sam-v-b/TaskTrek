package com.sam.TaskTrek.repo;

import com.sam.TaskTrek.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo,Long> {
}
