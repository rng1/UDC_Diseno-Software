package e1;

public abstract class Members {
    private final String f_name;
    private final String l_name;
    private final int age;
    private final int horcruxes;

    public enum House { Gryffindor, Hufflepuff, Ravenclaw, Slytherin }
    public enum Subject {
        Defence { public int salary() { return 500; } },
        Transfiguration { public int salary() { return 400; } },
        Potions { public int salary() { return 350; } },
        Herbology { public int salary() { return 250; } },
        History { public int salary() { return 200; } };
        public abstract int salary();
    }

    public Members(String f_name, String l_name, int age, int horcruxes) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.age = age;
        this.horcruxes = horcruxes;
    }

    public String getF_name() { return f_name; }
    public String getL_name() { return l_name; }
    public int getAge() { return age; }
    public int getHorcruxes() { return horcruxes; }

    public abstract double getReward();
}
