// Questao2_ValidacaoBST.java
// Verifica se uma árvore binária é BST. Exemplo com inteiros (pode representar IDs/categorias).
public class Questao2_ValidacaoBST {

    static class No {
        int valor;
        No esq, dir;
        No(int v) { valor = v; esq = dir = null; }
    }

    public boolean validarBST(No raiz) {
        return validarBSTRec(raiz, null, null);
    }

    private boolean validarBSTRec(No node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.valor <= min) || (max != null && node.valor >= max)) return false;
        return validarBSTRec(node.esq, min, node.valor) && validarBSTRec(node.dir, node.valor, max);
    }

    public static void main(String[] args) {
        // Montando uma árvore que é BST
        No root = new No(20);
        root.esq = new No(10);
        root.dir = new No(30);
        root.esq.esq = new No(5);
        root.esq.dir = new No(15);
        root.dir.dir = new No(40);

        Questao2_ValidacaoBST v = new Questao2_ValidacaoBST();
        System.out.println("A árvore é BST? " + v.validarBST(root)); // true

        // Montando uma árvore que NÃO é BST
        No bad = new No(10);
        bad.esq = new No(5);
        bad.dir = new No(8); // valor 8 no lado direito de 10 quebra a propriedade
        System.out.println("Árvore inválida é BST? " + v.validarBST(bad)); // false
    }
}
