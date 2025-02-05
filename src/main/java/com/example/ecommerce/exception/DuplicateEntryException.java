package com.example.ecommerce.exception;

public class DuplicateEntryException extends RuntimeException {
  public DuplicateEntryException(String message) {
    super(message);
  }
}
