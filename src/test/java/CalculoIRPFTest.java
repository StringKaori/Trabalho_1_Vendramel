import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sleep.CalculoIRPF;

public class CalculoIRPFTest {

    @Test
    @DisplayName("Salário exatamente 2259.20 deve ser isento")
    void testLimiteIsento() {
        double imposto = new CalculoIRPF().CalcularImposto(2259.20);
        assertEquals(0.0, imposto, 0.01);
    }

    @Test
    @DisplayName("Salário exatamente 2259.21 entra na faixa 7.5%")
    void testLimiteFaixa75Inicio() {
        double imposto = new CalculoIRPF().CalcularImposto(2259.21);
        double esperado = (2259.21 * 0.075) - 169.44;
        assertEquals(esperado, imposto, 0.01);
    }

    @Test
    @DisplayName("Salário exatamente 2826.65 ainda na faixa 7.5%")
    void testLimiteFaixa75Fim() {
        double imposto = new CalculoIRPF().CalcularImposto(2826.65);
        double esperado = (2826.65 * 0.075) - 169.44;
        assertEquals(esperado, imposto, 0.01);
    }

    @Test
    @DisplayName("Salário exatamente 2826.66 entra na faixa 15%")
    void testLimiteFaixa15Inicio() {
        double imposto = new CalculoIRPF().CalcularImposto(2826.66);
        double esperado = (2826.66 * 0.15) - 381.44;
        assertEquals(esperado, imposto, 0.01);
    }

    @Test
    @DisplayName("Salário exatamente 3751.05 ainda na faixa 15%")
    void testLimiteFaixa15Fim() {
        double imposto = new CalculoIRPF().CalcularImposto(3751.05);
        double esperado = (3751.05 * 0.15) - 381.44;
        assertEquals(esperado, imposto, 0.01);
    }

    @Test
    @DisplayName("Salário exatamente 3751.06 entra na faixa 22.5%")
    void testLimiteFaixa225Inicio() {
        double imposto = new CalculoIRPF().CalcularImposto(3751.06);
        double esperado = (3751.06 * 0.225) - 662.77;
        assertEquals(esperado, imposto, 0.01);
    }

    @Test
    @DisplayName("Salário exatamente 4664.68 ainda na faixa 22.5%")
    void testLimiteFaixa225Fim() {
        double imposto = new CalculoIRPF().CalcularImposto(4664.68);
        double esperado = (4664.68 * 0.225) - 662.77;
        assertEquals(esperado, imposto, 0.01);
    }

    @Test
    @DisplayName("Salário exatamente 4664.69 entra na faixa 27.5%")
    void testLimiteFaixa275() {
        double imposto =  new CalculoIRPF().CalcularImposto(4664.69);
        double esperado = (4664.69 * 0.275) - 896.0;
        assertEquals(esperado, imposto, 0.01);
    }
}