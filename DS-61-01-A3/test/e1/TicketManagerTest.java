package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static e1.TicketSearch.Operator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketManagerTest {
    SearchEngine manager;
    TicketSearch parameter;
    List<Ticket> originalList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        //ALL TICKETS (07/12/2021)
        originalList.add(new Ticket("Coruña", "Vigo", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Coruña", "Vigo", 12.70, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Coruña", "Vigo", 18.70, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Coruña", "Vigo", 14.95, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Coruña", "Santiago", 6.30, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Coruña", "Santiago", 7.60, LocalDate.of( 2021 , 12 , 7 )));

        originalList.add(new Ticket("Vigo", "Ourense", 12.90, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Vigo", "Ourense", 7.20, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Vigo", "Santiago", 9.55, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Vigo", "Santiago", 11.50, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Vigo", "Coruña", 18.70, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 7 )));

        originalList.add(new Ticket("Santiago", "Coruña", 6.30, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Santiago", "Coruña", 7.60, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Santiago", "Vigo", 9.55, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Santiago", "Vigo", 11.50, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Santiago", "Ourense", 10.35, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Santiago", "Ourense", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Santiago", "Ourense", 17.70, LocalDate.of( 2021 , 12 , 7 )));

        originalList.add(new Ticket("Ourense", "Santiago", 10.35, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Ourense", "Santiago", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Ourense", "Santiago", 17.70, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Ourense", "Vigo", 12.90, LocalDate.of( 2021 , 12 , 7 )));
        originalList.add(new Ticket("Ourense", "Vigo", 7.20, LocalDate.of( 2021 , 12 , 7 )));

        //ALL TICKETS (08/12/2021)
        originalList.add(new Ticket("Coruña", "Vigo", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Coruña", "Vigo", 12.70, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Coruña", "Vigo", 18.70, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Coruña", "Vigo", 14.95, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Coruña", "Santiago", 6.30, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Coruña", "Santiago", 7.60, LocalDate.of( 2021 , 12 , 8 )));

        originalList.add(new Ticket("Vigo", "Ourense", 12.90, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Vigo", "Ourense", 7.20, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Vigo", "Santiago", 9.55, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Vigo", "Santiago", 11.50, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Vigo", "Coruña", 18.70, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 8 )));

        originalList.add(new Ticket("Santiago", "Coruña", 6.30, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Santiago", "Coruña", 7.60, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Santiago", "Vigo", 9.55, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Santiago", "Vigo", 11.50, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Santiago", "Ourense", 10.35, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Santiago", "Ourense", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Santiago", "Ourense", 17.70, LocalDate.of( 2021 , 12 , 8 )));

        originalList.add(new Ticket("Ourense", "Santiago", 10.35, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Ourense", "Santiago", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Ourense", "Santiago", 17.70, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Ourense", "Vigo", 12.90, LocalDate.of( 2021 , 12 , 8 )));
        originalList.add(new Ticket("Ourense", "Vigo", 7.20, LocalDate.of( 2021 , 12 , 8 )));

        //ALL TICKETS (09/12/2021)
        originalList.add(new Ticket("Coruña", "Vigo", 15.85, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Coruña", "Vigo", 12.70, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Coruña", "Vigo", 18.70, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Coruña", "Vigo", 14.95, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Coruña", "Santiago", 6.30, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Coruña", "Santiago", 7.60, LocalDate.of( 2021 , 12 , 9 )));

        originalList.add(new Ticket("Vigo", "Ourense", 12.90, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Vigo", "Ourense", 7.20, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Vigo", "Santiago", 9.55, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Vigo", "Santiago", 11.50, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Vigo", "Coruña", 18.70, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 9 )));

        originalList.add(new Ticket("Santiago", "Coruña", 6.30, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Santiago", "Coruña", 7.60, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Santiago", "Vigo", 9.55, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Santiago", "Vigo", 11.50, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Santiago", "Ourense", 10.35, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Santiago", "Ourense", 15.85, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Santiago", "Ourense", 17.70, LocalDate.of( 2021 , 12 , 9 )));

        originalList.add(new Ticket("Ourense", "Santiago", 10.35, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Ourense", "Santiago", 15.85, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Ourense", "Santiago", 17.70, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Ourense", "Vigo", 12.90, LocalDate.of( 2021 , 12 , 9 )));
        originalList.add(new Ticket("Ourense", "Vigo", 7.20, LocalDate.of( 2021 , 12 , 9 )));
    }

    @Test
    void basicTest() {
        //null
        manager = new SearchEngine();
        List<Ticket> tempList = new ArrayList<>();
        assertEquals(0, manager.searchTicket(originalList).size());
        assertEquals(tempList, manager.searchTicket(originalList));

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

        parameter = new Origin("Vigo");
        manager = new SearchEngine(parameter);
        assertEquals(tempList, manager.searchTicket(originalList));

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

        parameter = new Destination("Coruña");
        manager.AND(parameter);
        assertEquals(manager.searchTicket(originalList), tempList);

        //origin=Vigo AND destination=Coruña AND date=2021-12-07
        tempList = new ArrayList<>();
        tempList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 18.70, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 7 )));

        parameter = new Date(LocalDate.of(2021, 12, 7), E);
        manager.AND(parameter);
        assertEquals(manager.searchTicket(originalList), tempList);

        //origin=Vigo AND destination=Coruña AND date=2021-12-07 AND price<16.00
        tempList = new ArrayList<>();
        tempList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 7 )));

        parameter = new Price(16., S);
        manager.AND(parameter);
        assertEquals(manager.searchTicket(originalList), tempList);

        //origin=Vigo AND destination=Coruña AND date=2021-12-07 AND price<16.00 AND origin=Coruña
        tempList = new ArrayList<>();

        parameter = new Origin("Coruña");
        manager.AND(parameter);
        assertEquals(manager.searchTicket(originalList), tempList);
    }

    @Test
    void argumentTest(){
        manager = new SearchEngine();
        List<Ticket> tempList = new ArrayList<>();

        //origin=Vigo||Coruña
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
        tempList.add(new Ticket("Coruña", "Vigo", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Coruña", "Vigo", 12.70, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Coruña", "Vigo", 18.70, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Coruña", "Vigo", 14.95, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Coruña", "Santiago", 6.30, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Coruña", "Santiago", 7.60, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Coruña", "Vigo", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Coruña", "Vigo", 12.70, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Coruña", "Vigo", 18.70, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Coruña", "Vigo", 14.95, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Coruña", "Santiago", 6.30, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Coruña", "Santiago", 7.60, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Coruña", "Vigo", 15.85, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Coruña", "Vigo", 12.70, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Coruña", "Vigo", 18.70, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Coruña", "Vigo", 14.95, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Coruña", "Santiago", 6.30, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Coruña", "Santiago", 7.60, LocalDate.of( 2021 , 12 , 9 )));

        manager.OR(new Origin("Vigo"), new Origin("Coruña"));
        assertEquals(tempList, manager.searchTicket(originalList));

        tempList = new ArrayList<>();
        //origin=Vigo && destination=Ourense
        tempList.add(new Ticket("Vigo", "Ourense", 12.90, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Ourense", 7.20, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Ourense", 12.90, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Ourense", 7.20, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Ourense", 12.90, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Vigo", "Ourense", 7.20, LocalDate.of( 2021 , 12 , 9 )));

        manager.AND(new Origin("Vigo"), new Destination("Ourense"));
        assertEquals(tempList, manager.searchTicket(originalList));
    }

    @Test
    void comparationTest(){
        manager = new SearchEngine(new Date(LocalDate.of(2021,12,6), G));
        assertEquals(originalList, manager.searchTicket(originalList));
        manager.AND(new Date(LocalDate.of(2021,12,7), EG));
        assertEquals(originalList, manager.searchTicket(originalList));
        manager.AND(new Date(LocalDate.of(2021,12,10), S));
        assertEquals(originalList, manager.searchTicket(originalList));
        manager.AND(new Date(LocalDate.of(2021,12,9), ES));
        assertEquals(originalList, manager.searchTicket(originalList));

        List<Ticket> tempList = new ArrayList<>();
        tempList.add(new Ticket("Coruña", "Vigo", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Coruña", "Vigo", 12.70, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Coruña", "Vigo", 18.70, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Coruña", "Vigo", 14.95, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Coruña", "Santiago", 6.30, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Coruña", "Santiago", 7.60, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Ourense", 12.90, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Ourense", 7.20, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Santiago", 9.55, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Santiago", 11.50, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Coruña", 12.70, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Coruña", 18.70, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Coruña", 14.95, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Santiago", "Coruña", 6.30, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Santiago", "Coruña", 7.60, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Santiago", "Vigo", 9.55, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Santiago", "Vigo", 11.50, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Santiago", "Ourense", 10.35, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Santiago", "Ourense", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Santiago", "Ourense", 17.70, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Ourense", "Santiago", 10.35, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Ourense", "Santiago", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Ourense", "Santiago", 17.70, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Ourense", "Vigo", 12.90, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Ourense", "Vigo", 7.20, LocalDate.of( 2021 , 12 , 8 )));

        manager.AND(new Date(LocalDate.of(2021,12,7), G), new Date(LocalDate.of(2021,12,9), S));
        assertEquals(tempList, manager.searchTicket(originalList));

        manager = new SearchEngine(new Date(LocalDate.of(2021,12,8), EG));
        manager.AND(new Date(LocalDate.of(2021,12,8), ES));
        assertEquals(tempList, manager.searchTicket(originalList));

        manager = new SearchEngine(new Date(LocalDate.of(2021,12,8)));
        assertEquals(tempList, manager.searchTicket(originalList));

        //18.70, 7.20
        manager = new SearchEngine(new Price(6., G));
        assertEquals(originalList, manager.searchTicket(originalList));
        manager.AND(new Price( 6.30, EG));
        assertEquals(originalList, manager.searchTicket(originalList));
        manager.AND(new Price( 19., S));
        assertEquals(originalList, manager.searchTicket(originalList));
        manager.AND(new Price( 18.70, ES));
        assertEquals(originalList, manager.searchTicket(originalList));

        tempList = new ArrayList<>();
        tempList.add(new Ticket("Coruña", "Vigo", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Santiago", "Ourense", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Ourense", "Santiago", 15.85, LocalDate.of( 2021 , 12 , 7 )));
        tempList.add(new Ticket("Coruña", "Vigo", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Santiago", "Ourense", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Ourense", "Santiago", 15.85, LocalDate.of( 2021 , 12 , 8 )));
        tempList.add(new Ticket("Coruña", "Vigo", 15.85, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Vigo", "Coruña", 15.85, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Santiago", "Ourense", 15.85, LocalDate.of( 2021 , 12 , 9 )));
        tempList.add(new Ticket("Ourense", "Santiago", 15.85, LocalDate.of( 2021 , 12 , 9 )));

        manager.AND(new Price( 15.85));
        assertEquals(tempList, manager.searchTicket(originalList));

        manager = new SearchEngine(new Price(15.85, EG));
        manager.AND(new Price( 15.85, ES));
        assertEquals(tempList, manager.searchTicket(originalList));

        manager = new SearchEngine(new Price(15.84, G));
        manager.AND(new Price( 15.86, S));
        assertEquals(tempList, manager.searchTicket(originalList));
    }

    @Test
    void exceptionTest() {
        manager = new SearchEngine();
        assertThrows(IllegalArgumentException.class, () -> manager.AND(new Price( -1., S)));
        assertThrows(IllegalArgumentException.class, () -> manager.AND(new Price( -1.)));
    }
}
