package model;

public class Produto {

    private int codigo;
    private int codBarras;
    private String descricao;
    private float paletizacao;

    public Produto(int codigo, int codBarras, String descricao, float paletizacao) {
        this.codigo = codigo;
        this.codBarras = codBarras;
        this.descricao = descricao;
        this.paletizacao = paletizacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(int codBarras) {
        this.codBarras = codBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPaletizacao() {
        return paletizacao;
    }

    public void setPaletizacao(float paletizacao) {
        this.paletizacao = paletizacao;
    }
}
