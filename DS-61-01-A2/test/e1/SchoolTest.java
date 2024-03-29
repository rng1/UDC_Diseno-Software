package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static e1.Members.House.*;
import static e1.Members.Subject.*;
import static e1.School.Category.*;
import static org.junit.jupiter.api.Assertions.*;

public class SchoolTest {

    private School school;

    @BeforeEach
    void setUp() {
        school = new School();
        school.insertMember(Student, "Hermione", "Granger", 12, 3, Gryffindor);
        school.insertMember(Ghost, "Bloody", "Baron", 107, 1, Slytherin);
        school.insertMember(Gamekeeper, "Rubeus", "Hagrid", 56, 2);
        school.insertMember("Minerva", "McGonagall", 71, 1, Transfiguration);
        school.insertMember("Severus", "Snape", 49, 2, Defence);
        school.insertMember(Caretaker, "Argus", "Filch", 34, 0);
    }
    @Test
    void testBasic() {
        School emptySchool = new School();
        assertEquals(0, emptySchool.size());

        assertEquals("""
                Hermione Granger (Student of Gryffindor, 3 horcruxes): 270.0 galleons
                Bloody Baron (Ghost of Slytherin, 1 horcruxes): 160.0 galleons
                Rubeus Hagrid (Gamekeeper, 2 horcruxes): 150.0 galleons
                Minerva McGonagall (Teacher of Transfiguration, 1 horcruxes): 50.0 galleons
                Severus Snape (Teacher of Defence, 2 horcruxes): 75.0 galleons
                Argus Filch (Caretaker, 0 horcruxes): 0.0 galleons
                The total reward for Hogwarts School is 705.0 galleons""", school.printReward());
        assertEquals("""
                Rubeus Hagrid (Gamekeeper): 180 galleons
                Minerva McGonagall (Teacher of Transfiguration): 400 galleons
                Severus Snape (Teacher of Defence): 500 galleons
                Argus Filch (Caretaker): 160 galleons
                The total payroll for Hogwarts School is 1240 galleons""", school.printSalary());
    }

    @Test
    void testAdvanced() {
        School schoolA = new School();

        schoolA.insertMember(Student, "student", "1", 10, 1, Gryffindor);
        schoolA.insertMember(Student, "student", "2", 10, 1, Slytherin);
        schoolA.insertMember(Student, "student", "3", 10, 1, Ravenclaw);
        schoolA.insertMember(Student, "student", "4", 10, 1, Hufflepuff);
        schoolA.insertMember(Ghost, "ghost", "1", 10, 1, Gryffindor);
        schoolA.insertMember(Ghost, "ghost", "2", 10, 1, Slytherin);
        schoolA.insertMember(Ghost, "ghost", "3", 10, 1, Ravenclaw);
        schoolA.insertMember(Ghost, "ghost", "4", 10, 1, Hufflepuff);
        schoolA.insertMember(Gamekeeper, "gamekeeper", "1", 10, 1);
        schoolA.insertMember(Gamekeeper, "gamekeeper", "2", 10, 1);
        schoolA.insertMember(Caretaker, "caretaker", "1", 10, 1);
        schoolA.insertMember(Caretaker, "caretaker", "2", 10, 1);
        schoolA.insertMember("teacher", "transfiguration", 10, 1, Transfiguration);
        schoolA.insertMember("teacher", "defence", 10, 1, Defence);
        schoolA.insertMember("teacher", "potions", 10, 1, Potions);
        schoolA.insertMember("teacher", "herbology", 10, 1, Herbology);
        schoolA.insertMember("teacher", "history", 10, 1, History);

        assertEquals("""
                student 1 (Student of Gryffindor, 1 horcruxes): 90.0 galleons
                student 2 (Student of Slytherin, 1 horcruxes): 180.0 galleons
                student 3 (Student of Ravenclaw, 1 horcruxes): 90.0 galleons
                student 4 (Student of Hufflepuff, 1 horcruxes): 90.0 galleons
                ghost 1 (Ghost of Gryffindor, 1 horcruxes): 80.0 galleons
                ghost 2 (Ghost of Slytherin, 1 horcruxes): 160.0 galleons
                ghost 3 (Ghost of Ravenclaw, 1 horcruxes): 80.0 galleons
                ghost 4 (Ghost of Hufflepuff, 1 horcruxes): 80.0 galleons
                gamekeeper 1 (Gamekeeper, 1 horcruxes): 75.0 galleons
                gamekeeper 2 (Gamekeeper, 1 horcruxes): 75.0 galleons
                caretaker 1 (Caretaker, 1 horcruxes): 65.0 galleons
                caretaker 2 (Caretaker, 1 horcruxes): 65.0 galleons
                teacher transfiguration (Teacher of Transfiguration, 1 horcruxes): 50.0 galleons
                teacher defence (Teacher of Defence, 1 horcruxes): 37.5 galleons
                teacher potions (Teacher of Potions, 1 horcruxes): 50.0 galleons
                teacher herbology (Teacher of Herbology, 1 horcruxes): 50.0 galleons
                teacher history (Teacher of History, 1 horcruxes): 50.0 galleons
                The total reward for Hogwarts School is 1367.5 galleons""", schoolA.printReward());

        assertEquals(schoolA, schoolA);
        assertEquals(schoolA.hashCode(), schoolA.hashCode());
        assertNotEquals(null, schoolA);
    }

    @Test
    void testExceptions() {
        School school = new School();

        assertThrows(IllegalArgumentException.class, () -> school.insertMember(null, "student", "1", 10, 1, Gryffindor));
        assertThrows(IllegalArgumentException.class, () -> school.insertMember(Student, "student", "2", 10, 1, null));
        assertThrows(IllegalArgumentException.class, () -> school.insertMember(Student, "student", "3", 0, 1, Gryffindor));
        assertThrows(IllegalArgumentException.class, () -> school.insertMember(Student, "student", "4", 10, -1, Gryffindor));
        school.insertMember(Student, null, null, 10, 1, Gryffindor);

        assertThrows(IllegalArgumentException.class, () -> school.insertMember(null, "ghost", "1", 10, 1, Gryffindor));
        assertThrows(IllegalArgumentException.class, () -> school.insertMember(Ghost, "ghost", "2", 10, 1, null));
        assertThrows(IllegalArgumentException.class, () -> school.insertMember(Ghost, "ghost", "3", 0, 1, Gryffindor));
        assertThrows(IllegalArgumentException.class, () -> school.insertMember(Ghost, "ghost", "4", 10, -1, Gryffindor));
        school.insertMember(Ghost, null, null, 10, 1, Gryffindor);

        assertThrows(IllegalArgumentException.class, () -> school.insertMember(null, "gamekeeper", "1", 10, 1));
        assertThrows(IllegalArgumentException.class, () -> school.insertMember(Gamekeeper, "gamekeeper", "2", 0, 1));
        assertThrows(IllegalArgumentException.class, () -> school.insertMember(Gamekeeper, "gamekeeper", "3", 10, -1));
        school.insertMember(Gamekeeper, null, null, 10, 1);

        assertThrows(IllegalArgumentException.class, () -> school.insertMember(null, "caretaker", "1", 10, 1));
        assertThrows(IllegalArgumentException.class, () -> school.insertMember(Caretaker, "caretaker", "2", 0, 1));
        assertThrows(IllegalArgumentException.class, () -> school.insertMember(Caretaker, "caretaker", "3", 10, -1));
        school.insertMember(Caretaker, null, null, 10, 1);

        assertThrows(IllegalArgumentException.class, () -> school.insertMember("teacher", "defense", 10, 1, null));
        assertThrows(IllegalArgumentException.class, () -> school.insertMember("teacher", "defense", 0, 1, Defence));
        assertThrows(IllegalArgumentException.class, () -> school.insertMember("teacher", "defense", 0, -1, Defence));
        school.insertMember(null, null, 10, 1, Defence);
    }
}
