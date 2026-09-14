package Graphs.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class cycleinDirected {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // code here
        List<List<Integer>> adjLs = new ArrayList<>();

              for (int i = 0; i < numCourses; i++) {
                  adjLs.add(new ArrayList<>());
              }
              
              int n = prerequisites.length;

              for (int i = 0; i < n; i++) {
                  adjLs.get(prerequisites[i][1]).add(prerequisites[i][0]);
              }

              int[] indegree = new int[numCourses];
              for (int i = 0; i < numCourses; i++) {
                  for (int it : adjLs.get(i)) {
                      indegree[it]++;
                  }
              }

              Queue<Integer> q = new LinkedList<>();

              for (int i = 0; i < numCourses; i++) {
                  if (indegree[i] == 0) {
                      q.add(i);
                  }
              }

              int index = 0;
              int [] topo= new int[numCourses];

              while (!q.isEmpty()) {
                  int node = q.peek();
                  q.remove();
                  topo[index]= node;

                  for (Integer adjNode : adjLs.get(node)) {

                      indegree[adjNode]--;
                      if (indegree[adjNode] == 0)
                          q.add(adjNode);

                  }

              }


              return  topo;

    }

}
