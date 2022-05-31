package br.edu.ifal.aluno.esther.bank;

import java.math.BigDecimal;

public class Conta {
  private final String banco;
  private final String agencia;
  private final String titular;
  private BigDecimal saldo;

  public Conta(String banco, String agencia, String titular, BigDecimal saldo) {
    this.banco = banco;
    this.agencia = agencia;
    this.titular = titular;

    if (saldo.signum() > 0) {
      this.saldo = saldo;
    } else {
      this.saldo = BigDecimal.ZERO;
    }
  }

  public void depositar(BigDecimal quantia) {
    if (quantia.signum() > 0) {
      saldo = saldo.add(quantia);
    }
  }

  public Boolean sacar(BigDecimal quantia) {
    if (quantia.signum() > 0 && this.possui(quantia)) {
      saldo = saldo.subtract(quantia);
      return true;
    }
    return false;
  }

  public void transferir(BigDecimal quantia, Conta destino) {
    if (sacar(quantia)) {
      destino.depositar(quantia);
    }
  }

  private Boolean possui(BigDecimal quantia) {
    return quantia.compareTo(saldo) <= 0;
  }

  public String getBanco() {
    return banco;
  }

  public String getAgencia() {
    return agencia;
  }

  public String getTitular() {
    return titular;
  }

  public BigDecimal getSaldo() {
    return saldo;
  }

  @Override
  public String toString() {
    return "Conta{" +
      "titular='" + titular + '\'' +
      ", saldo=" + saldo +
      '}';
  }
}
