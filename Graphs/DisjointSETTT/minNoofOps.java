package Graphs.DisjointSETTT;

class DisjoinTSet {
    public int[] rank;
    public int[] size;
    public int[] parent;

    DisjoinTSet(int n) {

        rank = new int[n + 1];
        size = new int[n + 1];

        parent = new int[n + 1];

        for (int i = 0; i < parent.length; i++) {
            rank[i] = 0;
            size[i] = 1;
            parent[i] = i;
        }

    }

    public int findUpar(int node) {

        if (parent[node] == node)
            return node;

        int ulp = findUpar(parent[node]);

        parent[node] = ulp;
        return parent[node];

    }

    public void unionByranK(int u, int v) {

        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);

        if (ulp_u == ulp_v)
            return;

        if (rank[ulp_u] < rank[ulp_v]) {
            int temp = ulp_u;
            ulp_u = ulp_v;
            ulp_v = temp;
        }

        parent[ulp_v] = ulp_u;

        if (rank[ulp_v] == rank[ulp_u]) {
            rank[ulp_u]++;
        }

    }

    public void unionBysize(int u, int v) {

        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);

        if (ulp_u == ulp_v)
            return;

        if (size[ulp_u] < size[ulp_v]) {
            int temp = ulp_u;
            ulp_u = ulp_v;
            ulp_v = temp;
        }

        parent[ulp_v] = ulp_u;


            size[ulp_u] += size[ulp_v];
       

    }

}

public class minNoofOps {

    public int solve(int n, int[][] Edge) {

        DisjoinTSet ds = new DisjoinTSet(n);

        int countExtraEdges=0;

        for (int i = 0; i < Edge.length; i++) {
            int u = Edge[i][0];
            int v = Edge[i][1];
            

            if(ds.findUpar(u)== ds.findUpar(v)){
                countExtraEdges++;
            }

            else{
                ds.unionBysize(u, v);
            }
            
        }


        //find parent count


        int pc =0;
        for (int i = 0; i < n; i++) {
          if(ds.parent[i]==i) pc++;
            
        }

        

        if(countExtraEdges >= pc-1) return pc-1;


        return -1;

    }

    public static void main(String[] args) {
         int n = 9;

        int[][] Edge = {{0,1},{0,2},{0,3},{1,2},{2,3},{4,5},{5,6},{7,8}};

        minNoofOps obj = new minNoofOps();

        int ans = obj.solve(n, Edge);

        System.out.println(ans);

    }

}
