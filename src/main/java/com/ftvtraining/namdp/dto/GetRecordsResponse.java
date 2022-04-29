package com.ftvtraining.namdp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.ftvtraining.namdp.models.PhuLuc;
import java.util.List;

@Data
@AllArgsConstructor
public class GetRecordsResponse {
  boolean success = true;

  long length;

  List<PhuLuc> phuLuc;
}
