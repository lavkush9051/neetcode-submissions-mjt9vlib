class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])  // Sort by COST, not coordinates
        );
        boolean[] vis = new boolean[n];
        pq.add(new int[]{0, 0});
        int cost = 0;
        int edgesAdded = 0;

        while(!pq.isEmpty() && edgesAdded < n){
            int[] rec = pq.poll();
            int wt = rec[0];
            int u = rec[1];
            if(vis[u]==true){
                continue;
            }
            vis[u] = true;
            cost += wt; 
            edgesAdded++;

            for(int v=0; v<n; v++){
                 if(!vis[v]){
                    int manhattan = Math.abs(points[u][0] - points[v][0]) 
                        + Math.abs(points[u][1] - points[v][1]);
                    pq.add(new int[]{manhattan, v});
                 }
            }
        }
        return cost;
    }
}
