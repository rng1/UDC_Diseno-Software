package e1;

import e1.TicketManager.Comparator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record Date(LocalDate value) implements SearchEngine {

    @Override
    public List<Ticket> searchBy(List<Ticket> targetList, Comparator comparator) {
        List<Ticket> tempList = new ArrayList<>();
        for (Ticket ticket : targetList)
            switch (comparator) {
                case LESS -> {
                    if (ticket.date().isBefore(value))
                        tempList.add(ticket);
                }
                case EQUAL_LESS -> {
                    if (ticket.date().isBefore(value) && ticket.date().isEqual(value))
                        tempList.add(ticket);
                }
                case EQUAL -> {
                    if (ticket.date().isEqual(value))
                        tempList.add(ticket);
                }
                case EQUAL_MORE -> {
                    if (ticket.date().isAfter(value) && ticket.date().isEqual(value))
                        tempList.add(ticket);
                }
                case MORE -> {
                    if (ticket.date().isAfter(value))
                        tempList.add(ticket);
                }
                default -> throw new IllegalArgumentException();
            }
        return tempList;
    }
}
