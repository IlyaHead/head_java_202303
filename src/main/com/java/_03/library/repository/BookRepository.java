package _03.library.repository;

import _03.DynamicArray;
import _03.library.domain.Book;

// C - create
// R - read
// U - update
// D - delete
public interface BookRepository {

  Book save(Book book);

  DynamicArray findAll();

  Book findById(long Id);

  Book findByIsbn(String isbn);

  DynamicArray findByTitle(String title);

  DynamicArray findByAuthor(String author);


  void delete(Book book);
}
