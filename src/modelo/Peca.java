
package modelo;


public abstract class Peca {
    
    private TipoCor cor;
    int linha;
    int coluna;
    private String imagem;
    private boolean eliminada = false; 
    private boolean selecionada = false;
    private Tabuleiro tabuleiro;

    
    public Peca(TipoCor cor,int linha, int coluna,String imagem){
        this.cor = cor;
        this.linha = linha;
        this.coluna = coluna;
        this.imagem = imagem;
    }
    
    public abstract boolean validaMovimento(int linhaDestino, int colunaDestino);
     public abstract boolean validaMovimento1(int linhaDestino, int colunaDestino); 
    

    
    public TipoCor getCor() {
        return this.cor;
    }


    public int getLinha() {
        return this.linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return this.coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public String getImagem() {
        return this.imagem;
    }

    public boolean isEliminada() {
        return this.eliminada;
    }

    public void setEliminada(boolean eliminada) {
        this.eliminada = eliminada;
    }

    public boolean isSelecionada() {
        return this.selecionada;
    }

    public void setSelecionada(boolean selecionada) {
        this.selecionada = selecionada;
    }

    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    
   
    
    
    
}
