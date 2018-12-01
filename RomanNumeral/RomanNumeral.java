import java.util.*;
// código sacado de: https://codigosimportantes.blogspot.com/2012/05/romanos-decimal.html
public class RomanNumeral
{
	public static int convierte(String s) {
        char Rom[]= {' ','I','V','X','L','C','D','M'};         //GUARDAN LETRAS A COMPARAR
        int valor[] = {0,1,5,10,50,100,500,1000};              //SE LE DA VALOR A LA LETRAS
        int ant = 0;
        int suma = 0;
        int m = 0;
		int d = 0;
		int c = 0;
		int l = 0;
		int x = 0;
		int v = 0;
		int i = 0;
		
        char letra = ' ';
        for(int z = 0; z < s.length(); z++){                   
			letra = s.charAt(z);
			if (letra!= 'I' && letra!= 'V' && letra!= 'X'&& letra!= 'L'&&letra!= 'C'&&letra!= 'D'&& letra!= 'M') {
				throw new RuntimeException("Número romano no existente");
			}
			if(letra == 'I'){
				i= i +1;
			}
			if(letra == 'V'){
				v= v +1;
			}
			if(letra == 'X'){
				x = x + 1;
			}
			if(letra == 'L'){
				l= l +1;
			}
			if(letra == 'C'){
				c = c + 1;
			}
			if(letra == 'D'){
				d= d +1;
			}
			if(letra == 'M'){
				m= m +1;
			}
            for(int j = 0; j < Rom.length; j++){              //RECORRE
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
        }//si tiene + de 3 letras =
        if (i>3 ||v>1 ||x>3 ||l>1 || c>3 ||d>1 || m>3) {
			throw new RuntimeException("Número romano no válido(tiene + de 3 letras =)");
		}
        return(suma);    
   }
	public static void main(String[] args)
	{
		//System.out.println(convierte("V"));
		//System.out.println(convierte("Z"));
		//System.out.println(convierte("VIIII"));
		;
	}
}
   
