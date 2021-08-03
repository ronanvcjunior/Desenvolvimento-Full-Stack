import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class App {
    public static void main(String[] args) throws Exception {
        Integer nrConta = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String dtNascimento = "28/02/1999";
        Date dtNascimentoEmDate = sdf.parse(dtNascimento);
        Calendar dtNascimentoEmCalendar = Calendar.getInstance();
        dtNascimentoEmCalendar.setTime(dtNascimentoEmDate);

        PessoaFisica pessoaFisica = new PessoaFisica(0, "Ronan", "Aparecida de Goiânia", 000, dtNascimentoEmCalendar, "M");
        
        Conta conta1 = new Conta();
        abrirContaEmBanco(pessoaFisica, conta1, nrConta);
        System.out.println(conta1.getCliente().getNome());

        ContaEspecial conta2 = new ContaEspecial();
        abrirContaEmBanco(pessoaFisica, conta2, nrConta, 1000);
        System.out.println(conta2.getCliente().getNome());
        conta2.depositar(100);
        System.out.println(conta2.getSaldo());
        
        conta2.transferir(conta1, 50);
        System.out.println(conta2.getSaldo());
        System.out.println(conta1.getSaldo());

        ContaPoupanca conta3 = new ContaPoupanca();
        abrirContaEmBanco(pessoaFisica, conta3, nrConta, 1.5);
        System.out.println(conta3.getCliente().getNome());
        conta3.depositar(1000);
        conta3.atualizaSaldoRendimento();
        System.out.println(conta3.getSaldo());
    }

    public static void abrirContaEmBanco(PessoaFisica cliente, Conta conta, Integer nrConta) {
        conta.abrirConta(cliente, nrConta, 0);
        nrConta++;
    }

    public static void abrirContaEmBanco(PessoaJuridica cliente, Conta conta, Integer nrConta) {
        conta.abrirConta(cliente, nrConta, 0);
        nrConta++;
    }

    public static void abrirContaEmBanco(PessoaFisica cliente, ContaEspecial conta, Integer nrConta, double limite) {
        conta.abrirConta(cliente, nrConta, 0, limite);
        nrConta++;
    }

    public static void abrirContaEmBanco(PessoaJuridica cliente, ContaEspecial conta, Integer nrConta, double limite) {
        conta.abrirConta(cliente, nrConta, 0, limite);
        nrConta++;
    }

    public static void abrirContaEmBanco(PessoaFisica cliente, ContaPoupanca conta, Integer nrConta,
            double txCorrecao) {
        conta.abrirConta(cliente, nrConta, 0, txCorrecao);
        nrConta++;
    }

    public static void abrirContaEmBanco(PessoaJuridica cliente, ContaPoupanca conta, Integer nrConta,
            double txCorrecao) {
        conta.abrirConta(cliente, nrConta, 0, txCorrecao);
        nrConta++;
    }
}
