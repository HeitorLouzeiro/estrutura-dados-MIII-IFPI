public class InsertionSort {
    public static void main(String[] args) {
        int[] array = { 5, 3, 2, 4, 7, 1, 0, 6 };
        int i, j, numeroSelecionado;

        // Tamanho do vetor
        int tamanhoVetor = array.length - 1;

        /* 
         * Exemplo
         * i = 1;
         * numeroSelecionado = 3;
         * j = 1 - 1 = 0;
         * array[0] = 5;
         * j >= 0 && array[0] > 3
         * array[1] = 5;
         * array[0] = 3;
         * j = -1;
         * 
         * array[0 + 1] = 5;
         */
        for (i = 1; i <= tamanhoVetor; i++) {
            numeroSelecionado = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > numeroSelecionado) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = numeroSelecionado;
        }

        for (int arr : array) {
            System.out.println(arr);
        }
    }
}

/* 
O melhor caso do algoritmo ocorre quando o vetor de entrada fornecido possui os 
elementos já ordenados. Para cada j = 0, 1, ... , n-2, tem-se que a condição X [ j ] >eleito 
na linha 5 é falsa. Então, o custo de executar a linha 5 é 1 para cada valor de j 
e o tempo de execução do melhor caso é T(n) = O(n-1), já que se tem n-1 valores para j. 
 */