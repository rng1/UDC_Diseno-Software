package e1;

import java.util.ArrayList;
import java.util.List;

public class TicketManager{
    public enum Operator {AND, OR}

    List<Ticket> fullList = new ArrayList<>();
    public SearchEngine category;
    public CommandHandler handler = new CommandHandler_I();

    //public abstract <T> List<T> searchTickets(String str, List<T> fullList);

    public List<Ticket> searchTickets(String str) {
        List<Ticket> tempList = new ArrayList<>();
        String[] splited = str.split(" ");
        int i;
        Operator op;

        category = handler.getCategory(splited[0]);
        category.searchBy(handler.getValue(splited[1]), handler.getComparator(splited[1]), fullList, tempList);

        for(i = 2; i < splited.length; i+=2){
            op = Operator.valueOf(splited[i]);
            category = handler.getCategory(splited[++i]);
            if(op == Operator.AND)
                category.searchBy(handler.getValue(splited[++i]), handler.getComparator(splited[++i]), tempList, tempList);
            else if(op == Operator.OR)
                category.searchBy(handler.getValue(splited[++i]), handler.getComparator(splited[++i]), fullList, tempList);
            else
                throw new IllegalArgumentException();
        }
        return tempList;
    }
}
