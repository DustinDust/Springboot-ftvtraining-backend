package com.ftvtraining.namdp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.ftvtraining.namdp.models.PhuLuc;
import java.util.List;

@Data
@AllArgsConstructor
public class GetRecordsResponse {
  long length;

  List<PhuLuc> phuLuc;
}
