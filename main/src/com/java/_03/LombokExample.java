package com.java._03;

import lombok.Builder;
import lombok.Value;
import lombok.val;

public class LombokExample {

  public static void main(String[] args) {
    val address = new Address("Polevaya 45", "Tmz", "452751");
    System.out.println(address);

    val person = new Person(1L, "head", "ilyan", "kolesnikov", address);

    Person person2 = Person.builder()
        .id(1L)
        .username("head")
        .name("ilya")
        .surname("kolesnikov")
        .address(address)
        .build();

    System.out.println(person.getId());
  }

}

@Builder
@Value
class Person{

  Long id;
  String username;
  String name;
  String surname;
  Address address;

}

// P - plain
// O - old
// J - java
// O - object

// D - Data
// T - Transfer
// O - Object

@Value
class Address{

  String address;
  String city;
  String zipCode;

}
