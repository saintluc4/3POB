package Exercicio12_codes.Exercicio3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercicio3 {
    public static void main(String[] args) {
        List<Aluno> alunos = Arrays.asList(
                new Aluno("Ana", "Informática", 9.0),
                new Aluno("Carlos", "Informática", 7.0),
                new Aluno("Beatriz", "Administração", 8.5),
                new Aluno("Pedro", "Administração", 5.0),
                new Aluno("Amanda", "Engenharia", 8.0),
                new Aluno("Bruno", "Engenharia", 6.5));

        Map<String, List<Aluno>> porCurso = alunos.stream()
                .collect(Collectors.groupingBy(Aluno::getCurso));

        Map<Boolean, List<Aluno>> porAprovacao = alunos.stream()
                .collect(Collectors.partitioningBy(aluno -> aluno.getNotaFinal() > 7.0));

        porCurso.forEach((curso, turma) -> {
            System.out.println("===== " + curso + " =====");
            turma.forEach(aluno -> System.out.printf("%s | Nota: %.1f%n",
                    aluno.getNome(), aluno.getNotaFinal()));
        });

        porAprovacao.forEach((aprovado, grupo) -> {
            System.out.println(aprovado ? "===== Aprovados =====" : "===== Reprovados =====");
            grupo.forEach(aluno -> System.out.printf("%s | Nota: %.1f%n",
                    aluno.getNome(), aluno.getNotaFinal()));
        });
    }
}
