// Essa interface representa o filtro (estratégia) que será utilizado pela busca.
// Qualquer novo filtro criado no projeto deve implementar essa regra,
// definindo se uma consulta deve ou não aparecer.
public interface QueryFilter {
    boolean matches(String query);
}
