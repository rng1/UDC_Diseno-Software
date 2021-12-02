package e1;

public class CommandHandler_I implements CommandHandler{
    @Override
    public SearchEngine getCategory(String str) {
        String category;
        int top = str.indexOf('=');
        if(top < 0)
            top = str.indexOf('<');
        if(top < 0)
            top = str.indexOf('>');
        if(top < 0)
            throw new IllegalArgumentException();
        category = str.substring(0,top);
        SearchEngine criterion;
        switch(category){
            case "origin"-> criterion = new SearchOrigin();
            case "destination"-> criterion = new SearchDestination();
            // . . .
            //TODO FINISH DYNAMIC POLYMORPHISM
            default -> throw new IllegalArgumentException();
        }
        return criterion;
    }

    @Override
    public CommandHandler.Comparator getComparator(String str) {
        int equal = str.indexOf('=');
        int less = str.indexOf('<');
        int more = str.indexOf('>');
        Comparator comparator;
        if(less>0 && more>0)
            throw new IllegalArgumentException();
        else if(equal>0 && less>0)
            comparator = Comparator.EQUAL_LESS;
        else if(equal>0 && more>0)
            comparator = Comparator.EQUAL_MORE;
        else if (equal>0)
            comparator = Comparator.EQUAL;
        else if (less>0)
            comparator = Comparator.LESS;
        else if (more>0)
            comparator = Comparator.MORE;
        else
            throw new IllegalArgumentException();
        return comparator;
    }

    @Override
    public String getValue(String str) {
        int bottom = str.indexOf('<');
        if(bottom < 0)
            bottom = str.indexOf('>');
        if(bottom < 0)
            bottom = str.indexOf('=');
        if(bottom < 0)
            throw new IllegalArgumentException();
        return str.substring(bottom);
    }
}
