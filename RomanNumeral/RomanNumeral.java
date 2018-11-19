import java.util.*;
// código sacado de: https://codigosimportantes.blogspot.com/2012/05/romanos-decimal.html
public class RomanNumeral
{
	public static int convierte(String s) {
        char Rom[]= {' ','I','V','X','L','C','D','M'};         //GUARDAN LETRAS A COMPARAR
        int valor[] = {0,1,5,10,50,100,500,1000};              //SE LE DA VALOR A LA LETRAS
        int ant = 0;
        int suma = 0;
        char letra = ' ';
        for(int i = 0; i < s.length(); i++){                   //RECORRER TODA LA FRASE(numero romano)
			letra = s.charAt(i);
            for(int j = 0; j < Rom.length; j++){              //RECORRE ARREGLO ROM
				if(letra == Rom[j]){                       	 //si letra recorrida = a letra contenida en rom                 
                	suma = suma + valor [j];          		 //sumar el valor de la letra
                 	if( ant < valor[j]){                     //si el valor de letra anterior menor a valor letra   //actual
                    	suma = suma - ant*2 ;                // restale el doble del menor de los dos
                        ant = valor[j];                		 // valor anterior = valor letra actual
                   }else {                            		 //si no se cumple lo anterior  
                        ant = valor[j];                      //el dato actual se guarda en anterior
                   }              
                }
			}
        }
        return(suma);    
   }
	public static void main(String[] args)
	{
		//System.out.println(convierte("MXVI"));
		;
	}
}
   
