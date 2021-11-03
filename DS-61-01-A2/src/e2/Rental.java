package e2;

import java.util.ArrayList;
import java.util.Collections;

public class Rental {
    public ArrayList<Apartments> vector;
    private enum Criterion {base, total, size, bath}

    private Criterion criterion;

    public Rental() {
        vector = new ArrayList<>();
        criterion = null;
    }

    public void newApartment(int ref, double bP, int slots, double pP, double size, int b) {
        vector.add(new Apartments(ref, bP, slots, pP, size, b));
    }

    public void changeCriterion() { this.criterion = null; }

    public void changeCriterion(Criterion criterion) { this.criterion = criterion; }

    public void sortRental() {
        if(criterion == null)
            Collections.sort(vector);
        else
            switch(criterion) {
                case base -> vector.sort(new SortbyBasePrice());
                case total -> vector.sort(new SortbyTotalPrice());
                case size -> vector.sort(new SortbySize());
                case bath -> vector.sort(new SortbyBaths());
            }
    }
}
