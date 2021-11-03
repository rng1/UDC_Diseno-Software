package e2;

public record Apartments(int reference, double bPrice, int slots, double pPrice, double size,
                         int baths) implements Comparable<Apartments> {

    public double tPrice() {
        return bPrice + (slots * pPrice);
    }

    @Override
    public int compareTo(Apartments o) {
        if (o == null)
            throw new NullPointerException();
        if (this == o)
            return 0;

        if (this.reference != o.reference)
            return this.reference > o.reference ? 1 : (-1);
        else
            return 0;
    }
}
