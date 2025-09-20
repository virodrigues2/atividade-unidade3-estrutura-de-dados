// Questao8_MinimoBST.java
// Encontra o menor valor em uma BST (útil para achar o produto mais barato se a árvore for ordenada por preço).
public class Questao8_MinimoBST {

    static class No {
        int valor;
        No esq, dir;
        No(int v) { valor = v; esq = dir = null; }
    }

    public static No inserir(No raiz, int v) {
        if (raiz == null) return new No(v);
        if (v < raiz.valor) raiz.esq = inserir(raiz.esq, v);
        else raiz.dir = inserir(raiz.dir, v);
        return raiz;
    }

    public static No minimo(No raiz) {
        if (raiz == null) return null;
        No atual = raiz;
        while (atual.esq != null) atual = atual.esq;
        return atual;
    }

    public static void main(String[] args) {
        No raiz = null;
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int v : valores) raiz = inserir(raiz, v);
        No min = minimo(raiz);
        if (min != null) System.out.println("Menor valor na BST: " + min.valor);
        else System.out.println("Árvore vazia.");
    }
}
