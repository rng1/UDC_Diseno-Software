package e1;

public class Ghosts extends Members {
    private final House house;

    public Ghosts(String f_name, String l_name, int age, int horcruxes, House house) {
        super(f_name, l_name, age, horcruxes);
        this.house = house;
    }

    public double getReward() {
        double aux = getHorcruxes() * 80.0;
        if(this.house == House.Slytherin) aux *= 2.0;
        return aux;
    }
    House getHouse() { return house; }
}
