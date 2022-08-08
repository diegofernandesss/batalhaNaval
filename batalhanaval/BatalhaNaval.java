package batalhanaval;

import java.io.IOException;
import java.util.Scanner;


public class BatalhaNaval {
    

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        Jogo jogo = new Jogo();
        Jogador jogador1 = null,jogador2 = null;
        
        
        int op = 0;
        
        while(op<3){
            
            
            jogo.printMenu();
            op = s.nextInt();
            
            switch(op){
                case 1 ->{
                    if(jogador1!=null && jogador2!=null){
                        System.out.println("Os dois jogadores já foram adcionados");
                        break;
                    }
                    else if(jogador1==null){
                        jogador1 = jogo.criarJogador();
                    System.out.println("Jogador 1 criado");
                    }
                    else{
                        jogador2 = jogo.criarJogador();
                        System.out.println("Jogador 2 criado");
                    
                    }
                    
                    break;
                }
                
                case 2->{
                    if(jogador1==null || jogador2==null){
                        System.out.println("Opss!, voce não criou jogadores, não é possivel jogar!");
                        break;
                    }
                    else if(jogador1.venceu() || jogador2.venceu()){
                        System.out.println("");
                        break;
                }
                    jogo.Jogar(jogador1, jogador2);
                    
                    System.out.println("FIM DE JOGO!");
                    break;
                }
                    
            }
        
        
        }
    }
}
