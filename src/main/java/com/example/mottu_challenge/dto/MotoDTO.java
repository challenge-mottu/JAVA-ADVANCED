package com.example.mottu_challenge.dto;
import jakarta.validation.constraints.*;
import java.util.Date;

public class MotoDTO {

    private Integer id;

    @NotBlank
    @Size(min = 7, max = 8)
    private String placa;

    @NotBlank
    @Pattern(regexp = "E|POP|SPORT")
    private String tipo;

    @NotBlank
    @Pattern(regexp = "A|D|M|V")
    private String status;

    @NotNull
    private Date dataCadastro;

    private Integer ano;

    private String cor;

    private String modelo;

    @NotBlank
    private String tag;

    private Integer idDispositivo;

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

    public Integer getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
    }
}
