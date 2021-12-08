
package modelo;


public class Bispo extends Peca {

    public Bispo(TipoCor cor,int linha,int coluna){
        super(cor,linha,coluna,"src/figs/BISPO"+cor+".png");
    }
    
    public Bispo(TipoCor cor,int linha,int coluna,String imagem){
        super(cor,linha,coluna,imagem);
    }
    
    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        
          Peca pecaDestino = getTabuleiro().getPeca(linhaDestino,colunaDestino);
          int j;
          
          
          
          if((linhaDestino == this.getLinha()+1 && colunaDestino == this.getColuna()+1) || (linhaDestino == this.getLinha()+2 && colunaDestino == this.getColuna()+2)|| (linhaDestino == this.getLinha()+3 && colunaDestino == this.getColuna()+3) ||
            (linhaDestino == this.getLinha()+4 && colunaDestino == this.getColuna()+4) || (linhaDestino == this.getLinha()+5 && colunaDestino == this.getColuna()+5)
            || (linhaDestino == this.getLinha()+6 && colunaDestino == this.getColuna()+6)|| (linhaDestino == this.getLinha()+7 && colunaDestino == this.getColuna()+7)
            ){
              j = this.getColuna()+1;
              for(int i=this.getLinha()+1;i<linhaDestino;i++){
                  
                  if(Tabuleiro.pecas[i][j] != null && !(Tabuleiro.pecas[i][j] instanceof Ponto)){
                      return false;
                  }
                  
                  j++;   
                  
          }
          }
          
          
          if((linhaDestino == this.getLinha()+1 && colunaDestino == this.getColuna()-1) || (linhaDestino == this.getLinha()+2 && colunaDestino == this.getColuna()-2)|| (linhaDestino == this.getLinha()+3 && colunaDestino == this.getColuna()-3) ||
            (linhaDestino == this.getLinha()+4 && colunaDestino == this.getColuna()-4) || (linhaDestino == this.getLinha()+5 && colunaDestino == this.getColuna()-5)
            || (linhaDestino == this.getLinha()+6 && colunaDestino == this.getColuna()-6)|| (linhaDestino == this.getLinha()+7 && colunaDestino == this.getColuna()-7)
            ){
              j = this.getColuna()-1;
              for(int i=this.getLinha()+1;i<linhaDestino;i++){
                  
                  if(Tabuleiro.pecas[i][j] != null && !(Tabuleiro.pecas[i][j] instanceof Ponto)){
                      return false;
                  }
                  
                  j--;   
                  
          }
          }
          
          
          
          if((linhaDestino == this.getLinha()-1 && colunaDestino == this.getColuna()-1) || (linhaDestino == this.getLinha()-2 && colunaDestino == this.getColuna()-2)|| (linhaDestino == this.getLinha()-3 && colunaDestino == this.getColuna()-3) ||
            (linhaDestino == this.getLinha()-4 && colunaDestino == this.getColuna()-4) || (linhaDestino == this.getLinha()-5 && colunaDestino == this.getColuna()-5)
            || (linhaDestino == this.getLinha()-6 && colunaDestino == this.getColuna()-6)|| (linhaDestino == this.getLinha()-7 && colunaDestino == this.getColuna()-7)
            ){
              j = this.getColuna()-1;
              for(int i=this.getLinha()-1;i>linhaDestino;i--){
                  
                  if(Tabuleiro.pecas[i][j] != null && !(Tabuleiro.pecas[i][j] instanceof Ponto)){
                      return false;
                  }
                  
                  j--;   
                  
          }
          }
          
          
          if((linhaDestino == this.getLinha()-1 && colunaDestino == this.getColuna()+1) || (linhaDestino == this.getLinha()-2 && colunaDestino == this.getColuna()+2)|| (linhaDestino == this.getLinha()-3 && colunaDestino == this.getColuna()+3) ||
            (linhaDestino == this.getLinha()-4 && colunaDestino == this.getColuna()+4) || (linhaDestino == this.getLinha()-5 && colunaDestino == this.getColuna()+5)
            || (linhaDestino == this.getLinha()-6 && colunaDestino == this.getColuna()+6)|| (linhaDestino == this.getLinha()-7 && colunaDestino == this.getColuna()+7)
            ){
              j = this.getColuna()+1;
              for(int i=this.getLinha()-1;i>linhaDestino;i--){
                  
                  if(Tabuleiro.pecas[i][j] != null && !(Tabuleiro.pecas[i][j] instanceof Ponto)){
                      return false;
                  }
                  
                  j++;   
                  
          }
          }
          
          
          
              
          if((linhaDestino == this.getLinha()+1 || linhaDestino == this.getLinha()-1)&& (colunaDestino == this.getColuna()+1 || colunaDestino == this.getColuna() - 1 )){
    
                return true;
            }
            
            if((linhaDestino == this.getLinha()+2 || linhaDestino == this.getLinha()-2)&& (colunaDestino == this.getColuna()+2 || colunaDestino == this.getColuna() - 2 )){
            
                return true;
            }
            
            if((linhaDestino == this.getLinha()+3 || linhaDestino == this.getLinha()-3)&& (colunaDestino == this.getColuna()+3 || colunaDestino == this.getColuna() - 3 )){
                    return true;
    
            }
            if((linhaDestino == this.getLinha()+4 || linhaDestino == this.getLinha()-4)&& (colunaDestino == this.getColuna()+4 || colunaDestino == this.getColuna() - 4 )){
            
                return true;
                }
        
            if((linhaDestino == this.getLinha()+5 || linhaDestino == this.getLinha()-5)&& (colunaDestino == this.getColuna()+5 || colunaDestino == this.getColuna() - 5 )){
            
                return true;
                }
            
           if((linhaDestino == this.getLinha()+6 || linhaDestino == this.getLinha()-6)&& (colunaDestino == this.getColuna()+6 || colunaDestino == this.getColuna() - 6 )){
             
                return true;
              
            }
            if((linhaDestino == this.getLinha()+7 || linhaDestino == this.getLinha()-7)&& (colunaDestino == this.getColuna()+7 || colunaDestino == this.getColuna() - 7 )){
               
                return true;
                }
            
            if((linhaDestino == this.getLinha()+8 || linhaDestino == this.getLinha()-8)&& (colunaDestino == this.getColuna()+8 || colunaDestino == this.getColuna() - 8 )){
              
                return true;
                }
            
          
        return false;
            
            
      
    }
    
     public boolean validaMovimento1(int linhaDestino, int colunaDestino) {
        return false;
    }
    
}