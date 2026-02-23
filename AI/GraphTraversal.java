import java.util.*;

public class GraphTraversal {

    private int vertices;
    private LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public GraphTraversal(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Add edge (Undirected)
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // ---------------- BFS ----------------
    public void BFS(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbour : adj[vertex]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        System.out.println();
    }

    // ---------------- DFS ----------------
    public void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Traversal: ");
        DFSUtil(start, visited);
        System.out.println();
    }

    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbour : adj[vertex]) {
            if (!visited[neighbour]) {
                DFSUtil(neighbour, visited);
            }
        }
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of vertices: ");
            int v = sc.nextInt();

            if (v <= 0) {
                System.out.println("Number of vertices must be positive.");
                return;
            }

            GraphTraversal graph = new GraphTraversal(v);

            System.out.print("Enter number of edges: ");
            int e = sc.nextInt();

            System.out.println("Enter edges (source destination):");

            for (int i = 0; i < e; i++) {
                int src = sc.nextInt();
                int dest = sc.nextInt();

                if (src >= 0 && src < v && dest >= 0 && dest < v) {
                    graph.addEdge(src, dest);
                } else {
                    System.out.println("Invalid edge! Try again.");
                    i--;
                }
            }

            System.out.print("Enter starting vertex for traversal: ");
            int start = sc.nextInt();

            if (start < 0 || start >= v) {
                System.out.println("Invalid starting vertex.");
                return;
            }

            System.out.println("\n--- Traversal Results ---");
            graph.BFS(start);
            graph.DFS(start);

        } catch (Exception ex) {
            System.out.println("Invalid input! Please enter integers only.");
        } finally {
            sc.close();
        }
    }
}