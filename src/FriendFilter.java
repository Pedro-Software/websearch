// Filtro que procura consultas que contenham a palavra "friend".
public class FriendFilter implements QueryFilter {
    @Override
    public boolean matches(String query) {
        // Transformamos a consulta para letras minúsculas para aceitar Friend, FRIEND ou friend,
        // garantindo que não haja diferença entre maiúsculas e minúsculas.
        return query.toLowerCase().contains("friend");
    }
}
