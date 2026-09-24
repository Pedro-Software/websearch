# Perguntas para Arguição

## 1. Por que utilizou Strategy?

Porque queríamos separar as regras de filtragem do modelo de busca. Assim o modelo não precisa saber como cada filtro funciona — ele apenas chama o método `matches()` e verifica se a consulta é relevante ou não.

## 2. Quem é a estratégia?

A interface `QueryFilter` representa a estratégia. Ela define o contrato que todos os filtros devem seguir. As classes `FriendFilter` e `LongQueryFilter` são as estratégias concretas, cada uma com sua própria regra de filtragem.

## 3. Quem é o contexto?

O `WebSearchModel` é o contexto porque ele utiliza o filtro sem conhecer sua implementação. Ele recebe um `QueryFilter` e apenas chama `matches()`, sem se preocupar com qual filtro específico está sendo usado.

## 4. Como adicionar um novo filtro?

Basta criar uma nova classe implementando a interface `QueryFilter` e definir a lógica no método `matches()`. Depois, no `Snooper`, basta registrar um observador usando esse novo filtro. O modelo não precisa ser alterado.

## 5. Qual problema existia antes?

O modelo tinha a responsabilidade de decidir todas as regras de filtragem internamente, deixando o código menos flexível. Qualquer mudança nas regras exigia modificar diretamente o `WebSearchModel`, o que dificultava a manutenção e a adição de novos filtros.
