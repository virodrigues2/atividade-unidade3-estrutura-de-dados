// Questao1_ArvoreBinariaLivros.java
// Implementação de árvore binária onde cada nó armazena um livro (título e autor).
public class Questao1_ArvoreBinariaLivros {

    static class Livro {
        String titulo;
        String autor;
        Livro esquerda, direita;

        Livro(String titulo, String autor) {
            this.titulo = titulo;
            this.autor = autor;
            esquerda = direita = null;
        }
    }

    private Livro raiz;

    public void inserir(String titulo, String autor) {
        raiz = inserirRec(raiz, titulo, autor);
    }

    private Livro inserirRec(Livro node, String titulo, String autor) {
        if (node == null) return new Livro(titulo, autor);
        // Usamos comparação por título para decidir onde inserir
        if (titulo.compareToIgnoreCase(node.titulo) < 0) node.esquerda = inserirRec(node.esquerda, titulo, autor);
        else node.direita = inserirRec(node.direita, titulo, autor);
        return node;
    }

    public void preOrdem() { preOrdemRec(raiz); }
    private void preOrdemRec(Livro node) {
        if (node != null) {
            System.out.println(node.titulo + " - " + node.autor);
            preOrdemRec(node.esquerda);
            preOrdemRec(node.direita);
        }
    }

    public void emOrdem() { emOrdemRec(raiz); }
    private void emOrdemRec(Livro node) {
        if (node != null) {
            emOrdemRec(node.esquerda);
            System.out.println(node.titulo + " - " + node.autor);
            emOrdemRec(node.direita);
        }
    }

    public void posOrdem() { posOrdemRec(raiz); }
    private void posOrdemRec(Livro node) {
        if (node != null) {
            posOrdemRec(node.esquerda);
            posOrdemRec(node.direita);
            System.out.println(node.titulo + " - " + node.autor);
        }
    }

    public static void main(String[] args) {
        Questao1_ArvoreBinariaLivros biblioteca = new Questao1_ArvoreBinariaLivros();
        biblioteca.inserir("Java Básico", "João Silva");
        biblioteca.inserir("Estruturas de Dados", "Maria Oliveira");
        biblioteca.inserir("Algoritmos Avançados", "Carlos Souza");
        biblioteca.inserir("Banco de Dados", "Ana Pereira");

        System.out.println("=== Pré-ordem ===");
        biblioteca.preOrdem();

        System.out.println("\n=== Em-ordem ===");
        biblioteca.emOrdem();

        System.out.println("\n=== Pós-ordem ===");
        biblioteca.posOrdem();
    }
}
