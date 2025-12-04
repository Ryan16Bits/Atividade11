package model;

import java.time.LocalDate;

public class Postagem {
    private int idPostagem;
    private int fkIdUsuario;
    private String conteudo;
    private LocalDate dataPostagem;

    public Postagem(int fkIdUsuario,String conteudo) {
        this.fkIdUsuario = fkIdUsuario;
        this.conteudo = conteudo;
        this.dataPostagem = dataPostagem;
    }

    public Postagem(int idPostagem, int fkIdUsuario,String conteudo) {
        this.idPostagem = idPostagem;
        this.fkIdUsuario = fkIdUsuario;
        this.conteudo = conteudo;
        this.dataPostagem = dataPostagem;
    }

    public int getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(int idPostagem) {
        this.idPostagem = idPostagem;
    }

    public int getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(int fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getDataPostagem() {
        return dataPostagem;
    }
}
