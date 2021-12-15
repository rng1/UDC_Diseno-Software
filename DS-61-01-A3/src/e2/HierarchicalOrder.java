package e2;

import java.util.*;

public class HierarchicalOrder implements GraphIterator{
    Queue<Character> graphList = new LinkedList<>();
    Queue<Character> tempList = new PriorityQueue<>();
    @Override
    public Queue<Character> traverseGraph(Graph graph) {
        for (Map.Entry<Character, List<Character>> entry : graph.getMap().entrySet()) {
            if (graph.isAvailable(entry.getKey())) {
                graphList.add(entry.getKey());
                for (Character element : entry.getValue()) {
                    if (!tempList.contains(element))
                        tempList.add(element);
                }
            }
        }
        while(!graph.isEmpty()){
            for(Character element : graphList)
                graph.freeNode(element);
            while(!tempList.isEmpty()){
                graphList.add(tempList.element());
                tempList.remove(tempList.element());
            }
            for(Character element : graphList) {
                if(graph.getMap().get(element) != null) {
                    for (Character subelement : graph.getMap().get(element)) {
                        if (!tempList.contains(subelement) && !graphList.contains(subelement))
                            tempList.add(subelement);
                    }
                }
            }
        }
        return graphList;
    }
}

