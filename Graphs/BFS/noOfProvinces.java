package Graphs.BFS;

import java.util.ArrayList;
import java.util.List;

public class noOfProvinces {


       public static void dfs(int node, List<List<Integer>> adjLs, int[] vis) {

        vis[node] = 1;

        for (int it : adjLs.get(node)) {
            if (vis[it] == 0) {
                vis[it] = 1;
                dfs(it, adjLs, vis);
            }

        }

    }


    public int findCircleNum(int[][] isConnected) {

        List<List<Integer>> adjLs = new ArrayList<>();

        for (int i = 0; i <= isConnected.length; i++) {
            adjLs.add(new ArrayList<>());
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {

                if (isConnected[i][j] == 1 && i != j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }

        }

        int vis[] = new int[isConnected.length];

        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {

            if (vis[i] == 0) {
                count++;
                dfs(i, adjLs, vis);
            }

        }

        return count;

    }

 

    public static void main(String[] args) {

    }

}
