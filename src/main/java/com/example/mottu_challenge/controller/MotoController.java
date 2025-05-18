package com.example.mottu_challenge.controller;
import com.example.mottu_challenge.dto.MotoDTO;
import com.example.mottu_challenge.service.MotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/motos")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @PostMapping
    public MotoDTO criar(@Valid @RequestBody MotoDTO dto) {
        return motoService.salvar(dto);
    }

    @GetMapping("/{id}")
    public MotoDTO buscarPorId(@PathVariable Long id) {
        return motoService.buscarPorId(id);
    }

    @GetMapping
    public ResponseEntity<Page<MotoDTO>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<MotoDTO> motos = motoService.listarPaginado(page, size, sortBy);
        return ResponseEntity.ok(motos);
    }

    @PutMapping("/{id}")
    public MotoDTO atualizar(@PathVariable Long id, @Valid @RequestBody MotoDTO dto) {
        return motoService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        motoService.excluir(id);
    }
}
