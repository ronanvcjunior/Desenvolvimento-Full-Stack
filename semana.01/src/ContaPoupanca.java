public class ContaPoupanca extends Conta {
    private double txCorrecao;

    public double getTxCorrecao() {
        return txCorrecao;
    }

    public void abrirConta(Pessoa cliente, Integer nrConta, double saldo, double txCorrecao) {
        abrirConta(cliente, nrConta, saldo);
        this.txCorrecao = txCorrecao;
    }

    public void atualizaSaldoRendimento() {
        depositar(getSaldo() * txCorrecao / 100);
    }
}
