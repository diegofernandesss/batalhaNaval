package batalhanaval;

public class Jogador {
    private String nome;
    private Campo meucampo;
    private Campo campoinimigo;
    private int cont = 0;
    private Exception e = new Exception();

    public Jogador(String nome, Campo meucampo) {
        this.nome = nome;
        this.meucampo = meucampo;
        this.campoinimigo = new Campo();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public Campo getMeucampo() {
        return meucampo;
    }

    public void setMeucampo(Campo meucampo) {
        this.meucampo = meucampo;
    }

    public Campo getCampoinimigo() {
        return campoinimigo;
    }

    public void setCampoinimiigo(Campo campoiminigo) {
        this.campoinimigo = campoiminigo;
    }
    
    public void registrarTiro(int linha, int coluna,Campo iminigo){
        if(e.verificarTiro(linha,coluna,iminigo.getCampo())){
            campoinimigo.setPosicao(linha, coluna, iminigo.getPosicao(linha, coluna));
            System.out.println("Acertou um navio");
            cont++;
            this.setCont(cont);
        }
        else{
            campoinimigo.setPosicao(linha, coluna, 'o');
            System.out.println("Tiro na agua");
        }
    }
    
    public boolean venceu(){
        return cont==12;
    }
    
    
}
