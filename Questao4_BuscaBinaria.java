// Questao4_BuscaBinaria.java
// Busca binária em array ordenado - retorna índice ou -1.
public class Questao4_BuscaBinaria {

    public static int buscaBinaria(int[] arr, int chave) {
        int esquerda = 0, direita = arr.length - 1;
        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            if (arr[meio] == chave) return meio;
            if (arr[meio] < chave) esquerda = meio + 1;
            else direita = meio - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] listaOrdenada = {2, 5, 7, 12, 18, 21, 30};
        int alvo = 12;
        int pos = buscaBinaria(listaOrdenada, alvo);
        System.out.println(pos >= 0 ? "Encontrado em: " + pos : "Não encontrado (-1).");
    }
}
