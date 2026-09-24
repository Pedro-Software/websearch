# Padrão Strategy - WebSearch

## Objetivo

O objetivo deste projeto foi aplicar o padrão de projeto **Strategy** em um mecanismo de busca simulado.

Antes da refatoração, todas as consultas lidas do arquivo de texto eram enviadas diretamente aos observadores, sem nenhum tipo de filtragem. Isso fazia com que o modelo de busca ficasse responsável por todas as regras de decisão.

Com a aplicação do Strategy, os **filtros foram separados em classes independentes**, permitindo que cada observador tenha sua própria estratégia de filtragem. Dessa forma, o modelo de busca não precisa conhecer os detalhes de cada filtro.

## Estrutura do projeto

| Classe / Interface | Descrição |
|--------------------|-----------|
| `QueryFilter` | Interface que representa uma estratégia de filtro. Define o método `matches(String query)` que decide se uma consulta é relevante ou não. |
| `FriendFilter` | Estratégia concreta que verifica se a consulta contém a palavra `"friend"`. |
| `LongQueryFilter` | Estratégia concreta que verifica se a consulta possui mais de 60 caracteres. |
| `WebSearchModel` | Contexto do padrão Strategy. Utiliza as estratégias de filtro associadas a cada observador para decidir quem deve ser notificado. |
| `Snooper` | Cliente que cria os observadores e escolhe qual filtro cada um vai utilizar. |
| `Main` | Classe principal que inicializa o modelo e dispara a busca simulada. |

## Funcionamento

O fluxo do programa funciona da seguinte forma:

1. Uma consulta (linha do arquivo de texto) é lida pelo modelo.
2. O modelo percorre todos os observadores registrados e verifica o filtro de cada um.
3. Caso o filtro aceite a consulta (retorne `true`), o observador é notificado.
4. O observador imprime a mensagem na tela.

## Como executar

Dentro da pasta `src/`, compile e execute:

```bash
javac *.java
java Main
```

## Exemplo de saída

```
Oh Yes! Friends to this ground.
So long Enter KING CLAUDIUS, KING HAMLET's Brother, QUEEN GERTRUDE of Denmark,
```

> As saídas dependem do conteúdo do arquivo `data/Hamlet.txt` utilizado como entrada.
