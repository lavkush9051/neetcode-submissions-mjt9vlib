class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();
        int fresh =0;
        int time = 0;
        int[][] dir = {{1, 0}, {-1, 0}, {0,1}, {0,-1}};
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    que.add(new int[]{i, j});
                }
            }
        }
        
        while(fresh > 0 && !que.isEmpty()){
            int sz = que.size();

            for(int r=0; r<sz; r++){
                int[]rotten = que.remove();
                int row = rotten[0];
                int col = rotten[1];
                for(int[] val:dir){
                    int nr = row+val[0];
                    int nc = col + val[1];
                    if(nr < grid.length && nr >=0 && nc < grid[0].length && nc >= 0 && grid[nr][nc]==1){
                        grid[nr][nc]= 2;
                        que.add(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh==0 ? time : -1;
    }
}
