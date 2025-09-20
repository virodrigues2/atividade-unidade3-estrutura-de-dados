// Questao10_TopologicalSort.java
// Ordenação topológica para grafo dirigido (usado em planejamento de tarefas).
import java.util.*;

public class Questao10_TopologicalSort {

    static class Grafo {
        int V;
        List<Integer>[] adj;
        @SuppressWarnings("unchecked")
        Grafo(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        }

        void addAresta(int u, int v) { adj[u].add(v); } // u -> v

        void ordenacaoTopologica() {
            boolean[] visit = new boolean[V];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < V; i++) if (!visit[i]) topoUtil(i, visit, stack);
            System.out.print("Ordenação topológica: ");
            while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
            System.out.println();
        }

        private void topoUtil(int v, boolean[] visit, Stack<Integer> stack) {
            visit[v] = true;
            for (int u : adj[v]) if (!visit[u]) topoUtil(u, visit, stack);
            stack.push(v);
        }
    }

    public static void main(String[] args) {
        Grafo g = new Grafo(6);
        g.addAresta(5,2);
        g.addAresta(5,0);
        g.addAresta(4,0);
        g.addAresta(4,1);
        g.addAresta(2,3);
        g.addAresta(3,1);

        g.ordenacaoTopologica();
    }
}
