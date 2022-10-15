package contaCorrentista;

public class ContaCorrente extends Conta{
    private double tarifa;

    public ContaCorrente(int numeroAgencia, long numeroConta, Conta saldo, double tarifa) {
        super();
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public void debitar(double valor) {
        super.saldo -= valor;
    }

    public void creditar(double valor) {
        super.saldo += valor;
    }
}
