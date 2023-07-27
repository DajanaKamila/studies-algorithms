package algorithms.graph;

import java.util.*;

public class DepthFirstSearch {

    private Map<String, ArrayList<Edge>> edges;

    public DepthFirstSearch(Map<String, ArrayList<Edge>> edges) {
        this.edges = edges;
    }

    public void iterativeDfs(String rootVertex) {
        Stack<String> stack = new Stack<>();
        Set<String> visitedVertices = new HashSet<>();
        stack.push(rootVertex);

        while (!stack.empty()) {
            String vertex = stack.pop();
            if (visitedVertices.contains(vertex)){
                continue;
            } else {
                visitedVertices.add(vertex);
                System.out.println("Vertex: " + vertex);
                ArrayList<Edge> listOfEdges = edges.get(vertex);

                for (int i = listOfEdges.size()-1 ; i >=0; i--){
                    stack.push(listOfEdges.get(i).getVertex());
                }
            }
        }
    }

    public void recursiveDfs(String rootVertex) {
        System.out.println("Vertex: " + rootVertex);
        ArrayList<Edge> listOfEdges = edges.get(rootVertex);
        for (int i = 0; i < listOfEdges.size(); i++){
            recursiveDfs(listOfEdges.get(i).getVertex());
        }
    }
}
