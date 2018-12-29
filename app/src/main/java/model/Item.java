package model;

public class Item extends Produto {

    private int codigo;
    private int qtdIndividual;
    private int qtdPaletes;

    public Item(int codigo, int codBarras, String descricao, float paletizacao, int codigo1,
                int qtdIndividual, int qtdPaletes) {
        super(codigo, codBarras, descricao, paletizacao);
        this.codigo = codigo1;
        this.qtdIndividual = qtdIndividual;
        this.qtdPaletes = qtdPaletes;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtdIndividual() {
        return qtdIndividual;
    }

    public void setQtdIndividual(int qtdIndividual) {
        this.qtdIndividual = qtdIndividual;
    }

    public int getQtdPaletes() {
        return qtdPaletes;
    }

    public void setQtdPaletes(int qtdPaletes) {
        this.qtdPaletes = qtdPaletes;
    }
}
