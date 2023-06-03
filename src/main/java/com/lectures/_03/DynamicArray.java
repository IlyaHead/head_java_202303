package com.lectures._03;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray implements Iterable{

  private Object[] values = {};
  private int size;

  public DynamicArray() {
    values = new Object[0];
    size = 0;
  }

  @Override
  public Iterator iterator() {
    return new DynamicArrayIterator();
  }

  public void add(Object value) {
    resizeIfNeeded();
    values[size++] = value;
  }

  public void add(Object value, int position) {
    if (position > size) {
      System.err.println("IllegalArgument: position = " + position);
      return;
    } else if (position == size) {
      add(value);
    } else {
      resizeIfNeeded();
      System.arraycopy(values, position, value, position + 1, size - 1);
      values[position] = value;
      size++;
    }
  }

  public void set(Object value, int position) {
    if (position < 0 || position >= size) {
      System.err.println("IllegalArgument: position = " + position);
      return;
    }
    values[position] = value;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Object get(int position) {
    if (position < 0 || position >= size) {
      System.err.println("IllegalArgument: position = " + position);
      return null;
    }
    return values[position];
  }

  public void remove(int position) {
    if (position < 0 || position >= size) {
      System.err.println("IllegalArgument: position = " + position);
    } else if (position == size - 1) {
      values[position] = null;
      size--;
    } else {
      System.arraycopy(values, position + 1, values, position, size - position);
      values[size - 1] = null;
      size--;
    }
  }

  public void remove(Object object){
    for (int i = 0; i < size; i++) {
      Object value = values[i];
      if (values[i].equals(object)) {
        remove(i);
        return;
      }
    }
  }

  public boolean contains(Object value) {
    for (Object val : values
    ) {
      if (val.equals(value)) {
        return true;
      }
    }
    return false;
  }

  protected void resizeIfNeeded() {
    if (values.length == size) {
      values = Arrays.copyOf(values, size * 2 + 1);
    }
  }

  @Override
  public String toString() {
    return Arrays.toString(values);
  }

  public void clean() {
    values = new Object[0];
    size = 0;
  }

  //static class => nested
  //class => inner
  private class DynamicArrayIterator implements Iterator{

    private int position;


    @Override
    public boolean hasNext() {
      return position != size;
    }

    @Override
    public Object next() {
      return values[position++];
    }
  }
}


