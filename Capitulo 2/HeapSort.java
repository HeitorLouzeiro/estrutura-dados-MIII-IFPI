public class HeapSort {
    public static void main(String[] args) {
        int array[] = { 5, 3, 7, 6, 2, 8, 4, 9, 1, 10 };
        int quantidade = array.length;

        //System.err.println(n);
        //System.err.println(quantidade);

        transformaHeap(array, quantidade);

        ordena(array, quantidade);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void transformaHeap(int[] array, int quantidade) {
        int i;
        for (i = quantidade / 2 - 1; i >= 0; i--) {
            heapFica(array, i, quantidade);
        }
    }

    public static void heapFica(int[] array, int i, int quantidade) {
        int filhoEsquerdo, filhoDireito, filhoMaior, auxiliar;

        filhoMaior = i;
        filhoEsquerdo = 2 * i + 1;
        filhoDireito = 2 * i + 2;

        if (filhoEsquerdo < quantidade && array[filhoEsquerdo] > array[filhoMaior]) {
            filhoMaior = filhoEsquerdo;
        }

        if (filhoDireito < quantidade && array[filhoDireito] > array[filhoMaior]) {
            filhoMaior = filhoDireito;
        }

        if (filhoMaior != i) {
            auxiliar = array[i];
            array[i] = array[filhoMaior];
            array[filhoMaior] = auxiliar;
            heapFica(array, filhoMaior, quantidade);
        }
    }

    public static void ordena(int[] array, int quantidade) {
        int i, auxiliar;
        for (i = quantidade - 1; i >= 0; i--) {
            auxiliar = array[0];
            array[0] = array[i];
            array[i] = auxiliar;
            quantidade--;
            heapFica(array, 0, quantidade);
        }
    }
}


/* 
Para realizar a análise do algoritmo de ordenação HEAP SORT, é necessário antes
analisar a complexidade de dois procedimentos: heap_fica e transformaHeap.
O procedimento heapFica é aplicado sempre a um nó da árvore, que representa na verdade um elemento do vetor,
e "afunda" esse nó até que a propriedade HEAP seja válida.
O pior caso ocorre quando o procedimento é aplicado sobre o primeiro elemento (raiz da árvore) e
este deve afundar até alcançar uma folha. Logo, o número de trocas realizadas corresponderá à altura da árvore, que é log n.
Portanto, o procedimento heapFica gasta O(log n).
O procedimento transformaHeap utiliza o procedimento heapFica, conforme mostrado a seguir.
Considerando que quantidade é o número de elementos do vetor que formam o HEAP,
e a estrutura de repetição para será executada quantidade/2 vezes e ainda
que o tempo de execução do heapFica é log n, portanto,
o tempo de execução do procedimento transformaHeap é T(n) = n/2 · logn = O(n ·logn).
 */