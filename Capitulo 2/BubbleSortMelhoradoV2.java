public class BubbleSortMelhoradoV2 {
    public static void main(String[] args) {
        // Array desordenado
        int[] array = { 64, 34, 25, 12, 22, 11, 90 };
        int tamanhoArray = array.length;
        int temp;
        int n = 1;
        // troca = 1 para iniciar o loop
        int troca = 1;

        while (n <= tamanhoArray && troca == 1) {
            // Inicializa a variável troca
            troca = 0;

            // Algoritmo de ordenação
            for (int i = 0; i < tamanhoArray - 1; i++) {
                /* 
                 * Se for, troca os valores
                 * Exemplo:
                 * array[0] = 64
                 * array[1] = 34
                 * 
                 * array[0] > array[1] ? true
                 * array[0] = 64
                 * array[1] = 32
                 * 
                 */
                if (array[i] > array[i + 1]) {
                    troca = 1;
                    /* 
                     * Se for, troca os valores
                     * Exemplo:
                     * array[0] = 64
                     * array[1] = 34
                     * 
                     * temp = array[0]
                     * array[0] = array[1]
                     * array[1] = temp
                     * 
                     */
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            n++; // ou n = n + 1;
        }

        // Imprime o vetor ordenado
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
