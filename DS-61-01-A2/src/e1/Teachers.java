package e1;

public class Teachers extends Members{
    private final int bonus = 90;

    public Teachers(String f_name, String l_name, int age, int horcruxes) {
        super(f_name, l_name, age, horcruxes);
    }

    public enum Subject {
        Defense { public int salary() { return 500; } },
        Transfiguration { public int salary() { return 400; } },
        Potions { public int salary() { return 350; } },
        Herbology { public int salary() { return 250; } },
        History { public int salary() { return 200; } };
        public abstract int salary();
    }

    private Subject subject;
    private int reward;
    private int salary;

    public Teachers(String f_name, String l_name, int age, int horcruxes, Subject subject) {
        super(f_name, l_name, age, horcruxes);
        this.subject = subject;
        this.reward = this.getReward();
        this.salary = this.getSalary();
    }

    int getReward() {
        int aux = getHorcruxes()*bonus;
        if (this.subject == Subject.Defense) aux *= 0.75;
        return aux;
    }
    int getSalary() { return this.getSubject().salary();}
    Subject getSubject() { return subject; }
}

