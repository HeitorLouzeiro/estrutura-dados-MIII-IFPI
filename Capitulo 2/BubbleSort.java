/**
 * bubbleSort
 */
public class BubbleSort {
    public static void main(String[] args) {
        // Array desordenado
        int[] array = { 5, 4, 3, 2, 1 };

        // Tamanho do vetor
        int tamanhoVetor = array.length;

        // Algoritmo de ordenação
        for (int i = 0; i < tamanhoVetor - 1; i++) {
            // Verifica se o valor atual é maior que o próximo.
            for (int j = 0; j < tamanhoVetor - 1; j++) {
                /* 
                * Se for, troca os valores
                * Exemplo:
                * array[0] = 5
                * array[1] = 4
                *
                * array[0] > array[1] ? true
                * array[0] = 4
                * array[1] = 5

                * array[1] = 5
                * array[2] = 3
                *
                * array[1] > array[2] ? true
                * array[1] = 3
                * array[2] = 5
                */
                

                if (array[j] > array[j + 1]) {
                    /* 
                     * Troca os valores
                     * Exemplo:
                     * array[0] = 4
                     * array[1] = 5
                     * 
                     * temp = array[0]
                     * array[0] = array[1]
                     * array[1] = temp
                     * 
                     */
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        // Imprime o vetor ordenado
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

/* Aplicando a mesma ideia sobre um algoritmo com um vetor de tamanho n,
ele re-alizará n(n - l) = n2 - n comparações (linha 5).
Pode-se dizer que o tempo de execução do algoritmo BUBBLE SORTED é O(n2). 
*/