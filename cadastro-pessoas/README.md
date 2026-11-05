# Cadastro de Pessoas (Java + MVC + CSV)

Sistema de console para cadastrar pessoas (`id`, `nome`, `idade`, `altura`),
com persistência em arquivo `pessoas.csv`.

## Arquitetura (MVC)

| Camada | Pacote | Responsabilidade |
|---|---|---|
| Model | `model` | Classe `Pessoa` e suas validações |
| View | `view` | Menu e leitura/exibição no console |
| Controller | `controller` | Coordena View e dados |
| Repository | `repository` | `ArrayList<Pessoa>` + leitura/gravação do CSV |
| Exceções | `exception` | `PessoaInvalidaException`, `PessoaNaoEncontradaException`, `ArquivoException` |

## Como executar

```bash
mkdir out
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out Main
```

O arquivo `pessoas.csv` é criado na pasta onde o programa é executado.

## Formato do CSV

```
id;nome;idade;altura
1;Ana Lima;28;1.65
```
