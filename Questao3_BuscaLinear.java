// Questao3_BuscaLinear.java
// Busca linear em array de inteiros - retorna índice ou -1.
public class Questao3_BuscaLinear {

    public static int buscaLinear(int[] arr, int chave) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == chave) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] contatos = {9876, 1234, 5555, 2020, 3141};
        int procurar = 2020;
        int pos = buscaLinear(contatos, procurar);
        if (pos >= 0) System.out.println("Encontrado na posição: " + pos);
        else System.out.println("Não encontrado (-1).");
    }
}
