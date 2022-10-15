package contaCorrentista;

public abstract class Conta {
    private int numeroAgencia;
    private long numeroConta;
    protected double saldo;

    private Correntista correntista;

    public abstract void debitar(double valor);

    public abstract void creditar(double valor);


    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
