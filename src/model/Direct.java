package model;

import java.time.LocalDate;

public class Direct {
    private int idDirect;
    private int fkIdRemetente;
    private int fkIdDestinatario;
    private String mensagem;
    private LocalDate dataEnvio;

    public Direct(int fkIdRemetente,int fkIdDestinatario,String mensagem) {
        this.fkIdRemetente = fkIdRemetente;
        this.fkIdDestinatario = fkIdDestinatario;
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
    }

    public Direct(int idDirect,int fkIdRemetente,int fkIdDestinatario,String mensagem) {
        this.idDirect = idDirect;
        this.fkIdRemetente = fkIdRemetente;
        this.fkIdDestinatario = fkIdDestinatario;
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
    }

    public int getIdDirect() {
        return idDirect;
    }

    public void setIdDirect(int idDirect){
        this.idDirect = idDirect;
    }

    public int getFkIdRemetente() {
        return fkIdRemetente;
    }

    public void setFkIdRemetente(int fkIdRemetente) {
        this.fkIdRemetente = fkIdRemetente;
    }

    public int getFkIdDestinatario() {
        return fkIdDestinatario;
    }

    public void setFkIdDestinatario(int fkIdDestinatario) {
        this.fkIdDestinatario = fkIdDestinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }
}
