package e1;

import java.util.List;

public interface TicketSearch {
    enum Operator { E, G, S, EG, ES }
    List<Ticket> searchTicket(List<Ticket> list);
}
