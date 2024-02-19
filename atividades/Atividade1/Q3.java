/* 3. Faça um programa que cadastre 12 produtos.
Para cada produto devem ser cadastrados os seguintes dados: 
código, 
descrição 
e preço.
Use um método de ordenação e em Seguida calcule e
mostre quantas comparações devem ser feitas para encontrar um funcionário pelo código:

a) usando busca sequencial;
b) usando busca binária. */

public class Q3 {
    static class Produto {
        int codigo;
        String descricao;
        double preco;

        public Produto(int codigo, String descricao, double preco) {
            this.codigo = codigo;
            this.descricao = descricao;
            this.preco = preco;
        }

        public int getCodigo() {
            return codigo;
        }

        public String getDescricao() {
            return descricao;
        }

        public double getPreco() {
            return preco;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }

        public static void ordena(Produto[] produtos) {
            for (int i = 0; i < produtos.length; i++) {
                for (int j = i + 1; j < produtos.length; j++) {
                    if (produtos[i].getCodigo() > produtos[j].getCodigo()) {
                        Produto temp = produtos[i];
                        produtos[i] = produtos[j];
                        produtos[j] = temp;
                    }
                }
            }

            for (int i = 0; i < produtos.length; i++) {
                System.out.println(produtos[i].getCodigo() + " " + 
                produtos[i].getDescricao() + " " + produtos[i].getPreco());
            }
        }

        // Busca binaria

        /* 
         * Como a busca binária é um algoritmo de busca que divide o vetor em duas partes
         * e verifica se o elemento está na parte esquerda ou direita, a cada iteração
         * metade do vetor é descartado. Isso faz com que a busca binária seja mais
         * eficiente que a busca sequencial.
         * 
         * A busca binária é um algoritmo de complexidade O(log n), enquanto a busca
         * sequencial é de complexidade O(n).
         * 
         * Exemplo:
         * Se buscamos o codigo 6 em um vetor de 12 elementos, a busca binária será de 1 comparação.
         * pois o numero 6 esta no meio do vetor.
         * 
         * Se buscamos o codigo 8 em um vetor de 12 elementos, a busca binária será de 4 comparações.
         * pois o numero 8 esta no meio do vetor.
         * 
         */
        public static int buscaBinaria(Produto[] produtos, int codigo) {
            // Inicializa as variáveis
            int inicio = 0;
            int fim = produtos.length - 1;// Tamanho do vetor - 1, pois o vetor começa em 0
            int meio;
            int comparacoes = 0;

            while (inicio <= fim) {
                meio = (int) ((inicio + fim) / 2); // Calcula o meio do vetor e arredonda para baixo
                
                comparacoes++;
                if (produtos[meio].getCodigo() == codigo) {
                    return comparacoes;
                } else if (codigo < produtos[meio].getCodigo()) {
                    fim = meio - 1;
                } else {
                    inicio = meio + 1;
                }
            }
            return comparacoes;
        }

        public static int buscaSequencial(Produto[] produtos, int codigo) {
            int comparacoes = 0;
            for (int i = 0; i < produtos.length; i++) {
                comparacoes++;
                if (produtos[i].getCodigo() == codigo) {
                    return comparacoes;
                }
            }
            return comparacoes;
        }
    }

    public static void main(String[] args) {
        Produto[] produtos = new Produto[12];
/*         produtos[0] = new Produto(1, "Produto 1", 10.0);
        produtos[1] = new Produto(2, "Produto 2", 20.0);
        produtos[2] = new Produto(3, "Produto 3", 30.0);
        produtos[3] = new Produto(4, "Produto 4", 40.0);
        produtos[4] = new Produto(5, "Produto 5", 50.0);
        produtos[5] = new Produto(6, "Produto 6", 60.0);
        produtos[6] = new Produto(7, "Produto 7", 70.0);
        produtos[7] = new Produto(8, "Produto 8", 80.0);
        produtos[8] = new Produto(9, "Produto 9", 90.0);
        produtos[9] = new Produto(10, "Produto 10", 100.0);
        produtos[10] = new Produto(11, "Produto 11", 110.0);
        produtos[11] = new Produto(12, "Produto 12", 120.0); */

        produtos[0] = new Produto(12, "Produto 12", 120.0);
        produtos[1] = new Produto(9, "Produto 9", 110.0);
        produtos[2] = new Produto(8, "Produto 8", 100.0);
        produtos[3] = new Produto(10, "Produto 10", 90.0);
        produtos[4] = new Produto(11, "Produto 11", 80.0);
        produtos[5] = new Produto(7, "Produto 7", 70.0);
        produtos[6] = new Produto(5, "Produto 5", 60.0);
        produtos[7] = new Produto(6, "Produto 6", 50.0);
        produtos[8] = new Produto(4, "Produto 4", 40.0);
        produtos[9] = new Produto(1, "Produto 1", 10.0);
        produtos[10] = new Produto(3, "Produto 3", 30.0);
        produtos[11] = new Produto(2, "Produto 2", 20.0);
        
        Produto.ordena(produtos);
        System.out.println("");

        // Busca sequencial
        System.out.println("Busca sequencial");
        System.out.println("Comparacoes: " + Produto.buscaSequencial(produtos, 12));
        System.out.println("");

        // Busca binaria
        System.out.println("Busca binaria");
        System.out.println("Comparacoes: " + Produto.buscaBinaria(produtos, 12));
    }
}
