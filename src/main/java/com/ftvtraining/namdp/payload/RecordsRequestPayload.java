package com.ftvtraining.namdp.payload;

import java.io.Serializable;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import lombok.Data;

@Data
public class RecordsRequestPayload implements Serializable {
  @Nullable
  private String nguoiTao;

  @Nullable
  private String maHopDong;

  @Nullable
  private String ngayNghiemThuUpperBound;

  @Nullable
  private String ngayNghiemThuLowerBound;

  @NonNull
  private int pageIndex;

  @NonNull
  private int pageSize;
}
