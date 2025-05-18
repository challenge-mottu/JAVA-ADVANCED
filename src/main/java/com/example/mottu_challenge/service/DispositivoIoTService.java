package com.example.mottu_challenge.service;
import com.example.mottu_challenge.dto.DispositivoIoTDTO;
import com.example.mottu_challenge.model.DispositivoIoT;
import com.example.mottu_challenge.repository.DispositivoIoTRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DispositivoIoTService {

    private final DispositivoIoTRepository repository;

    public DispositivoIoTDTO salvar(DispositivoIoTDTO dto) {
        DispositivoIoT entidade = fromDto(dto);
        return toDto(repository.save(entidade));
    }

    public DispositivoIoTDTO buscarPorId(Integer id) {
        var entidade = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispositivo não encontrado"));
        return toDto(entidade);
    }

    public List<DispositivoIoTDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public DispositivoIoTDTO atualizar(Integer id, DispositivoIoTDTO dto) {
        var entidade = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispositivo não encontrado"));
        entidade.setNome(dto.getNome());
        entidade.setTipoConexao(dto.getTipoConexao());
        entidade.setStatus(dto.getStatus());
        entidade.setDataInstalacao(dto.getDataInstalacao());
        entidade.setObservacoes(dto.getObservacoes());
        return toDto(repository.save(entidade));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }


    public DispositivoIoTDTO toDto(DispositivoIoT dispositivo) {
        DispositivoIoTDTO dto = new DispositivoIoTDTO();
        dto.setId(dispositivo.getId());
        dto.setNome(dispositivo.getNome());
        dto.setTipoConexao(dispositivo.getTipoConexao());
        dto.setStatus(dispositivo.getStatus());
        dto.setDataInstalacao(dispositivo.getDataInstalacao());
        dto.setObservacoes(dispositivo.getObservacoes());
        return dto;
    }



    public DispositivoIoT fromDto(DispositivoIoTDTO dto) {
        DispositivoIoT dispositivo = new DispositivoIoT();
        dispositivo.setId(dto.getId());
        dispositivo.setNome(dto.getNome());
        dispositivo.setTipoConexao(dto.getTipoConexao());
        dispositivo.setStatus(dto.getStatus());
        dispositivo.setDataInstalacao(dto.getDataInstalacao());
        dispositivo.setObservacoes(dto.getObservacoes());

        return dispositivo;
    }


}
