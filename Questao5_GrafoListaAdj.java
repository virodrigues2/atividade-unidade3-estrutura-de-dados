// Questao5_GrafoListaAdj.java
// Representação de grafo por lista de adjacência (direcionado ou não).
import java.util.ArrayList;
import java.util.List;

public class Questao5_GrafoListaAdj {

    static class Grafo {
        private final int V;
        private final List<Integer>[] adj;

        @SuppressWarnings("unchecked")
        Grafo(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        }

        // Para grafo não direcionado, chame addAresta(u,v) e addAresta(v,u)
        void addArestaDirigida(int u, int v) { adj[u].add(v); }

        void addArestaNaoDirigida(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);
        }

        void mostrar() {
            for (int i = 0; i < V; i++) {
                System.out.print(i + " -> ");
                for (int v : adj[i]) System.out.print(v + " ");
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Grafo g = new Grafo(5);
        g.addArestaNaoDirigida(0,1);
        g.addArestaNaoDirigida(0,2);
        g.addArestaNaoDirigida(1,3);
        g.addArestaNaoDirigida(2,4);
        System.out.println("Representação por lista de adjacência:");
        g.mostrar();
    }
}
