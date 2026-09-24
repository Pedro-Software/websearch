public class LongQueryFilter implements QueryFilter {
    @Override
    public boolean matches(String query) {
        return query.length() > 60;
    }
}
