package br.edu.ifal.aluno.esther.loterica;

import br.edu.ifal.aluno.esther.bank.Conta;

import java.math.BigDecimal;

public class Application {
  public static void main(String[] args) {
    var conta_joao = new Conta(
      "341", "4175", "Joao", BigDecimal.ZERO
    );

    var conta_maria = new Conta(
      "341", "5784", "Maria", new BigDecimal("1000.00")
    );

    System.out.println(conta_joao);
    System.out.println(conta_maria);

    conta_maria.depositar(new BigDecimal("900.00"));
    conta_maria.transferir(new BigDecimal("1100.00"), conta_joao);

    System.out.println(conta_joao);
    System.out.println(conta_maria);

    conta_joao.sacar(new BigDecimal("1000.00"));
    conta_joao.transferir(new BigDecimal("100.00"), conta_maria);
    conta_maria.depositar(new BigDecimal("2000.00"));

    System.out.println(conta_joao);
    System.out.println(conta_maria);
  }
}
