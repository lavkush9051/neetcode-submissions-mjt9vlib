class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);

        for(int[] edge:edges){
            boolean ans = dsu.union(edge[0], edge[1]);
            if(!ans){
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[0];
    }
    
}

class DSU{
    int[] parent;
    int[] rank;
    public DSU(int v){
        parent = new int[v+1];
        rank = new int[v+1];
        for(int i=0; i< v; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public boolean union(int u, int v){
        int pu = findP(u);
        int pv = findP(v);

        if(pu == pv){
            return false;
        }
        if(rank[pu] > rank[pv]){
            parent[pv] = pu;
            rank[pu] += rank[pv];
        }else{
            parent[pu] = pv;
            rank[pv] += rank[pu];
        }
        return true;


    }
    public int findP(int elm){
        if(parent[elm]== elm){
            return parent[elm];
        }

        parent[elm] = findP(parent[elm]);
        return parent[elm];
    }
}
