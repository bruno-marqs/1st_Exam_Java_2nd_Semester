import java.util.Scanner;

public class Elevador {
    private int andar;
    private int topo;
    private int capacidade;
    private int qnt;

    public Elevador(int andar, int topo, int capacidade, int qnt){
        this.andar = andar;
        this.topo = topo;
        this.capacidade = capacidade;
        this.qnt = qnt;
    }

    public int getQnt() {
        return qnt;
    }

    public int getAndar() {
        return andar;
    }

    public void entrar(){
        if(qnt < capacidade){
            qnt ++;
        }
        else{
            System.out.println("Elevador cheio");
        }
    }

    public void sair(){
        if(qnt > 0){
            qnt --;
        }
        else{
            System.out.println("Elevador vazio");
        }
    }

    public void subir(){
        if(andar < topo){
            andar ++;
        }
        else if(andar == topo){
            System.out.println("Você já está no último andar");
        }

    }

    public void descer(){
        if(andar > 0){
            andar --;
        }
        else{
            System.out.println("Você já está no térreo");
        }
    }

    public static void main(String[] args) {
        System.out.println("Determine a capacidade do elevador, em pessoas");
        Scanner s = new Scanner(System.in);
        int capacidade = s.nextInt();

        Elevador elev1 = new Elevador(0, 5, capacidade, 0);

        for(int i = 0; i < capacidade; i++){
            elev1.entrar();
        }
        System.out.println("Tem " + elev1.getQnt() + " passageiros dentro do elevador.");
        elev1.entrar();
        
        
        for(int i = 0; i < 5; i++){
            elev1.subir();
        }
        elev1.subir();
        
        int x = elev1.getQnt();              // Go Horse(?)
        for(int i = 0; i < x; i++){
            elev1.sair();
        }
        System.out.println("Tem " + elev1.getQnt() + " passageiros dentro do elevador.");
        elev1.sair();

        for(int i = 0; i < 5; i++){
            elev1.descer();
        }
        elev1.descer();

        s.close();
    }


}
