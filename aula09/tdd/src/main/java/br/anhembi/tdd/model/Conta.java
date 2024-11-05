package br.anhembi.tdd.model;

public class Conta {

    private int numero;
    private double saldo;

    public Conta(int numero){
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean depositar(double valor) {
        if( valor <= 0) {
            return false;
        }
        saldo +=valor;
        return true;
    }
}
