package com.example.mottu_challenge.controller;


import com.example.mottu_challenge.dto.DispositivoIoTDTO;
import com.example.mottu_challenge.service.DispositivoIoTService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivos")
@RequiredArgsConstructor
public class DispositivoIoTController {

    private final DispositivoIoTService dispositivoIoTService;

    @PostMapping
    public ResponseEntity<DispositivoIoTDTO> salvar(@RequestBody @Valid DispositivoIoTDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dispositivoIoTService.salvar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DispositivoIoTDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(dispositivoIoTService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<DispositivoIoTDTO>> listarTodos() {
        return ResponseEntity.ok(dispositivoIoTService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DispositivoIoTDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid DispositivoIoTDTO dto) {
        return ResponseEntity.ok(dispositivoIoTService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        dispositivoIoTService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}