# Catálogo de Produtos para E-commerce

Exercício de fixação da Aula 11 (POO): estruturas de dados dinâmicas, `List` e `ArrayList`.

## Estrutura
- `ecommerce.model.Produto`: entidade com `Comparable<Produto>` (ordenação natural por nome, ignorando caixa).
- `ecommerce.service.CatalogoService`: `List<Produto>` instanciada como `ArrayList` (coding to interfaces).
- `ecommerce.app.Main`: demonstração de todas as operações.

## Conceitos aplicados
- `List<Produto> = new ArrayList<>()` (programação voltada a interfaces)
- Remoção segura durante iteração com `Iterator.remove()`
- `Collections.sort()` com `Comparable` e com `Comparator`
- `get(index)` em O(1) e busca por id em O(n)
- `List.copyOf()` para devolver lista imutável
- `equals`/`hashCode` por id

## Como executar
```bash
mkdir out
javac -d out $(find src -name "*.java")
java -cp out ecommerce.app.Main
```
