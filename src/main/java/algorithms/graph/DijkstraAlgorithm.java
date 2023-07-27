package algorithms.graph;

import java.util.*;

public class DijkstraAlgorithm {

    private Graph graph = new Graph();
    private Map<String, ArrayList<Edge>> edges = new HashMap<>();
    private Map<String, Edge> edgesDijkstra = new HashMap<>();
    private Set<String> Q = new HashSet<>();

    public void runDijkstraAlgorithm(String rootNode, String destination){
        graph.createGraph();
        edges = graph.getEdges();
        fillWeights(rootNode);

        while (!Q.isEmpty()) {
            String node_V = findLowestWeightNode();
            Q.remove(node_V);
            for (Edge edge_K : edges.get(node_V)) {
                String node_U = edge_K.getVertex();
                int newCost = edgesDijkstra.get(node_V).getWeight() + edge_K.getWeight();
                if (newCost < edgesDijkstra.get(node_U).getWeight()) {
                    edgesDijkstra.replace(node_U, new Edge(node_V, newCost));
                }
            }
        }

        List<String> listOfSteps = new ArrayList<>();
        System.out.println("The total cost is: " + edgesDijkstra.get(destination).getWeight());
        System.out.print("The path is: ");

        do {
            listOfSteps.add(destination);
            destination = edgesDijkstra.get(destination).getVertex();
        } while (!destination.equals(""));

        for (int i=listOfSteps.size()-1; i >= 0; i--) {
            System.out.print(listOfSteps.get(i) + " ");
        }
    }

    private void fillWeights(String rootNode) {
        for (String k : edges.keySet()) {
            if (k.equals(rootNode)){
                edgesDijkstra.putIfAbsent(k, new Edge("",0));
            } else {
                edgesDijkstra.putIfAbsent(k, new Edge("",Integer.MAX_VALUE));
            }
        }
        for (String key : edgesDijkstra.keySet()) {
            Q.add(key);
        }
    }

    private String findLowestWeightNode() {
        int lowestWeight = Integer.MAX_VALUE;
        String lowestWeightNode = "";

        for(String node : edgesDijkstra.keySet()) {
            if (!Q.contains(node)) {continue;}
            int nodeWeight = edgesDijkstra.get(node).getWeight();
            if (nodeWeight < lowestWeight) {
                lowestWeight = nodeWeight;
                lowestWeightNode = node;
            }
        }
        return lowestWeightNode;
    }
}