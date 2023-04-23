package com.java._03.library.service;

import com.java._03.DynamicArray;
import com.java._03.library.domain.User;
import com.java._03.library.domain.User.Type;
import com.java._03.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;

  public User authenticate(String username, String password) {
    User user = repository.findByUsername(username);
    if (user.getPassword().equals(password)) {
      return user;
    }
    return null;
  }

  public DynamicArray getUsers() {
    return repository.findAll();
  }

  public User add(User admin, String username, String password, Type type) {
    User user = repository.findByUsername(username);
    if(user !=null){
      System.err.println("Admin " + admin + " tried to add dublicate user!");
      return null;
    }
    User newUser = repository.save(User.builder()
        .username(username)
        .password(password)
        .type(type)
        .build());
    System.out.println("Admin " + admin + " added new user " + newUser);

    return newUser;
  }

  public User delete(User admin, long userId) {
    if(admin.getId() == userId){
      System.err.println("admin tried to delete himself" + userId);
      return null;
    }

    User userToBeDeleted = repository.findById(userId);
    if (userToBeDeleted == null){
      System.err.println("Admin try to delete not existing user " + userId);
      return null;
    }
    repository.delete(userToBeDeleted);
    System.err.println("Admin " + admin + " deleted user " + userToBeDeleted);
    return  userToBeDeleted;

  }
}
