package algorithms;

import algorithms.graph.BreadthFirstSearch;
import algorithms.graph.DepthFirstSearch;
import algorithms.graph.DijkstraAlgorithm;
import algorithms.graph.Graph;
import algorithms.sort.SortAlgorithms;

public class Main {
    public static void main(String[] args) {

        //Dijkstra Algorithm
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        dijkstraAlgorithm.runDijkstraAlgorithm("0", "8");

        // Depth-First Search - iterative and recursive
        Graph graphDfs = new Graph();
        graphDfs.createTree();
        DepthFirstSearch dfs = new DepthFirstSearch(graphDfs.getEdges());
        dfs.iterativeDfs("1");
        System.out.println();
        dfs.recursiveDfs("1");

        //Breadth-First Search - iterative and recursive
        Graph graphBfs = new Graph();
        graphBfs.createTree();
        BreadthFirstSearch bfs = new BreadthFirstSearch(graphBfs.getEdges());
        bfs.iterativeBfs("1");
        System.out.println();
        bfs.callRecursiceBfs("1");

        //Sort
        SortAlgorithms sortAlgorithms = new SortAlgorithms();

        int result = sortAlgorithms.euclideanAlgorithm(4,4);
        System.out.println(result);

        int[] table = sortAlgorithms.blumBlumShub(10);

        sortAlgorithms.bubbleSort(table);
        sortAlgorithms.displayTable(table);

        sortAlgorithms.quickSort(0, table.length-1,table);
        sortAlgorithms.displayTable(table);


    }
}