package e2;

import java.util.List;
import java.util.Map;

public class Handler implements GraphHandler{
    List<Character> tempList;

    public boolean isAvailable(Character target, Map<Character, List<Character>> graph) {
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

    public void freeNode(Character target, Map<Character, List<Character>> graph) {
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

