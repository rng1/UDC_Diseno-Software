package e2;

import java.io.*;
import java.util.*;

public class TaskPlanner {
    Queue<Character> queue;
    List<Character> tempList;
    Graph graph;

    public TaskPlanner() {
        queue = new PriorityQueue<>();
        graph = new Graph();
    }

    public void planTask(File file, GraphIterator iterator) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            String[] splitted;
            Character father, child;
            int lineCount = 0;
            while ((line = br.readLine()) != null) {
                lineCount++;
                splitted = line.split("\\s+");
                //REVISE FORMAT
                if(splitted.length != 3 || splitted[0].length() != 1 || splitted[2].length() != 1 || !splitted[1].equals("->"))
                    System.out.print("Error, line " + lineCount + ": " + line + "\n");
                    //throw new IllegalArgumentException();
                else {
                    father = splitted[0].charAt(0);
                    child = splitted[2].charAt(0);
                    if (!graph.getMap().containsKey(father)) {
                        tempList = new ArrayList<>();
                        tempList.add(child);
                    } else {
                        tempList = graph.getMap().get(father);
                        tempList.add(child);
                        Comparator<Character> comparador = Collections.reverseOrder();
                        tempList.sort(comparador);
                    }
                    graph.getMap().put(father, tempList);
                    if (!graph.getMap().containsKey(child)) {
                        tempList = new ArrayList<>();
                        graph.getMap().put(child, tempList);
                    }
                }
            }
        } catch (IOException e) { e.printStackTrace(); }

        //ACTUAL PROGRAM
        queue = iterator.traverseGraph(graph);
    }

}
