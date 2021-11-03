package e1;

import java.util.ArrayList;

public class School {

    private final ArrayList<Members> register;

    public School() { register = new ArrayList<>(); }

    public void insertMember(Residents.Category category, String name, String surname, int age, int horcruxes, Residents.House house) {
        register.add(new Residents(name, surname, age, horcruxes, category, house));
    }

    public void insertMember(Staff.Category category, String name, String surname, int age, int horcruxes) {
        register.add(new Staff(name, surname, age, horcruxes, category));
    }

    public void insertMember(Teachers.Subject subject, String name, String surname, int age, int horcruxes) {
        register.add(new Teachers(name, surname, age, horcruxes, subject));
    }

    public String extractReward(Members member) {
        String name = member.getF_name();
        String surname = member.getL_name();
        int horcruxes = member.getHorcruxes();
        int age = member.getAge();
        String str;
        if (member instanceof Residents) {
            Residents.Category category = ((Residents) member).getCategory();
            Residents.House house = ((Residents) member).getHouse();
            double reward = member.getReward();
            str = name + " " + surname + " (" + category + " of " + house + ", " + horcruxes + " horcruxes): "
                    + reward + " galleons";
            return str;
        }
        else if (member instanceof Staff) {
            Staff.Category category = ((Staff) member).getCategory();
            double reward = member.getReward();
            str = name + " " + surname + " (" + category + ", " + horcruxes + " horcruxes): "
                    + reward + " galleons";
            return str;
        }
        else if (member instanceof Teachers) {
            Teachers.Subject subject = ((Teachers) member).getSubject();
            double reward = member.getReward();
            str = name + " " + surname + " (Teacher of " + subject + ", " + horcruxes + " horcruxes): "
                    + reward + " galleons";
            return str;
        }
        throw new IllegalArgumentException();
    }

    public double totalReward(){
        double total = 0.0;
        for (Members members : register) {
            if (members instanceof Residents)
                total = total + members.getReward();
            else if (members instanceof Staff)
                total = total + members.getReward();
            else if (members instanceof Teachers)
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
            if (members instanceof Staff)
                total = total + ((Staff) members).getSalary();
            else if (members instanceof Teachers)
                total = total + ((Teachers) members).getSalary();
        }
        return total;
    }

    public String extractSalary(Members member) {
        String name = member.getF_name();
        String surname = member.getL_name();
        int age = member.getAge();
        String str;
        if (member instanceof Residents) {
            return null;
        }
        else if (member instanceof Staff) {
            Staff.Category category = ((Staff) member).getCategory();
            int salary = ((Staff) member).getSalary();
            str = name + " " + surname + " (" + category + "): "
                    + salary + " galleons";
            return str;
        }
        else if (member instanceof Teachers) {
            Teachers.Subject subject = ((Teachers) member).getSubject();
            int salary = ((Teachers) member).getSalary();
            str = name + " " + surname + " (Teacher of " + subject + "): "
                    + salary + " galleons";
            return str;
        }
        throw new IllegalArgumentException();
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


