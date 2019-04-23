package array;

/**
 * Created by miula on 2019/4/15.
 *
 * @author miula
 * @date 2019/04/15
 */
public class SpiralMatrixII59 {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0){
            return res;
        }
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int length = n * n;
        int temp = 1;
        while (temp <= length) {
            for (int i = colBegin; i <= colEnd; i++) {
                res[rowBegin][i] = temp;
                temp++;
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++){
                res[i][colEnd] = temp;
                temp++;
            }
            colEnd--;
            for (int i = colEnd; i >= colBegin; i--){
                res[rowEnd][i] = temp;
                temp++;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowBegin; i--){
                res[i][colBegin] = temp;
                temp++;
            }
            colBegin++;
        }
        return res;
    }

    public static void main(String[] args){
        int[][] res = generateMatrix(3);
        System.out.println(res);
    }
}
