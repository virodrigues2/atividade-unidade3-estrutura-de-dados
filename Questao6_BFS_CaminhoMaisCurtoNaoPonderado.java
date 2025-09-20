// Questao6_BFS_CaminhoMaisCurtoNaoPonderado.java
// BFS que retorna o caminho mais curto (em número de arestas) entre dois vértices em grafo não ponderado.
import java.util.*;

public class Questao6_BFS_CaminhoMaisCurtoNaoPonderado {

    static class Grafo {
        int V;
        List<Integer>[] adj;

        @SuppressWarnings("unchecked")
        Grafo(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        }

        void addAresta(int u, int v) { // não direcionado
            adj[u].add(v);
            adj[v].add(u);
        }

        List<Integer> bfsCaminho(int origem, int destino) {
            boolean[] visit = new boolean[V];
            int[] pai = new int[V];
            Arrays.fill(pai, -1);

            Queue<Integer> q = new LinkedList<>();
            visit[origem] = true;
            q.add(origem);

            while (!q.isEmpty()) {
                int u = q.poll();
                if (u == destino) break;
                for (int v : adj[u]) {
                    if (!visit[v]) {
                        visit[v] = true;
                        pai[v] = u;
                        q.add(v);
                    }
                }
            }

            List<Integer> caminho = new ArrayList<>();
            if (!visit[destino]) return caminho; // vazio = sem caminho
            for (int v = destino; v != -1; v = pai[v]) caminho.add(v);
            Collections.reverse(caminho);
            return caminho;
        }
    }

    public static void main(String[] args) {
        Grafo g = new Grafo(6);
        g.addAresta(0,1);
        g.addAresta(0,2);
        g.addAresta(1,3);
        g.addAresta(2,4);
        g.addAresta(3,5);
        g.addAresta(4,5);

        int origem = 0, destino = 5;
        List<Integer> caminho = g.bfsCaminho(origem, destino);
        if (caminho.isEmpty()) System.out.println("Sem caminho entre " + origem + " e " + destino);
        else System.out.println("Caminho mais curto (BFS): " + caminho);
    }
}
