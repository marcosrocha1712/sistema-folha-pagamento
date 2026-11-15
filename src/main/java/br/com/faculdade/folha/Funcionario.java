package br.com.faculdade.folha;

public class Funcionario {

    private String nome;
    private double salarioBase;
    private double desconto;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.desconto = 0;
    }

    public void aplicarDesconto(double valor) {
        if (valor > salarioBase - desconto) {
            throw new IllegalArgumentException(
                    "O desconto não pode ser maior que o salário disponível."
            );
        }

        this.desconto += valor;
    }

    public double calcularSalarioLiquido() {
        return salarioBase - desconto;
    }
}
