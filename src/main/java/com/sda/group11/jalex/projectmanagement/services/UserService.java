package com.sda.group11.jalex.projectmanagement.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.group11.jalex.projectmanagement.model.User;
import com.sda.group11.jalex.projectmanagement.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CRUD
    // save
    public User save(User user){
        return userRepository.save(user);

    }

    // findAll
    public List<User> findAll() {
        log.debug("find all users...");
        return userRepository.findAll();
    }

    // findById
    public Optional<User> findByUsername(String id) {
        return userRepository.findByUserName(id);
    }

    // update
    public User update(Long id, User request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        updateFields(request, user);

        return userRepository.save(user);
    }

    private void updateFields(User request, User user) {
        user.setUserName(request.getUserName());
    }

    // delete
    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}
