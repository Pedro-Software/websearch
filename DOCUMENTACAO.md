# Implementação do Strategy - WebSearch

## Problema inicial

O modelo de busca original não possuía uma forma flexível de definir quais consultas eram interessantes para cada observador. Toda a lógica de filtragem ficava dentro do próprio modelo, o que dificultava a adição de novos critérios e tornava o código mais rígido.

Se quiséssemos adicionar um novo tipo de filtro, seria necessário modificar diretamente o `WebSearchModel`, violando o princípio aberto/fechado.

## Solução aplicada

Foi criada uma interface chamada `QueryFilter` que define um único método: `matches(String query)`. Essa interface representa a **estratégia** do padrão Strategy.

Cada filtro concreto implementa essa interface com sua própria lógica de decisão. O modelo de busca (`WebSearchModel`) recebe o filtro junto com o observador no momento do registro, e utiliza o filtro para decidir se deve ou não notificar aquele observador.

Assim, o modelo não conhece os detalhes de nenhum filtro — ele apenas chama `matches()` e age conforme o resultado.

## Quem representa cada parte do padrão?

| Papel no Padrão     | Classe / Interface   |
|----------------------|----------------------|
| **Strategy**         | `QueryFilter`        |
| **Concrete Strategy**| `FriendFilter` e `LongQueryFilter` |
| **Context**          | `WebSearchModel`     |
| **Client**           | `Snooper`            |

## Benefícios

- **Extensibilidade**: novos filtros podem ser adicionados criando novas classes que implementam `QueryFilter`, sem precisar modificar o `WebSearchModel`.
- **Separação de responsabilidades**: cada filtro cuida apenas da sua regra, e o modelo cuida apenas de notificar.
- **Facilidade de teste**: cada filtro pode ser testado de forma isolada.
- **Código mais limpo**: o modelo ficou mais simples e fácil de entender.
