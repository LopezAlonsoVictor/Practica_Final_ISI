import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MiDescuentoBlackFridayTest
{

    private DescuentoBlackFriday producto;

	@Before      // Set up - Called before every test method.
    public void setUp()
    {
	  producto = new DescuentoBlackFriday();
	}

// Fallará siempre pues no controlan este caso
 	@Test public void testprecionegativo()
	{
        double valor = -5.0;
        double descuento = valor * 0.7;
        LocalDate fecha = LocalDate.now();
        if (fecha.getMonthValue() == 11 && fecha.getDayOfMonth()==23){
            assertFalse("No se pueden introducir precios negativos",
            descuento == producto.PrecioFinal(valor));
        }else{
            assertFalse("No se pueden introducir precios negativos",
            valor == producto.PrecioFinal(valor));
        }
	}

	@Test public void testlimitesuperior()
	{
		double valor = 15.2;
        LocalDate fecha = LocalDate.now();
        if (fecha.getMonthValue() == 11 && fecha.getDayOfMonth()==24){
            assertTrue("El total es 15.2", valor == producto.PrecioFinal(valor));
        }
	}

	@Test public void testlimiteinferior()
	{
        double valor = 15.2;
        LocalDate fecha = LocalDate.now();
        if (fecha.getMonthValue() == 11 && fecha.getDayOfMonth()==22){
            assertTrue("El total es 15.2", valor == producto.PrecioFinal(valor));
        }
	}

	@Test public void testcorrectofunc()
	{
        double valor = 15.2;
        double descuento = valor * 0.7;
        LocalDate fecha = LocalDate.now();
        if (fecha.getMonthValue() == 11 && fecha.getDayOfMonth()==23){
            assertTrue("El total es 15.2", descuento == producto.PrecioFinal(valor));
        }
	}
}
