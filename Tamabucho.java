import java.util.Scanner;

public class Tamabucho {
    private String nome;
    private int fome;
    private int tedio;
    private int idade;

    public Tamabucho(String nome, int fome, int tedio, int idade){
        this.nome = nome;
        this.fome = fome;
        this.tedio = tedio;
        this.idade = idade;
    }

    public String getNome() {
      return nome;
  }

    public int getFome() {
      return fome;
  }

    public int getTedio() {
      return tedio;
  }

    public int getIdade() {
      return idade;
  }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void alimentar(int comida) {
        if(fome > 0){
          if((comida > 0) && (comida <= 100)){
            this.fome -= comida;
            if(fome < 0){
              this.fome = 0;
            }
          }
        }
    }

    public void brincar(int minuto){
      if(tedio > 0){
        if((minuto > 0) && (minuto <= 100)){
          this.tedio -= minuto * 10;
          if(tedio < 0){
            this.tedio = 0;
          }
        }
      }
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double humor(){
        double mood = (fome + tedio) / 2;
            if (mood == 100) {
                System.out.println(nome + " está com humor " + mood + "\nEle morreu!");
            }
            
            else if (mood == 0){
                System.out.println(nome + " está com humor " + mood + "\nEle tá ótimo!");
            }

            else{
                System.out.println(nome + " está com humor " + mood + "\nDê mais atenção à ele");
            }
        return mood;
    }

    public static void main(String[] args) {
        System.out.println("Dê um nome ao seu bicho: ");
        Scanner s = new Scanner(System.in);
        String nome = s.next();
        Tamabucho bicho1 = new Tamabucho(nome, 50, 50, 1);
        
        System.out.println("Seu Tamabucho chamado " + nome + " irá começar com 01 ano de idade\ne Fome e Tédio pela metade.");
        System.out.println("O nome de seu Tamabucho é " + bicho1.getNome() + " e tem " + bicho1.getIdade() + " anos");
        
        // teste da classe
        while(true){
          System.out.println(bicho1.getNome() + " está com tédio de " + bicho1.getTedio() + " e fome de " + bicho1.getFome());
          System.out.println("O que você quer fazer?\n 1 - Brincar\n 2 - Alimentar\n 3 - Ver Humor");
          int escolha = s.nextInt();

          if(escolha == 1){
            System.out.println("Você decidiu brincar com " + bicho1.getNome());
            System.out.println("Por quantos minutos você quer brincar?");
            int minuto = s.nextInt();
            bicho1.brincar(minuto);
            System.out.println(bicho1.getNome() + " está com Tédio igual a " + bicho1.getTedio());
          }
          
          else if(escolha == 2){
            System.out.println("Você decidiu alimentar " + bicho1.getNome());
            System.out.println("Quanto de comida você quer dar? (0 - 100)");
            int comida = s.nextInt();
            bicho1.alimentar(comida);
            System.out.println(bicho1.getNome() + " está com Fome igual a " + bicho1.getFome());
          }

          else if(escolha ==3){
            System.out.println("Você escolheu ver o nível de humor de " + bicho1.getNome());
            System.out.println(bicho1.humor());
          }


          else{
            System.out.println("Entrada inválida. Tente outra vez");
          }
          
          
        }
        
      }
}