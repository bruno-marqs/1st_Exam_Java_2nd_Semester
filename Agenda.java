import java.util.Arrays;
import java.util.Scanner;

public class Agenda{
    private Pessoa[] agenda;

    public Agenda(){
        agenda = new Pessoa[10];
    }

    public void addPessoa(){
        System.out.println("Insira o nome do contato: ");
        Scanner s = new Scanner(System.in);
        String nome = s.next();
        System.out.println("Insira a idade de " + nome);
        int idade = s.nextInt();
        System.out.println("Insira a altura de " + nome);
        float altura = s.nextFloat();
        Pessoa person = new Pessoa(nome, idade, altura);
        s.close();

        boolean cheia = true;
        for(int i = 0; i < agenda.length; i++){
            if(agenda[i] == null){
                agenda[i] = person;
                cheia = false;
                break;
            }
        }
        if(cheia){
            System.out.println("Agenda cheia");
        }
    }

    public void tirarPessoa(String nome){
        boolean achar = false;
        for(int i = 0; i < agenda.length; i++){
            if(agenda[i].getNome().equals(nome)){
                agenda[i] = null;
                achar = true;
            }
        }
        if(!achar){
            System.out.println("Contato não encontrado.");
        }
    }

    public int buscaPessoa(String nome){
        for(int i = 0; i < agenda.length; i++){
            if(agenda[i].getNome().equals(nome)){
                return i;
            }
        }

        return 11;
    }

    public void verAgenda(){
        System.out.println(Arrays.toString(agenda));
    }

    public void verPessoa(int i){
        System.out.println(agenda[i]);
    }

    public static void main(String[] args) {
        Agenda ag1 = new Agenda();
        System.out.println("Adicione 10 contatos em sua agenda");
        for(int i = 0; i < 10; i++){
            ag1.addPessoa();
        }
        System.out.println("Tente adicionar +1 contato");
        ag1.addPessoa();
        System.out.println("Busque a posição de um contato pelo seu nome:");
        Scanner s = new Scanner(System.in);
        String nome = s.next();
        ag1.buscaPessoa(nome);
        System.out.println("Remova um contato pelo seu nome");
        String name = s.next();
        ag1.tirarPessoa(name);
        System.out.println("Veja um contato por sua posição, de 1 a 10");
        int i = s.nextInt();
        ag1.verPessoa(i);
        System.out.println("Veja toda a sua agenda:");
        ag1.verAgenda();
        s.close();
    }
}