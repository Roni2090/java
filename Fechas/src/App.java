import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {

       int  contador = 1;
       Map<Integer, Integer>cifrasControl = new TreeMap<Integer,Integer>();
       Integer[] cifras ={12344,2349192,398485,1774,9293,9894,984,10,9};
       String mensajeArmado = null;
    

        LocalDate fechaActual = LocalDate.now();
        String fechaFormateada = fechaActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("fecha sin formatear " + fechaActual);
        System.out.println("fecha formeteada es "  + fechaFormateada);

        File file =new File("/home/hakkon/Documentos/prueba.txt");
        
        BasicFileAttributes atribs;
        try{
            atribs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            FileTime time = atribs.creationTime();

            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String formatted = simpleDateFormat.format(new Date(time.toMillis()));

            System.out.println("fecha del archivo "  + formatted);

            if(formatted.equals(fechaFormateada)){
               contador+=1;

            }

        }catch(Exception e){
            System.out.println("error en el formato de fecha ");
        }

        System.out.println("el valor del contador es  "  + contador);


         for(int i =0 ; i <=8 ;i++){
            cifrasControl.put(i, cifras[i]);
         }
        

         mensajeArmado= armaMensaje (cifrasControl);
         System.out.println( mensajeArmado );
        
    }

    public static String  armaMensaje(Map<Integer,Integer>cifrasControl){

        String mensaje = null;
        StringBuilder cifrasMensaje = new StringBuilder();
        String  cuerpoMensaje ="el proceso termino de manera correcta con las cifras: " ;
    
        Map<Integer,Integer>cifrasCon = cifrasControl;
         Iterator<Integer> it =cifrasCon.keySet().iterator();

          while(it.hasNext()){
            Integer llave = it.next();
            cifrasMensaje.append("Region ")
            .append(llave)
            .append(" Numero de registro descargados ")
            .append(cifrasCon.get(llave))
            .append("\n");
          }
          mensaje = cifrasMensaje.toString();
          return cuerpoMensaje + "\n" +  mensaje;

    }

}
