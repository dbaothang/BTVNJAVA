package week13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Subset {
    int parent;
    int rank;

    Subset(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
}

class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge otherEdge) {
        return Integer.compare(this.weight, otherEdge.weight);
    }
}

public class KruskalsMST {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();

        List<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < edges; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();

            edgeList.add(new Edge(from, to, weight));
        }

        int result = findMinimumSpanningTreeWeight(vertices, edgeList);
        System.out.println(result);

    }

    public static int findMinimumSpanningTreeWeight(int numberOfNodes, List<Edge> edges) {
        Collections.sort(edges);

        List<Subset> subsets = new ArrayList<>();
        for (int i = 0; i <= numberOfNodes; i++) {
            subsets.add(new Subset(i, 0));
        }

        int minimumSpanningTreeWeight = 0;
        for (Edge edge : edges) {
            int sourceParent = findParent(subsets, edge.source);
            int destinationParent = findParent(subsets, edge.destination);

            if (sourceParent != destinationParent) {
                union(subsets, sourceParent, destinationParent);
                minimumSpanningTreeWeight += edge.weight;
            }
        }

        return minimumSpanningTreeWeight;
    }

    public static void union(List<Subset> subsets, int x, int y) {
        int rootX = findParent(subsets, x);
        int rootY = findParent(subsets, y);

        if (subsets.get(rootX).rank <= subsets.get(rootY).rank) {
            subsets.get(rootX).parent = rootY;
        } else {
            subsets.get(rootY).parent = rootX;
        }
    }

    public static int findParent(List<Subset> subsets, int i) {
        if (subsets.get(i).parent == i) {
            return subsets.get(i).parent;
        }
        return findParent(subsets, subsets.get(i).parent);
    }
}

