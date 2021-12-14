package e2;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class StrongDependency implements GraphIterator{
    Queue<Character> graphList = new LinkedList<>();
    GraphHandler handler = new Handler();
    @Override
    public Queue<Character> traverseGraph(Map<Character, List<Character>> graph) {
        while(!graph.isEmpty()){
            for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
                if(handler.isAvailable(entry.getKey(), graph)) {
                    graphList.add(entry.getKey());
                    handler.freeNode(entry.getKey(), graph);
                    break;
                }
            }
        }
        return graphList;
    }
}
