package Q1;
/* 
Faça um programa para executar as operações abaixo em uma árvore binária. 
Menu 
1 - Inserir número 
2 - Mostrar os nós folha 
3 - Mostrar os nós ancestrais de um nó 
4 - Mostrar os nós descendentes de um nó 
5 - Mostrar o nó pai e os nós filhos de um nó 
6- Sair  
*/


import java.util.Scanner;

class Node {
    int data; // Armazena o valor do nó
    Node esquerda, direita; // aponta para o nó esquerda e direita

    Node(int data) {
        this.data = data; // Atribui o valor do nó, this.data é o valor do nó e data é o valor passado como parâmetro
        esquerda = direita = null; // Inicializa os nós esquerda e direita como nulo
    }
}

class BinaryTree {
    Node raiz; // Raiz da árvore

    BinaryTree() {
        raiz = null; // Inicializa a raiz como nulo
    }

    void insert(int data) {
        raiz = insertRec(raiz, data); // Chama o método insertRec passando a raiz e o valor a ser inserido
    }

    Node insertRec(Node raiz, int data) {
        if (raiz == null) { 
            raiz = new Node(data); // Se a raiz for nula, cria um novo nó com o valor passado como parâmetro
            return raiz; // Retorna a raiz
        }

        // raiz.data é o valor do nó atual
        if (data < raiz.data) {
            raiz.esquerda = insertRec(raiz.esquerda, data);
        } else if (data > raiz.data) {
            raiz.direita = insertRec(raiz.direita, data);
        }

        return raiz;
    }

    void mostrarNosFolhas(Node raiz) {
        if (raiz == null) {
            return;
        }
        // Se o nó atual não tiver filhos, então é um nó folha
        if (raiz.esquerda == null && raiz.direita == null) {
            System.out.print(raiz.data + " ");
        }

        mostrarNosFolhas(raiz.esquerda);
        mostrarNosFolhas(raiz.direita);
    }


    void mostrarAncestrais(Node raiz, int data) {
        if (raiz == null) {
            return;
        }

        if (raiz.data == data) {
            return;
        }

        // Se o valor do nó for menor que o valor da raiz, então o nó é um ancestral
        if (data < raiz.data) {
            System.out.print(raiz.data + " ");
            mostrarAncestrais(raiz.esquerda, data);
            
        } else {
            System.out.print(raiz.data + " ");
            mostrarAncestrais(raiz.direita, data);
        }
    }


    // Mostra o nó pai e os nós filhos de um nó
    void mostrarNosPaiFilhos(Node raiz, int data) {
        if (raiz == null) {
            return;
        }

        // Se o nó atual for igual ao nó passado como parâmetro
        if (raiz.data == data) {
            System.out.print("Nó Pai: " + raiz.data + " ");
            // Se o nó atual tiver filhos, então mostra os filhos
            if (raiz.esquerda != null) {
                System.out.print("Filhos a esquerda: " + raiz.esquerda.data + " ");
            }
            // Se o nó atual tiver filhos, então mostra os filhos
            if (raiz.direita != null) {
                System.out.print("Filhos a direita: " + raiz.direita.data + " ");
            }
            return;
        }

        // Se o valor do nó for menor que o valor da raiz, então recorre pela subárvore esquerda
        if (data < raiz.data) {
            mostrarNosPaiFilhos(raiz.esquerda, data);
        } else {
            mostrarNosPaiFilhos(raiz.direita, data);
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        while (true) {
            System.out.println("Menu");
            System.out.println("1 - Inserir número");
            System.out.println("2 - Mostrar os nós folha");
            System.out.println("3 - Mostrar os nós ancestrais de um nó");
            System.out.println("4 - Mostrar o nó pai e os nós filhos de um nó");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    /*System.out.print("Número: ");
                    int number = scanner.nextInt();
                    tree.insert(number);*/
                    tree.insert(10);

                    /* Nós filhos de 10 */
                    tree.insert(5);
                    tree.insert(15);

                    /* Nós filhos de 5 */
                    tree.insert(3);
                    tree.insert(7);

                    /* Nós filhos de 15 */
                    tree.insert(12);
                    tree.insert(17);

                    /* Nós filhos de 3 */
                    tree.insert(1);
                    tree.insert(4);

                    /* Nós filhos de 7 */
                    tree.insert(6);

                    System.out.println("Árvore binária criada com sucesso");
                    break;
                case 2:
                    System.out.print("Nós folha: ");
                    tree.mostrarNosFolhas(tree.raiz);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Nó: ");
                    int node = scanner.nextInt();
                    System.out.print("Nós ancestrais: ");
                    tree.mostrarAncestrais(tree.raiz, node);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Nó: ");
                    int node2 = scanner.nextInt();
                    tree.mostrarNosPaiFilhos(tree.raiz, node2);
                    System.out.println();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
