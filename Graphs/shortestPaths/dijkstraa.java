package Graphs.shortestPaths;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {
    int first;
    int second;

    Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

public class dijkstraa {

    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.first - y.first);

        for (int i = 0; i < V; i++) {

            adj.add(new ArrayList<>());

        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt));
adj.get(v).add(new Pair(u, wt));

        }
        int dist[] = new int[V];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = (int) 1e9;
        }

        dist[src] = 0;

        pq.add(new Pair(0, src));

        while (pq.size() != 0) {

            int dis = pq.peek().first;
            int node = pq.peek().second;

            pq.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).second;
                int adjNode = adj.get(node).get(i).first;

                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        ArrayList<Integer> distance = new ArrayList<>();
        for (int i = 0; i < dist.length; i++) {
            distance.add(dist[i]);
        }

        return distance;

    }

}
