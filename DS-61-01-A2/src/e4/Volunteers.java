package e4;

public abstract class Volunteers {
    protected Volunteers(String name, String surname, Sex sex, Category category, Activity activity) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.category = category;
        this.activity = activity;
    }

    enum Sex {Male, Female, Other}
    enum Category {Student, Faculty, Junior}
    enum Activity { Editathon, Workshop}

    private final String name;
    private final String surname;
    private final Sex sex;
    private final Category category;
    private final Activity activity;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Sex getSex() {
        return sex;
    }

    public Category getCategory() {
        return category;
    }

    public Activity getActivity() {
        return activity;
    }
}
