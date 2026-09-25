package Graphs.DisjointSETTT;

public class disjointSet {

    public int[] rank;
    public int[] parent;
    public int[] size;

    public disjointSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    public int findUPar(int node) {
        if (node == parent[node])
            return node;

        return parent[node] = findUPar(parent[node]);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v)
            return;

        if (rank[ulp_u] < rank[ulp_v]) {
            int temp = ulp_u;
            ulp_u = ulp_v;
            ulp_v = temp;
        }

        parent[ulp_v] = ulp_u;

        if (rank[ulp_u] == rank[ulp_v]) {
            rank[ulp_u]++;
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

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

    public boolean find(int u, int v) {
        return findUPar(u) == findUPar(v);
    }

    public int componentSizeOf(int node) {
        return size[findUPar(node)];
    }
}

class Main {
    public static void main(String[] args) {
        disjointSet dsu = new disjointSet(5);

        dsu.unionBySize(1, 2);
        dsu.unionBySize(4, 5);
        dsu.unionBySize(2, 4);

        System.out.println(dsu.find(5, 2));
        //System.out.println(dsu.componentSizeOf(1));
    }
}