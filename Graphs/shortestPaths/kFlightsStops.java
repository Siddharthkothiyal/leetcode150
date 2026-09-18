package Graphs.shortestPaths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {

    int first;
    int second;

    Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;

    }

}

class tuple {

    int first;
    int second;
    int third;

    tuple(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }

}

public class kFlightsStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] dist = new int[n];

        List<List<Pair>> adjLs = new ArrayList<>();

        Queue<tuple> q = new LinkedList<>();

        for (int i = 0; i < dist.length; i++) {
            adjLs.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {

            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            adjLs.get(u).add(new Pair(v, wt));
        }

        dist[src] = 0;
      q.add(new tuple(0, 0, src));
      
for(int i=0 ; i< n ; i++){
        dist[i]= (int) (1e9);
       } 
        while (!q.isEmpty()) {

            int stops = q.peek().first;
            int dis = q.peek().second;
            int node = q.peek().third;
            q.remove();

            if (stops > k ) continue;
              

            for (Pair iter : adjLs.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                if (dis + edW < dist[adjNode] && stops <=k) {
                    dist[adjNode] = dis + edW;
                   q.add(new tuple(stops+1, dis+edW, adjNode));

                }
            }

        }
       if(dist[dst]==(int)(1e9))  return -1;
       return dist[dst];

    }
}
