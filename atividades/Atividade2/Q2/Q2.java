package Q2;
/* 
2. Faça um programa para executar as operações abaixo em uma árvore binária. Menu
1 - Inserir número
2 - Mostrar todos
Ex. Dado que tenha a árvore:
Faça a seguinte representação:
6(2(1 4(3)) 8) 
3 - Mostrar a subárvore da direita
4 - Mostrar a subárvore da esquerda 
5 - Mostrar o nó pai e os nós filhos de um nó 
6 - Sair

 */
import java.util.Scanner;

class Node {
    int data; // Armazena o valor do nó
    Node esquerda, direita; // aponta para o nó esquerda e direita

    // Construtor para inicializar o nó
    Node(int data) {
        this.data = data; // Atribui o valor do nó
        esquerda = direita = null; // Inicializa os nós esquerda e direita como nulo
    }
}

// Classe para criar a árvore binária
class BinaryTree {
    Node raiz; // Raiz da árvore

    BinaryTree() {
        raiz = null; // Inicializa a raiz como nulo
    }

    // Método para inserir um nó na árvore
    void insert(int data) {
        raiz = insertRec(raiz, data);
    }

    Node insertRec(Node raiz, int data) {
        /* 
         * Se a árvore estiver vazia, então cria um novo nó e retorna ele
         * como raiz da árvore binária
         */
        if (raiz == null) {
            raiz = new Node(data);
            return raiz;
        }

        /* 
         * Caso contrário, recorre pela árvore
         * Se o valor do nó for menor que o valor da raiz,
         * então recorre pela subárvore esquerda e insere o nó
         * Se o valor do nó for maior que o valor da raiz,
         * então recorre pela subárvore direita e insere o nó
         * Se o valor do nó for igual ao valor da raiz, então retorna a raiz
         * sem fazer nenhuma alteração
         */
        if (data < raiz.data) {
            raiz.esquerda = insertRec(raiz.esquerda, data);
        } else if (data > raiz.data) {
            raiz.direita = insertRec(raiz.direita, data);
        }

        return raiz;
    }

    void mostrarTodos(Node raiz) {
        if (raiz == null) {
            return;
        }
        
        /* 
         * Mostra o nó raiz ou seja o primeiro nó da árvore
         */
        System.out.print(raiz.data);
    
        if (raiz.esquerda != null || raiz.direita != null) {
            System.out.print("(");
            mostrarTodos(raiz.esquerda);
            System.out.print(" ");
            mostrarTodos(raiz.direita);
            System.out.print(")");
        }
    }

    void mostrarSubArvoreDireita(Node raiz) {
        if (raiz == null) {
            return;
        }

        mostrarTodos(raiz.direita);
    }

    void mostrarSubArvoreEsquerda(Node raiz) {
        if (raiz == null) {
            return;
        }

        mostrarTodos(raiz.esquerda);
    }

    void mostrarPaiENosFilhos(Node raiz, int data) {
        if (raiz == null) {
            return;
        }

        if (raiz.data == data) {
            System.out.println("Pai: " + raiz.data);
            if (raiz.esquerda != null) {
                System.out.println("Filho esquerda: " + raiz.esquerda.data);
            }
            if (raiz.direita != null) {
                System.out.println("Filho direita: " + raiz.direita.data);
            }
        }

        mostrarPaiENosFilhos(raiz.esquerda, data);
        mostrarPaiENosFilhos(raiz.direita, data);
    }


}

public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        while (true) {
            System.out.println("1 - Inserir número");
            System.out.println("2 - Mostrar todos");
            System.out.println("3 - Mostrar a subárvore da direita");
            System.out.println("4 - Mostrar a subárvore da esquerda");
            System.out.println("5 - Mostrar o nó pai e os nós filhos de um nó");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                                         
/*                     System.out.print("Número: ");
                    int numero = scanner.nextInt();
                    tree.insert(numero);  */
                    

                    //tree.insert(10);

                    /* Nós filhos de 10 */
                    //tree.insert(5);
                    //tree.insert(15);

                    /* Nós filhos de 5 */
                    //tree.insert(3);
                    //tree.insert(7);

                    /* Nós filhos de 15 */
                    //tree.insert(12);
                    //tree.insert(17);

                    /* Nós filhos de 3 */
                    //tree.insert(1);
                    //tree.insert(4);

                    /* Nós filhos de 7 */
                    //tree.insert(6); 

                    /* 
                     * Exemplo da árvore binária 2
                     */
                    tree.insert(6);
                    tree.insert(2);
                    tree.insert(8);
                    tree.insert(1);
                    tree.insert(4);
                    tree.insert(3);


                    System.out.println("Árvore binária criada com sucesso");

                    break;
                case 2:
                    tree.mostrarTodos(tree.raiz);
                    System.out.println();
                    break;
                case 3:
                    tree.mostrarSubArvoreDireita(tree.raiz);
                    System.out.println();
                    break;
                case 4:
                    tree.mostrarSubArvoreEsquerda(tree.raiz);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Número: ");
                    int numeroNo = scanner.nextInt();
                    tree.mostrarPaiENosFilhos(tree.raiz, numeroNo);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}
