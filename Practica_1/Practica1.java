package Practica1;
/*****************************************************************************************************************************************************************************
*
* Class Name: Practica 1
* Author/s name: Eduardo Mora Gonzalez y Lucia Rosa Alonso
* Release/Creation date: 28/10/2016
* Class version: 1.0 
* Class description: Las frutas se obtendr�n de un fichero de texto proporcionado. Cuando una fruta se sit�e encima de otra igual, ambas desaparecer�n y se obtendr� un punto.
* Cuando se encuentre una bomba en el fichero de texto se producir� una explosi�n que eliminar� tres frutas del tablero.
* Al finalizar el juego, deber� mostrarse la puntuaci�n total obtenida, el contenido final del tablero y el n�mero de frutas en este.
* 
******************************************************************************************************************************************************************************
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.lang.Thread;

public class Practica1 {

	String[] fruit; // Este es el array, donde se van a ir guardando los objetos
					// del fichero, y luego vamos a ir comparando con la pila
	int objeto; // Este es la variable objeto, que son las palabras que se van
				// leyendo del fichero
	int puntos = 0; // Esta es la variable de los puntos, que se va a ir
					// incrementando durante desarrollo del programa
	Stack<String> stack; // Definde que la pila va a ser de String
	String Fichero; // Esta es la variable fichero, de la cual van a salir los
					// objetos

	public Practica1() throws InterruptedException{
		/******************************************************************************************************************************************************************************************************
		 *
		 * Method name: Practica 1()
		 *
		 * Name of the original author:------
		 *
		 * Description of the Method: Este m�todo es el constructor, pero por
		 * otro lado tambi�n cumple otras funciones: como la lectura del
		 * fichero, uso de la excepci�n, la creaci�n de la pila y del array con
		 * los objetos,y adem�s el inicio de otro m�todo.
		 *
		 * Calling arguments:------
		 * 
		 * Return value: Este m�todo no devuelve ning�n valor.
		 *
		 * Required Files: Este m�todo requiere que se introduzca un fichero
		 * para poder leerlo e introducir los datos en el array
		 *
		 * List of Checked Exceptions:
		 * (a)InterruptedException: al nombrar el m�todo candy(), que dicho
		 * m�todo utiliza esta excepci�n, obligatoriamente la tenemos que poner
		 * en este m�todo.
		 *
		 ********************************************************************************************************************************************************************************************************/
		Scanner sc = null;
		int indice;
		try {
			sc = new Scanner (new File ("examen.txt"));//cargamos el fichero del paquete
		} catch (FileNotFoundException e) {
			System.out.println("File was not found.");
		}
		
		fruit = new String[100]; // Creamos el array, con un tama�o de 100
		objeto = 0; // Inicializamos el par�metro a 0

		while (sc.hasNext()) { //Lee el contenido del fichero, cada palabra que lea, lo llamar� objeto, lo introducir� en la "casilla" correspondiente del array, y pasar� a la siguiente "casilla", donde se introducir� el siguiente objeto.
								 
			fruit[objeto] = sc.next();
			objeto++;
		}

		stack = new Stack(); // Creaci�n del stack o pila

		candy(); // Inicio del m�todo
		printstack(); // Cuando acabe el m�todo candy(), ejecuta el m�todo printstack()

	}

	public void candy() throws InterruptedException {
		/******************************************************************************************************************************************************************************************************
		 *
		 * Method name: candy()
		 *
		 * Name of the original author:------
		 *
		 * Description of the Method: Este m�todo se encarga de las operaciones
		 * que nos manda la prueba. Para ello lee el primer objeto del array
		 * fruit y lo introduce dentro de la pila, a partir de ah� va comparando
		 * el array con la pila, si coincide se elimina 1, si es una bomba
		 * EXPLOTA y elimina 3, y si no coinciden lo introduce en la pila y pasa
		 * al siguiente. Todas estas operaciones se van indicando en su
		 * correspondiente l�nea con un comentario a la derecha.
		 *
		 * Calling arguments:------
		 * 
		 * Return value: Este m�todo no devuelve ning�n valor.
		 *
		 * Required Files: Este m�todo no requiere ning�n archivo, s�lo necesita
		 * el array del m�todo anterior.
		 *
		 * List of Checked Exceptions: (a)InterruptedException: utilizamos esta
		 * excepci�n en las l�neas 104 y 107.
		 *
		 ********************************************************************************************************************************************************************************************************/
		
		Thread.sleep(1000); //Esperamos 1 segundo
		for (int i = 0; i < objeto; i++) { // Inicializamos el bucle a 1, y leemos el array
			System.out.println(fruit[i]); // Mostramos el objeto correspondiente
			Thread.sleep(1000);// Esperamos 1 segundo
			if (stack.isEmpty()) {//Si est� vac�a la pila
				stack.push(fruit[i]);//Mete el objeto dentro de la pila
			} else if (stack.peek().equals(fruit[i])) { // Si el objeto que acabamos de leer del array es igual al que hay dentro de la pila, entonces:
				stack.push(fruit[i]);
				stack.pop(); // Elimina 2 elemento de la pila
				stack.pop(); 
				puntos += 1; // Suma 1 punto
				System.out.println("Las dos frutas:  " + fruit[i] + " coinciden"); // Nos dice cual es el objeto que coincide
				System.out.println("Los puntos son:  " + puntos); // Muestra los puntos acumulados
			} else if (fruit[i].equals("bomba")) { // Si el objeto que leemos de la lista es la palabra bomba, entonces:
				stack.push(fruit[i]);
				stack.pop();
				stack.pop(); // Elimina 4 elementos de la pila
				stack.pop();
				stack.pop();
				puntos += 2; // Suma 2 puntos
				System.out.println("EXPLOTA"); // Muestra EXPLOTA
				System.out.println("Los puntos son:  " + puntos); // Muestra los puntos acumulados
			} else // Si el objeto le�do del array no coincide ni es una bomba, entonces:
				stack.push(fruit[i]); // Mete el objeto dentro de la lista
		}
	}

	public void printstack() {
		/******************************************************************************************************************************************************************************************************
		 *
		 * Method name: printstack()
		 *
		 * Name of the original author:------
		 *
		 * Description of the Method: Este m�todo muestra los puntos finales, el
		 * n�mero de frutas que quedan en la pila y cu�les son.
		 *
		 * Calling arguments:------
		 * 
		 * Return value: Este m�todo no devuelve ning�n valor.
		 *
		 * Required Files: Este m�todo no requiere ning�n archivo, s�lo necesita
		 * el array del m�todo anterior.
		 *
		 * List of Checked Exceptions:------
		 *
		 ********************************************************************************************************************************************************************************************************/

		Stack<String> aux = new Stack();
		System.out.println("---------------------------------------");
		System.out.println("La puntuaci�n total es: " + puntos);
		System.out.println("El n�mero de frutas que queda es: " + stack.size());
		System.out.println("Y son: ");
		while (!stack.isEmpty()) {
			System.out.println(stack.peek());
			aux.push(stack.peek());
			stack.pop();

		}
	}

