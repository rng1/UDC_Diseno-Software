package e2;

import java.util.List;
import java.util.Map;

public interface GraphHandler {
    public boolean isAvailable(Character target, Map<Character, List<Character>> graph);
    public void freeNode(Character target, Map<Character, List<Character>> graph);
}
