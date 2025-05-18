package com.example.mottu_challenge.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_CM_MOTO")
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moto_seq")
    @SequenceGenerator(name = "moto_seq", sequenceName = "MOTO_SEQ", allocationSize = 1)
    @Column(name = "ID_MOTO")
    private Integer id;

    @Column(name = "DS_PLACA", nullable = false, unique = true, length = 8)
    private String placa;

    @Column(name = "TP_MOTO", nullable = false, length = 64)
    private String tipo;

    @Column(name = "ST_MOTO", nullable = false, length = 1)
    private String status;

    @Column(name = "DT_CADASTRO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Column(name = "NR_ANO_MOTO")
    private Integer ano;

    @Column(name = "DS_COR", length = 50)
    private String cor;

    @Column(name = "DS_MODELO", length = 100)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "ID_DISPOSITIVO", nullable = false)
    private DispositivoIoT dispositivo;

    @Column(name = "CD_TAG", nullable = false, length = 50)
    private String tag;

    // Construtor padrao

    public Moto() {
    }

    // Construtor completo

    public Moto(Integer id, String placa, String tipo, String status, Date dataCadastro, Integer ano, String cor, String modelo, String tag, DispositivoIoT dispositivo) {
        this.id = id;
        this.placa = placa;
        this.tipo = tipo;
        this.status = status;
        this.dataCadastro = dataCadastro;
        this.ano = ano;
        this.cor = cor;
        this.modelo = modelo;
        this.tag = tag;
        this.dispositivo = dispositivo;
    }

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public DispositivoIoT getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(DispositivoIoT dispositivo) {
        this.dispositivo = dispositivo;
    }
}
