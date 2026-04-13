class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int res = n;
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(dsu.union(u, v)){
                res --;
            }
        }
        return res;
    }
}

class DSU{
    int[] parent, rank;
    public DSU(int v){
        parent = new int[v+1];
        rank = new int[v+1];
        for(int i=0; i< v; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int node){
        if(node == parent[node]){
            return node;
        }
        parent[node] = find(parent[node]);
        return parent[node];

    }
    public boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv){
            return false;
        }
        if(rank[pv] > rank[pu]){
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        parent[pv] = pu;
        rank[pu]+= rank[pv];
        return true;
        

    }
}
