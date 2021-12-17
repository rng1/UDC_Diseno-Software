package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskPlannerTest {
    private final TaskPlanner planner = new TaskPlanner();
    private final Queue<Character> testStrongQueue = new LinkedList<>();
    private final Queue<Character> testWeakQueue = new LinkedList<>();
    private final Queue<Character> testOrderQueue = new LinkedList<>();
    private File text;

    @BeforeEach
    void setUp(){
        text = new File("test/e2/graphBasic");
        //C - A - B - D - G - F - E - H - J
        testStrongQueue.add('C');
        testStrongQueue.add('A');
        testStrongQueue.add('B');
        testStrongQueue.add('D');
        testStrongQueue.add('G');
        testStrongQueue.add('F');
        testStrongQueue.add('E');
        testStrongQueue.add('H');
        testStrongQueue.add('J');
        //C - A - B - D - E - F - G - H - J
        testWeakQueue.add('C');
        testWeakQueue.add('A');
        testWeakQueue.add('B');
        testWeakQueue.add('D');
        testWeakQueue.add('E');
        testWeakQueue.add('F');
        testWeakQueue.add('G');
        testWeakQueue.add('H');
        testWeakQueue.add('J');
        //C - G - A - F - H - B - D - E - J
        testOrderQueue.add('C');
        testOrderQueue.add('G');
        testOrderQueue.add('A');
        testOrderQueue.add('F');
        testOrderQueue.add('H');
        testOrderQueue.add('B');
        testOrderQueue.add('D');
        testOrderQueue.add('E');
        testOrderQueue.add('J');
    }

    @Test
    void basicTest(){
        planner.planTask(text, new StrongDependency());
        assertEquals(testStrongQueue, planner.queue);
        planner.planTask(text, new WeakDependency());
        assertEquals(testWeakQueue, planner.queue);
        planner.planTask(text, new HierarchicalOrder());
        assertEquals(testOrderQueue, planner.queue);
    }

    @Test
    void exceptionTest(){
        TaskPlanner planner = new TaskPlanner();
        assertThrows(IllegalArgumentException.class, () -> planner.graph.isAvailable('A'));

        Queue<Character> testQueue = new LinkedList<>();
        testQueue.add('A');
        testQueue.add('E');
        text = new File("test/e2/graphBad");
        planner.planTask(text, new StrongDependency());
        assertEquals(testQueue, planner.queue);
        planner.planTask(text, new WeakDependency());
        assertEquals(testQueue, planner.queue);
        planner.planTask(text, new HierarchicalOrder());
        assertEquals(testQueue, planner.queue);
    }
}
