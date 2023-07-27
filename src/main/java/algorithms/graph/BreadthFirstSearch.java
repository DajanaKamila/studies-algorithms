package algorithms.graph;

import java.util.*;

public class BreadthFirstSearch {

    private Map<String, ArrayList<Edge>> edges;

    public BreadthFirstSearch(Map<String, ArrayList<Edge>> edges) {
        this.edges = edges;
    }

    public void iterativeBfs(String rootVertex) {
        Queue<String> queue = new LinkedList<>();
        queue.add(rootVertex);

        while (!queue.isEmpty()){
            String vertex = queue.poll();
            System.out.println("Vertex: " + vertex);
            ArrayList<Edge> listOfEdges = edges.get(vertex);

            for (Edge edge : listOfEdges) {
                queue.add(edge.getVertex());
            }
        }
    }

    public void callRecursiceBfs (String rootVertex){
        Queue<String> queue = new LinkedList<>();
        queue.add(rootVertex);
        recursiveBfs(queue);
    }

    public void recursiveBfs(Queue<String> queue){
        if (queue.isEmpty()) {return;}
        String vertex = queue.poll();
        System.out.println("Vertex: " + vertex);
        ArrayList<Edge> listOfEdges = edges.get(vertex);

        for (Edge edge : listOfEdges) {
            queue.add(edge.getVertex());
        }
        recursiveBfs(queue);
    }
}
