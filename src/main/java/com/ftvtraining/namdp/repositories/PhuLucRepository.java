package com.ftvtraining.namdp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ftvtraining.namdp.models.PhuLuc;

@Repository
@Transactional
public interface PhuLucRepository extends JpaRepository<PhuLuc, Long>, JpaSpecificationExecutor<PhuLuc> {
}