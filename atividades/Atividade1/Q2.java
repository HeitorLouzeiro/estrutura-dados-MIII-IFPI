/*
2. Faça um programa que cadastre 10 números, ordene-os e em seguida encontre e mostre:
a) o menor número e quantas vezes ele aparece no vetor;
b) o maior número e quantas vezes ele aparece no vetor. 
*/
class Numeros {
    int numero;

    public Numeros(int numero) {
        this.numero = numero;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public static void ordenaCrescente(Numeros[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i].getNumero() > numeros[j].getNumero()) {
                    Numeros aux = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = aux;
                }
            }
        }
        for (int i = 0; i < numeros.length; i++) {
          System.out.println(numeros[i].getNumero());
        }
    }

    public static void menorNumero(Numeros[] numeros) {
        int menor = numeros[0].getNumero();
        int contador = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i].getNumero() == menor) {
                contador++;
            }
        }
        System.out.println("Menor número: " + menor + " - " + contador + " vezes");
    }
    public static void maiorNumero(Numeros[] numeros) {
        int maior = numeros[numeros.length - 1].getNumero();
        int contador = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i].getNumero() == maior) {
                contador++;
            }
        }
        System.out.println("Maior número: " + maior + " - " + contador + " vezes");
    }
}

public class Q2 {
    public static void main(String[] args) {
        Numeros[] numeros = new Numeros[10];

        numeros[0] = new Numeros(10);
        numeros[1] = new Numeros(5);
        numeros[2] = new Numeros(3);
        numeros[3] = new Numeros(7);
        numeros[4] = new Numeros(1);
        numeros[5] = new Numeros(10);
        numeros[6] = new Numeros(2);
        numeros[7] = new Numeros(1);
        numeros[8] = new Numeros(10);
        numeros[9] = new Numeros(6);

        Numeros.ordenaCrescente(numeros);
        
        System.out.println(" ");
        Numeros.menorNumero(numeros);

        System.out.println(" ");
        Numeros.maiorNumero(numeros);

    }
    
}
