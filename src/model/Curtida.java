package model;

import java.time.LocalDate;

public class Curtida {
    private int idCurtida;
    private int fkIdPostagem;
    private int fkIdUsuario;
    private LocalDate dataCurtida;

    private Curtida(int fkIdPostagem,int fkIdUsuario,LocalDate dataCurtida) {
        this.fkIdPostagem = fkIdPostagem;
        this.fkIdUsuario = fkIdUsuario;
        this.dataCurtida = dataCurtida;
    }

    private Curtida(int idCurtida,int fkIdPostagem,int fkIdUsuario,LocalDate dataCurtida) {
        this.idCurtida = idCurtida;
        this.fkIdPostagem = fkIdPostagem;
        this.fkIdUsuario = fkIdUsuario;
        this.dataCurtida = dataCurtida;
    }

    public int getIdCurtida() {
        return idCurtida;
    }

    public void setIdCurtida(int idCurtida) {
        this.idCurtida = idCurtida;
    }

    public int getFkIdPostagem() {
        return fkIdPostagem;
    }

    public void setFkIdPostagem(int fkIdPostagem) {
        this.fkIdPostagem = fkIdPostagem;
    }

    public int getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(int fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public LocalDate getDataCurtida() {
        return dataCurtida;
    }
}
