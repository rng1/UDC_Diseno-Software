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
    public void searchTickets(SearchEngine criterion) {
        finalList = criterion.searchBy(fullList, EQUAL);
    }

    //ASSUMES THE COMPARATOR IS EQUAL
    public void searchTickets(Operator operator, SearchEngine criterion) {
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
    }

    //ALLOWS SEARCHING BY OTHER THAN EQUAL
    public void searchTickets(Operator operator, Comparator comparator, SearchEngine criterion) {
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
    }

    /*public boolean equals(List<Ticket> otherList) {
        if (this.finalList == otherList)
            return true;
        if(this.finalList.size() != otherList.size())
            return false;
        for(int i = 0; i < this.finalList.size(); i++)
            if(!this.finalList.get(i).equals(otherList.get(i)))
                return false;
        return true;
    }*/
}
