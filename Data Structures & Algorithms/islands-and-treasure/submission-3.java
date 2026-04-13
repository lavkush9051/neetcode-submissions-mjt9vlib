class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int INF = 2147483647;
        Queue<int[]> que = new LinkedList<>();
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==0){
                    que.add(new int[]{i, j});
                }
            }
        }

        while(!que.isEmpty()){
            int[]curr = que.poll();
            int r = curr[0], c = curr[1];
            for(int d[]:directions){
                int nr = r+d[0];
                int nc = c+d[1];
                if(nr >= 0 && nr < grid.length && nc >=0 && nc < grid[0].length && grid[nr][nc] == INF){
                    grid[nr][nc] = grid[r][c] + 1;
                    que.add(new int[]{nr, nc});
                } 
            }
        }
    }
}
