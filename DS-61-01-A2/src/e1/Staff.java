package e1;

public class Staff extends Members{
    public enum Category {
        Caretaker {     public double calculate(double n) { return (n * 65.0); }
                        public int salary() { return 150; } },
        Gamekeeper {    public double calculate(double n) { return (n * 75.0); }
                        public int salary() { return 170; } };
        //Teacher { public int calculate(int n) { return (n * 90); } };
        public abstract double calculate(double n);
        public abstract int salary();
    }

    private final Category category;

    public Staff(String f_name, String l_name, int age, int horcruxes, Category category) {
        super(f_name, l_name, age, horcruxes);
        this.category = category;
        double reward = this.getReward();
        int salary = this.getSalary();
    }

    double getReward() { return (getCategory().calculate(getHorcruxes())); }
    int getSalary() {return (getCategory().salary() + 10);}
    Staff.Category getCategory() { return category; }
}
