import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

public class App {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        Date primeiraDt = data.parse("01/01/2021");
        Date segundaDt = data.parse("01/02/2021");

        long diffEmMil = Math.abs(segundaDt.getTime() - primeiraDt.getTime());

        long diff = TimeUnit.DAYS.convert(diffEmMil, TimeUnit.MILLISECONDS);

        PessoaFisica p = new PessoaFisica();
        p.setDtNascimento(primeiraDt);
        
        System.out.println(p.getDtNascimento());
    }
}
