package e2;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskPlanner {
    Queue<Character> queueTask;
    Map<Character, List<Character>> graphTask;

    public TaskPlanner() {
        queueTask = new PriorityQueue<>();
    }

    public void planTask(File file, GraphIterator iterator) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line
            }
        } catch (IOException e) { e.printStackTrace(); }

        queueTask = iterator.traverseGraph(graphTask);
    }
}
