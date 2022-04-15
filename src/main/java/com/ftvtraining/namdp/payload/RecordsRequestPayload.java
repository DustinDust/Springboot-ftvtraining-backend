package com.ftvtraining.namdp.payload;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import lombok.Data;

@Data
public class RecordsRequestPayload {
  @Nullable
  private String tenNguoiTaoQueryString;

  @Nullable
  private String maHopDongQueryString;

  @Nullable
  private String ngayNghiemThuUpperBound;

  @Nullable
  private String ngayNghiemThuLowerBound;

  @NonNull
  private int currentPage;

  @NonNull
  private int perPage;
}
