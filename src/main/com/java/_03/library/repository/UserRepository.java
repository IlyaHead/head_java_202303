package _03.library.repository;


import _03.DynamicArray;
import _03.library.domain.User;

public interface UserRepository {

  User save(User user);

  DynamicArray findAll();

  User findById(long Id);

  /**
   *
   * @param username to be used for search
   * @return null if user not found or else domain object represents user
   */
  User findByUsername(String username);

  void delete(User user);
}
