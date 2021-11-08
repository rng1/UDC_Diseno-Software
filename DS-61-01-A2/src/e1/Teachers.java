package e1;

public class Teachers extends Members {
    private final Subject subject;

    public Teachers(String f_name, String l_name, int age, int horcruxes, Subject subject) {
        super(f_name, l_name, age, horcruxes);
        this.subject = subject;
    }

    public double getReward() {
        double bonus = 50.0;
        double aux = getHorcruxes()* bonus;
        if (this.subject == Subject.Defence) aux *= 0.75;
        return aux;
    }
    int getSalary() { return this.getSubject().salary();}
    Subject getSubject() { return subject; }
}

