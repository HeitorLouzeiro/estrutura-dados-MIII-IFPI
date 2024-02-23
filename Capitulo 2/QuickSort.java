public class QuickSort {
    public static void main(String[] args) {
        // array desordenado
        int[] array = { 5, 3, 7, 6, 2, 8, 4, 9, 1 };

        // tamanho do array
        int n = array.length - 1;

        // ordena o array
        quickSort(array, 0, n);

        // array ordenado
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void troca(int[] array, int i, int j) {
        int auxiliar = array[i];
        array[i] = array[j];
        array[j] = auxiliar;
    }

    // método de particionamento
    public static int particao(int[] array, int inicio, int fim) {
        int pivo, i, j;

        // pivo é o elemento que será usado para particionar o array
        pivo = array[(inicio + fim) / 2];

        i = inicio - 1;
        j = fim + 1;
        /* 
         * Enquanto i for menor que j, faça:
         * Exemplo:
         * posição dos números no array
         * 0  1  2  3  4  5  6  7  8
         * 5, 3, 7, 6, 2, 8, 4, 9, 1
         * 
         * array = [5, 3, 7, 6, 2, 8, 4, 9, 1]
         * 
         * inicio = 0
         * fim = 8
         * pivo = 5
         * 
         * i = -1
         * j = 9
         * 
         * array[i] = 1
         * array[j] = 9
         * 
         * 
         * array[i] = 4
         * array[j] = 8
         * 
         * array[i] = 2
         * array[j] = 6
         * 
         * array[i] = 7
         * array[j] = 3
         * 
         * array[i] = 5
         * 
         * array = [1, 2, 3, 4, 5, 6, 7, 8, 9]
         * 
         */
        while (i < j) {
            do {
                j--;
            } while (array[j] > pivo);
            do {
                i++;
            } while (array[i] < pivo);
            if (i < j) {
                troca(array, i, j);
            }
        }
        return j;
    }

    // método de ordenação
    public static void quickSort(int[] array, int inicio, int fim) {
        // Esse pivo é o elemento que será usado para particionar o array
        int pivo;

        if (inicio < fim) {

            // pivo é o índice que particiona o array
            pivo = particao(array, inicio, fim);
            // Ordena a primeira metade do array
            quickSort(array, inicio, pivo);

            // Ordena a segunda metade do array
            quickSort(array, pivo + 1, fim);
        }
    }
}

/* 
 * O tempo de execução do QUICKSORT depende se o particionamento é ou não balanceado,
 * e isto depende de quais elementos são utilizados para o particionamento.
 * Se é balanceado, o algoritmo executa tão rapidamente quanto o MERGE SORT.
 * Se não é balanceado, o algoritmo é tão lento quanto o INSERTION SORT.
 * Essa é a mesma recorrência já foi calculada na sessão do algoritmo MERGE SORT.
 * Então, pelo teorema master, sabe-se que essa recorrência
 * solucionada fornece o tempo de execução T(n) = 0(n. log n).
 */