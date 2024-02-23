public class BubbleSortMelhoradoV1 {
    public static void main(String[] args) {
        // Array desordenado
        int[] array = { 5, 4, 3, 2, 1 };

        // Tamanho do vetor
        int tamanhoVetor = array.length;

        // Algoritmo de ordenação
        for (int i = 1; i < tamanhoVetor - 1; i++) {
            // Verifica se o valor atual é menor que o anterior.

            /* 
             * Se for, troca os valores
             * Exemplo:
             * array[4] = 1
             * array[3] = 2
             * 
             * array[4] < array[3] ? true
             * array[4] = 2
             * array[3] = 1
             * 
             * array[3] = 1
             * array[2] = 3
             * 
             * array[3] < array[2] ? true
             * array[3] = 3
             * array[2] = 1
             * 
             */
            for (int j = tamanhoVetor - 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    /* 
                     * Se for, troca os valores
                     * Exemplo:
                     * array[4] = 2
                     * array[3] = 1
                     * 
                     * temp = array[4]
                     * array[4] = array[3]
                     * array[3] = temp
                     */
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        // Imprime o vetor ordenado
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
