
package modelo;


public class Ponto extends Peca{
    
    public Ponto(TipoCor cor,int linha,int coluna){
        super(cor,linha,coluna,"src/figs/PONTO.png");
    }
    
     public Ponto(TipoCor cor,int linha,int coluna,String imagem){
        super(cor,linha,coluna,imagem);
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        return false;
    }
    
     public boolean validaMovimento1(int linhaDestino, int colunaDestino) {
        return false;
    }
    
}
