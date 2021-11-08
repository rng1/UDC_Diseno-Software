package e1;

public class Caretakers extends Members{

    public Caretakers(String f_name, String l_name, int age, int horcruxes) { super(f_name, l_name, age, horcruxes); }

    public double getReward() { return getHorcruxes() * 65.0; }
    int getSalary() { return 150 + 10; }
}
