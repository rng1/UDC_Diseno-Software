package e1;

import java.util.ArrayList;

public class School {

    public ArrayList<Members> register;
    public enum Category { Student, Ghost, Caretaker, Gamekeeper}

    public int size ()
    {
        return register.size();
    }

    public School() { register = new ArrayList<>(); }

    public void insertMember(Category category, String name, String surname, int age, int horcruxes, Members.House house) {
        if(category == null || house == null | horcruxes < 0 | age < 1) throw new IllegalArgumentException();
        if(name == null) name = "";
        if(surname == null) surname = "";
        switch(category) {
            case Ghost -> register.add(new Ghosts(name, surname, age, horcruxes, house));
            case Student -> register.add(new Students(name, surname, age, horcruxes, house));

        }
    }

    public void insertMember(Category category, String name, String surname, int age, int horcruxes) {
        if(category == null | horcruxes < 0 | age < 1) throw new IllegalArgumentException();
        if(name == null) name = "";
        if(surname == null) surname = "";
        switch(category) {
            case Caretaker -> register.add(new Caretakers(name, surname, age, horcruxes));
            case Gamekeeper -> register.add(new Gamekeepers(name, surname, age, horcruxes));

        }
    }

    public void insertMember(String name, String surname, int age, int horcruxes, Teachers.Subject subject) {
        if(subject == null | horcruxes < 0 | age < 1) throw new IllegalArgumentException();
        if(name == null) name = "";
        if(surname == null) surname = "";
        register.add(new Teachers(name, surname, age, horcruxes, subject));
    }

    public String extractReward(Members member) {
        String name = member.getF_name();
        String surname = member.getL_name();
        int horcruxes = member.getHorcruxes();
        int age = member.getAge();
        String str;
        if (member instanceof Students) {
            Members.House house = ((Students) member).getHouse();
            double reward = member.getReward();
            str = name + " " + surname + " (Student of " + house + ", " + horcruxes + " horcruxes): "
                    + reward + " galleons";
        }
        else if (member instanceof Ghosts) {
            Members.House house = ((Ghosts) member).getHouse();
            double reward = member.getReward();
            str = name + " " + surname + " (Ghost of " + house + ", " + horcruxes + " horcruxes): "
                    + reward + " galleons";
        }
        else if (member instanceof Caretakers) {
            double reward = member.getReward();
            str = name + " " + surname + " (Caretaker, " + horcruxes + " horcruxes): "
                    + reward + " galleons";
        }
        else if (member instanceof Gamekeepers) {
            double reward = member.getReward();
            str = name + " " + surname + " (Gamekeeper, " + horcruxes + " horcruxes): "
                    + reward + " galleons";
        }
        else {
            Teachers.Subject subject = ((Teachers) member).getSubject();
            double reward = member.getReward();
            str = name + " " + surname + " (Teacher of " + subject + ", " + horcruxes + " horcruxes): "
                    + reward + " galleons";
        }
        return str;
    }

    public double totalReward(){
        double total = 0.0;
        for (Members members : register) {
                total = total + members.getReward();
        }
        return total;
    }

    public String printReward(){
        StringBuilder string = new StringBuilder();
        for (Members members : register) {
            //System.out.println(extractReward(members));
            string.append(extractReward(members)).append("\n");
        }
        //System.out.println("The total reward for Hogwarts School is " + totalReward() + " galleons");
        string.append("The total reward for Hogwarts School is ").append(totalReward()).append(" galleons");
        return String.valueOf(string);
    }

    public int totalSalary(){
        int total = 0;
        for (Members members : register) {
            if (!(members instanceof Students) && !(members instanceof Ghosts)) {
            if (members instanceof Caretakers)
                total = total + ((Caretakers) members).getSalary();
            else if (members instanceof Gamekeepers)
                total = total + ((Gamekeepers) members).getSalary();
            else
                total = total + ((Teachers) members).getSalary();
            }
        }
        return total;
    }

    public String extractSalary(Members member) {
        String name = member.getF_name();
        String surname = member.getL_name();
        int age = member.getAge();
        String str;
        if (member instanceof Students || member instanceof Ghosts) {
            return null;
        }
        else if (member instanceof Caretakers) {
            int salary = ((Caretakers) member).getSalary();
            str = name + " " + surname + " (Caretaker): "
                    + salary + " galleons";
        }
        else if (member instanceof Gamekeepers) {
            int salary = ((Gamekeepers) member).getSalary();
            str = name + " " + surname + " (Gamekeeper): "
                    + salary + " galleons";
        }
        else {
            Teachers.Subject subject = ((Teachers) member).getSubject();
            int salary = ((Teachers) member).getSalary();
            str = name + " " + surname + " (Teacher of " + subject + "): "
                    + salary + " galleons";
        }
        return str;
    }

    public String printSalary(){
        StringBuilder string = new StringBuilder();
        for (Members members : register) {
            String str = extractSalary(members);
            if (str != null) //System.out.println(str);
                string.append(str).append("\n");
        }
        //System.out.println("The total payroll for Hogwarts School is " + totalSalary() + " galleons");
        string.append("The total payroll for Hogwarts School is ").append(totalSalary()).append(" galleons");
        return String.valueOf(string);
    }
}


