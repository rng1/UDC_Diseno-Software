package e1;

import e3.Melody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static e1.Residents.House.*;
import static e1.Teachers.Subject.*;

import java.util.Random;

public class SchoolTest {

    private final float delta = 0.0001f;

    private School school;

    @BeforeEach
    void setUp() {
        school = new School();
        school.insertStudent("Hermione", "Granger", 12, 3, Gryffindor);
        school.insertGhost("Bloody", "Baron", 107, 1, Slytherin);
        school.insertGamekeeper("Rubeus", "Hagrid", 56, 2);
        school.insertTeacher("Minerva", "McGonagall", 71, 1, Transfiguration);
        school.insertTeacher("Severus", "Snape", 49, 2, Defence);
        school.insertCaretaker("Argus", "Filch", 34, 0);
    }
    @Test
    void testBasicSchool() {
        assertEquals("Hermione Granger (Student of Gryffindor, 3 horcruxes): 270.0 galleons\n" +
                "Bloody Baron (Ghost of Slytherin, 1 horcruxes): 160.0 galleons\n" +
                "Rubeus Hagrid (Gamekeeper, 2 horcruxes): 150.0 galleons\n" +
                "Minerva McGonagall (Teacher of Transfiguration, 1 horcruxes): 50.0 galleons\n" +
                "Severus Snape (Teacher of Defence, 2 horcruxes): 75.0 galleons\n" +
                "Argus Filch (Caretaker, 0 horcruxes): 0.0 galleons\n" +
                "The total reward for Hogwarts School is 705.0 galleons", school.printReward());
        assertEquals("Rubeus Hagrid (Gamekeeper): 180 galleons\n" +
                "Minerva McGonagall (Teacher of Transfiguration): 400 galleons\n" +
                "Severus Snape (Teacher of Defence): 500 galleons\n" +
                "Argus Filch (Caretaker): 160 galleons\n" +
                "The total payroll for Hogwarts School is 1240 galleons", school.printSalary());
    }
}
