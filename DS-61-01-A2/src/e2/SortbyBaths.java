package e2;

import java.util.Comparator;

public class SortbyBaths implements Comparator<Apartments> {

    @Override
    public int compare(Apartments o1, Apartments o2) {
        if (o1 == null || o2 == null)
            throw new NullPointerException();

        if(o1.baths() != o2.baths())
            return o1.baths() > o2.baths() ? 1:(-1);
        else
            return 0;
    }
}
