package e1;

import java.util.ArrayList;
import java.util.List;

import static e1.TicketSearch.Operator.E;

public class Price implements TicketSearch {
    double value;
    Operator condition;
    List<Ticket> tempList;

    public Price(Double value, Operator condition) {
        this.value = value;
        this.condition = condition;
    }

    public Price(Double value) {
        this.value = value;
        this.condition = E;
    }

    @Override
    public List<Ticket> searchTicket(List<Ticket> list) {
        tempList = new ArrayList<>();
        for (Ticket ticket : list)
            switch(condition){
                case S -> {
                    if (ticket.price() < value)
                        tempList.add(ticket);
                }
                case ES -> {
                    if (ticket.price() <= value)
                        tempList.add(ticket);
                }
                case E -> {
                    if (ticket.price() == value)
                        tempList.add(ticket);
                }
                case EG -> {
                    if (ticket.price() >= value)
                        tempList.add(ticket);
                }
                case G -> {
                    if (ticket.price() > value)
                        tempList.add(ticket);
                }
            }
        return tempList;
    }
}
