package e1;

import java.util.ArrayList;
import java.util.List;
import e1.TicketManager.Comparator;
import static e1.TicketManager.Comparator.EQUAL;

record Origin(String value) implements SearchEngine {

    @Override
    public List<Ticket> searchBy(List<Ticket> targetList, Comparator comparator){
        List<Ticket> tempList = new ArrayList<>();

        if(comparator != EQUAL)
            throw new IllegalArgumentException();

        for (Ticket ticket : targetList)
            if (ticket.origin().equals(value))
                tempList.add(ticket);
        return tempList;
    }
}
