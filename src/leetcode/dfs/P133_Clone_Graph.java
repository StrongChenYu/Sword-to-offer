package leetcode.dfs;

import org.junit.Before;
import org.junit.Test;
import structure.Node;

import java.util.*;

public class P133_Clone_Graph {

    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(newNode.val, newNode);

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
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
        cloneGraph(data);
    }

}
