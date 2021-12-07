package e1;

import java.util.ArrayList;
import java.util.List;

import static e1.TicketManager.Comparator.EQUAL;

public class TicketManager{
    public enum Operator {AND, OR}
    public enum Comparator {LESS, EQUAL_LESS, EQUAL, EQUAL_MORE, MORE}
    List<Ticket> fullList;
    List<Ticket> finalList;

    public TicketManager() {
        fullList = new ArrayList<>();
        finalList = new ArrayList<>();
    }

    //RESETS THE LIST TO THE ONE SEARCHED HERE
    public List<Ticket> searchTickets(SearchEngine criterion) {
        finalList = criterion.searchBy(fullList, EQUAL);
        return finalList;
    }

    //ASSUMES THE COMPARATOR IS EQUAL
    public List<Ticket> searchTickets(Operator operator, SearchEngine criterion) {
        List<Ticket> tempList;
        switch (operator){
            case AND -> finalList = criterion.searchBy(finalList, EQUAL);
            case OR -> {
                tempList = new ArrayList<>(criterion.searchBy(fullList, EQUAL));
                tempList.removeAll(finalList);
                finalList.addAll(tempList);
            }
            default -> throw new IllegalArgumentException();
        }
        return finalList;
    }

    //ALLOWS SEARCHING BY OTHER THAN EQUAL
    public List<Ticket> searchTickets(Operator operator, Comparator comparator, SearchEngine criterion) {
        List<Ticket> tempList;
        switch (operator){
            case AND -> finalList = criterion.searchBy(finalList, comparator);
            case OR -> {
                tempList = new ArrayList<>(criterion.searchBy(fullList, comparator));
                tempList.removeAll(finalList);
                finalList.addAll(tempList);
            }
            default -> throw new IllegalArgumentException();
        }
        return finalList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        TicketManager manager = (TicketManager) obj;
        if(this.finalList.size() != manager.finalList.size())
            return false;
        for(int i = 0; i < this.finalList.size(); i++)
            if(!this.finalList.get(i).equals(manager.finalList.get(i)))
                return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Ticket ticket : this.finalList)
            str.append(ticket.toString()).append("\n");
        return String.valueOf(str);
    }
}
