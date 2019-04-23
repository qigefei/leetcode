package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by miula on 2019/4/23.
 *
 * @author miula
 * @date 2019/04/23
 */
public class PascalsTriangleII119 {

    public static List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        //每行除了第一个数值之外都是上一次循环当前位置的数值加上前面位置的数值
        for (int i = 0; i <= rowIndex; i++){
            for (int j = i; j >= 0; j--){
                if (j == 0 || j == i){
                    res[j] = 1;
                    continue;
                }
                res[j] = res[j] + res[j-1];
            }
        }
        List<Integer> resList = Arrays.asList(res);
        return resList;
    }

    public static void main(String[] args){
        List<Integer> res = getRow(3);
        System.out.println(res);
    }
}
