package Graphs.shortestPaths;

import java.util.ArrayList;

import java.util.List;
import java.util.PriorityQueue;


class Pair {

    int first;
    int second;

    Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;

    }

}

public class networkDelayTime {

    public int findDelayTime(int V, int[][] edges, int src) {
       

        List<List<Pair>> adjLs = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.second - y.second);

        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adjLs.get(u).add(new Pair(v, wt));
        }

 int[] dist = new int[V];
 for (int i = 0; i < dist.length; i++) {
    dist[i]= (int) 1e9;
 }


        dist[src] = 0;

        pq.add(new Pair(src, 0));

        while (pq.size() != 0) {

            int node = pq.peek().first;
            int time = pq.peek().second;
            pq.remove();

            for (Pair iter : adjLs.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                if (time + edW < dist[adjNode]) {
                    dist[adjNode] = time + edW;
                    pq.add(new Pair(adjNode, edW + time));
                }

            }

        }

          int maxTime = 0;

            for (int i = 0; i < dist.length; i++) {

                if (dist[i] == (int) 1e9)
                    return -1;

                maxTime = Math.max(maxTime, dist[i]);

            }

           return maxTime;

    }

}
