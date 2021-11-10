package e4;

public class Faculty extends Participants {
    private final String department;
    private final double hours;
    private final double bonus = 0.2;


    protected Faculty(String name, String surname, Sex sex, Category category, Activity activity, String department, double hours) {
        super(name, surname, sex, category, activity);
        this.department = department;
        this.hours = hours;
    }

    public String getDepartment() {
        return department;
    }

    public double getHours() {
        return hours;
    }

    public double getBonus() {
        return bonus;
    }

    public double getFreeHours() {
        if(hours >= 30)
            return hours * bonus;
        else
            return 0 * bonus;
    }
}
