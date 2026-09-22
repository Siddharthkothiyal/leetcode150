
package Graphs.MST_DisJoinT;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {
    int first;
    int second;

    Pair(int _first, int _second) {
        this.first = _first;
        this.second= _second;
    }
}

public class mstTheory {
    public int spanningTree(int V, int[][] edges) {

        ArrayList<ArrayList<Pair>> adjLs = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adjLs.get(u).add(new Pair(v, wt));
            adjLs.get(v).add(new Pair(u, wt));

        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        int vis[] = new int[V];

        pq.add(new Pair(0, 0));
        int sum = 0;

        while (pq.size() > 0) {
            int node = pq.peek().second;
            int wtt = pq.peek().first;
            pq.remove();

            if (vis[node] == 1)
                continue;

            vis[node] = 1;

            sum = sum + wtt;

            for (Pair iter : adjLs.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                if (vis[adjNode] == 0) {
                    pq.add(new Pair(edW, adjNode));
                }

            }

        }

        return sum;

    }

}