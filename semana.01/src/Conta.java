public class Conta {
    private Pessoa cliente;
    private Integer nrConta;
    private double saldo;

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Integer getNrConta() {
        return nrConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void abrirConta(Pessoa cliente, Integer nrConta, double saldo) {
        this.cliente = cliente;
        this.nrConta = nrConta;
        this.saldo = 0;
    }

    public void sacar(double saque) {
        if (saque <= (saldo)) {
            debitar(saque);
            System.out.printf("Você sacou R$ %.2f%n", saque);
        } else {
            System.out.printf("Impossivel sacar R$ %.2f, devido ao seu saldo ser insuficiente%n", saque);
        }
    }

    public void depositar(double deposito) {
        saldo += deposito;
        System.out.printf("Você depositou R$ %.2f%n", deposito);
    }

    public void transferir(Conta contaTransferencia, double transferencia) {
        if (transferencia <= (saldo)) {
            debitar(transferencia);
            contaTransferencia.depositar(transferencia);
            System.out.printf("Você transferiu R$ %.2f para a conta do(a) %s%n", transferencia, contaTransferencia.getCliente().getNome());
        } else {
            System.out.printf("Impossivel transferir R$ %.2f, devido ao seu saldo ser insuficiente%n", transferencia);
        }
    }

    private void debitar(double saque) {
        saldo -= saque;
    }

    protected void temSaldo() {
        System.out.printf("O seu saldo é: R$ %.2f%n", saldo);
    }
}