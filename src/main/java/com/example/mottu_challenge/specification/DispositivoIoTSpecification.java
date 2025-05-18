package com.example.mottu_challenge.specification;

import com.example.mottu_challenge.model.DispositivoIoT;
import org.springframework.data.jpa.domain.Specification;

public class DispositivoIoTSpecification {

    public static Specification<DispositivoIoT> tipoConexaoEquals(String tipo) {
        return (root, query, cb) -> tipo == null ? null : cb.equal(root.get("tipoConexao"), tipo);
    }

    public static Specification<DispositivoIoT> statusEquals(String status) {
        return (root, query, cb) -> status == null ? null : cb.equal(root.get("status"), status);
    }
}
