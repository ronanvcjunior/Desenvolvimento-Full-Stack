public class ContaEspecial extends Conta {
    private double limite;

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void abrirConta(Pessoa cliente, Integer nrConta, double saldo, double limite) {
        abrirConta(cliente, nrConta, saldo);
        this.limite = limite;
    }

    protected void temSaldo() {
        System.out.printf("O seu saldo é: R$ %.2f%n", getSaldo());
    }
}
