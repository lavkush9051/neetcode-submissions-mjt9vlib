

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // Step 1: Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];
            adj.get(u).add(new Pair(v, w));
        }
        
        // Step 2: Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        // Step 3: Min Heap (distance, node)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(k, 0));
        
        // Step 4: Dijkstra
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int dis = curr.wt;
            
            // Skip outdated entries
            if(dis > dist[node]) continue;
            
            for(Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                int weight = neighbor.wt;
                
                if(dis + weight < dist[nextNode]) {
                    dist[nextNode] = dis + weight;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }
        
        // Step 5: Find max time
        int max = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        
        return max;
    }
}

class Pair {
    int node;
    int wt;
    
    public Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}