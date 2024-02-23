public class BuscaBinaria {
    public static void main(String[] args) {
        int[] vetor = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int valor = 5;

        int inicio = 0;
        int fim = vetor.length - 1;
        int meio = 0;
        int achou = 0;

        while (inicio <= fim && achou == 0) {
            meio = (int) ((inicio + fim) / 2);
            if (vetor[meio] == valor) {
                achou = 1;
            } else {
                if (vetor[meio] < valor) {
                    inicio = meio + 1;
                } else {
                    fim = meio - 1;
                }
            }
        }

        if (achou == 1) {
            System.out.println("Valor encontrado na posição " + meio);
        } else {
            System.out.println("Valor não encontrado");
        }
    }
}
/* 
O pior caso da busca binária ocorre quando o número procurado não se encontra no vetor
ou quando o número procurado é o último elemento do vetor, realizando-se então log2 n
+ 1 comparações. Logo, o tempo de execução é T(n) = O (log n).
 */
