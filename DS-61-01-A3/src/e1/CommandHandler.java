package e1;

interface CommandHandler {
    enum Comparator {LESS, EQUAL, MORE, EQUAL_LESS, EQUAL_MORE}
    SearchEngine getCategory(String str);
    CommandHandler.Comparator getComparator(String str);
    String getValue(String str);
}
