
package modelo;

import static modelo.TipoCor.BRANCO;
import static modelo.TipoCor.PRETO;



public class Peao extends Peca {

    private boolean primeiroMovimento = true;
    
    
    
    public Peao(TipoCor cor,int linha,int coluna){
        super(cor,linha,coluna,"src/figs/PEAO"+cor+".png");
    }
    
    
    public Peao(TipoCor cor,int linha,int coluna,String imagem){
        super(cor,linha,coluna,imagem);
    }
    
    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        
       
        Peca pecaDestino = getTabuleiro().getPeca(linhaDestino,colunaDestino);
       

        //--------MOVIMENTO SEM COMER OUTRA PEÇA------------
        if(this.primeiroMovimento){
            if(this.getCor() == BRANCO){
            if(pecaDestino == null && (linhaDestino == this.getLinha() + 2 && colunaDestino == getColuna()) ){
           
                return true;
        }
        }
            if(this.getCor() == BRANCO){
            if(pecaDestino == null && (linhaDestino == this.getLinha() + 1 && colunaDestino == getColuna()) ){
            return true;
        }
        }
        if(this.getCor() == PRETO){
            if(pecaDestino == null && (linhaDestino == this.getLinha() - 2 && colunaDestino == getColuna()) ){
            return true;
        }
        }
        if(this.getCor() == PRETO){
            if(pecaDestino == null && (linhaDestino == this.getLinha() - 1 && colunaDestino == getColuna()) ){
            return true;
        }
        }
       
        }else{
            if(this.getCor() == BRANCO){
            if(pecaDestino == null && (linhaDestino == this.getLinha() + 1 && colunaDestino == getColuna()) ){
            return true;
        }
        }
        if(this.getCor() == PRETO){
            if(pecaDestino == null && (linhaDestino == this.getLinha() - 1 && colunaDestino == getColuna()) ){
            return true;
        }
        }
        }
          //--------------MOVIMENTO COMENDO OUTRA PEÇA------------------------
        /*
        if(this.getCor() == BRANCO){
        if(pecaDestino != null){
            if(linhaDestino == this.getLinha()+1 && (colunaDestino == this.getColuna()+1 || colunaDestino == this.getColuna() - 1 )){      
              
                return true;
                
            }
        }
        }
        if(this.getCor() == PRETO){
        if(pecaDestino != null){
            if(linhaDestino == this.getLinha()-1 && (colunaDestino == this.getColuna()+1 || colunaDestino == this.getColuna() - 1 )){      
             
                return true;
                
            }
        }
        }

        */
        return false;
        
    }
    
    public boolean validaMovimento1(int linhaDestino, int colunaDestino) { //
        
        Peca pecaDestino = getTabuleiro().getPeca(linhaDestino,colunaDestino);
        
         if(this.getCor() == BRANCO){
        if(pecaDestino != null){
            if(linhaDestino == this.getLinha()+1 && (colunaDestino == this.getColuna()+1 || colunaDestino == this.getColuna() - 1 )){      
              
                return true;
                
            }
        }
        }
        if(this.getCor() == PRETO){
        if(pecaDestino != null){
            if(linhaDestino == this.getLinha()-1 && (colunaDestino == this.getColuna()+1 || colunaDestino == this.getColuna() - 1 )){      
             
                return true;
                
            }
        }
        }
        return false;
    }
    
    public void setPrimeiroMovimento(boolean primeiroMovimento){
        this.primeiroMovimento = primeiroMovimento;
    }
    
    
    
}
