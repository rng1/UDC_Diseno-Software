package e1;

public class Students extends Members {
    private final House house;

    public Students(String f_name, String l_name, int age, int horcruxes, Students.House house) {
        super(f_name, l_name, age, horcruxes);
        this.house = house;
    }

    public double getReward() {
        double aux = getHorcruxes() * 90.0;
        if(this.house == House.Slytherin) aux *= 2.0;
        return aux;
    }
    House getHouse() { return house; }
}
