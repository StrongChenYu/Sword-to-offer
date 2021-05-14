package leetcode.dfs;

import org.junit.Before;
import org.junit.Test;
import structure.Node;

import java.util.*;

public class P133_Clone_Graph {

    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraphDFS(Node node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(newNode.val, newNode);

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraphDFS(neighbor));
        }
        return newNode;
    }


    public Node cloneGraphBFS(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);

        while (!nodeQueue.isEmpty()) {
            /**
             * 队列不为空取节点
             */
            Node node1 = nodeQueue.poll();

            Node newNode = new Node(node1.val, new ArrayList<>());
            map.put(node1.val, newNode);

            /**
             * 找邻居
             */
            for (Node neigh : node1.neighbors) {
                //bfs队列添加
                nodeQueue.offer(neigh);

                //找邻居节点，如果在map里面，就不用复制了
                Node copyNeigh = map.get(neigh.val);
                if (copyNeigh == null) {
                    copyNeigh = new Node(neigh.val, new ArrayList<>());
                    map.put(neigh.val, copyNeigh);
                    newNode.neighbors.add(copyNeigh);
                }
            }
        }

        return map.get(node.val);
    }

    Node data;

    @Before
    public void before() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        ArrayList<Node> adj1 = new ArrayList<>();
        adj1.add(node2);
        adj1.add(node4);
        node1.neighbors = adj1;

        ArrayList<Node> adj2 = new ArrayList<>();
        adj2.add(node1);
        adj2.add(node3);
        node2.neighbors = adj2;

        ArrayList<Node> adj3 = new ArrayList<>();
        adj3.add(node2);
        adj3.add(node4);
        node3.neighbors = adj3;

        ArrayList<Node> adj4 = new ArrayList<>();
        adj4.add(node1);
        adj4.add(node3);
        node4.neighbors = adj4;

        data = node1;
    }

    @Test
    public void Test() {
        cloneGraphBFS(data);
    }

}
