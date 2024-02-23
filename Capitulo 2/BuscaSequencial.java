public class BuscaSequencial {

    public static void main(String[] args) {
        int[] vetor = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int valor = 5;

        int i = 0; // Inicializando i
        int achou = 0; // Inicializando achou

        int tamanhoVetor = vetor.length; // Tamanho do vetor

        while (i < tamanhoVetor && achou == 0) {
            if (vetor[i] == valor) {
                achou = 1;
            } else {
                i++;
            }
        }

        if (achou == 1) {
            System.out.println("Valor encontrado na posição " + i);
        } else {
            System.out.println("Valor não encontrado");
        }
    }
}
/* 
O pior caso da busca acontece quando o número procurado é o último elemento do
vetor ou quando o número procurado não se encontra no vetor, realizando-se então n
comparações. Logo, o tempo de execução é T(n) = O (n).
Já o melhor caso ocorre quan-do o número procurado
é o elemento qu e se encontra na primeira posição, realizando
uma única comparação e cujo tempo de execução é constante, ou seja, T (n) = 0(1). 
 */