package contaCorrentista;

public class RepositorioCorrentista {
    private Correntista [] listaCorrentistas;
    private int tamanhoAtual =0;


    public int getTamanhoAtual() {
        return tamanhoAtual+1;
    }

    public void incluir(Correntista correntista){
        listaCorrentistas[tamanhoAtual] = correntista;
        tamanhoAtual++;
    }
    public Correntista buscarCpf(long cpf){
        for(int i=0; 1<tamanhoAtual+1; i++){
            if(listaCorrentistas[i].getCpf() == cpf){
                return listaCorrentistas[i];
            }
        }
        return null;
    }
    public Correntista [] consultarTodos(){
        return listaCorrentistas;
    }
}
