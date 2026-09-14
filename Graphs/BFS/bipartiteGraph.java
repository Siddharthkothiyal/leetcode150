package Graphs.BFS;

import java.util.ArrayList;
import java.util.List;

public class bipartiteGraph {

    public boolean dfs(int node, int col, int[] color, List<List<Integer>> adjLs) {

        color[node] = col;

        for (Integer it : adjLs.get(node)) {

            if (color[it] == -1) {
                if (dfs(it, 1 - col, color, adjLs) == false)
                    return false;
            } else if (color[it] == col) {
                return false;
            }

        }

        return true;

    }

    public boolean isBipartite(int[][] graph) {

        List<List<Integer>> adjLs = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            adjLs.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int neighbor : graph[i]) {
                adjLs.get(i).add(neighbor);
            }
        }

        int v = adjLs.size();
        int color[] = new int[v];

        for (int i = 0; i < v; i++)
            color[i] = -1;

        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, color, adjLs) == false)
                    return false;
                ;
            }

        }

        return true;

    }
}
