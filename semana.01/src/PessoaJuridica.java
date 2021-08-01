public class PessoaJuridica extends Pessoa {
    private int cnpj;
    private char atividade;

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public char getAtividade() {
        return atividade;
    }

    public void setAtividade(char atividade) {
        this.atividade = atividade;
    }
}
