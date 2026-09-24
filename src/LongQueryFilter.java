// Filtro que verifica o tamanho da consulta.
// Apenas consultas longas (com mais de 60 caracteres) serão aceitas.
public class LongQueryFilter implements QueryFilter {
    @Override
    public boolean matches(String query) {
        return query.length() > 60;
    }
}
