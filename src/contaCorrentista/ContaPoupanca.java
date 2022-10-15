package contaCorrentista;

public class ContaPoupanca extends Conta {

    private double taxabonus;

    public ContaPoupanca(int numeroAgencia, long numeroConta, Conta saldo, double taxabonus) {
        super();
    }

    public void debitar(double valor) {
        super.saldo -= valor;
    }

    public void creditar(double valor) {
        super.saldo += valor;
    }

    public double getTaxabonus() {
        return taxabonus;
    }

    public void setTaxabonus(double taxabonus) {
        this.taxabonus = taxabonus;
    }
}
