package com.example.mottu_challenge.repository;
import com.example.mottu_challenge.model.Moto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MotoRepository extends JpaRepository<Moto, Long>, JpaSpecificationExecutor<Moto> {
    Page<Moto> findByTipo(String tipo, Pageable pageable);
    Page<Moto> findByStatus(String status, Pageable pageable);
}

