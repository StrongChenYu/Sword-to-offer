package leetcode.heap;

import org.junit.Test;

import java.util.*;

public class P332_Reconstruct_Itinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).offer(ticket.get(1));
        }

        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", res, map);
        return res;
    }

    private void dfs(String start, LinkedList<String> res, Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> target = map.get(start);
        while (target != null && target.size() != 0) {
            dfs(target.poll(), res, map);
        }
        res.addFirst(start);
    }

    @Test
    public void test() {
//        [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        List<List<String>> test = new ArrayList<>();

        test.add(Arrays.asList("JFK", "KUL"));
        test.add(Arrays.asList("JFK", "NRT"));
        test.add(Arrays.asList("NRT", "JFK"));

        findItinerary(test);
    }
}
