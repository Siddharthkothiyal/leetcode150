package Graphs.shortestPaths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Pair {

    long first;
    long second;

    Pair(long _first , long _second){
        this.first = _first;
        this.second = _second;
    }

}

public class noOfways {
    public int countPaths(int n, int[][] roads) {

        long[] dist = new long[n];
        long[] ways = new long[n];

    PriorityQueue<Pair> pq =
        new PriorityQueue<>((x, y) -> Long.compare(x.first, y.first));

        List<List<Pair>> adjLs = new ArrayList<>();
        for (int i = 0; i < dist.length; i++) {
            adjLs.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {

            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];
            adjLs.get(u).add(new Pair(v, wt));
            adjLs.get(v).add(new Pair(u, wt));

        }

        for (int i = 0; i < n; i++) {
            dist[i] =Long.MAX_VALUE;
            ways[i]=0;
        }

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new Pair(0, 0));


        long mod = (int)(1e9 + 7);

        while (pq.size() != 0) {
             long dis = pq.peek().first;
            long node = pq.peek().second;
           

            pq.remove();

            for (Pair iter : adjLs.get((int)node)) {
                long adjNode = iter.first;
                long edW = iter.second;

                if (dis + edW < dist[(int)adjNode]) {
                    dist[(int)adjNode] = dis + edW;
                    pq.add(new Pair(edW + dis, adjNode));
                    ways[(int)adjNode] = ways[(int)node];

                }

               else if (dist[(int)adjNode] == dis + edW) {
                    ways[(int)adjNode] =  ((ways[(int) adjNode] + ways[(int)node]) % mod);
                }
            }

        }

        return  (int) (ways[n - 1] % mod);

    }
}
