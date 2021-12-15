package e2;

import java.util.*;


public class StrongDependency implements GraphIterator{
    Queue<Character> graphList = new LinkedList<>();
    @Override
    public Queue<Character> traverseGraph(Graph graph) {
        while(!graph.isEmpty()){
            for (Map.Entry<Character, List<Character>> entry : graph.getMap().entrySet()) {
                if(graph.isAvailable(entry.getKey())) {
                    graphList.add(entry.getKey());
                    graph.freeNode(entry.getKey());
                    break;
                }
            }
        }
        return graphList;
    }
}

