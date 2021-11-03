package e1;

public class Teachers extends Members{

    public enum Subject {
        Defence { public int salary() { return 500; } },
        Transfiguration { public int salary() { return 400; } },
        Potions { public int salary() { return 350; } },
        Herbology { public int salary() { return 250; } },
        History { public int salary() { return 200; } };
        public abstract int salary();
    }

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

