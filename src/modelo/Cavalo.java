
package modelo;

import static modelo.TipoCor.BRANCO;
import static modelo.TipoCor.PRETO;


public class Cavalo extends Peca {

    public Cavalo(TipoCor cor,int linha,int coluna){
        super(cor,linha,coluna,"src/figs/CAVALO"+cor+".png");
    }
    
    public Cavalo(TipoCor cor,int linha,int coluna,String imagem){
        super(cor,linha,coluna,imagem);
    }
    
    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        
         Peca pecaDestino = getTabuleiro().getPeca(linhaDestino,colunaDestino);
     
            if(this.getCor() == BRANCO && this.isSelecionada() == false){
                return true;
            }

            if((linhaDestino == this.getLinha() + 2 || linhaDestino == this.getLinha() + 2) && (colunaDestino == this.getColuna() + 1 || colunaDestino == this.getColuna() - 1 )){
                 
                return true;
            }

            if((colunaDestino == this.getColuna() - 2 || colunaDestino == this.getColuna() +2) && (linhaDestino == this.getLinha() + 1 || linhaDestino == this.getLinha() - 1 )){
                 
                return true;
            }
  
            if((linhaDestino == this.getLinha() - 2 || linhaDestino == this.getLinha() + 2) && (colunaDestino == this.getColuna() + 1 || colunaDestino == this.getColuna() - 1 )){
                  
                return true;
            }
        
        
            if((colunaDestino == this.getColuna() + 2 || colunaDestino == this.getColuna() - 2) && (linhaDestino == this.getLinha() + 1 || linhaDestino == this.getLinha() - 1 )){
                 
                return true;
            }
            
         
           
        return false;
        
    }
    
     public boolean validaMovimento1(int linhaDestino, int colunaDestino) {
        return false;
    }
    
}
