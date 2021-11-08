package e1;

public class Gamekeepers extends Members{

    public Gamekeepers(String f_name, String l_name, int age, int horcruxes) {
        super(f_name, l_name, age, horcruxes);
    }

    public double getReward() { return getHorcruxes() * 75.0; }
    int getSalary() { return 170 + 10; }
}
