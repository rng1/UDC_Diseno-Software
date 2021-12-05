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

    //public abstract <T> List<T> searchTickets(String str, List<T> fullList);

    public List<Ticket> searchTickets(SearchEngine criterion) {
        finalList = criterion.searchBy(fullList, EQUAL);
        return finalList;
    }

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
}
