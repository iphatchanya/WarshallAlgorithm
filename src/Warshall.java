import java.lang.*;

public class Warshall {
    private final static int INF = 999, V = 4;

    // print adjacency matrix
    public void adjacency(int dist[][])
    {
        System.out.println("Adjacency Matrix: ");
        System.out.print("\ncolm.\t");
        for (int j = 0; j < V; j++) {
            System.out.print(j+1 + "\t");
        }
        System.out.println();
        for (int j = 0; j < 22; j++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < V; ++i) {
            System.out.print("row " + (i+1) + " |\t");
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF )
                    System.out.print("0"+"   ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println("\n");
        }
        System.out.println();
    }

    // calculate shortest path
    private int[][] warshallShortest(int graph[][])
    {
        int dist[][] = new int[V][V];

        int i, j, k;

        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                if(graph[i][j] == 0) {
                    dist[i][j] = INF;
                }
                else {
                    dist[i][j] = graph[i][j];
                }

        for (k = 0; k < V; k++)
        {
            for (i = 0; i < V; i++)
            {
                for (j = 0; j < V; j++)
                {
                    if (dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return dist;
    }

    // print shortest path
    public void shortest(int dist[][])
    {
        dist = warshallShortest(dist);
        System.out.println("1. Shortest path by using Warshall's Algorithm: ");
        System.out.print("\ncolm.\t");
        for (int j = 0; j < V; j++) {
            System.out.print(j+1 + "\t");
        }
        System.out.println();
        for (int j = 0; j < 22; j++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < V; ++i) {
            System.out.print("row " + (i+1) + " |\t");
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] < 10 ? dist[i][j] + "   " : dist[i][j] + "  ");
            }
            System.out.println("\n");
        }
        System.out.println();
    }

    // calculate path matrix
    private int[][] warshallPath(int graph[][])
    {
        int dist[][] = new int[V][V];
        int next[][] = new int[V][V];
        int i, j, k;

        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] > 0 && graph[i][j] < INF)
                    next[i][j] = 1;
                else if(graph[i][j] == 0) {
                    next[i][j] = 1;
                }
            }

        for (k = 0; k < V; k++)
        {
            for (i = 0; i < V; i++)
            {
                for (j = 0; j < V; j++)
                {
                    if (dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = 1;
                    }
                }
            }
        }
        return next;
    }

    // print path matrix
    public void path(int dist[][])
    {
        dist = warshallPath(dist);
        System.out.println("2. Path matrix by using Warshall's Algorithm: ");
        System.out.print("\ncolm.\t");
        for (int j = 0; j < V; j++) {
            System.out.print(j+1 + "\t");
        }
        System.out.println();
        for (int j = 0; j < 22; j++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < V; ++i) {
            System.out.print("row " + (i+1) + " |\t");
            for (int j = 0; j < V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] < 10 ? dist[i][j]+"   " :dist[i][j]+"  ");
            }
            System.out.println("\n");
        }
        System.out.println();
    }
}
