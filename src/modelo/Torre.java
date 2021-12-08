
package modelo;

//import static modelo.Tabuleiro.pecas;
import static modelo.TipoCor.BRANCO;
import static modelo.TipoCor.PRETO;



public class Torre extends Peca {
    
    public Peca[][] pecas;
    public Tabuleiro tabuleiro;
    private Peca pecaSelecionada = null;

    public Torre(TipoCor cor,int linha,int coluna){
        super(cor,linha,coluna,"src/figs/TORRE"+cor+".png");           
    }
    
    public Torre(TipoCor cor,int linha,int coluna,String imagem){
        super(cor,linha,coluna,imagem);
    }
    
    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        
        Peca pecaDestino = getTabuleiro().getPeca(linhaDestino,colunaDestino);
       
        if((linhaDestino != this.getLinha() && colunaDestino != this.getColuna())){
            return false;
        }
        
        
       
            for(int i=this.getLinha()+1;i<linhaDestino;i++){
                
                if(Tabuleiro.pecas[i][colunaDestino] != null && !(Tabuleiro.pecas[i][colunaDestino] instanceof Ponto)){
                   
                    return false;
                }
       
            }
            
            for(int i=this.getLinha()-1;i>linhaDestino;i--){
                
                if(Tabuleiro.pecas[i][colunaDestino] != null && !(Tabuleiro.pecas[i][colunaDestino] instanceof Ponto)){
                   
                    return false;
                }
       
            }
            
            for(int j=this.getColuna()+1;j<colunaDestino;j++){
                

                if(Tabuleiro.pecas[linhaDestino][j] != null && !(Tabuleiro.pecas[linhaDestino][j] instanceof Ponto)){
                    
                    return false;
                }
       
            }
            
            for(int j=this.getColuna()-1;j>colunaDestino;j--){
                

                if(Tabuleiro.pecas[linhaDestino][j] != null && !(Tabuleiro.pecas[linhaDestino][j] instanceof Ponto)){
                    
                    return false;
                }
       
            }
 
        

        return true;
        
    }
    
    @Override
     public boolean validaMovimento1(int linhaDestino, int colunaDestino) {
        return false;
    }

    
}