package com.java._03.library;

import com.java._03.library.domain.Terminal;
import com.java._03.library.domain.User;
import com.java._03.library.domain.User.Type;
import com.java._03.library.repository.InMemoryUserRepository;
import com.java._03.library.repository.UserRepository;
import com.java._03.library.service.UserService;

public class Launcher {

  public static void main(String[] args) {
    System.err.println("Program started");

    Terminal terminal = new Terminal(System.in, System.out);
    UserRepository userRepository = new InMemoryUserRepository();
    prepareUserRepositoryMockData(userRepository);
    UserService userService = new UserService(userRepository);

    User user = login(terminal, userService);
    switch (user.getType()) {
      case ADMIN:
        handleAdmin(terminal, userService, user);
        break;
      case MANAGER:
//        handleManager();
        break;
      case CLIENT:
//        handleClient();
        break;
    }

    System.err.println("Program finished");
  }

  private static void prepareUserRepositoryMockData(UserRepository userRepository) {
    userRepository.save(User.builder().username("admin").password("admin").type(Type.ADMIN).build());
    userRepository.save(User.builder().username("manager").password("manager").type(Type.MANAGER).build());
    userRepository.save(User.builder().username("client").password("client").type(Type.CLIENT).build());
  }

  private static void handleAdmin(Terminal terminal, UserService userService, User admin) {
    terminal.println("Enter to the admin mode...");

    do {
      terminal.println("Please enter the command");
      String[] parts = terminal.readLine().split(" ");
      String command = parts[0].toUpperCase();
      switch (command) {
        case "LIST_USERS":
          terminal.print("List of users: ");
          for (Object user : userService.getUsers()) {
            terminal.println(user);
          }
          break;

        case "ADD_USER":
          String username = parts[1];
          String password = parts[2];
          String type = parts[3];
          User newUser = userService.add(admin, username, password, Type.valueOf(type));
          terminal.println("New user was added " + newUser);
          break;
        case "DELETE_USER":

          long userId = Long.parseLong(parts[1]);
          User deletedUser = userService.delete(admin, userId);
          if (deletedUser == null) {
            terminal.println("Failed to delete user with id: " + userId);
          } else {
            terminal.println("User was deleted: " + deletedUser);
          }
          break;

        case "EXIT":
          terminal.println("Closing admin mode... ");
          return;

        default:
          terminal.println("Unknown command: please try again...");
      }
    } while (true);
  }

  private static User login(Terminal terminal, UserService userService) {
    do {
      terminal.print("Please enter your username: ");
      String username = terminal.readLine();

      terminal.print("Please enter your password: ");
      String password = terminal.readLine();

      User user = userService.authenticate(username, password);
      if (user != null) {
        return user;
      }

      terminal.println("Failed to login, please try again!");
    } while (true);
  }

}
