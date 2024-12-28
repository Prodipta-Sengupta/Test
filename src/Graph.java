import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Graph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public HashMap<String, ArrayList<String>> getAdjList() {
        return adjList;
    }

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    // WRITE REMOVEVERTEX METHOD HERE //
    //                                //
    //                                //
    //                                //
    //                                //

    /// /////////////////////////////////
    public boolean removeVertex(String vertex) {
        if (!adjList.containsKey(vertex)) {
            return false;
        }
        List<String> edgeList = adjList.get(vertex);
        for (String edge : edgeList) {
            adjList.get(edge).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }

}