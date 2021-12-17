package e1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static e1.TicketSearch.Operator.E;

public class Date implements TicketSearch {
    LocalDate value;
    Operator condition;
    List<Ticket> tempList;

    public Date(LocalDate value, Operator condition) {
        this.value = value;
        this.condition = condition;
    }

    public Date(LocalDate value) {
        this.value = value;
        this.condition = E;
    }

    @Override
    public List<Ticket> searchTicket(List<Ticket> list) {
        tempList = new ArrayList<>();
        for (Ticket ticket : list)
            switch(condition){
                case S -> {
                    if (ticket.date().isBefore(value))
                        tempList.add(ticket);
                }
                case ES -> {
                    if (ticket.date().isBefore(value) || ticket.date().isEqual(value))
                        tempList.add(ticket);
                }
                case E -> {
                    if (ticket.date().isEqual(value))
                        tempList.add(ticket);
                }
                case EG -> {
                    if (ticket.date().isAfter(value) || ticket.date().isEqual(value))
                        tempList.add(ticket);
                }
                case G -> {
                    if (ticket.date().isAfter(value))
                        tempList.add(ticket);
                }
            }
        return tempList;
    }
}
