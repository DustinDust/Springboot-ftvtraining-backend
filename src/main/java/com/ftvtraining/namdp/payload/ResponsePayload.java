package com.ftvtraining.namdp.payload;

import java.io.Serializable;

import com.ftvtraining.namdp.models.PhuLuc;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponsePayload implements Serializable {

  @NonNull
  private String message;

  @NonNull
  private boolean success;

  @Nullable
  private PhuLuc alteredRecord;
}
