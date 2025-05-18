package com.example.mottu_challenge.service;
import com.example.mottu_challenge.dto.MotoDTO;
import com.example.mottu_challenge.model.DispositivoIoT;
import com.example.mottu_challenge.model.Moto;
import com.example.mottu_challenge.repository.MotoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import com.example.mottu_challenge.repository.DispositivoIoTRepository;

import java.util.List;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private DispositivoIoTRepository dispositivoRepository;

    @CacheEvict(value = "motos", allEntries = true)
    public MotoDTO salvar(MotoDTO dto) {
        Moto moto = converterParaEntidade(dto);
        return converterParaDTO(motoRepository.save(moto));
    }

    public MotoDTO buscarPorId(Long id) {
        Moto moto = motoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Moto não encontrada"));
        return converterParaDTO(moto);
    }

    @Cacheable("motos")
    public Page<MotoDTO> listarTodos(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return motoRepository.findAll(pageable).map(this::converterParaDTO);
    }

    @CacheEvict(value = "motos", allEntries = true)
    public void excluir(Long id) {
        if (!motoRepository.existsById(id)) {
            throw new EntityNotFoundException("Moto não encontrada");
        }
        motoRepository.deleteById(id);
    }

    @CacheEvict(value = "motos", allEntries = true)
    public MotoDTO atualizar(Long id, MotoDTO dto) {
        Moto moto = motoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Moto não encontrada"));
        moto.setPlaca(dto.getPlaca());
        moto.setTipo(dto.getTipo());
        moto.setStatus(dto.getStatus());
        moto.setDataCadastro(dto.getDataCadastro());
        moto.setAno(dto.getAno());
        moto.setCor(dto.getCor());
        moto.setModelo(dto.getModelo());
        moto.setTag(dto.getTag());

        DispositivoIoT dispositivo = dispositivoRepository.findById(dto.getIdDispositivo())
                .orElseThrow(() -> new EntityNotFoundException("Dispositivo não encontrado"));
        moto.setDispositivo(dispositivo);

        return converterParaDTO(motoRepository.save(moto));
    }

    private MotoDTO converterParaDTO(Moto moto) {
        MotoDTO dto = new MotoDTO();
        dto.setId(moto.getId());
        dto.setPlaca(moto.getPlaca());
        dto.setTipo(moto.getTipo());
        dto.setStatus(moto.getStatus());
        dto.setDataCadastro(moto.getDataCadastro());
        dto.setAno(moto.getAno());
        dto.setCor(moto.getCor());
        dto.setModelo(moto.getModelo());
        dto.setTag(moto.getTag());
        dto.setIdDispositivo(moto.getDispositivo().getId());
        return dto;
    }

    @Cacheable("motos")
    public Page<MotoDTO> listarPaginado(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return motoRepository.findAll(pageable).map(this::converterParaDTO);
    }

    private Moto converterParaEntidade(MotoDTO dto) {
        Moto moto = new Moto();
        moto.setId(dto.getId());
        moto.setPlaca(dto.getPlaca());
        moto.setTipo(dto.getTipo());
        moto.setStatus(dto.getStatus());
        moto.setDataCadastro(dto.getDataCadastro());
        moto.setAno(dto.getAno());
        moto.setCor(dto.getCor());
        moto.setModelo(dto.getModelo());
        moto.setTag(dto.getTag());

        DispositivoIoT dispositivo = dispositivoRepository.findById(dto.getIdDispositivo())
                .orElseThrow(() -> new EntityNotFoundException("Dispositivo não encontrado"));
        moto.setDispositivo(dispositivo);

        return moto;
    }

    public Page<MotoDTO> buscarPorTipoOuStatus(String tipo, String status, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        if (tipo != null && !tipo.isEmpty()) {
            return motoRepository.findByTipo(tipo, pageable).map(this::converterParaDTO);
        } else if (status != null && !status.isEmpty()) {
            return motoRepository.findByStatus(status, pageable).map(this::converterParaDTO);
        } else {
            return motoRepository.findAll(pageable).map(this::converterParaDTO);
        }
    }

    public MotoDTO toDTO(Moto moto) {
        MotoDTO dto = new MotoDTO();
        dto.setId(moto.getId());
        dto.setPlaca(moto.getPlaca());
        dto.setTipo(moto.getTipo());
        dto.setStatus(moto.getStatus());
        dto.setDataCadastro(moto.getDataCadastro());
        dto.setAno(moto.getAno());
        dto.setCor(moto.getCor());
        dto.setModelo(moto.getModelo());
        dto.setTag(moto.getTag());

        // Atenção aqui:
        if (moto.getDispositivo() != null) {
            dto.setIdDispositivo(moto.getDispositivo().getId());
        }

        return dto;
    }


    private Moto toEntity(MotoDTO dto) {
        Moto moto = new Moto();
        moto.setId(dto.getId());
        moto.setModelo(dto.getModelo());
        moto.setPlaca(dto.getPlaca());
        moto.setStatus(dto.getStatus());
        return moto;
    }


    @Cacheable("motos")
    public Page<MotoDTO> listarPaginado(Pageable pageable) {
        return motoRepository.findAll(pageable).map(this::toDTO);
    }

    public List<MotoDTO> buscarPorStatusOuModelo(String status, String modelo) {
        List<Moto> motos;
        if (status != null && modelo != null) {
            motos = motoRepository.findByStatusAndModeloContainingIgnoreCase(status, modelo);
        } else if (status != null) {
            motos = motoRepository.findByStatus(status);
        } else if (modelo != null) {
            motos = motoRepository.findByModeloContainingIgnoreCase(modelo);
        } else {
            motos = motoRepository.findAll();
        }
        return motos.stream().map(this::toDTO).toList();
    }


}


