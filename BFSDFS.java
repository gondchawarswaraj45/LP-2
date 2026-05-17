/*
Enter number of vertices: 5
Enter number of edges: 4
Enter edges:
0 1
0 2
1 3
2 4
Enter starting vertex: 0
*/

import java.util.*;

public class BFSDFS {

    static ArrayList<Integer> graph[];

    static void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    static void bfs(int start, int vertices) {

        boolean visited[] = new boolean[vertices];

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            int node = queue.poll();

            System.out.print(node + " ");

            for (int neighbor : graph[node]) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    static void dfs(int node, boolean visited[]) {

        visited[node] = true;

        System.out.print(node + " ");

        for (int neighbor : graph[node]) {

            if (!visited[neighbor]) {

                dfs(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        graph = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        System.out.println("Enter edges:");

        for (int i = 0; i < edges; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            addEdge(u, v);
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        bfs(start, vertices);

        boolean visited[] = new boolean[vertices];

        System.out.print("DFS Traversal: ");
        dfs(start, visited);

        sc.close();
    }
}