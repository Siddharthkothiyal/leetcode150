package Graphs.BFS;

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

public class cycleDetectUsingBFS {

    public static boolean bfs(boolean[] vis, int src, List<ArrayList<Integer>> adjLs) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, -1));

        vis[0] = true;

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;

            q.remove();

            for (int adjNode : adjLs.get(node)) {

                if (vis[adjNode] == false) {
                    vis[adjNode] = true;
                    q.add(new Pair(adjNode, node));
                } else if (parent != adjNode) {
                    return true;
                }

            }

        }

        return false;

    }

    public boolean isCycle(int V, int[][] edges) {

        List<ArrayList<Integer>> adjLs = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>());
        }

        boolean vis[] = new boolean[V];
        for (int i = 0; i < edges.length; i++) {

            for (int j = 0; j < edges.length; j++) {

                adjLs.get(i).add(j);
                adjLs.get(j).add(i);

            }

        }

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {
                if (bfs(vis, i, adjLs))
                    return true;
            }

        }


        return false;

    }

}
