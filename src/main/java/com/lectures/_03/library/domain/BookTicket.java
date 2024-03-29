package com.lectures._03.library.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data@Builder@EqualsAndHashCode
public class BookTicket {

  private long id;
  private Book book;
  private User user;
  private long takenTimestamp; // new Date(takenTimestamp == 0) - 1970.01.01 00:00:00
}
