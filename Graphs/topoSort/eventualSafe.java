package Graphs.topoSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class eventualSafe {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        // reversethe graph
        int n = graph.length;

        List<List<Integer>> adjRevList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjRevList.add(new ArrayList<>());
        }

        // indegree finding out
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int it : graph[i]) {

                adjRevList.get(it).add(i);

                indegree[i]++;
            }
        }

        // all the terminal nodes are in the queue already with indegree 0
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> safeNodes = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            safeNodes.add(node);

            for (Integer iter : adjRevList.get(node)) {

                indegree[iter]--;
                if (indegree[iter] == 0) {
                    q.add(iter);
                }

            }

        }

        Collections.sort(safeNodes);

        return safeNodes;

    }

}
