package e4;

public class Students extends Participants {
    private final double hours;
    private final double bonus = 1.5;
    private final Faculty teacher;


    protected Students(String name, String surname, Sex sex, Category category, Activity activity, double hours, Faculty teacher) {
        super(name, surname, sex, category, activity);
        this.hours = hours;
        this.teacher = teacher;
    }

    public double getHours() {
        return hours;
    }

    public double getBonus() {
        return bonus;
    }

    public Faculty getTeacher() {
        return teacher;
    }

    public double getCredits(){
        double credits = 0;
        if(hours >= 30)
            return bonus * 2;
        else if(hours >= 15)
            return bonus;
        else
            return bonus * 0;
    }
}
