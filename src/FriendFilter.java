public class FriendFilter implements QueryFilter {
    @Override
    public boolean matches(String query) {
        return query.toLowerCase().contains("friend");
    }
}
