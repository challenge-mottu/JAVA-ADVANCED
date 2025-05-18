package com.example.mottu_challenge.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class DispositivoIoTDTO {

    private Integer id;

    @NotBlank(message = "Nome do dispositivo é obrigatório")
    @Size(max = 50)
    private String nome;

    @NotBlank(message = "Tipo de conexão é obrigatório")
    @Size(max = 20)
    private String tipoConexao;

    @NotBlank
    @Pattern(regexp = "A|I", message = "Status deve ser 'A' (Ativo) ou 'I' (Inativo)")
    private String status;

    @NotNull(message = "Data de instalação é obrigatória")
    private LocalDate dataInstalacao;

    private String observacoes;


    // Construtores


    public DispositivoIoTDTO() {
    }

    public DispositivoIoTDTO(Integer id, String nome, String tipoConexao, String status, LocalDate dataInstalacao, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.tipoConexao = tipoConexao;
        this.status = status;
        this.dataInstalacao = dataInstalacao;
        this.observacoes = observacoes;
    }

// Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoConexao() {
        return tipoConexao;
    }

    public void setTipoConexao(String tipoConexao) {
        this.tipoConexao = tipoConexao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
