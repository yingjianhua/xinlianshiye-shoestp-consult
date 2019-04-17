package com.xinlianshiye.shoestp.consult.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xinlianshiye.shoestp.consult.api.entity.Consult;

public interface ConsultRepository extends JpaRepository<Consult, Long>, ConsultRepositoryCustom{}
