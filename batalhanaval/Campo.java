package batalhanaval;

public class Campo {
    private final  char[][] campo;
    private int quantSub = 3;
    private int quantCruz = 2;
    private int quantPa = 1;
    private final String[] linhas;
    private final Exception e = new Exception();
    
    public Campo(){
        this.campo = new char[8][8];
        this.linhas = new String[8];
        for (char[] campo1 : campo) {
            for (int j = 0; j < campo1.length; j++) {
                campo1[j] = ' ';
            }
        }
    }
    
    public char[][] getCampo(){
        return campo;
    }
    
    public char getPosicao(int linha,int coluna){
        return campo[linha][coluna];
    }
    
    public boolean cheio(){
        return (this.quantCruz+this.quantPa+this.quantSub) ==0;
    }
    
    public void setPosicao(int linha,int coluna,char valor){
        this.campo[linha][coluna] = valor;
    }
    
    

    
    public void adicionarArma(String tipo,int linha,int coluna){
        
        switch (tipo){
            case "submarino" -> {
                if(e.verificarQuantNavio(quantSub)){
                    System.out.println("Já foram adcionados todos os submarinos");
                    break;
                }
                
                if(e.verificarPosicao(0, linha, coluna,this.campo )){
                    campo[linha][coluna] = 's';
                    this.quantSub--;
                }
                else{
                    System.out.println("Não pode adcionar navio");
                }
                break;
            }
            case "cruzador" ->{
                if(e.verificarQuantNavio(quantCruz)){
                    System.out.println("Já foram adcionados todos os cruzadores");
                    break;
                }
                
                if(e.verificarPosicao(1, linha, coluna,this.campo) && this.quantCruz>0 ){
                    campo[linha][coluna] = 'c';
                    campo[linha][coluna+1] = 'c';
                    this.quantCruz--;
                }
                else{
                    System.out.println("Não pode adcionar navio");
                }
                break;
            }
            case "porta-avioes" ->{
                if(e.verificarQuantNavio(quantPa)){
                    System.out.println("Já foram adcionados todos os porta-avioes");
                    break;
                }
                
                if(e.verificarPosicao(4, linha, coluna,this.campo) && this.quantPa>0 ){
                    for(int i=coluna;i<=coluna+4;i++){
                        campo[linha][i] = 'p';
                        this.quantPa--;
                    }
                }
                else{
                    System.out.println("Não pode adcionar navio");
                }
            }
        }
    }
    

    
    public void printCampo(){
        System.out.println("==========================================");
        System.out.println("               Batalha Naval              ");
        System.out.println("==========================================\n");
        System.out.println("    1   2   3   4   5   6   7   8  ");
        for (int i=0;i<campo.length;i++){
            System.out.print(" "+ e.getLinha(i) +" ");
            for(int j=0;j<campo[i].length;j++){
                if(campo[i][j]!=' ' ){
                    System.out.print("|"+ campo[i][j] + "| ");
                }
                else{
                    System.out.print("| | ");
                }
                
            }
            System.out.println("");
        }
        System.out.println("");
        
        
        
    }

    @Override
    public String toString() {
        
        
        return "Campo{" + '}';
    }
    
    
}
