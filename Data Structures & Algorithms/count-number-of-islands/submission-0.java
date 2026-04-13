class Solution {
    private static final int[][] directions = {{1,0}, {0,-1}, {-1,0}, {0,1}};
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int island = 0;
        for(int i=0; i< rows; i++){
            for(int c=0; c<cols; c++){
                if(grid[i][c]=='1'){
                    dfs(grid, i, c);
                    island++;
                }
            }
        }
        return island;
    }

    public void dfs(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        for(int[] dir: directions){
            dfs(grid, r+ dir[0], c + dir[1]);
        }
    }
}
