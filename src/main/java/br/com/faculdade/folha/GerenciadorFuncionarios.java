package br.com.faculdade.folha;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorFuncionarios {

    private List<Funcionario> funcionarios = new ArrayList<>();

    public void cadastrar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> listarTodos() {
        return funcionarios;
    }
    public Funcionario buscarPorId(int id) {
        for (Funcionario funcionario : listarTodos()) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public void remover(int id) {
        funcionarios.removeIf(funcionario -> funcionario.getId() == id);
    }

    public double calcularTotalFolha() {
        double total = 0;

        for (Funcionario funcionario : listarTodos()) {
            total += funcionario.calcularSalarioLiquido();
        }

        return total;
    }

    public void exibirRelatorioSalarios() {
        for (Funcionario funcionario : listarTodos()) {
            System.out.println(
                    "ID: " + funcionario.getId()
                            + " | Salário líquido: R$ "
                            + funcionario.calcularSalarioLiquido()
            );
        }
    }

}

