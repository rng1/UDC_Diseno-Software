package e2;

import java.util.*;

public class WeakDependency implements GraphIterator{
    Queue<Character> graphList = new LinkedList<>();
    Queue<Character> tempList = new PriorityQueue<>();
    Character tempChar;

    @Override
    public Queue<Character> traverseGraph(Graph graph) {
        while(!graph.isEmpty()){
            for (Map.Entry<Character, List<Character>> entry : graph.getMap().entrySet()) {
                if(graph.isAvailable(entry.getKey()))
                    tempList.add(entry.getKey());
            }
            while(!tempList.isEmpty()){
                tempChar = tempList.element();
                if(!graph.getMap().get(tempChar).isEmpty())
                    for(Character subelement : graph.getMap().get(tempChar)){
                        if(!tempList.contains(subelement))
                            tempList.add(subelement);
                    }
                graph.freeNode(tempChar);
                graphList.add(tempChar);
                tempList.remove(tempChar);
            }
        }
        return graphList;
    }
}
