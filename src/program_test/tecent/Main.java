package program_test.tecent;

import java.util.Scanner;

public class Main {
    private int[] id;
    private int count;
    private int maxPerson;
    public Main(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        maxPerson = 1;
        count = N;
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) id[i] = qId;
        }
        count--;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dataCount = scanner.nextInt();

        for (int i = 0; i < dataCount; i++) {
            int pairCount = scanner.nextInt();
            Main main = new Main(pairCount);
            for (int j = 0; j < pairCount; j++) {
                int p = scanner.nextInt();
                int q = scanner.nextInt();


            }
        }
    }
}
