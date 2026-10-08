package Exercicio9_codes.Exercicio5;

import java.util.Arrays;
import java.util.List;

public class Exercicio5 {
    public static void main(String[] args) {

        List<DispositivoEletronico> dispositivos = Arrays.asList(
                new Computador("Computador do laboratorio"),
                new Calculadora("Calculadora da sala"));

        for (DispositivoEletronico dispositivo : dispositivos) {
            dispositivo.exibirIdentificacao();
            dispositivo.ligar();
            if (dispositivo instanceof Conectavel) {
                Conectavel conectavel = (Conectavel) dispositivo;
                conectavel.conectar("Rede da escola");
            }
        }
    }
}
