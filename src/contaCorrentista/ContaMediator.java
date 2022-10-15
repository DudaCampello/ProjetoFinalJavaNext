package contaCorrentista;


public class ContaMediator {

    private static final int SUCESSO = 0;
    private static final int CONTA_INEXISTENTE = 1;
    private static final int VALOR_INSUFICIENTE = 3;
    private static final int SALDO_INSUFICIENTE = 4;

    private RepositorioConta repositorioConta;
    private RepositorioCorrentista repositorioCorrentista;

    /*public int incluir(Conta conta, long cpf) {
        repositorioConta.incluir(conta);
        return 0;
    }*/
    public int incluir(Conta conta, long cpf) {
        Correntista corrente = repositorioCorrentista.buscarCpf(cpf);
        RepositorioConta.incluir(conta);
        return 0;
    }

    public int debitar(int numeroAgencia, long numeroConta, double valor) {
        if (valor < 0) {
            return VALOR_INSUFICIENTE;
        } else {
            Conta conta = repositorioConta.buscarConta(numeroAgencia, numeroConta);
            if (conta == null) {
                return CONTA_INEXISTENTE;
            } else if (conta.getSaldo() < valor) {
                return SALDO_INSUFICIENTE;
            } else {
                conta.debitar(valor);
                return SUCESSO;
            }
        }
    }
    public int creditar(int numeroAgencia, long numeroConta, double valor){
        if (valor < 0) {
            return VALOR_INSUFICIENTE;
        } else {
            Conta conta = repositorioConta.buscarConta(numeroAgencia, numeroConta);
            if (conta == null) {
                return CONTA_INEXISTENTE;
            } else {
                conta.creditar(valor);
                return SUCESSO;
            }
        }
    }

    public Conta[] consultarOrdenadoPorSaldo() {
        Conta[] listaOrdenadoPorSaldo = repositorioConta.consultarTodos();
        return listaOrdenadoPorSaldo;

    }
}

