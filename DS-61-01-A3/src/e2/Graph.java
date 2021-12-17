package e2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    Map<Character, List<Character>> graph;
    List<Character> tempList;

    public Graph(){
        graph = new HashMap<>();
    }

    public boolean isNotEmpty(){
        return !graph.isEmpty();
    }

    public Map<Character, List<Character>> getMap() {
        return graph;
    }

    public boolean isAvailable(Character target) {
        //CHECK IF EXISTS
        if(!graph.containsKey(target) && target != null)
            throw new IllegalArgumentException();
        //IF THE ELEMENT IS IN SOMEBODY LISTS IT MEANS IT IS A CHILD
        for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
            if(target != entry.getKey()){
                tempList = entry.getValue();
                if(tempList.contains(target))
                    return false;
            }
        }
        return true;
    }

    public void freeNode(Character target) {
        //REMOVE THE ELEMENT
        graph.remove(target);
        //REMOVE THE ELEMENT OF ANYONE'S LIST
        for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
            tempList = entry.getValue();
            tempList.remove(target);
            graph.put(entry.getKey(), tempList);
        }
    }
}
