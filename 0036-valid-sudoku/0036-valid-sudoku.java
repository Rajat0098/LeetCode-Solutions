import java.util.*;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        if(n != 9) return false;

        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] submat = new HashSet[n];

        for(int i = 0; i < 9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            submat[i] = new HashSet<>();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                char val = board[i][j];

                if (val == '.') continue;

                if(rows[i].contains(val)) return false;
                rows[i].add(val);
                if(cols[j].contains(val)) return false;
                cols[j].add(val);

                int index = (i / 3) * 3 + (j / 3);
                if(submat[index].contains(val)) return false;
                submat[index].add(val);
            }
        }

        return true;
    }
}