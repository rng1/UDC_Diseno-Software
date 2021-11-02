package e1;

public class Residents extends Members {
    public Residents(String f_name, String l_name, int age, int horcruxes) {
        super(f_name, l_name, age, horcruxes);
    }

    public enum House { Gryffindor, Hufflepuff, Ravenclaw, Slytherin }
    public enum Category {
        Student { public double calculate(double n) { return (n * 90.0); } },
        Ghost { public double calculate(double n) { return (n * 80.0); } };

        public abstract double calculate(double n);
    }

    private Category category;
    private House house;

    public Residents(String f_name, String l_name, int age, int horcruxes, Category category, House house) {
        super(f_name, l_name, age, horcruxes);
        this.category = category;
        this.house = house;
        double reward = this.getReward();
    }

    double getReward() {
        double aux = this.getCategory().calculate(getHorcruxes());
        if(this.house == House.Slytherin) aux *= 2.0;
        return aux;
    }
    Residents.Category getCategory() { return category; }
    House getHouse() { return house; }
}
