package e2;

import java.util.Comparator;

public class SortbyBasePrice implements Comparator<Apartments> {

    @Override
    public int compare(Apartments o1, Apartments o2) {
        if(o1.bPrice() != o2.bPrice())
            return o1.bPrice() > o2.bPrice() ? 1:(-1);
        else
            return 0;
    }
}
