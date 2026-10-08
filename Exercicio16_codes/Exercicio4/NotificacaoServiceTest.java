package Exercicio16_codes.Exercicio4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NotificacaoServiceTest {
    @Mock
    private EmailSender emailSender;

    @InjectMocks
    private NotificacaoService service;

    @Captor
    private ArgumentCaptor<String> destinatarioCaptor;

    @Captor
    private ArgumentCaptor<String> assuntoCaptor;

    @Captor
    private ArgumentCaptor<String> corpoCaptor;

    @Test
    void deveEnviarBoasVindasPersonalizadas() {
        Usuario usuario = new Usuario("Ana Silva", "ana@email.com");

        service.notificarBoasVindas(usuario);

        verify(emailSender).enviar(destinatarioCaptor.capture(),
                assuntoCaptor.capture(), corpoCaptor.capture());
        assertEquals("ana@email.com", destinatarioCaptor.getValue());
        assertTrue(assuntoCaptor.getValue().contains("Bem-vindo"));
        assertTrue(corpoCaptor.getValue().contains("Ana"));
    }
}
