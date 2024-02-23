public class SelectionSort {
    public static void main(String[] args) {
        // Array desordenado
        int[] array = { 64, 25, 12, 22, 11 };

        // Tamanho do array
        int n = array.length;

        // Algoritmo de ordenação
        /* 
         * i = 0
         * numeroSelecionado = array[0] = 64
         * menorNumero = array[1] = 25
         * posicaoMenorNumero = 1
         */

        int i, j, numeroSelecionado, menorNumero, posicaoMenorNumero;

        for (i = 0; i < n - 1; i++) {
            numeroSelecionado = array[i];
            menorNumero = array[i + 1];
            posicaoMenorNumero = i + 1;

            /* 
             * j = 2
             * j = 2 < n = 5 ? true
             * array[2] = 12 < menorNumero = 25 ? true
             * menorNumero = 12
             * posicaoMenorNumero = 2
             */
            for (j = i + 2; j < n; j++) {
                if (array[j] < menorNumero) {
                    menorNumero = array[j];
                    posicaoMenorNumero = j;
                }
            }

            /* 
             * menorNumero = 12 < numeroSelecionado = 64 ? true
             * array[0] = array[2] = 12
             * array[2] = 64
             */
            if (menorNumero < numeroSelecionado) {
                array[i] = array[posicaoMenorNumero];
                array[posicaoMenorNumero] = numeroSelecionado;
            }
        }

        // Imprime o vetor ordenado
        for (int arr : array) {
            System.out.print(arr + " ");
        }
    }
}
/* 
Logo, o tempo de execução do SELECTION SORT é O(n2) .
Independentemente do vetor de entrada,
o algoritmo se comportará da mesma maneira.
Lembrando que a no-tação O(n2) indica que o tempo de execução do algoritmo
é limitado superiormente e inferiormente pela função n^2.
*/