/* 
5. Faça um programa que cadastre 15 números, não permitindo números repetidos.
Ordene-os em seguida, verifique se um número digitado pelo usuário está no vetor.
Caso encontre, verifique se está em uma posição par ou ímpar do vetor.

a) usando busca sequencial;
b) usando busca binária; 
*/

import java.util.Scanner;

class Numero {
    private int numero;

    public Numero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public static void inserirNumeros(Numero[] numeros) {
        Scanner scanner = new Scanner(System.in);
    
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            int numero = scanner.nextInt();
            for (int j = 0; j < numeros.length; j++) {
                /*
                 * numeros[j] != null: verifica se a posição do vetor está vazia
                 * numeros[j].getNumero() == numero: verifica se o número já foi cadastrado
                 */
                if (numeros[j] != null && numeros[j].getNumero() == numero) {
                    System.out.println("Número já cadastrado, digite outro número.");
                    // decrementa o contador para que o usuário digite o número novamente
                    i--;
                    break;
                    // se a posição do vetor estiver vazia, insere o número
                } else if (numeros[j] == null) {
                    numeros[j] = new Numero(numero);
                    break;
                }
            }
        }
    }

    public static void ordenaNumeros(Numero[] numeros) {
        System.out.println("Números ordenados:");
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i].getNumero() > numeros[j].getNumero()) {
                    int temp = numeros[i].getNumero();
                    numeros[i].setNumero(numeros[j].getNumero());
                    numeros[j].setNumero(temp);
                }
            }
            System.out.println(numeros[i].getNumero());
        }
    }

    public static void buscaSequencial(Numero[] numeros, int numero) {
        System.out.println("Busca sequencial.");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i].getNumero() == numero) {
                System.out.println("Número " + numero + " encontrado na posição " + i);
                if (i % 2 == 0) {
                    System.out.println("Número " + numero + " está na posição par do vetor.");
                } else {
                    System.out.println("Número " + numero + " está na posição ímpar do vetor.");
                }
                return;
            }
        }
        System.out.println("Número " + numero + " não encontrado.");
    }


    public static void buscaBinaria(Numero[] numeros, int numero) {
        System.out.println("Busca binária.");
        int inicio = 0;
        int fim = numeros.length - 1;
        int meio;
    
        while (inicio <= fim) {
            meio = (int) ((inicio + fim) / 2); // Calcula o meio do vetor e arredonda para baixo
            if (numeros[meio].getNumero() == numero) {
                System.out.println("Número " + numero + " encontrado na posição " + meio);
                if (meio % 2 == 0) {
                    System.out.println("Número " + numero + " está na posição par do vetor.");
                } else {
                    System.out.println("Número " + numero + " está na posição ímpar do vetor.");
                }
                return;
            } else if (numeros[meio].getNumero() < numero) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        System.out.println("Número " + numero + " não encontrado.");
    }

}

public class Q5 {
    public static void main(String[] args) {
        Numero[] numeros = new Numero[15];
        Numero.inserirNumeros(numeros);
        Numero.ordenaNumeros(numeros);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número para buscar no vetor: ");
        int numero = scanner.nextInt();
        System.out.println("");

        Numero.buscaSequencial(numeros, numero);
        System.out.println("");

        Numero.buscaBinaria(numeros, numero);
        scanner.close();
    }
}