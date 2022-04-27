package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class P52_N_Queens_II {

    public class Axis {
        public int x;
        public int y;

        public Axis(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    int res = 0;
    public int totalNQueens(int n) {

        List<Axis> path = new ArrayList<>();

        dfs(0, n, path);

        return res;
    }


    private void dfs(int deep, int n,  List<Axis> path) {
        if (deep == n) {
            res++;
            return;
        }

        for (int i = 0; i < n; i++) {
            // 判断坐标是否满足要求
            Axis cur = new Axis(deep, i);

            if (canFillIn(path, cur)) {
                // 可以填进去才进行递归
                path.add(cur);
                dfs(deep + 1, n, path);
                path.remove(path.size() - 1);
            }
        }

    }

    private boolean canFillIn(List<Axis> path, Axis a2) {
        // 判断axis是否满足path的要求
        // 遍历path,判断是不是在一条直线，斜线上
        for (Axis a1 : path) {
            if (a2.y == a1.y || Math.abs(a2.y - a1.y) == Math.abs(a2.x - a1.x)) {
                return false;
            }
        }
        return true;
    }

}
