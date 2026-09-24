// O Snooper é responsável por criar os observadores e definir qual estratégia (filtro) cada um vai usar.
public class Snooper {
    public Snooper(WebSearchModel model) {
        // Primeiro observador: utiliza a estratégia FriendFilter (filtra consultas com "friend")
        model.addQueryObserver(query -> System.out.println("Oh Yes! " + query), new FriendFilter());

        // Segundo observador: utiliza a estratégia LongQueryFilter (filtra consultas com mais de 60 caracteres)
        model.addQueryObserver(query -> System.out.println("So long " + query), new LongQueryFilter());
    }
}
