package e2;

import java.util.Comparator;

public class SortbySize implements Comparator<Apartments> {

    @Override
    public int compare(Apartments o1, Apartments o2) {
        if (o1 == null || o2 == null)
            throw new NullPointerException();

        if(o1.size() != o2.size())
            return o1.size() > o2.size() ? 1:(-1);
        else
            return 0;
    }
}
