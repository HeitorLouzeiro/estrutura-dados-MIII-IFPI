/* 
4. Faça um programa que cadastre 8 alunos. 
Para cada aluno devem ser cadastrados: nome, nota 1 e nota 2. 
Primeiro, liste todos os alunos cadastrados ordenando-os pela média ponderada das notas,
tendo a primeira nota peso 2 e a segunda peso 3.
Em seguida, ordene os alunos, de forma crescente, pela nota 1, e liste-os.
Finalmente, considerando que para ser aprovado o aluno deve ter no mínimo média 7, 
liste, em ordem alfabética, os alunos reprovados.

*/
class Alunos{
    String nome;
    double nota1;
    double nota2;
    double media;
    
    public Alunos(String nome, double nota1, double nota2){
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.media = (nota1*2 + nota2*3)/5;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public static void ordenaMedia(Alunos[] alunos){
        for(int i = 0; i < alunos.length; i++){
            for(int j = i +1; j < alunos.length; j++){
                if(alunos[i].getMedia() > alunos[j].getMedia()){
                    Alunos aux = alunos[i];
                    alunos[i] = alunos[j];
                    alunos[j] = aux;
                }
            }
        }
        for(int i = 0; i < alunos.length; i++){
            System.out.println("Nome: " + alunos[i].getNome() + " Média: " + alunos[i].getMedia());
        }
        
    }

    public static void ordenaNota1(Alunos[] alunos){
        for(int i = 0; i < alunos.length; i++){
            for(int j = i + 1; j < alunos.length; j++){
                if(alunos[i].getNota1() < alunos[j].getNota1()){
                    Alunos aux = alunos[i];
                    alunos[i] = alunos[j];
                    alunos[j] = aux;
                }
            }
        }

        for(int i = 0; i < alunos.length; i++){
            System.out.println("Nome: " + alunos[i].getNome() + " Nota 1: " + alunos[i].getNota1());
        }
        
    }

    public static void reprovados(Alunos[] alunos){
        for(int i = 0; i < alunos.length; i++){
            for(int j = i + 1; j < alunos.length; j++){
                if(alunos[i].getNome().compareTo(alunos[j].getNome()) > 0){
                    Alunos aux = alunos[i];
                    alunos[i] = alunos[j];
                    alunos[j] = aux;
                }
            }

            if(alunos[i].getMedia() < 7){
                System.out.println("Nome: " + alunos[i].getNome() + " Média: " + alunos[i].getMedia());
            }
        }
    }
    
}
public class Q4 {
    public static void main(String[] args) {
        Alunos[] alunos = new Alunos[8];
        alunos[0] = new Alunos("João", 7, 8);
        alunos[1] = new Alunos("Maria", 5, 6);
        alunos[2] = new Alunos("José", 8, 5);
        alunos[3] = new Alunos("Ana", 5, 9);
        alunos[4] = new Alunos("Carlos", 4, 6);
        alunos[5] = new Alunos("Arthur", 8, 10);
        alunos[6] = new Alunos("Pedro", 4, 4);
        alunos[7] = new Alunos("Paulo", 10, 10);
        
        System.out.println("Ordenando por média");
        Alunos.ordenaMedia(alunos);
        System.err.println("");
        
        System.out.println("Ordenando por nota 1");
        Alunos.ordenaNota1(alunos);
        System.out.println("");

        System.out.println("Alunos reprovados");
        Alunos.reprovados(alunos);
        System.out.println("");

        
    }
    
}
