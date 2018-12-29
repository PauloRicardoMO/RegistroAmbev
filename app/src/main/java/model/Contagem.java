package model;

import java.util.Date;
import java.util.List;

public class Contagem {

    private int codigo;
    private String horaInicio;
    private String horaFim;
    private long numNota;
    private Date data;
    private List<Item> itens;

    public Contagem(int codigo, String horaInicio, String horaFim, long numNota, Date data,
                    List<Item> itens) {
        this.codigo = codigo;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.numNota = numNota;
        this.data = data;
        this.itens = itens;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public long getNumNota() {
        return numNota;
    }

    public void setNumNota(long numNota) {
        this.numNota = numNota;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
