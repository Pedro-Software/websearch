public class Snooper {
    public Snooper(WebSearchModel model) {
        model.addQueryObserver(query -> System.out.println("Oh Yes! " + query), new FriendFilter());
        model.addQueryObserver(query -> System.out.println("So long " + query), new LongQueryFilter());
    }
}
