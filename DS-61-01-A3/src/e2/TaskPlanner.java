package e2;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskPlanner {
    Queue<Character> queueTask;
    Map<Character, List<Character>> graphTask;

    public TaskPlanner(){
        queueTask = new PriorityQueue<>();
    }

    //public void traverseGraph(file, criterion)
    // {
    //    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    //    String line;
    //    while ((line = br.readLine()) != null) {
    //       // process the line.
    //    }
    //      while map is not empty
    //          while there is some avaible
    //              criterion.isAvailable(char)
    //              saveNode(char)
    //          freeNode(char)
    //
    //}



}
