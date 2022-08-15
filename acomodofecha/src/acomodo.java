import java.util.ArrayList;
import java.util.List;

public class acomodo {
    public static void main(String[] args) throws Exception {
    List<String>cuentasMops = new ArrayList<>();
    String[] cuentas = {"02/12/2021 1","02/02/2022 1" ,"02/01/2022 3"};
    String[] cuentas21 = new String[13];
    //String[] cuenta22={};
    String  datos =null;
    String cuenta = null;
    String ano = null;
    int mops =  0;
    int mes = 0 ;
    final String  ano21 ="2021";
   // final String  ano22="2022";
    int mesAnterior = 0;
    int diferenciaMes = 0;
    int mopAnterior = 0;
    int valorSiguiente = 0;


    for(int i =0; i < 2; i++){
        datos = cuentas[i];
        cuentasMops.add(datos);
    }

    for (String valores : cuentas) {

        cuenta = valores.substring(0, 9);
        mes =Integer.parseInt(valores.substring(13, 15));
        ano =  valores.substring(16, 20);
        mops  =Integer.parseInt(valores.substring(21, 22));
        
     if(ano.equals(ano21)){

        if(mesAnterior  == 0 ){
            diferenciaMes = 0;
        }else{
            diferenciaMes = (mes - mesAnterior);
            valorSiguiente = (mesAnterior + 1);

            if(diferenciaMes < mesAnterior ){
                diferenciaMes = mesAnterior ;
            }else if(valorSiguiente < diferenciaMes ){
                diferenciaMes = valorSiguiente;

            }
            System.out.println("el valor del valorsiguiente " + valorSiguiente + " " + diferenciaMes );
        }

            while(diferenciaMes < mes){
                
           System.out.println(" el valor de diferenciaMES ES: " + diferenciaMes );
            if(diferenciaMes == 0 ){
                cuentas21[diferenciaMes] = cuenta;
            }else{
                if(mops == 1 && mesAnterior == 0 || mops == 1  && mopAnterior == 1 ){
                    cuentas21[diferenciaMes] = "1";

                }else if(mops >= 2  && mopAnterior >= 2){
                    cuentas21[diferenciaMes] = String.valueOf(mopAnterior);
                
                }else if(mops >=2 && mesAnterior < mes ){
                    cuentas21[diferenciaMes] = "1";

                }else if(mops == 1  &&  mopAnterior >= 2){
                    cuentas21[diferenciaMes] = String.valueOf(mopAnterior);

                }
            }
            diferenciaMes+=1;
        }
          cuentas21[mes]=String.valueOf(mops);
          mopAnterior = mops;
          mesAnterior = mes;
          System.out.println(" el valor de arreglo  21 es: " + diferenciaMes  + " el valor del  mes es: " + mes);
          
          System.out.println("el valor de mes anterior: " + mesAnterior);
          
           
          System.out.println("EL VALOR DE VALORES ES: " + valores );

     }
    
    
    }
    


  

  
   
   

   for(int i =0; i < cuentas21.length;i++){
      System.out.println("arreglo " + cuentas21[i]);
   }
   
   
}
}
