public class Snooper {
    public Snooper(WebSearchModel model) {
        model.addQueryObserver(query -> System.out.println("Query: " + query));
    }
}
