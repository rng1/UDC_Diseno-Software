package e1;

import java.util.ArrayList;
import java.util.List;

public class Origin implements TicketSearch {
    String value;
    List<Ticket> tempList;

    public Origin(String value) {
        this.value = value;
    }

    @Override
    public List<Ticket> searchTicket(List<Ticket> list) {
        tempList = new ArrayList<>();
        for (Ticket ticket : list)
            if (ticket.origin().equals(value))
                tempList.add(ticket);
        return tempList;
    }
}
