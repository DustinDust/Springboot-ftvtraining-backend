package com.ftvtraining.namdp.services;

import com.ftvtraining.namdp.repositories.PhuLucRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ftvtraining.namdp.exceptions.RecordAlreadyExistException;
import com.ftvtraining.namdp.models.PhuLuc;
import com.ftvtraining.namdp.models.PhuLuc_;
import com.ftvtraining.namdp.payload.RecordsRequestPayload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PhuLucService {
  @Autowired
  PhuLucRepository pLucRepository;

  public List<PhuLuc> getAllPL(RecordsRequestPayload payload, Pageable pageable) {
    Optional<String> maHopDong = Optional.ofNullable(payload.getMaHopDongQueryString());
    Optional<String> tenNguoiTao = Optional.ofNullable(payload.getTenNguoiTaoQueryString());
    Optional<String> ngayNghiemThuUpperBound = Optional.ofNullable(payload.getNgayNghiemThuUpperBound());
    Optional<String> ngayNghiemThuLowerBound = Optional.ofNullable(payload.getNgayNghiemThuLowerBound());
    // System.out.println(ngayNghiemThuUpperBound.get());
    // System.out.println(ngayNghiemThuLowerBound.get());

    Page<PhuLuc> page = this.pLucRepository.findAll(new Specification<PhuLuc>() {
      @Override
      public Predicate toPredicate(Root<PhuLuc> root, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (maHopDong.isPresent()) {
          predicates.add(criteriaBuilder.like(root.get(PhuLuc_.MA_HOP_DONG),
              maHopDong.get() + "%"));
        }
        if (tenNguoiTao.isPresent()) {
          predicates.add(criteriaBuilder.like(root.get(PhuLuc_.NGUOI_TAO),
              tenNguoiTao.get() + "%"));
        }
        if (ngayNghiemThuLowerBound.isPresent()) {
          Date lowerBound = Date.valueOf(ngayNghiemThuLowerBound.get());
          System.out.println(lowerBound);
          predicates.add(
              criteriaBuilder.greaterThanOrEqualTo(root.get(PhuLuc_.NGAY_NGHIEM_THU),
                  lowerBound));
        }
        if (ngayNghiemThuUpperBound.isPresent()) {
          Date upperBound = Date.valueOf(ngayNghiemThuUpperBound.get());
          System.out.println(upperBound);
          predicates.add(
              criteriaBuilder.lessThanOrEqualTo(root.get(PhuLuc_.NGAY_NGHIEM_THU),
                  upperBound));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
      }

    }, pageable);
    System.out.println(
        "Items per page: " + pageable.getPageSize() +
            "\nCurrent page: " + pageable.getPageNumber() +
            "\nTotal page: " + page.getTotalPages());
    return page.getContent();
  }

  public PhuLuc getOnePL(Long id) throws NoSuchElementException {
    Optional<PhuLuc> phuLuc = this.pLucRepository.findById(id);
    if (phuLuc.isPresent()) {
      return phuLuc.get();
    } else {
      throw new NoSuchElementException("Could not find any record with id of " + id);
    }
  }

  public PhuLuc insertPhuLuc(PhuLuc phuLuc) throws RecordAlreadyExistException {
    Optional<PhuLuc> existingPL = this.pLucRepository.findById(phuLuc.getId());
    if (existingPL.isPresent()) {
      throw new RecordAlreadyExistException("Record with id of " + phuLuc.getId() + " already exists");
    }
    return this.pLucRepository.save(phuLuc);
  }

  public PhuLuc updatePhuLuc(long id, PhuLuc phuLuc) {
    Optional<PhuLuc> exisitingPL = this.pLucRepository.findById(id);
    if (!exisitingPL.isPresent()) {
      throw new NoSuchElementException("Record with id of " + phuLuc.getId() + " does not exist");
    } else {
      phuLuc.setId(id);
      return this.pLucRepository.save(phuLuc);
    }
  }

  public void deletePhuLuc(long id) {
    Optional<PhuLuc> existingPL = this.pLucRepository.findById(id);
    if (!existingPL.isPresent()) {
      throw new NoSuchElementException("Record with id of " + id + " does not exist");
    }
    this.pLucRepository.deleteById(id);
  }
}