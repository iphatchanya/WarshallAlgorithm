public class Main {
    public static void main(String[] args) {

        final int INF = 999;

        int graph[][] = {
                {2, INF, INF, INF},
                {4, 0, INF, 3},
                {INF, 5, 0, INF},
                {7, INF, 9, 0}
        };

        Warshall warshall = new Warshall();
        warshall.adjacency(graph);
        warshall.shortest(graph);
        warshall.path(graph);
    }
}
