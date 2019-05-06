package array;

/**
 * Created by miula on 2019/5/5.
 * 不增加额外的存储空间，通过标记 原状态->当前状态 来实现
 * @author miula
 * @date 2019/05/05
 */
public class GameofLife289 {
    public static void gameOfLife(int[][] board) {
        if (board.length < 1){
            return;
        }
        int lineSize = board.length;
        int colSize = board[0].length;
        //D->D 2, D->L 3, L->D 4, L->L 5
        for (int i = 0; i < lineSize; i++){
            for (int j = 0; j < colSize; j++){
                int count = getLive(board, i + 1, j + 1, lineSize, colSize);
                if (board[i][j] == 0){
                    if (count == 3){
                        board[i][j] = 3;
                    }else {
                        board[i][j] = 2;
                    }
                }
                if (board[i][j] == 1){
                    if (count < 2 || count > 3){
                        board[i][j] = 4;
                    }
                    if (count == 2 || count == 3){
                        board[i][j] = 5;
                    }
                }
            }
        }
        for (int i = 0; i < lineSize; i++){
            for (int j = 0; j < colSize; j++){
                board[i][j] = board[i][j] % 2;
            }
        }
    }

    //获取一个细胞周围临近边界的存货细胞数，主要是关注边界条件
    private static int getLive(int[][] board, int currentLine, int currentCol, int lineSize, int colSize){
        int count = 0;
        for (int i = currentLine - 2; i <= currentLine; i++){
            for (int j = currentCol - 2; j <= currentCol; j++){
                if (i == currentLine - 1 && j == currentCol - 1){
                    continue;
                }
                if (i < 0 || j < 0 || i > lineSize - 1 || j > colSize - 1){
                    continue;
                }
                if (board[i][j] >= 4 || board[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[][] board = {{0,1,0},
            {0,0,1},
            {1,1,1},
            {0,0,0}};
        gameOfLife(board);
        System.out.println(board);
    }
}
