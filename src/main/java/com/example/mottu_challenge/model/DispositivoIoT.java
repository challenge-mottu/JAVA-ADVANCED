package com.example.mottu_challenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "T_CM_DISPOSITIVO_IOT")
public class DispositivoIoT {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dispositivo_iot_seq")
    @SequenceGenerator(name = "dispositivo_iot_seq", sequenceName = "IOT_SEQ", allocationSize = 1)
    @Column(name = "ID_DISPOSITIVO")
    private Integer id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "NM_DISPOSITIVO", nullable = false, length = 50)
    private String nome;

    @NotBlank
    @Size(max = 20)
    @Column(name = "TP_CONEXAO", nullable = false, length = 20)
    private String tipoConexao;

    @NotNull
    @Pattern(regexp = "A|I", message = "Status deve ser 'A' (Ativo) ou 'I' (Inativo)")
    @Column(name = "ST_DISPOSITIVO", nullable = false, length = 1)
    private String status;

    @NotNull
    @Column(name = "DT_INSTALACAO", nullable = false)
    private LocalDate dataInstalacao;

    @Column(name = "DS_OBS", columnDefinition = "CLOB")
    private String observacoes;


    public DispositivoIoT(Integer id, String nome, String tipoConexao, String status, LocalDate dataInstalacao, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.tipoConexao = tipoConexao;
        this.status = status;
        this.dataInstalacao = dataInstalacao;
        this.observacoes = observacoes;
    }

    public DispositivoIoT() {

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
