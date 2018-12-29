package model;

public class Motorista {

    private int codigo;
    private String nome;
    private String cnh;

    public Motorista(int codigo, String nome, String cnh) {
        this.codigo = codigo;
        this.nome = nome;
        this.cnh = cnh;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
}
