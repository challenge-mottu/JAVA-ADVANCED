package com.example.mottu_challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.example.mottu_challenge.model.DispositivoIoT;

public interface DispositivoIoTRepository extends JpaRepository<DispositivoIoT, Integer>, JpaSpecificationExecutor<DispositivoIoT> {
}
