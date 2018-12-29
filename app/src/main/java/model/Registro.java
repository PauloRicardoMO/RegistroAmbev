package model;

import java.util.Date;

public class Registro {

    private int codigo;
    private Date data;
    private String hora;
    private String obs;
    private String tipo;
    private Veiculo veiculo;
    private Motorista motorista;
    private Contagem contagem;

    public Registro(int codigo, Date data, String hora, String obs, Veiculo veiculo,
                    Motorista motorista, Contagem contagem, String tipo) {
        this.codigo = codigo;
        this.data = data;
        this.hora = hora;
        this.obs = obs;
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.contagem = contagem;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Contagem getContagem() {
        return contagem;
    }

    public void setContagem(Contagem contagem) {
        this.contagem = contagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
}
