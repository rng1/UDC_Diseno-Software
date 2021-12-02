package e1;

import java.util.List;

interface SearchEngine {
    void searchBy(String value, CommandHandler.Comparator comparator, List<Ticket> ogList, List<Ticket> targetList);
}
