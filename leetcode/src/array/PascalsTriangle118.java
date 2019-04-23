package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miula on 2019/4/19.
 * 毕加索三角形
 * @author miula
 * @date 2019/04/19
 */
public class PascalsTriangle118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0){
            return res;
        }
        for (int i = 1; i <= numRows; i++){
            List<Integer> tmpRes = new ArrayList<>();
            for (int j = 1; j <= i; j++){
                if (j == 1 || j == i){
                    tmpRes.add(1);
                }else {
                    List<Integer> lastList = res.get(i-2);
                    tmpRes.add(lastList.get(j-2) + lastList.get(j-1));
                }
            }
            res.add(tmpRes);
        }
        return res;
    }

    public static void main(String[] args){
        List<List<Integer>> res = generate(5);
        System.out.println(res);
    }
}
