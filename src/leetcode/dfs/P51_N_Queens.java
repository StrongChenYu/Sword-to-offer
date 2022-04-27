package leetcode.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P51_N_Queens {

    public class Axis {
        public int x;
        public int y;

        public Axis(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Axis{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<Axis> path = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append('.');
        }

        dfs(0, n, res, path, builder);

        return res;
    }

    private void dfs(int deep, int n, List<List<String>> res, List<Axis> path, StringBuilder builder) {
        if (path.size() == n) {
            List<String> temp = new ArrayList<>();
            for (Axis axis : path) {
                builder.setCharAt(axis.y, 'Q');
                temp.add(builder.toString());
                builder.setCharAt(axis.y, '.');
            }

            res.add(temp);

            return;
        }

        for (int i = 0; i < n; i++) {
            // 判断坐标是否满足要求
            Axis cur = new Axis(deep, i);

            if (canFillIn(path, cur)) {
                // 可以填进去才进行递归
                path.add(cur);
                dfs(deep + 1, n, res, path, builder);
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

    @Test
    public void test() {
        solveNQueens(5);
    }

}
