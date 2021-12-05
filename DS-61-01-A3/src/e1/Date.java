package e1;

import e1.TicketManager.Comparator;

import java.util.ArrayList;
import java.util.List;

public class Date extends java.util.Date implements SearchEngine {
    private final Date value;

    public Date(Date value) { this.value = value; }
    public Date value() { return value; }

    @Override
    public List<Ticket> searchBy(List<Ticket> targetList, Comparator comparator){
        List<Ticket> tempList = new ArrayList<>();
        for (Ticket ticket : targetList)
            switch(comparator){
                case LESS -> {
                    if (ticket.date().before(value))
                        tempList.add(ticket);
                }
                case EQUAL_LESS -> {
                    if (ticket.date().before(value) && ticket.date().equals(value))
                        tempList.add(ticket);
                }
                case EQUAL -> {
                    if (ticket.date().equals(value))
                        tempList.add(ticket);
                }
                case EQUAL_MORE -> {
                    if (ticket.date().after(value) && ticket.date().equals(value))
                        tempList.add(ticket);
                }
                case MORE -> {
                    if (ticket.date().after(value))
                        tempList.add(ticket);
                }
                default -> throw new IllegalArgumentException();
            }
        return tempList;
    }
}
