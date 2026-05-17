/* 
  Enter number of vertices: 4

  Enter adjacency matrix:
  0 10 15 0
  10 0 20 25
  15 20 0 30
  0 25 30 0

*/

import java.util.*;

public class Prims {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int graph[][] = new int[n][n];

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                graph[i][j] = sc.nextInt();
            }
        }

        boolean visited[] = new boolean[n];

        visited[0] = true;

        int edges = 0;
        int total = 0;

        System.out.println("Edges in MST:");

        while (edges < n - 1) {

            int min = 999;
            int x = 0;
            int y = 0;

            for (int i = 0; i < n; i++) {

                if (visited[i]) {

                    for (int j = 0; j < n; j++) {

                        if (!visited[j] && graph[i][j] != 0) {

                            if (graph[i][j] < min) {

                                min = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + " : " + graph[x][y]);

            total += graph[x][y];

            visited[y] = true;

            edges++;
        }

        System.out.println("Total Cost = " + total);

        sc.close();
    }
}