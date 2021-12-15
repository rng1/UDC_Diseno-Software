package e1;

import java.util.ArrayList;
import java.util.List;

public class Destination implements TicketSearch {
    String value;
    List<Ticket> tempList;

    public Destination(String value) {
        this.value = value;
    }

    @Override
    public List<Ticket> searchTicket(List<Ticket> list) {
        tempList = new ArrayList<>();
        for (Ticket ticket : list)
            if (ticket.destination().equals(value))
                tempList.add(ticket);
        return tempList;
    }
}
