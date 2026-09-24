public interface QueryFilter {
    // Define se uma consulta deve ser mostrada ou ignorada.
    boolean matches(String query);
}
