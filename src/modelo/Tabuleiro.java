package modelo;

import empateoudesistencia.Empate;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import visao.JXadrez;
import modelo.Peao;
import modelo.Peca;
import static modelo.TipoCor.BRANCO;
import static modelo.TipoCor.PRETO;
import org.w3c.dom.Text;
import telas.Principal;
import visao.JCelula;
import visao.JTabuleiro;
import javax.swing.BorderFactory;
import static telas.Jogadores.jogador1;
import static telas.Jogadores.jogador2;
import visao.JPeca;

public class Tabuleiro {
    
    
    public static Peca[][] pecas;
    private Peca pecaSelecionada = null;
    public TipoCor vez = TipoCor.BRANCO;
    private List<Peca> pecasForaJogo;
    
    public JFrame telaFim;
    public Text textFim;
    private static JLabel text;
    private static JButton botao;
    private static JLabel text1;
    private static JButton botao1;
    
    public boolean fimJogo; 
    public boolean fimJogoXeque = false; 
    public Rei reiBranca;
    public Rei reiPreta;
    
    public Ponto ponto;
    
    int linha;
    int coluna;
    
    int jogadasEmpate;
    
    public static String vezNome;

    public Tabuleiro(){
        this.pecas = new Peca[8][8];
        this.pecasForaJogo = new ArrayList<>();

        //----------------------TORRE------------------------------
        Torre torreBranca1 = new Torre(TipoCor.BRANCO,0,0);
        Torre torreBranca2 = new Torre(TipoCor.BRANCO,0,7);
        this.adicionaPeca(torreBranca1);
        this.adicionaPeca(torreBranca2);
        Torre torrePreta1 = new Torre(TipoCor.PRETO,7,0);
        Torre torrePreta2 = new Torre(TipoCor.PRETO,7,7);
        this.adicionaPeca(torrePreta1);
        this.adicionaPeca(torrePreta2);
        
        //----------------------CAVALO------------------------------
        Cavalo cavaloBranca1 = new Cavalo(TipoCor.BRANCO,0,1);
        Cavalo cavaloBranca2 = new Cavalo(TipoCor.BRANCO,0,6);
        this.adicionaPeca(cavaloBranca1);
        this.adicionaPeca(cavaloBranca2);
        Cavalo cavaloPreta1 = new Cavalo(TipoCor.PRETO,7,1);
        Cavalo cavaloPreta2 = new Cavalo(TipoCor.PRETO,7,6);
        this.adicionaPeca(cavaloPreta1);
        this.adicionaPeca(cavaloPreta2);
        
        //----------------------BISPO------------------------------
        Bispo bispoBranca1 = new Bispo(TipoCor.BRANCO,0,2);
        Bispo bispoBranca2 = new Bispo(TipoCor.BRANCO,0,5);
        this.adicionaPeca(bispoBranca1);
        this.adicionaPeca(bispoBranca2);
        Bispo bispoPreta1 = new Bispo(TipoCor.PRETO,7,2);
        Bispo bispoPreta2 = new Bispo(TipoCor.PRETO,7,5);
        this.adicionaPeca(bispoPreta1);
        this.adicionaPeca(bispoPreta2);
        
        //----------------------RAINHA------------------------------
        Rainha rainhaBranca = new Rainha(TipoCor.BRANCO,0,3);
        this.adicionaPeca(rainhaBranca);
        Rainha rainhaPreta = new Rainha(TipoCor.PRETO,7,3);
        this.adicionaPeca(rainhaPreta);
        
        //----------------------REI------------------------------
        reiBranca = new Rei(TipoCor.BRANCO,0,4);
        this.adicionaPeca(reiBranca);
        reiPreta = new Rei(TipoCor.PRETO,7,4);
        this.adicionaPeca(reiPreta);
 
        //----------------------PEAO------------------------------
        for(int i = 0;i<8;i++){
            Peao peaoBranco = new Peao(TipoCor.BRANCO,1,i);
            this.adicionaPeca(peaoBranco);
            
            Peao peaoPreto = new Peao(TipoCor.PRETO,6,i);
            this.adicionaPeca(peaoPreto);
        }
    }

    public List<Peca> getPecasForaJogo(){
        return this.pecasForaJogo;
    }
    
    public Peca getPeca(int linha,int coluna){
        return this.pecas[linha][coluna];
    }
    
    public void setPeca(Peca peca){
        this.pecas[peca.getLinha()][peca.getColuna()] = peca;
        peca.setTabuleiro(this);
    }
    
    public void adicionaPeca(Peca peca){
        this.pecas[peca.getLinha()][peca.getColuna()] = peca;
        peca.setTabuleiro(this);
    }
    
    public void selecionaPeca(Peca peca){

        if(peca.isSelecionada()){
            
           peca.setSelecionada(false);
           this.pecaSelecionada = null;
           this.apagaPonto();
  
        }else{
            peca.setSelecionada(true);
            this.pecaSelecionada = peca;
            this.movimentosPossiveis(peca);
            
        }
    }

    public void movimentosPossiveis(Peca peca){
       
       Ponto ponto = new Ponto(TipoCor.BRANCO,linha,coluna);
       for(int i=0;i<8;i++){
           for(int j=0;j<8;j++){
               if(peca.validaMovimento(i,j) || peca.validaMovimento1(i,j)){
                   
                if(pecas[i][j] == null){
                  this.pecas[i][j] = ponto;
                }
                if(pecas[i][j] == reiBranca && peca.getCor()==PRETO){
                  
                    System.out.println("FIM JOGO - XEQUE MATE");
                        System.out.println(this.getVez()); // Se o branco perder a vez sera do **Branco**
                        JFrame janelaFim1 = new JFrame("XEQUE MATE");
                        janelaFim1.setSize(600,400);
                        
                        JPanel painel = new JPanel();
                        text1 = new JLabel("XEQUE MATE!! O "+vezNome+" VENCEU");
                        painel.add(text1);
                        janelaFim1.add(painel,BorderLayout.CENTER);
                        
                        JPanel painel2 = new JPanel();
                        botao1 = new JButton("OK"); 
                        painel2.add(botao1);
                        janelaFim1.add(painel2,BorderLayout.SOUTH);
                        
                        
                        janelaFim1.setLocationRelativeTo(null);
                        janelaFim1.setVisible(true);
                        
                        
            botao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
              janelaFim1.setVisible(false);
              System.exit(0);
              //janelaFim.dispose();
            }
    });
                }
                if(pecas[i][j] == reiPreta  && peca.getCor()==BRANCO){
                    
 
                        JFrame janelaFim2 = new JFrame("XEQUE MATE");
                        janelaFim2.setSize(600,400);
                        
                        JPanel painel = new JPanel();
                        text1 = new JLabel("XEQUE MATE!! O "+vezNome+" VENCEU");
                        painel.add(text1);
                        janelaFim2.add(painel,BorderLayout.CENTER);
                        
                        JPanel painel2 = new JPanel();
                        botao1 = new JButton("OK"); 
                        painel2.add(botao1);
                        janelaFim2.add(painel2,BorderLayout.SOUTH);
                        
                        
                        janelaFim2.setLocationRelativeTo(null);
                        janelaFim2.setVisible(true);
                        
                        
            botao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
              janelaFim2.setVisible(false);
              System.exit(0);
             
            }
    });
                }
                
                   
               }
           }
       }
    }
    
    public void apagaPonto(){
        Ponto ponto = new Ponto(TipoCor.PRETO,linha,coluna);
        
       for(int i=0;i<8;i++){
           for(int j=0;j<8;j++){
               
               Peca peca = this.pecas[i][j];
               if(peca instanceof Ponto){
                   this.pecas[i][j] = null;
               }
           }
       }
    }

    public void movePeca(Peca peca,int novaLinha,int novaColuna){
       
        if(peca.validaMovimento(novaLinha, novaColuna) || peca.validaMovimento1(novaLinha, novaColuna)){
            jogadasEmpate++;

            this.pecas[peca.getLinha()][peca.getColuna()] = null;
            peca.setLinha(novaLinha);
            peca.setColuna(novaColuna);
            
            if(peca instanceof Peao){
               
               
                    jogadasEmpate=0;
           
                
                Peao peao = (Peao) peca;
                peao.setPrimeiroMovimento(false);
            }
            
            this.setPeca(peca);
            this.selecionaPeca(peca);
            this.inverteVez();
            
        }
    }
    
    public void inverteVez(){
        if(this.vez.equals(TipoCor.BRANCO)){
            this.vez = TipoCor.PRETO;
            vezNome = jogador2;
        }else{
            this.vez = TipoCor.BRANCO;
            vezNome = jogador1;
        }
        
        JXadrez.setVez(this.vez);
    }
    
    public void realizaJogada(int linha, int coluna){
        
        Peca peca = this.getPeca(linha,coluna);
        
        apagaPonto();
        if(jogadasEmpate == 50){
                fimJogo=true;
            }
        
        if(this.pecaSelecionada == null){

            if(peca != null && peca.getCor().equals(this.vez)){
                   
                this.selecionaPeca(peca);
                
            }
        }else{
            
            if(this.pecaSelecionada == peca){
                
                this.selecionaPeca(peca);
            } else{
                
                if(peca == null) {
                    this.movePeca(this.pecaSelecionada,linha,coluna);
                }
            
             
               if(peca != null && (!peca.getCor().equals(this.pecaSelecionada.getCor()))){ 
                 
                  
                  System.out.println("COMEU PECA");
                  jogadasEmpate = 0;
                  System.out.println(jogadasEmpate);
                  
                   
                       this.movePeca(this.pecaSelecionada, linha, coluna); 
                       peca.setEliminada(true); 
                       this.pecasForaJogo.add(peca);        
                       
                    if(this.fimJogo == true){
 
                        JFrame janelaFim = new JFrame("JOGO EMPATADO");
                        janelaFim.setSize(600,400);
                        
                        JPanel painel = new JPanel();
                        text = new JLabel("JOGO EMPATADO: 50 MOVIMENTOS SEM AÇÃO DE COMER OUTRA PEÇA");
                        text1 = new JLabel(" E PEÃO NÃO SELECIONADO");
                        painel.add(text);
                        painel.add(text1);
                        janelaFim.add(painel,BorderLayout.CENTER);
                        
                        JPanel painel2 = new JPanel();
                        botao = new JButton("OK"); 
                        painel2.add(botao);
                        janelaFim.add(painel2,BorderLayout.SOUTH);
                        
                        
                        janelaFim.setLocationRelativeTo(null);
                        janelaFim.setVisible(true);
                        
                        
            botao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
              janelaFim.setVisible(false);
              System.exit(0);
            }
    });
                   }
                    
                  
            }
        }
        }
    }

    public TipoCor getVez(){
        return this.vez;
    }

}


 