package com.sda.group11.jalex.projectmanagement.repositories;

import com.sda.group11.jalex.projectmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
