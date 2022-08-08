import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

      String cuentas= null;
      List<String> listCuentas = new ArrayList<>();

        File historico = new File ();

        try (BufferedReader obj = new BufferedReader(new FileReader(historico))) {
            while((cuentas = obj.readLine()) != null){

                listCuentas.add(cuentas);

               

            }
        }

        Collections.sort(listCuentas); 
         for (String cuentasOrdenadas : listCuentas) {
            System.out.println("esta es la lista ordenada "  + cuentasOrdenadas);
            
        }

    }
}
