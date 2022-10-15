package contaCorrentista;



public class CorrentistaMediator {
    private RepositorioCorrentista repositorioCorrentista;

    public int incluir(Correntista correntista) {
        repositorioCorrentista.incluir(correntista);
        return 0;
    }

    public Correntista[] consultarPorNome() {
        Correntista[] listaCorrentistaOrdenado = repositorioCorrentista.consultarTodos();
        return listaCorrentistaOrdenado;
    }
}
