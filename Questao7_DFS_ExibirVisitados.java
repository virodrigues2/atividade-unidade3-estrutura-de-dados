// Questao7_DFS_ExibirVisitados.java
// DFS recursivo que exibe todos os vértices visitados a partir de uma origem.
import java.util.*;

public class Questao7_DFS_ExibirVisitados {

    static class Grafo {
        int V;
        List<Integer>[] adj;

        @SuppressWarnings("unchecked")
        Grafo(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        }

        void addAresta(int u, int v) { adj[u].add(v); } // dirigido por padrão

        void dfs(int origem) {
            boolean[] visit = new boolean[V];
            dfsRec(origem, visit);
            System.out.println();
        }

        private void dfsRec(int u, boolean[] visit) {
            visit[u] = true;
            System.out.print(u + " ");
            for (int v : adj[u]) {
                if (!visit[v]) dfsRec(v, visit);
            }
        }
    }

    public static void main(String[] args) {
        Grafo g = new Grafo(6);
        g.addAresta(0,1);
        g.addAresta(0,2);
        g.addAresta(1,3);
        g.addAresta(2,4);
        g.addAresta(4,5);

        System.out.print("DFS a partir do vértice 0: ");
        g.dfs(0);
    }
}
