
package visao;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import modelo.Peca;


public class JCelula extends JPanel{
    
    private JPeca jPeca;
    private int linha, coluna;
    
    public JCelula(int linha,int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }
    
    public JCelula(JPeca jPeca) { 

        this.jPeca = jPeca;
        this.linha = jPeca.getPeca().getLinha();
        this.coluna = jPeca.getPeca().getColuna();
        this.add(jPeca);
        if((jPeca.getPeca() != null)&&(jPeca.getPeca().isSelecionada())){
            this.setBorder(BorderFactory.createLineBorder(Color.GREEN,5));
         
            
        }
    }

        
    /*
    public JCelula movimento(int linha,int coluna){
        
        if((jPeca.getPeca() != null)&&(jPeca.getPeca().isSelecionada())){
            
        }
        
        
        return null;
        
    }
*/
    
 
    
    public int getLinha(){
        return this.linha;
    }
    
    public int getColuna(){
        return this.coluna;
    }

  
}
