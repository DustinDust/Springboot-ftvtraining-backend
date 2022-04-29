package com.ftvtraining.namdp.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.lang.Nullable;

import lombok.Data;

@Data
public class RecordsRequestPayload implements Serializable {
  @Nullable
  private String nguoiTao;

  @Nullable
  private String maHopDong;

  @Nullable
  @Pattern(regexp = "^[1-9][0-9]{3}\\-[0-1][1-9]\\-[0-3][0-9]$", message = "Invalid Upper Bound Date String")
  private String ngayNghiemThuUpperBound;

  @Nullable
  @Pattern(regexp = "^[1-9][0-9]{3}\\-[0-1][1-9]\\-[0-3][0-9]$", message = "Invalid Lower Bound Date String")
  private String ngayNghiemThuLowerBound;

  @NotNull(message = "Page Index cannot be null")
  @Min(value = 0, message = "Invalid Page Index")
  private Integer pageIndex;

  @NotNull(message = "Page Size cannot be null")
  @Min(value = 1, message = "Invalid Page Size")
  private Integer pageSize;
}
