package Grafo;
/*******************************************************************************************************************************************************
*
* Class Name: Prueba
* Author/s name: Eduardo Mora Gonzalez y Lucia Rosa Alonso
* Release/Creation date: 17/12/2016
* Class version: 1.0 
* Class description: esta clase llama a la clase Cuerpo(), introduce el fichero correspondiente, y luego en el método main ejecutas el método anterior
*
********************************************************************************************************************************************************
*/
import java.io.IOException;

public class Prueba {
	/******************************************************************************************************************************************************************************************************
	 *
	 * Method name: main()
	 *
	 * Name of the original author:------
	 *
	 * Description of the Method: Este método es el main, y lo que hace es ejecutarnos todo el programa.
	 *
	 * Calling arguments:--------------------------
	 * 
	 * Return value: Este método no devuelve ningún valor.
	 *
	 * Required Files: Este método no requiere nada.
	 *
	 * List of Checked Exceptions: 
	 * (a)throws IOException
	 *
	 ********************************************************************************************************************************************************************************************************/
	

	public static void main(String[] args) throws IOException {
		
		Cuerpo G = new Cuerpo("C:/Users/Eduardo/Desktop/MetroBikeShare_2016_Q3_trips.txt");
	}
}