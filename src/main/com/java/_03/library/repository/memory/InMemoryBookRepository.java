package _03.library.repository.memory;

import _03.DynamicArray;
import _03.library.domain.Book;
import _03.library.repository.BookRepository;

public class InMemoryBookRepository implements BookRepository {

  private final DynamicArray storage = new DynamicArray();
  private long currentId = 1;


  @Override
  public Book save(Book book) {
    long id = book.getId();
    if (id > 0) {
      Book updateBook = findById(id);
      updateBook.setIsbn(book.getIsbn());
      updateBook.setTitle(book.getTitle());
      updateBook.setAuthor(book.getAuthor());
      updateBook.setYear(book.getYear());
      updateBook.setPrice(book.getPrice());
      updateBook.setCount(book.getCount());
      updateBook.setCount(book.getCount());
      System.err.println("Updated book " + updateBook);
      return book;
    } else {
      book.setId(currentId);
      currentId++;
      storage.add(book);
      return book;
    }
  }

  @Override
  public DynamicArray findAll() {
    return storage;
  }

  @Override
  public Book findById(long id) {
    for (Object userObj : storage) {
      Book user = (Book) userObj;
      if(user.getId() == id){
        return user;
      }
    }
    return null;
  }

  @Override
  public Book findByIsbn(String isbn) {
    for (Object bookObj : storage) {
      Book book = (Book) bookObj;
      if(book.getIsbn().equals(isbn)){
        return book;
      }
    }
    return null;
  }

  @Override
  public DynamicArray findByTitle(String title) {
    DynamicArray result = new DynamicArray();
    for (Object bookObj : storage) {
      Book book = (Book) bookObj;
      if(book.getTitle().equals(title)){
        result.add(book);
      }
    }
    return result;
  }

  @Override
  public DynamicArray findByAuthor(String author) {
    DynamicArray result = new DynamicArray();
    for (Object bookObj : storage) {
      Book book = (Book) bookObj;
      if(book.getAuthor().equals(author)){
        result.add(book);
      }
    }
    return result;
  }

  @Override
  public void delete(Book book) {
   storage.remove(book);
  }
}
