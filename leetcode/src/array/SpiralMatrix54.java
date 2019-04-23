package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miula on 2019/4/12.
 *
 * @author miula
 * @date 2019/04/12
 */
public class SpiralMatrix54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0){
            return result;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd){
            for (int i = colBegin; i <= colEnd; i++){
                result.add(matrix[colBegin][i]);
            }
            rowBegin++;
            if (rowBegin > rowEnd){
                break;
            }
            for (int i = rowBegin; i <= rowEnd; i++){
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (colBegin > colEnd){
                break;
            }
            for (int i = colEnd; i >= colBegin; i--){
                result.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            if (rowBegin > rowEnd){
                break;
            }
            for (int i = rowEnd; i >= rowBegin; i--){
                result.add(matrix[i][colBegin]);
            }
            colBegin++;
        }
        return result;
    }

    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3},
                         {4, 5, 6},
                         {7, 8, 9}};
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }

}
