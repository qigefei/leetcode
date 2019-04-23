package array;

/**
 * Created by miula on 2019/4/18.
 *
 * @author miula
 * @date 2019/04/18
 */
public class SetMatrixZeroes73 {
    public static void setZeroes(int[][] matrix) {
        if (matrix.length == 0){
            return;
        }
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int stableRowNum = -1;
        //遍历数组，找到不含0的行
        for (int i=0; i < rowLength; i++){
            stableRowNum = i;
            for (int j=0; j < colLength; j++){
                if (matrix[i][j] == 0){
                    stableRowNum = -1;
                    break;
                }
            }
            if (stableRowNum >= 0){
                break;
            }
        }
        //找不到的话全部置为0
        if (stableRowNum < 0){
            for (int i = 0; i < rowLength; i++){
                for (int j = 0; j < colLength; j++){
                    matrix[i][j] = 0;
                }
            }
            return;
        }

        //将含有0的列在稳定的行上标记一下
        for (int i = 0; i < colLength; i++){
            for (int j = 0; j < rowLength; j++){
                if (j == stableRowNum){
                    continue;
                }
                if (matrix[j][i] == 0){
                    matrix[stableRowNum][i] = 0;
                    break;
                }
            }
        }

        //除stable行以外有0的行置零
        for (int i = 0; i < rowLength; i++){
            if (i == stableRowNum){
                continue;
            }
            int zeroRow = -1;
            for (int j = 0; j < colLength; j++){
                if (matrix[i][j] == 0){
                    zeroRow = i;
                    break;
                }
            }
            if (zeroRow < 0){
                continue;
            }
            for (int j = 0; j < colLength; j++){
                matrix[i][j] = 0;
            }
        }

        //stable行标记的列置零
        for (int i = 0; i < colLength; i++){
            if (matrix[stableRowNum][i] == 0){
                for (int j = 0; j < rowLength; j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = {{0,0,0,5}, {4,3,1,4}, {1,2,1,3}, {0,0,1,1}};
        setZeroes(matrix);
        System.out.println(matrix);
    }
}
