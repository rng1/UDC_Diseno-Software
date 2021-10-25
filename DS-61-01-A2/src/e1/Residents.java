package e1;

public class Residents extends Members {
    public Residents(String f_name, String l_name, int age, int horcruxes) {
        super(f_name, l_name, age, horcruxes);
    }

    public enum House { Gryffindor, Hufflepuff, Ravenclaw, Slytherin }
    public enum Category {
        Student { public int calculate(int n) { return (n * 90); } },
        Ghost { public int calculate(int n) { return (n * 80); } };

        public abstract int calculate(int n);
    }

    private Category category;
    private House house;
    private int reward;

    public Residents(String f_name, String l_name, int age, int horcruxes, Category category, House house) {
        super(f_name, l_name, age, horcruxes);
        this.category = category;
        this.house = house;
        this.reward = this.getReward();
    }

    int getReward() {
        int aux = this.getCategory().calculate(getHorcruxes());
        if(this.house == House.Slytherin) aux *= 2;
        return aux;
    }
    Residents.Category getCategory() { return category; }
    House getHouse() { return house; }
}
