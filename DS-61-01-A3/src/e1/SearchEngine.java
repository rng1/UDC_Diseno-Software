package e1;

import java.util.List;
import e1.TicketManager.Comparator;

interface SearchEngine {
    List<Ticket> searchBy(List<Ticket> targetList, Comparator comparator);
}
