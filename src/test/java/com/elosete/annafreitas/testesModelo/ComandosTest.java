package com.elosete.annafreitas.testesModelo;

import com.elosete.annafreitas.modelo.Comandos;
import com.elosete.annafreitas.modelo.Sondas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ComandosTest {

    @Mock
    private Sondas sonda;

    @Test
    public void deveAndarParaFrente() {
        Comandos.MOVE.mover(sonda);
        verify(sonda, only()).andarParaFrente();
    }

    @Test
    public void deveVirarAEsquerda() {
        Comandos.VIRAR_ESQUERDA.mover(sonda);
        verify(sonda, only()).virarAEsquerda();
    }
    
    @Test
    public void deveVirarADireita() {
        Comandos.VIRAR_DIREITA.mover(sonda);
        verify(sonda, only()).virarADireita();
    }

}
