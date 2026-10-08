package Exercicio16_codes.Exercicio5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProcessadorPagamentoServiceTest {
    @Mock
    private GatewayPagamento gateway;

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private ProcessadorPagamentoService service;

    @Test
    void naoDeveAtualizarPedidoQuandoPagamentoForRecusado() {
        Pedido pedido = new Pedido(200.00);
        doThrow(new PagamentoRecusadoException()).when(gateway).cobrar(anyDouble());

        assertThrows(PagamentoRecusadoException.class, () -> service.processar(pedido));

        assertEquals("PENDENTE", pedido.getStatus());
        verify(gateway).cobrar(200.00);
        verify(pedidoRepository, never()).atualizar(any());
    }

    @Test
    void deveMarcarComoPagoEAtualizarAposCobranca() {
        Pedido pedido = new Pedido(200.00);

        service.processar(pedido);

        assertEquals("PAGO", pedido.getStatus());
        InOrder ordem = inOrder(gateway, pedidoRepository);
        ordem.verify(gateway).cobrar(200.00);
        ordem.verify(pedidoRepository).atualizar(pedido);
    }
}
