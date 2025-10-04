import org.junit.jupiter.api.Test;

import com.sleep.CalculoIRPF;
import static org.junit.jupiter.api.Assertions.*;

public class CalculoIRPFTest {

    CalculoIRPF calculo = new CalculoIRPF();

    @Test
    void testSalarioNegativo() {
        assertEquals(0.0, calculo.CalcularImposto(-1000.0), 0.0001);
    }

    @Test
    void testSalarioZero() {
        assertEquals(0.0, calculo.CalcularImposto(0.0), 0.0001);
    }

    @Test
    void testFaixaIsencaoLimite() {
        assertEquals(0.0, calculo.CalcularImposto(2259.20), 0.0001);
    }

    @Test
    void testFaixa7_5PercentualInicio() {
        double imposto = calculo.CalcularImposto(2259.21);
        assertEquals((2259.21 * 0.075) - 169.44, imposto, 0.0001);
    }

    @Test
    void testFaixa7_5PercentualFim() {
        double imposto = calculo.CalcularImposto(2826.65);
        assertEquals((2826.65 * 0.075) - 169.44, imposto, 0.0001);
    }

    @Test
    void testFaixa15PercentualInicio() {
        double imposto = calculo.CalcularImposto(2826.66);
        assertEquals((2826.66 * 0.15) - 381.44, imposto, 0.0001);
    }

    @Test
    void testFaixa15PercentualFim() {
        double imposto = calculo.CalcularImposto(3751.05);
        assertEquals((3751.05 * 0.15) - 381.44, imposto, 0.0001);
    }

    @Test
    void testFaixa22_5PercentualInicio() {
        double imposto = calculo.CalcularImposto(3751.06);
        assertEquals((3751.06 * 0.225) - 662.77, imposto, 0.0001);
    }

    @Test
    void testFaixa22_5PercentualFim() {
        double imposto = calculo.CalcularImposto(4664.68);
        assertEquals((4664.68 * 0.225) - 662.77, imposto, 0.0001);
    }

    @Test
    void testFaixa27_5PercentualInicio() {
        double imposto = calculo.CalcularImposto(4664.69);
        assertEquals((4664.69 * 0.275) - 896.0, imposto, 0.0001);
    }

    @Test
    void testFaixa27_5PercentualAlto() {
        double imposto = calculo.CalcularImposto(10000.0);
        assertEquals((10000.0 * 0.275) - 896.0, imposto, 0.0001);
    }

    @Test
    void testValorNaoDouble() {
        assertThrows(NullPointerException.class, () -> {
            calculo.CalcularImposto(null);
        });
    }

    @Test
    void testValorNegativo() {
        double resultado = calculo.CalcularImposto(-100.0);
        assertEquals(0.0, resultado, 0.0001);
    }

}