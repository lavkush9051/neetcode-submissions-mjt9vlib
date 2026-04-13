class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        int[][] directions = {{0, 1},{0, -1},{1, 0}, {-1, 0}};
        pq.offer(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;

        while(!pq.isEmpty()){
            int[] val = pq.poll();
            int t = val[0], r = val[1], c = val[2];
            if(r==n-1 && c== n-1){
                return t;
            }
            for(int[]dir : directions){
                int newR = r+dir[0], newC= c+dir[1];
                if(newR >= 0 && newC>=0 && newR<n && newC<n && !vis[newR][newC]){
                    vis[newR][newC] = true;
                    pq.add(new int[]{
                        Math.max(t, grid[newR][newC]), newR, newC
                    });
                }
            }
        }
        return n*n;
    }
}
