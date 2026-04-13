class Solution {
    private int[][] direction = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public void solve(char[][] board) {
        int[][]vis = new int[board.length][board[0].length];
        int nr = board.length-1;
        int nc = board[0].length-1;
        // boundry row traversal
        for(int i=0; i< board.length;i++){
            if(board[i][0] == 'O'){
                dfs(i,0,board, vis);
            }
            if(board[i][nc] == 'O'){
                dfs(i, nc, board, vis);
            }
        }

        // boundery col traversal
        for(int j=0; j< board[0].length; j++){
            if(board[0][j]=='O'){
                dfs(0, j, board, vis);
            }

            if(board[nr][j] == 'O'){
                dfs(nr, j, board, vis);
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j< board[0].length; j++){
                if(board[i][j]=='O' && vis[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int r, int c, char[][] board, int[][]vis){
        if(r < 0 || c <0 || r>=board.length || c >= board[0].length || vis[r][c] == 1 || board[r][c]!='O'){
            return;
        }
        vis[r][c] = 1;
        for(int[] dir : direction){
            int nr = r + dir[0];
            int nc = c + dir[1];

            dfs(nr, nc, board, vis);
        }
    }
}