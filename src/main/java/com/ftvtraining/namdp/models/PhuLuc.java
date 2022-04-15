package com.ftvtraining.namdp.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "DM_PHU_LUC_2")
public class PhuLuc implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "MA_HOP_DONG")
  private String maHopDong;

  @Column(name = "TEN_PHU_LUC")
  private String tenPhuLuc;

  @Column(name = "NGAY_KY")
  private Date ngayKy;

  @Column(name = "NGAY_NGHIEM_THU")
  private Date ngayNghiemThu;

  @Column(name = "NGAY_TAO")
  private Date ngayTao;

  @Column(name = "NGUOI_TAO")
  private String nguoiTao;

  @Column(name = "MA_KENH_TRUYEN")
  private String maKenhTruyen;
}