package com.ftvtraining.namdp.controllers;

import java.util.NoSuchElementException;

import com.ftvtraining.namdp.exceptions.DatabaseRuntimeQueryException;
import com.ftvtraining.namdp.exceptions.RecordAlreadyExistException;
import com.ftvtraining.namdp.payload.ResponsePayload;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class PhuLucAdviceController {

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponsePayload handleAllException(Exception exception, WebRequest wr) {
    exception.printStackTrace();
    return new ResponsePayload(exception.getLocalizedMessage(), false, null);
  }

  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponsePayload handleNotFoundException(NoSuchElementException e, WebRequest wr) {
    return new ResponsePayload(e.getLocalizedMessage(), false, null);
  }

  @ExceptionHandler(RecordAlreadyExistException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ResponsePayload handleAlreadyExistException(RecordAlreadyExistException e, WebRequest wr) {
    return new ResponsePayload(e.getMessage(), false, null);
  }

  @ExceptionHandler(DatabaseRuntimeQueryException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponsePayload handleQueryException(DatabaseRuntimeQueryException e, WebRequest wr) {
    return new ResponsePayload(e.getMessage() + " - " + e.getErrorCode(), false, null);
  }

}