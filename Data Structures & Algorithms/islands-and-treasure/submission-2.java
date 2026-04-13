class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int INF = 2147483647;
    private int ROWS, COLS;
    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        for(int r=0; r < ROWS; r++){
            for(int c=0; c< COLS; c++){
                if(grid[r][c]==INF){
                    grid[r][c] = bfs(grid, r, c);
                }
            }
        }
    }

    public int bfs(int[][] grid, int r, int c){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{r, c});
        boolean[][] vis = new boolean[ROWS][COLS];
        vis[r][c] = true;
        int steps = 0;

        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0; i< size; i++){
                int[] curr = que.poll();
                int row = curr[0], col = curr[1];
                if(grid[row][col]==0){
                    return steps;
                }
                for(int[] dir:directions){
                    int nr = row+dir[0], nc = col+dir[1];
                    if(nr >=0 && nr < ROWS && nc >=0 && nc < COLS && !vis[nr][nc]==true && grid[nr][nc]!=-1){
                        vis[nr][nc] = true;
                        que.add(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return INF;
    }
}
