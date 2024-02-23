public class MergeSort {
    public static void main(String[] args) {
        // array desordenado
        int[] array = { 5, 2, 4, 6, 1, 3 };

        // tamanho do array
        int n = array.length - 1;

        // ordena o array
        merge(array, 0, n);

        // array ordenado
        for (int arr : array) {
            System.out.print(arr + " ");
        }
    }

    // método de ordenação
    public static void merge(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (int)((inicio + fim) / 2);

            merge(array, inicio, meio);
            merge(array, meio + 1, fim);
            intercala(array, inicio, meio, fim);
        }
    }

    // método de intercalação
    public static void intercala(int[] array, int inicio, int meio, int fim) {
        // variáveis auxiliares
        int posicaoLivre, inicioVetor1, inicioVetor2, i;
        
        // vetor auxiliar
        int[] auxiliar = new int[array.length];
        
        inicioVetor1 = inicio;
        inicioVetor2 = meio + 1;
        posicaoLivre = inicio;
        /* 
         * Intercala os dois vetores ordenados
         * inicioVetor1 até meio e inicioVetor2 até fim
         * em um vetor auxiliar
         * 
         * exemplo:
         * array = [2, 4, 5, 6, 1, 3]
         * 
         * Aqui é a posição dos numeros no array
         * 0  1  2  3  4  5
         * 2, 4, 5, 6, 1, 3
         * 
         * inicioVetor1 = 0
         * meio = 2
         * inicioVetor2 = 3
         * fim = 5
         * 
         * array[inicioVetor1] = 2
         * array[inicioVetor2] = 6
         * 
         *  array[inicioVetor1] = 2
         * 
         * se
         *  array[inicioVetor1] <= array[inicioVetor2]
         *  auxiliar[posicaoLivre] = 2
         *  inicioVetor1++
         * entao
         *  auxiliar[posicaoLivre] = 6
         *  inicioVetor2++
         *   
         */
        while (inicioVetor1 <= meio && inicioVetor2 <= fim) {
            if (array[inicioVetor1] <= array[inicioVetor2]) {
                auxiliar[posicaoLivre] = array[inicioVetor1];
                inicioVetor1++;
            } else {
                auxiliar[posicaoLivre] = array[inicioVetor2];
                inicioVetor2++;
            }
            posicaoLivre++;
        }
        // se ainda existem números no primeiro vetor
        for (i = inicioVetor1; i <= meio; i++) {
            auxiliar[posicaoLivre] = array[i];
            posicaoLivre++;
        }

        for (i = inicioVetor2; i <= fim; i++) {
            auxiliar[posicaoLivre] = array[i];
            posicaoLivre++;
        }

        // copia os elementos de volta para o array original
        for (i = inicio; i <= fim; i++) {
            array[i] = auxiliar[i];
        }

    }    
}
/* 
 * Analisando o trecho de código anterior, verifica-se que o algoritmo recursivo merge 
 * possui três chamadas de função, sendo que as duas primeiras são chamadas recursivas
 * e recebem metade {en/2u e én/2Ü) dos elementos do vetor passado,
 * e a outra é a chamada para a função que realiza a intercalação das duas metades.
 * 
 * T(n) = 0(nlogn)
 */
