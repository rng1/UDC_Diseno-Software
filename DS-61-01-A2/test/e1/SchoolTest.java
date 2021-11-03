package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static e1.Residents.Category.Ghost;
import static e1.Residents.Category.Student;
import static e1.Residents.House.Gryffindor;
import static e1.Residents.House.Slytherin;
import static e1.Staff.Category.Caretaker;
import static e1.Staff.Category.Gamekeeper;
import static e1.Teachers.Subject.Defence;
import static e1.Teachers.Subject.Transfiguration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchoolTest {

    private School school;

    @BeforeEach
    void setUp() {
        school = new School();
        school.insertMember(Student, "Hermione", "Granger", 12, 3, Gryffindor);
        school.insertMember(Ghost, "Bloody", "Baron", 107, 1, Slytherin);
        school.insertMember(Gamekeeper, "Rubeus", "Hagrid", 56, 2);
        school.insertMember(Transfiguration,"Minerva", "McGonagall", 71, 1);
        school.insertMember(Defence, "Severus", "Snape", 49, 2);
        school.insertMember(Caretaker, "Argus", "Filch", 34, 0);
    }
    @Test
    void testBasicSchool() {
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
}
