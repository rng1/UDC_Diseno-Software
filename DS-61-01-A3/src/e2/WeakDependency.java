package e2;

import java.util.*;

public class WeakDependency implements GraphIterator{
    Queue<Character> graphList = new LinkedList<>();
    Queue<Character> tempList = new PriorityQueue<>();
    GraphHandler handler = new Handler();

    @Override
    public Queue<Character> traverseGraph(Map<Character, List<Character>> graph) {
        while(!graph.isEmpty()){
            for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
                if(handler.isAvailable(entry.getKey(), graph))
                    tempList.add(entry.getKey());
            }
            while(!tempList.isEmpty()){
                if(!graph.get(tempList.element()).isEmpty())
                    for(Character subelement : graph.get(tempList.element())){
                        if(!tempList.contains(subelement))
                            tempList.add(subelement);
                    }
                handler.freeNode(tempList.element(), graph);
                graphList.add(tempList.element());
                tempList.remove(tempList.element());
            }
        }
        return graphList;
    }
}
