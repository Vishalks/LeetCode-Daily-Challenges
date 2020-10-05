class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(board, i, j, m, n, 0, word))
                    return true;
            }
        }
        return false;
    }
    
    public boolean backtrack(char[][] board, int i, int j, int m, int n, int index, String word){
        if(index >= word.length())//this means either the word is empty or all the chars have been matched and no char remains to match so we reach end of string. hence return true
            return true;
        
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(index))//index out of bounds or char mismatch
            return false;
        
        //found a matching char. mark it as visited so that we don't visit again during dfs
        board[i][j] = '#';
        
        //do a dfs in all 4 possible directions
        if(backtrack(board, i, j-1, m, n, index+1, word) || backtrack(board, i-1, j, m, n, index+1, word)
            || backtrack(board, i, j+1, m, n, index+1, word) || backtrack(board, i+1, j, m, n, index+1, word)){
            board[i][j] = word.charAt(index);//remark the position in board with original char that we had replaced with a # above
            return true;
        }
        
        board[i][j] = word.charAt(index);//remark the position in board with original char that we had replaced with a # above
        return false;
    }
}