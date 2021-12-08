
package modelo;


public class Rei extends Peca {

    public Rei(TipoCor cor,int linha,int coluna){
        super(cor,linha,coluna,"src/figs/REI"+cor+".png");
    }
    
    
    public Rei(TipoCor cor,int linha,int coluna,String imagem){
        super(cor,linha,coluna,imagem);
    }
    
    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        
        if((linhaDestino == this.getLinha()+1 || linhaDestino == this.getLinha()-1)&& (colunaDestino == this.getColuna()+1 || colunaDestino == this.getColuna() - 1 )){
                return true;
        }
        
        if((linhaDestino == this.getLinha() + 1 || linhaDestino == this.getLinha() -1) && colunaDestino == getColuna() ){
            return true;
        }
        
        if((colunaDestino == this.getColuna() + 1 || colunaDestino == this.getColuna() -1) && linhaDestino == getLinha() ){
            return true;
        }
        return false;
        
    }
    
    
     public boolean validaMovimento1(int linhaDestino, int colunaDestino) {
        return false;
    }
    
    
    
    
}
