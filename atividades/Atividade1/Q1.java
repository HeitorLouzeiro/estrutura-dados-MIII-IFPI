/* 
1. Faça um programa que cadastre o nome e o salário de 5 funcionários. Usando três
métodos de ordenação diferentes, liste todos os dados dos funcionários das seguintes for
mas:
a) em ordem crescente de salário;
b) em ordem decrescente de salário;
c) em ordem alfabética.
*/
class Funcionario {
    String nome;
    double salario;
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }
    public String getNome() {
        return nome;
    }
    public double getSalario() {
        return salario;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
}

class Ordenacao {
    public static void ordenaCrescente(Funcionario[] funcionarios) {
        for (int i = 0; i < funcionarios.length; i++) {
            for (int j = i + 1; j < funcionarios.length; j++) {
                if (funcionarios[i].getSalario() > funcionarios[j].getSalario()) {
                    Funcionario aux = funcionarios[i];
                    funcionarios[i] = funcionarios[j];
                    funcionarios[j] = aux;
                }
            }
        }
        for (int i = 0; i < funcionarios.length; i++) {
            System.out.println(funcionarios[i].getNome() + " - " + funcionarios[i].getSalario());
        }
    }
    public static void ordenaDescrescente(Funcionario[] funcionarios) {
        for (int i = 0; i < funcionarios.length; i++) {
            for (int j = i + 1; j < funcionarios.length; j++) {
                if (funcionarios[i].getSalario() < funcionarios[j].getSalario()) {
                    Funcionario aux = funcionarios[i];
                    funcionarios[i] = funcionarios[j];
                    funcionarios[j] = aux;
                }
            }
        }
        for (int i = 0; i < funcionarios.length; i++) {
            System.out.println(funcionarios[i].getNome() + " - " + funcionarios[i].getSalario());
        }
    }

    public static void ordenaAlfabetica(Funcionario[] funcionarios) {
        for (int i = 0; i < funcionarios.length; i++) {
            for (int j = i + 1; j < funcionarios.length; j++) {
                /* 
                compareTo retorna 0 se as strings forem iguais
                retorna um número negativo se a primeira string for menor que a segunda
                retorna um número positivo se a primeira string for maior que a segunda 
                */
                if (funcionarios[i].getNome().compareTo(funcionarios[j].getNome()) > 0) {
                    Funcionario aux = funcionarios[i];
                    funcionarios[i] = funcionarios[j];
                    funcionarios[j] = aux;
                }
            }
        }
        for (int i = 0; i < funcionarios.length; i++) {
            System.out.println(funcionarios[i].getNome() + " - " + funcionarios[i].getSalario());
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        Funcionario [] funcionarios = new Funcionario[5];
        funcionarios[0] = new Funcionario("João", 1000);
        funcionarios[1] = new Funcionario("Maria", 2000);
        funcionarios[2] = new Funcionario("José", 1500);
        funcionarios[3] = new Funcionario("Ana", 3000);
        funcionarios[4] = new Funcionario("Carlos", 2500);
        Ordenacao.ordenaCrescente(funcionarios);
        System.out.println(" ");
        Ordenacao.ordenaDescrescente(funcionarios);
        System.out.println(" ");
        Ordenacao.ordenaAlfabetica(funcionarios);
    }
}
