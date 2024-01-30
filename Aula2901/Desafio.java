/* 
Algoritmo com uma matriz 5x4 com ponto de inicio e com ponto de fim
Usando lista funções, um a lista de numeros que não podem ser acessadas
que serão os obstaculos, onde o Algoritmo deverá descobrir o caminho mais curto. 
*/
package Aula2901;

public class Desafio {
    public static void main(String[] args) {
        // Coordenadas de inicio e fim
        // inicio = (0,0)
        // fim = (3,4)
        
        int startX = 0;
        int startY = 0;

        /* O limite da matriz é 3,4 pois a contagem começa do 0 */
        int endX = 3;
        int endY = 4;

        //(Linha, Coluna)
         int[][] obstacles = {
            {0, 3},
            {1, 1},
            {1, 0},
            {2, 2}
        };

/*         int [][] obstacles = {
            {1, 0},
            {2, 1},
            {2, 2},
            {3, 2}
        }; */

        // Inicializando a matriz
        int[][] path = new int[4][5];
        
        // Preenchendo a matriz com 0
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                path[i][j] = 0;
            }
        }

        // Preenchendo a matriz com 1 no inicio e no fim
        path[startX][startY] = 1;
        path[endX][endY] = 1;

        // Preenchendo a matriz com -1 nos obstaculos
        for (int i = 0; i < obstacles.length; i++) {
            path[obstacles[i][0]][obstacles[i][1]] = -1;
        }

        // Imprimindo a matriz inicial com 0, 1 e -1
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        // Algoritmo para encontrar o caminho mais curto
        int x = startX;
        int y = startY;

        // Se o ponto de inicio for igual ao ponto de fim
        while (x != endX || y != endY) {
            // Se x for menor que o limite da matriz
            // E se o proximo ponto não for um obstaculo
            // Então x++ (x = x + 1) 
            // Mover para a direita
            if (x < endX && path[x + 1][y] != -1) {
                x++;
            
            // Se y for menor que o limite da matriz
            // E se o proximo ponto não for um obstaculo
            // Então y++ (y = y + 1)
            // Mover para baixo
            } else if (y < endY && path[x][y + 1] != -1) {
                y++;
            
            // Se x for maior que 0
            // E se o proximo ponto não for um obstaculo
            // Então x-- (x = x - 1)
            // Mover para a esquerda

            } else if (x > 0 && path[x - 1][y] != -1) {
                x--;

            // Se y for maior que 0
            // E se o proximo ponto não for um obstaculo
            // Então y-- (y = y - 1)
            // Mover para cima
            } else if (y > 0 && path[x][y - 1] != -1) {
                y--;

            // Se não houver caminho
            } else {
                System.out.println("Não há caminho");
                break;
            }
            
            // Preenchendo a matriz com 1 no caminho mais curto
            path[x][y] = 1;
        }

        // Imprimindo a matriz com o caminho mais curto
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        // Imprimindo o caminho mais curto
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                if (path[i][j] == 1) {
                    System.out.print("[" + i + "," + j + "] ");
                }
            }
        }

        System.out.println();
    }
}