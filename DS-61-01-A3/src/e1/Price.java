package e1;

import e1.TicketManager.Comparator;

import java.util.ArrayList;
import java.util.List;

record Price(double value) implements SearchEngine {

    @Override
    public List<Ticket> searchBy(List<Ticket> targetList, Comparator comparator){
        List<Ticket> tempList = new ArrayList<>();
        for (Ticket ticket : targetList)
            switch(comparator){
                case LESS -> {
                    if (ticket.price() < value)
                        tempList.add(ticket);
                }
                case EQUAL_LESS -> {
                    if (ticket.price() <= value)
                        tempList.add(ticket);
                }
                case EQUAL -> {
                    if (ticket.price() == value)
                        tempList.add(ticket);
                }
                case EQUAL_MORE -> {
                    if (ticket.price() >= value)
                        tempList.add(ticket);
                }
                case MORE -> {
                    if (ticket.price() > value)
                        tempList.add(ticket);
                }
                default -> throw new IllegalArgumentException();
            }

        return tempList;
    }
}
