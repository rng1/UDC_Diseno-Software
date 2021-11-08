package e2;

import java.util.Comparator;

public class SortbyTotalPrice implements Comparator<Apartments> {

    @Override
    public int compare(Apartments o1, Apartments o2) {
        if (o1 == null || o2 == null)
            throw new NullPointerException();

        if(o1.tPrice() != o2.tPrice())
            return o1.tPrice() > o2.tPrice() ? 1:(-1);
        else
            return 0;
    }
}
