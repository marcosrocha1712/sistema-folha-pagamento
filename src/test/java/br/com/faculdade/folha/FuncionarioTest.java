package br.com.faculdade.folha;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuncionarioTest {

    @Test
    void deveCalcularSalarioLiquidoSemDescontos() {

        Funcionario funcionario = new Funcionario("João", 3000.00);

        double salarioLiquido = funcionario.calcularSalarioLiquido();

        assertEquals(3000.00, salarioLiquido, 0.001);
    }
    @Test
    void deveCalcularSalarioLiquidoComDesconto() {
        Funcionario funcionario = new Funcionario("Maria", 3000.00);

        funcionario.aplicarDesconto(300.00);

        double salarioLiquido = funcionario.calcularSalarioLiquido();

        assertEquals(2700.00, salarioLiquido, 0.001);
    }
    @Test
    void naoDevePermitirDescontoMaiorQueSalario() {
        Funcionario funcionario = new Funcionario("Carlos", 3000.00);

        assertThrows(IllegalArgumentException.class,
                () -> funcionario.aplicarDesconto(3500.00));
    }
}
