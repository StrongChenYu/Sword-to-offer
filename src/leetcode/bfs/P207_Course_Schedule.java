package leetcode.bfs;

import org.junit.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class P207_Course_Schedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashSet<Integer>[] neighs = new HashSet[numCourses];

        for (int i = 0; i < numCourses; i++) {
            neighs[i] = new HashSet<>();
        }

        for (int[] pre : prerequisites) {
            inDegree[pre[0]]++;
            neighs[pre[1]].add(pre[0]);
        }

        // 上面图就构建完毕了
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer learnFin = queue.poll();
            cnt++;
            for (Integer nextCourse : neighs[learnFin]) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return cnt == numCourses;
    }

    @Test
    public void test() {

    }

}
