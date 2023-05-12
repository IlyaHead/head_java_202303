package _03.library.service;

import _03.DynamicArray;
import _03.library.domain.Book;
import _03.library.domain.User;
import _03.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LibraryService {

  private final BookRepository repository;

  public DynamicArray getBooks() {
    return  repository.findAll();
  }

  public Book addBook(User manager, String isbn, String title, String author, double price, int count) {
    System.err.println("Manager " + manager + " trying to add a new book to the library...");
    Book book = repository.findByIsbn(isbn);
    if(book !=null){
      System.err.println("Manager " + manager + " tried to add duplicate a book");
      return null;
    }
    Book newBook = repository.save(Book.builder()
        .isbn(isbn)
        .title(title)
        .author(author)
        .price(price)
        .count(count)
        .build());
    System.err.println("Manager " + manager + " add a new book: " + newBook);

    return newBook;
  }

  public Book delete(User manager, long bookId) {
    System.err.println("Manager " + manager + " trying to delete a book from library: " + bookId);
    Book bookToBeDeleted = repository.findById(bookId);

    if (bookToBeDeleted == null){
      System.err.println("Cannot find a book with ID: " + bookId);
      return null;
    }

    repository.delete(bookToBeDeleted);
    System.err.println("Manager " + manager + " delete book " + bookToBeDeleted);
    return bookToBeDeleted;
  }
}
