package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RentalTest {

    private Rental simpleRental;

    @BeforeEach
    void setUp() {
        simpleRental = new Rental();
        simpleRental.newApartment(1000,2,100, 2000, 2);
        simpleRental.newApartment(2000,8,200, 4000, 8);   //x2
        simpleRental.newApartment(500,2,50, 1000, 2);     //x0.5
        simpleRental.newApartment(1000,10,150, 2500, 10);   //n1+
        simpleRental.newApartment(2000,9,250, 4500, 9);   //n2+
        simpleRental.newApartment(500,20,100, 2000, 20);     //n3+
    }

    @Test
    void testBasic() {
        Rental emptyRental = new Rental();
        assertEquals(0, emptyRental.size());
        assertNull(emptyRental.toString());

        assertEquals("""
                Rental:
                -: Apartment [1] of 2000.0 meters square with 2 bathrooms and 2 slots - Base price of 1000.0 and 100.0 per slot. (Max price of 1200.0)
                -: Apartment [2] of 4000.0 meters square with 8 bathrooms and 8 slots - Base price of 2000.0 and 200.0 per slot. (Max price of 3600.0)
                -: Apartment [3] of 1000.0 meters square with 2 bathrooms and 2 slots - Base price of 500.0 and 50.0 per slot. (Max price of 600.0)
                -: Apartment [4] of 2500.0 meters square with 10 bathrooms and 10 slots - Base price of 1000.0 and 150.0 per slot. (Max price of 2500.0)
                -: Apartment [5] of 4500.0 meters square with 9 bathrooms and 9 slots - Base price of 2000.0 and 250.0 per slot. (Max price of 4250.0)
                -: Apartment [6] of 2000.0 meters square with 20 bathrooms and 20 slots - Base price of 500.0 and 100.0 per slot. (Max price of 2500.0)
                """, simpleRental.toString());

        simpleRental.setCriterion(new SortbyBasePrice());
        simpleRental.sortRental();

        assertEquals("""
                Rental:
                -: Apartment [3] of 1000.0 meters square with 2 bathrooms and 2 slots - Base price of 500.0 and 50.0 per slot. (Max price of 600.0)
                -: Apartment [6] of 2000.0 meters square with 20 bathrooms and 20 slots - Base price of 500.0 and 100.0 per slot. (Max price of 2500.0)
                -: Apartment [1] of 2000.0 meters square with 2 bathrooms and 2 slots - Base price of 1000.0 and 100.0 per slot. (Max price of 1200.0)
                -: Apartment [4] of 2500.0 meters square with 10 bathrooms and 10 slots - Base price of 1000.0 and 150.0 per slot. (Max price of 2500.0)
                -: Apartment [2] of 4000.0 meters square with 8 bathrooms and 8 slots - Base price of 2000.0 and 200.0 per slot. (Max price of 3600.0)
                -: Apartment [5] of 4500.0 meters square with 9 bathrooms and 9 slots - Base price of 2000.0 and 250.0 per slot. (Max price of 4250.0)
                """, simpleRental.toString());

        simpleRental.setCriterion(new SortbyTotalPrice());
        simpleRental.sortRental();

        assertEquals("""
                Rental:
                -: Apartment [3] of 1000.0 meters square with 2 bathrooms and 2 slots - Base price of 500.0 and 50.0 per slot. (Max price of 600.0)
                -: Apartment [1] of 2000.0 meters square with 2 bathrooms and 2 slots - Base price of 1000.0 and 100.0 per slot. (Max price of 1200.0)
                -: Apartment [6] of 2000.0 meters square with 20 bathrooms and 20 slots - Base price of 500.0 and 100.0 per slot. (Max price of 2500.0)
                -: Apartment [4] of 2500.0 meters square with 10 bathrooms and 10 slots - Base price of 1000.0 and 150.0 per slot. (Max price of 2500.0)
                -: Apartment [2] of 4000.0 meters square with 8 bathrooms and 8 slots - Base price of 2000.0 and 200.0 per slot. (Max price of 3600.0)
                -: Apartment [5] of 4500.0 meters square with 9 bathrooms and 9 slots - Base price of 2000.0 and 250.0 per slot. (Max price of 4250.0)
                """, simpleRental.toString());

        simpleRental.setCriterion(new SortbyBaths());
        simpleRental.sortRental();

        assertEquals("""
                Rental:
                -: Apartment [3] of 1000.0 meters square with 2 bathrooms and 2 slots - Base price of 500.0 and 50.0 per slot. (Max price of 600.0)
                -: Apartment [1] of 2000.0 meters square with 2 bathrooms and 2 slots - Base price of 1000.0 and 100.0 per slot. (Max price of 1200.0)
                -: Apartment [2] of 4000.0 meters square with 8 bathrooms and 8 slots - Base price of 2000.0 and 200.0 per slot. (Max price of 3600.0)
                -: Apartment [5] of 4500.0 meters square with 9 bathrooms and 9 slots - Base price of 2000.0 and 250.0 per slot. (Max price of 4250.0)
                -: Apartment [4] of 2500.0 meters square with 10 bathrooms and 10 slots - Base price of 1000.0 and 150.0 per slot. (Max price of 2500.0)
                -: Apartment [6] of 2000.0 meters square with 20 bathrooms and 20 slots - Base price of 500.0 and 100.0 per slot. (Max price of 2500.0)
                """, simpleRental.toString());

        simpleRental.setCriterion(new SortbySize());
        simpleRental.sortRental();

        assertEquals("""
                Rental:
                -: Apartment [3] of 1000.0 meters square with 2 bathrooms and 2 slots - Base price of 500.0 and 50.0 per slot. (Max price of 600.0)
                -: Apartment [1] of 2000.0 meters square with 2 bathrooms and 2 slots - Base price of 1000.0 and 100.0 per slot. (Max price of 1200.0)
                -: Apartment [6] of 2000.0 meters square with 20 bathrooms and 20 slots - Base price of 500.0 and 100.0 per slot. (Max price of 2500.0)
                -: Apartment [4] of 2500.0 meters square with 10 bathrooms and 10 slots - Base price of 1000.0 and 150.0 per slot. (Max price of 2500.0)
                -: Apartment [2] of 4000.0 meters square with 8 bathrooms and 8 slots - Base price of 2000.0 and 200.0 per slot. (Max price of 3600.0)
                -: Apartment [5] of 4500.0 meters square with 9 bathrooms and 9 slots - Base price of 2000.0 and 250.0 per slot. (Max price of 4250.0)
                """, simpleRental.toString());

        simpleRental.setCriterion();
        simpleRental.sortRental();

        assertEquals("""
                Rental:
                -: Apartment [1] of 2000.0 meters square with 2 bathrooms and 2 slots - Base price of 1000.0 and 100.0 per slot. (Max price of 1200.0)
                -: Apartment [2] of 4000.0 meters square with 8 bathrooms and 8 slots - Base price of 2000.0 and 200.0 per slot. (Max price of 3600.0)
                -: Apartment [3] of 1000.0 meters square with 2 bathrooms and 2 slots - Base price of 500.0 and 50.0 per slot. (Max price of 600.0)
                -: Apartment [4] of 2500.0 meters square with 10 bathrooms and 10 slots - Base price of 1000.0 and 150.0 per slot. (Max price of 2500.0)
                -: Apartment [5] of 4500.0 meters square with 9 bathrooms and 9 slots - Base price of 2000.0 and 250.0 per slot. (Max price of 4250.0)
                -: Apartment [6] of 2000.0 meters square with 20 bathrooms and 20 slots - Base price of 500.0 and 100.0 per slot. (Max price of 2500.0)
                """, simpleRental.toString());
    }

    @Test
    void testExceptions() {
        Rental rental = new Rental();
        rental.newApartment(1000,4,100, 2000, 4);
        assertThrows(IllegalArgumentException.class, () -> rental.newApartment(-1,4,100, 2000, 4));
        assertThrows(IllegalArgumentException.class, () -> rental.newApartment(1000,-1,100, 2000, 4));
        assertThrows(IllegalArgumentException.class, () -> rental.newApartment(1000,4,-1, 2000, 4));
        assertThrows(IllegalArgumentException.class, () -> rental.newApartment(1000,4,100, -1, 4));
        assertThrows(IllegalArgumentException.class, () -> rental.newApartment(1000,4,100, 2000, -1));
    }
}
