package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Rental {
    public ArrayList<Apartments> vector;
    private Comparator<Apartments> criterion;

    public Rental() {
        vector = new ArrayList<>();
        criterion = null;
    }

    public void newApartment(double bP, int slots, double pP, double size, int b) {
        if(bP < 0 || slots < 0 || pP < 0 || size < 0 || b < 0)
            throw new IllegalArgumentException();
        int ref = vector.size() + 1;
        vector.add(new Apartments(ref, bP, slots, pP, size, b));
    }

    public void setCriterion() { this.criterion = null; }

    public void setCriterion(Comparator<Apartments> criterion) { this.criterion = criterion; }

    public void sortRental() {
            Collections.sort(vector, criterion); //TODO: ASK IF WE CAN NOT USE THIS
    }

    @Override
    public String toString() {
        if(!vector.isEmpty()) {
            StringBuilder string = new StringBuilder("Rental:\n");
            Apartments a;
            for (Apartments apartments : vector) {
                a = apartments;
                string.append("-: Apartment [").append(a.reference()).append("] of ").append(a.size()).append(" meters square with ").append(a.baths()).append(" bathrooms and ").append(a.slots())
                        .append(" slots - Base price of ").append(a.bPrice()).append(" and ").append(a.pPrice()).append(" per slot. (Max price of ").append(a.tPrice()).append(")\n");
            }
            return string.toString();
        }
        else
            return null;
    }

    public int size() { return vector.size(); }
}
