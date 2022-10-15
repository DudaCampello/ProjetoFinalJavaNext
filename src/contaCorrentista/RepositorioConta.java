package contaCorrentista;

public class RepositorioConta {

    private static Conta[] listaContas;
    private static int tamanhoAtual = 0;

    public RepositorioConta(Conta[] listaContas) {
        RepositorioConta.listaContas = listaContas;
    }


    public int getTamanhoAtual() {
        return tamanhoAtual + 1;
    }

    public static void incluir(Conta conta) {
        tamanhoAtual++;
        listaContas[tamanhoAtual] = conta;
    }

    public Conta buscarConta(int numeroAgencia, long numeroConta) {
        for (Conta conta : listaContas) {
            if (conta != null && conta.getNumeroConta() == numeroConta && conta.getNumeroAgencia() == numeroAgencia) {
                return conta;
            }
        }
        return null;
    }

    public Conta[] consultarTodos() {
        Conta[] listaRetorno = new Conta[tamanhoAtual + 1];
        for (int i = 0; i < listaRetorno.length; i++) {
            listaRetorno[i] = listaContas[i];
        }
        return listaRetorno;

    }


}
