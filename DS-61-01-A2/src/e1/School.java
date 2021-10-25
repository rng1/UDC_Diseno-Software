package e1;

import java.util.ArrayList;

import static e1.Residents.Category.*;
import static e1.Staff.Category.*;

public class School {

    private ArrayList<Members> register;

    void insertStudent(String name, String surname, int age, int horcruxes, Residents.House house) {
        register.add(new Residents(name, surname, age, horcruxes, Student, house));
    }

    void insertGhost(String name, String surname, int age, int horcruxes, Residents.House house) {
        register.add(new Residents(name, surname, age, horcruxes, Ghost, house));
    }

    void insertGamekeeper(String name, String surname, int age, int horcruxes) {
        register.add(new Staff(name, surname, age, horcruxes, Gamekeeper));
    }

    void insertCaretaker(String name, String surname, int age, int horcruxes) {
        register.add(new Staff(name, surname, age, horcruxes, Caretaker));
    }

    void insertTeacher(String name, String surname, int age, int horcruxes, Teachers.Subject subject) {
        register.add(new Teachers(name, surname, age, horcruxes, subject));
    }
}


