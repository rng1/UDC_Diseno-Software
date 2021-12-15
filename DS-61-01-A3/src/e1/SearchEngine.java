package e1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchEngine implements TicketSearch{
    private final List<TicketSearch> ANDpar;
    private final List<TicketSearch> ORpar;

    private List<Ticket> searchList;

    public SearchEngine() {
        ANDpar = new ArrayList<>();
        ORpar = new ArrayList<>();
        searchList = new ArrayList<>();
    }

    public SearchEngine(TicketSearch parameter) {
        ANDpar = new ArrayList<>();
        ORpar = new ArrayList<>();
        searchList = new ArrayList<>();
        ORpar.add(parameter);
    }

    public void AND(TicketSearch... implementation) {
        ANDpar.addAll(Arrays.asList(implementation));
    }

    public void OR(TicketSearch... implementation) {
        Collections.addAll(ORpar, implementation);
    }

    @Override
    public List<Ticket> searchTicket(List<Ticket> ticketList) {
        if(ANDpar.isEmpty() && ORpar.isEmpty())
            return searchList;
        for(TicketSearch parameter : ORpar) {
            List<Ticket> tempList = parameter.searchTicket(ticketList);
            tempList.removeAll(searchList);
            searchList.addAll(tempList);
        }
        for(TicketSearch parameter : ANDpar) {
            searchList = parameter.searchTicket(searchList);
        }
        return searchList;
    }
}
