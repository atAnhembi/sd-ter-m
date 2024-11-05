package br.anhembi.tdd.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ContaTest {

    // DadoQue_quando_EsperoQue

    @Test
    void criarConta_NumeroValido_ContaCriada() {
        int numeroConta = 123;

        Conta conta = new Conta(numeroConta);

        assertThat(conta).isNotNull();
    }

    @Test
    void criarConta_NumeroValido_NumeroContaCorreto() {
        int numeroConta = 123;

        Conta conta = new Conta(numeroConta);

        assertThat(conta.getNumero()).isEqualTo(numeroConta);
    }

    @Test
    void criarConta_NumeroValido_SaldoInicialZero() {
        int numeroConta = 123;

        Conta conta = new Conta(numeroConta);

        assertThat(conta.getSaldo()).isEqualTo(0);
    }

    @Test
    void depositarConta_NumeroValidoEValorValido_SaldoCorreto() {
        int numeroConta = 123;
        double valorDeposito = 100;

        Conta conta = new Conta(numeroConta);
        conta.depositar(valorDeposito);

        assertThat(conta.getSaldo()).isEqualTo(valorDeposito);
    }

    @Test
    void depositarConta_NumeroValidoEValorInvalido_SaldoSemAlteracao() {
        int numeroConta = 123;
        double valorDeposito = -100;

        Conta conta = new Conta(numeroConta);
        conta.depositar(valorDeposito);

        assertThat(conta.getSaldo()).isEqualTo(0);
    }
}
