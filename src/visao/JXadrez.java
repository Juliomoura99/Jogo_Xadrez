
package visao;

import empateoudesistencia.Desistir;
import empateoudesistencia.Empate;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import modelo.Peca;
import modelo.Rei;
import modelo.Tabuleiro;
import static modelo.Tabuleiro.vezNome;
import modelo.TipoCor;
import static modelo.TipoCor.BRANCO;
import static modelo.TipoCor.PRETO;
import telas.Jogadores;
import static telas.Jogadores.jogador1;
import static telas.Jogadores.jogador2;

public class JXadrez extends JFrame { 
    
    public Jogadores jogadores;
    private static JLabel lbVez;
    public Tabuleiro tabuleiro;
    private JButton btEmpate;
    private JButton btDesistir;
   
 
    
    public JXadrez(){                        
       setExtendedState(MAXIMIZED_BOTH);
       setTitle("Jogo de Xadrez");
       this.setLayout(new BorderLayout());
       this.tabuleiro = new Tabuleiro();   
       this.add(new JTabuleiro(new Tabuleiro()),BorderLayout.CENTER);
      
        
        final JPanel painelTopo = new JPanel();
        lbVez = new JLabel("VEZ: "+jogador1); //VEZ:BRANCO
  
        painelTopo.add(lbVez);
        this.add(painelTopo,BorderLayout.WEST);
        

        
        final JPanel painelLateral = new JPanel();
        painelLateral.setLayout(new GridLayout(10,1));
        btEmpate = new JButton("Declarar Empate");
        btDesistir = new JButton("Desistir da partida");
        painelLateral.add(btEmpate);
        painelLateral.add(btDesistir);
        this.add(painelLateral,BorderLayout.EAST);
  
        btEmpate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
              Empate e = new Empate();
              e.setVisible(true);
              e.setLocationRelativeTo(null);
               
            }
    });
        
         btDesistir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
               Desistir d = new Desistir();
               d.setVisible(true);
               d.setLocationRelativeTo(null);
             
            }
    });
    
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.pack();
        this.setVisible(true);
        
       
    }
    

    public static void setVez(TipoCor corVez){
        lbVez.setText("VEZ:"+ vezNome);

    }
    
    public static void main(String args[]){
        new JXadrez();
    }
    
   
}
