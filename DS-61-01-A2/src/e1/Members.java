package e1;

public class Members {
    private String f_name;
    private String l_name;
    private int age;
    private int horcruxes;
    private int reward;

    public void setF_name(String s){ f_name = s; }

    public void setHorcruxes(int n) { horcruxes = n; }
    public int getHorcruxes() { return horcruxes; }
    public void addHorcruxes() { horcruxes += 1; }

}
