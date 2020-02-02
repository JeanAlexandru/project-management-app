package com.sda.group11.jalex.projectmanagement.repositories;

import com.sda.group11.jalex.projectmanagement.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
