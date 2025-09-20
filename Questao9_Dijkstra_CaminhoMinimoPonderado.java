// Questao9_Dijkstra_CaminhoMinimoPonderado.java
// Dijkstra para grafo ponderado representado por matriz de adjacências (0 = sem aresta).
import java.util.Arrays;

public class Questao9_Dijkstra_CaminhoMinimoPonderado {

    public static void dijkstra(int[][] grafo, int src) {
        int V = grafo.length;
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDist(dist, sptSet);
            if (u == -1) break; // vértices restantes inacessíveis
            sptSet[u] = true;
            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && grafo[u][v] != 0 && dist[u] != Integer.MAX_VALUE &&
                    dist[u] + grafo[u][v] < dist[v]) {
                    dist[v] = dist[u] + grafo[u][v];
                }
            }
        }

        System.out.println("Distâncias a partir do vértice " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("-> " + src + " para " + i + " = " + (dist[i]==Integer.MAX_VALUE ? "∞" : dist[i]));
        }
    }

    private static int minDist(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int grafo[][] = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0,11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9,14, 0, 0, 0},
            {0, 0, 0, 9, 0,10, 0, 0, 0},
            {0, 0, 4,14,10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8,11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        dijkstra(grafo, 0);
    }
}
