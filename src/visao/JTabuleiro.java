
package visao;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import modelo.Peca;
import modelo.Tabuleiro;


public class JTabuleiro extends JPanel implements MouseListener  {
    
    private final Tabuleiro tabuleiro; 
  
    
    public JTabuleiro(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
        this.desenhaTabuleiro();
    }
    
    public void desenhaTabuleiro() {
        //JXadrez.painelCemiterio.removeAll();
        this.removeAll();
        this.setLayout(new GridLayout(8,8)); //faz uma tabela na tela, no caso 8x8
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
            JCelula jCelula;
            final Peca peca = this.tabuleiro.getPeca(i,j);
            if(peca == null){
                jCelula = new JCelula(i,j);
            }else{
                jCelula = new JCelula(new JPeca(peca));
            }
            if((i + j) % 2 == 0){
                jCelula.setBackground(Color.WHITE);
            }
            else{
                jCelula.setBackground(Color.ORANGE);
            }
            this.add(jCelula);
            jCelula.addMouseListener(this);
        }
        }
        /*
        for(Peca pecaRemovida : this.tabuleiro.getPecasForaJogo()){
            
            JXadrez.painelCemiterio.add(new JPeca(pecaRemovida));
        }
*/
        
        
        this.revalidate();
    }
    
    public Tabuleiro getTabuleiro(){
        return this.tabuleiro;
    }
    
    //public void setTabuleiro(Tabuleiro tabuleiro){ ///tirar caso de errado
    //    this.tabuleiro = tabuleiro;}

    @Override
    public void mouseClicked(MouseEvent e) {
        JCelula jCelula = (JCelula) e.getSource();
        this.tabuleiro.realizaJogada(jCelula.getLinha(),jCelula.getColuna());
        this.desenhaTabuleiro();
    }

    
    @Override
    public void mousePressed(MouseEvent arg0) {
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        
    }

 
}
