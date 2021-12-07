package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static e1.TicketManager.Comparator.LESS;
import static e1.TicketManager.Operator.AND;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TicketManagerTest {
    private final TicketManager manager = new TicketManager();

    @BeforeEach
    void setUp() {
        //ALL TICKETS (07/12/2021)
        manager.fullList.add(new Ticket("Coruña", "Vigo", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Coruña", "Vigo", 12.70, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Coruña", "Vigo", 18.70, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Coruña", "Vigo", 14.95, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Coruña", "Santiago", 6.30, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Coruña", "Santiago", 7.60, LocalDate.of( 2021 , 12 , 7 )));

        manager.fullList.add(new Ticket("Vigo", "Ourense", 12.90, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Vigo", "Ourense", 7.20, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Vigo", "Santiago", 9.55, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Vigo", "Santiago", 11.50, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Vigo", "Coruña", 18.70, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 7 )));

        manager.fullList.add(new Ticket("Santiago", "Coruña", 6.30, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Santiago", "Coruña", 7.60, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Santiago", "Vigo", 9.55, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Santiago", "Vigo", 11.50, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Santiago", "Ourense", 10.35, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Santiago", "Ourense", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Santiago", "Ourense", 17.70, LocalDate.of( 2021 , 12 , 7 )));

        manager.fullList.add(new Ticket("Ourense", "Santiago", 10.35, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Ourense", "Santiago", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Ourense", "Santiago", 17.70, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Ourense", "Vigo", 12.90, LocalDate.of( 2021 , 12 , 7 )));
        manager.fullList.add(new Ticket("Ourense", "Vigo", 7.20, LocalDate.of( 2021 , 12 , 7 )));

        //ALL TICKETS (08/12/2021)
        manager.fullList.add(new Ticket("Coruña", "Vigo", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Coruña", "Vigo", 12.70, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Coruña", "Vigo", 18.70, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Coruña", "Vigo", 14.95, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Coruña", "Santiago", 6.30, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Coruña", "Santiago", 7.60, LocalDate.of( 2021 , 12 , 8 )));

        manager.fullList.add(new Ticket("Vigo", "Ourense", 12.90, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Vigo", "Ourense", 7.20, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Vigo", "Santiago", 9.55, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Vigo", "Santiago", 11.50, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Vigo", "Coruña", 18.70, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 8 )));

        manager.fullList.add(new Ticket("Santiago", "Coruña", 6.30, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Santiago", "Coruña", 7.60, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Santiago", "Vigo", 9.55, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Santiago", "Vigo", 11.50, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Santiago", "Ourense", 10.35, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Santiago", "Ourense", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Santiago", "Ourense", 17.70, LocalDate.of( 2021 , 12 , 8 )));

        manager.fullList.add(new Ticket("Ourense", "Santiago", 10.35, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Ourense", "Santiago", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Ourense", "Santiago", 17.70, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Ourense", "Vigo", 12.90, LocalDate.of( 2021 , 12 , 8 )));
        manager.fullList.add(new Ticket("Ourense", "Vigo", 7.20, LocalDate.of( 2021 , 12 , 8 )));

        //ALL TICKETS (09/12/2021)
        manager.fullList.add(new Ticket("Coruña", "Vigo", 15.85, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Coruña", "Vigo", 12.70, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Coruña", "Vigo", 18.70, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Coruña", "Vigo", 14.95, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Coruña", "Santiago", 6.30, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Coruña", "Santiago", 7.60, LocalDate.of( 2021 , 12 , 9 )));

        manager.fullList.add(new Ticket("Vigo", "Ourense", 12.90, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Vigo", "Ourense", 7.20, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Vigo", "Santiago", 9.55, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Vigo", "Santiago", 11.50, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Vigo", "Coruña", 18.70, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 9 )));

        manager.fullList.add(new Ticket("Santiago", "Coruña", 6.30, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Santiago", "Coruña", 7.60, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Santiago", "Vigo", 9.55, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Santiago", "Vigo", 11.50, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Santiago", "Ourense", 10.35, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Santiago", "Ourense", 15.85, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Santiago", "Ourense", 17.70, LocalDate.of( 2021 , 12 , 9 )));

        manager.fullList.add(new Ticket("Ourense", "Santiago", 10.35, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Ourense", "Santiago", 15.85, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Ourense", "Santiago", 17.70, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Ourense", "Vigo", 12.90, LocalDate.of( 2021 , 12 , 9 )));
        manager.fullList.add(new Ticket("Ourense", "Vigo", 7.20, LocalDate.of( 2021 , 12 , 9 )));
    }

    @Test
    void basicTest() {
        //null
        List<Ticket> tempList = new ArrayList<>();
        assertEquals(0, manager.finalList.size());
        assertEquals(tempList, manager.finalList);

        //origin=Vigo
        tempList.add(new Ticket("Vigo", "Ourense", 12.90, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Ourense", 7.20, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Santiago", 9.55, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Santiago", 11.50, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 18.70, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Ourense", 12.90, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Ourense", 7.20, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Santiago", 9.55, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Santiago", 11.50, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Coruña", 18.70, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Ourense", 12.90, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Vigo", "Ourense", 7.20, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Vigo", "Santiago", 9.55, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Vigo", "Santiago", 11.50, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Vigo", "Coruña", 18.70, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 9 )));

        manager.searchTickets(new Origin("Vigo"));
        assertEquals(manager.finalList, tempList);

        //origin=Vigo AND destination=Coruña
        tempList = new ArrayList<>();
        tempList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 18.70, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Coruña", 18.70, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Vigo", "Coruña", 18.70, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 9 )));


        manager.searchTickets(AND, new Destination("Coruña"));
        assertEquals(manager.finalList, tempList);

        //origin=Vigo AND destination=Coruña AND date=2021-12-07
        tempList = new ArrayList<>();
        tempList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 18.70, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 7 )));

        manager.searchTickets(AND, new Date(LocalDate.of( 2021 , 12 , 7 )));
        assertEquals(manager.finalList, tempList);

        //origin=Vigo AND destination=Coruña AND date=2021-12-07 AND price<16.00
        tempList = new ArrayList<>();
        tempList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 7 )));

        manager.searchTickets(AND, LESS, new Price(16));
        assertEquals(manager.finalList, tempList);

        //origin=Vigo AND destination=Coruña AND date=2021-12-07 AND price<16.00 AND origin=Coruña
        tempList = new ArrayList<>();

        manager.searchTickets(AND, new Origin("Coruña"));
        assertEquals(manager.finalList, tempList);
    }
}
