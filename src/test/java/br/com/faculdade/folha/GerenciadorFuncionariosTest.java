package br.com.faculdade.folha;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GerenciadorFuncionariosTest {

    @Test
    void deveCadastrarFuncionario() {
        GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios();

        Funcionario funcionario = new Funcionario("João", 3000.00);
        funcionario.setId(1);

        gerenciador.cadastrar(funcionario);

        assertEquals(1, gerenciador.listarTodos().size());
    }

    @Test
    void deveBuscarFuncionarioPorId() {
        GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios();

        Funcionario funcionario = new Funcionario("Maria", 3500.00);
        funcionario.setId(2);

        gerenciador.cadastrar(funcionario);

        Funcionario encontrado = gerenciador.buscarPorId(2);

        assertEquals(2, encontrado.getId());
    }

    @Test
    void deveRemoverFuncionarioPorId() {
        GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios();

        Funcionario funcionario = new Funcionario("Carlos", 4000.00);
        funcionario.setId(3);

        gerenciador.cadastrar(funcionario);

        gerenciador.remover(3);

        assertEquals(0, gerenciador.listarTodos().size());
    }

    @Test
    void deveCalcularTotalDaFolhaPagamento() {
        GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios();

        Funcionario joao = new Funcionario("João", 3000.00);
        joao.setId(1);

        Funcionario maria = new Funcionario("Maria", 4000.00);
        maria.setId(2);
        maria.aplicarDesconto(500.00);

        gerenciador.cadastrar(joao);
        gerenciador.cadastrar(maria);

        double total = gerenciador.calcularTotalFolha();

        assertEquals(6500.00, total, 0.001);
    }

    @Test
    void deveExibirRelatorioSalarios() {
        GerenciadorFuncionarios gerenciador =
                new GerenciadorFuncionarios();

        Funcionario joao = new Funcionario("João", 3000.00);
        joao.setId(1);

        gerenciador.cadastrar(joao);

        gerenciador.exibirRelatorioSalarios();
    }

}
