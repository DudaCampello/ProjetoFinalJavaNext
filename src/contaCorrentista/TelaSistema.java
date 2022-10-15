package contaCorrentista;


import java.util.Scanner;

public class TelaSistema {

    private final Scanner ENTRADA = new Scanner(System.in);
    private final CorrentistaMediator correntistaMediator;
    private final ContaMediator contaMediator;

    public TelaSistema() {
        correntistaMediator = new CorrentistaMediator();
        contaMediator = new ContaMediator();
    }

    public void executarTela() {
        boolean continua;
        do {
            continua = menuPrincipal();
        } while (continua);
    }

    private boolean menuPrincipal() {
        System.out.println("1-Incluir Correntista");
        System.out.println("2-Incluir Conta Corrente ou Conta Poupança");
        System.out.println("3-Debitar");
        System.out.println("4-Creditar");
        System.out.println("5-Listar Contas Ordenadas por Saldo em Ordem Crescente");
        System.out.println("6-Listar Correntistas Ordenados por Nome em Ordem Crescente");
        System.out.println("7-Sair");
        int opcao = ENTRADA.nextInt();
        boolean ret = true;
        switch (opcao) {
            case 1 -> {
                incluirCorrentista();
                break;
            }
            case 2 -> {
                incluirConta();
                break;
            }
            case 3 -> {
                debitar();
                break;
            }
            case 4 -> {
                creditar();
                break;
            }
            case 5 -> {
                listarContas();
                break;
            }
            case 6 -> {
                listarCorrentistas();
                break;
            }
            case 7 -> ret = false;
        }
        return ret;
    }


    private void incluirCorrentista() {
        System.out.println("Digite o CPF: ");
        long cpf = ENTRADA.nextLong();
        System.out.println("Digite o nome: ");
        String nome = ENTRADA.next();
        Correntista correntista = new Correntista(cpf, nome);
        int retorno = correntistaMediator.incluir(correntista);
    }

    private void incluirConta() {
        Conta c = null;
        double tarifa = 0.0;
        double taxaBonus = 0.0;
        System.out.println("Digite 1 para Conta Corrente e 2 para Conta Poupança: ");
        int opcConta = ENTRADA.nextInt();
        System.out.println("Digite Agencia: ");
        int numeroAgencia = ENTRADA.nextInt();
        System.out.println("Digite o numero da conta: ");
        long numeroConta = ENTRADA.nextLong();
        System.out.println("Digite o CPF: ");
        long cpf = ENTRADA.nextLong();
        if (opcConta == 1) {
            System.out.println("Digite tarifa: ");
            tarifa = ENTRADA.nextDouble();
            c = new ContaCorrente(numeroAgencia, numeroConta, c = null, tarifa);
        } else {
            System.out.println("Digite a taxa bônus: ");
            taxaBonus = ENTRADA.nextDouble();
            c = new ContaPoupanca(numeroAgencia, numeroConta, c = null, taxaBonus);
        }
        int retorno = contaMediator.incluir(c, cpf);

    }

    private void debitar() {
        System.out.println("Digite Número da Agência: ");
        int numeroAgencia = ENTRADA.nextInt();
        System.out.println("Digite Número da Conta: ");
        int numeroConta = ENTRADA.nextInt();
        System.out.println("Digite Valor: ");
        double valor = ENTRADA.nextDouble();
        int ret = contaMediator.debitar(numeroAgencia, numeroConta, valor);
    }

    private void creditar() {
        System.out.println("Digite Número da Agência: ");
        int numeroAgencia = ENTRADA.nextInt();
        System.out.println("Digite Número da Conta: ");
        int numeroConta = ENTRADA.nextInt();
        System.out.println("Digite Valor: ");
        double valor = ENTRADA.nextDouble();
        double saldo = contaMediator.debitar(numeroAgencia, numeroConta, valor);

    }

    private void listarContas() {
        Conta[] contas = contaMediator.consultarOrdenadoPorSaldo();
        for (Conta conta : contas) {
            System.out.println(conta.getNumeroAgencia() + " - "
                    + conta.getNumeroConta() + " - "
                    + conta.getSaldo());
        }
    }

    private void listarCorrentistas() {
        Correntista[] correntistas = correntistaMediator.consultarPorNome();
        for (Correntista correntista : correntistas) {
            System.out.println(correntista.getNome() + " - "
                    + correntista.getCpf());
        }
    }
}



