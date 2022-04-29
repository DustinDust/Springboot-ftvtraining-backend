package com.ftvtraining.namdp.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
  boolean sucess;

  List<Violation> errors;
}
