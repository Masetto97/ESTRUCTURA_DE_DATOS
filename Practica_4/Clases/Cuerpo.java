package Grafo;

/*****************************************************************************************************************************************************************************
*
* Class Name: Cuerpo
* Author/s name: Eduardo Mora Gonzalez y Lucia Rosa Alonso
* Release/Creation date: 17/12/2016
* Class version: 1.0 
* Class description: Esta es la clase más importante de todo el programa. Al principio nos muestra un 
* menú para que nos sea más secilla la utilización del programa, a parte se encarga de leer el fichero, 
* separar los elementos, crear el grafo, pintarlo, buscar el camino entre dos estaciones las cuales nos pide
* el programa, buscar si dos estaciones están repetidas, y muchas más tareas. 
* 
******************************************************************************************************************************************************************************
*/

import java.io.*;
import java.util.*;
import graphsDSESIUCLM.*;

public class Cuerpo {

	private Graph grafo;
	private Estacion[] estaciones = new Estacion[100];
	private String cadena;
	private int contador;
	private int aristas;
	private ElementoDecorado estacion[] = new ElementoDecorado[100];
	private Vertex<ElementoDecorado> aux = null, aux1 = null, aux2 = null;

	public Cuerpo(String archivo) throws IOException {
		/******************************************************************************************************************************************************************************************************
		 *
		 * Method name: Cuerpo()
		 *
		 * Name of the original author:------
		 *
		 * Description of the Method: Este método es el constructor, además de
		 * el encargado de mostrarnos el menú, y a partir de ahí llevarnos al
		 * método que queremos emplear
		 *
		 * Calling arguments: llama a los métodos Crear_Grafo(), Pintar_Grafo(),
		 * Camino()
		 * 
		 * Return value: Este método no devuelve ningún valor.
		 *
		 * Required Files: Este método requiere que se introduzca un fichero
		 * para que otros métodos usen ese mismo fichero.
		 *
		 * List of Checked Exceptions: (a)throws IOException
		 *
		 ********************************************************************************************************************************************************************************************************/
		// Escaner
		Scanner sc = new Scanner(System.in);
		// Variables del menú
		boolean exit = false;
		int Opcion;

		do {
			System.out.println("\nEste es el menu principal del Programa");
			System.out.println("1. Crear Grafo(tambien te dira las estaciones y aristas que tiene)");
			System.out.println("2. Pintar el grafo");
			System.out.println("3. Buscar camino entre dos estaciones y finaliza el programa");

			Opcion = sc.nextInt();
			sc.nextLine();

			switch (Opcion) {

			case 1:
				this.aristas = Crear_Grafo(archivo);
				break;
			case 2:
				Pintar_Grafo();
				break;
			case 3:
				Camino_Corto();
				exit = true;
				break;
			}
		} while (!exit);
		System.out.println("\n");
		System.out.println("\nFIN DEL PROGRAMA");

	}

	public int Crear_Grafo(String archivo) throws IOException {
		/******************************************************************************************************************************************************************************************************
		 *
		 * Method name: Crear_Grafo()
		 *
		 * Name of the original author:------
		 *
		 * Description of the Method: Este método se encarga de leer el fichero,
		 * separar los datos, introducirlo en un array de Estaciones, cada una
		 * con su ID INICIO y su ID FIN, y más elementos que necesitamos. A
		 * continuación retira las que cuya duración es superior a 300, luego
		 * nos quedariamos con las que son menores o iguales de 300. Seguido,
		 * eliminamos las que están repetidas. Y a la vez que va haciendo esto
		 * último va creando el grafo. Una vez terminado todo lo descrito
		 * anteriormente nos muestra cierta información, como la el número de
		 * aristas, el número de estaciones finales y el números de vertices.
		 * 
		 * Calling arguments:------
		 * 
		 * Return value: Este método no devuelve ningún valor.
		 *
		 * Required Files: Este método requiere que se introduzca un fichero
		 * para poder leerlo e introducir los datos en el array
		 *
		 * List of Checked Exceptions: (a)throws IOException
		 *
		 ********************************************************************************************************************************************************************************************************/

		grafo = new TreeMapGraph<>();
		contador = 0;
		FileReader f = new FileReader(archivo);
		BufferedReader q = new BufferedReader(f);
		while ((cadena = q.readLine()) != null) {
			contador++;
		}
		q.close();

		FileReader Fichero = new FileReader(archivo);
		Scanner b = new Scanner(Fichero);
		

		String ID_Inicio;
		String duracion;
		String ID_Final;
		String Latitud_Inicio;
		String Latitud_Final;
		boolean existe_Inicio;
		boolean existe_FIN;
		boolean visita = true;
		int cont = 1;
		int z;
		int c = 0;
		int p = 0;
		int indice_ini;
		int indice_fin;
		int aristas = 0;

		b.nextLine();

		do {

			cadena = b.nextLine();

			if (cont == 1) {
				cont++;
				String array[] = cadena.split(",");

				duracion = array[1];
				ID_Inicio = array[4];
				Latitud_Inicio = array[5];
				ID_Final = array[7];
				Latitud_Final = array[8];

				if (ID_Inicio.equals(ID_Final)) {

					estaciones[c] = new Estacion(ID_Inicio, Latitud_Inicio);
					estaciones[c].setVisited(visita);
					estacion[p] = new ElementoDecorado(ID_Inicio, estaciones[c]);
					estacion[p].setVisitado(false);

					c++;
					p++;

				} else {

					estaciones[c] = new Estacion(ID_Inicio, Latitud_Inicio);
					estaciones[c].setVisited(visita);
					estacion[p] = new ElementoDecorado(ID_Inicio, estaciones[c]);
					c++;
					p++;
					estaciones[c] = new Estacion(ID_Final, Latitud_Final);
					estaciones[c].setVisited(visita);
					estacion[p] = new ElementoDecorado(ID_Final, estaciones[c]);
					grafo.insertEdge(estacion[p--], estacion[p]);
					aristas++;
					c++;
					p++;
				}

			} else if (cont < contador) {

				cont++;
				String array1[] = cadena.split(",");
				duracion = array1[1];
				ID_Inicio = array1[4];
				Latitud_Inicio = array1[5];
				ID_Final = array1[7];
				Latitud_Final = array1[8];

				int tiempo = Integer.parseInt(duracion);

				if (tiempo > 300 || (ID_Inicio.equals(ID_Final))) {

					continue;

				} else {

					int INI = Integer.parseInt(ID_Inicio);

					int FINI = Integer.parseInt(ID_Final);

					existe_Inicio = encontrar_estacion_igual(INI);
					existe_FIN = encontrar_estacion_igual(FINI);

					if (existe_Inicio == false && existe_FIN == false) {

						estaciones[c] = new Estacion(ID_Inicio, Latitud_Inicio);
						estaciones[c].setVisited(visita);
						estacion[p] = new ElementoDecorado(ID_Inicio, estaciones[c]);
						aux1 = grafo.insertVertex(estacion[p]);
						c++;
						p++;
						estaciones[c] = new Estacion(ID_Final, Latitud_Final);
						estaciones[c].setVisited(visita);
						estacion[p] = new ElementoDecorado(ID_Final, estaciones[c]);
						aux2 = grafo.insertVertex(estacion[p]);
						estacion[p].setVisitado(false);
						z = p - 1;

						if (!grafo.areAdjacent(aux1, aux2)) {
							grafo.insertEdge(estacion[z], estacion[p]);
							c++;
							p++;
							aristas++;
						}

					} else if (existe_Inicio == true && existe_FIN == true) {

						indice_ini = buscar_indice(ID_Inicio);
						indice_fin = buscar_indice(ID_Final);

						aux1 = grafo.insertVertex(estacion[indice_ini]);
						aux2 = grafo.insertVertex(estacion[indice_fin]);
						if (!grafo.areAdjacent(aux1, aux2)) {
							grafo.insertEdge(estacion[indice_ini], estacion[indice_fin]);
							aristas++;
						}

					} else if (existe_Inicio == false && existe_FIN == true) {

						estaciones[c] = new Estacion(ID_Inicio, Latitud_Inicio);
						estaciones[c].setVisited(visita);
						estacion[p] = new ElementoDecorado(ID_Inicio, estaciones[c]);
						aux1 = grafo.insertVertex(estacion[p]);
						indice_fin = buscar_indice(ID_Final);
						aux2 = grafo.insertVertex(estacion[indice_fin]);
						if (!grafo.areAdjacent(aux1, aux2)) {
							grafo.insertEdge(estacion[p], estacion[indice_fin]);
							c++;
							p++;
							aristas++;
						}

					} else if (existe_Inicio = true && existe_FIN == false) {

						estaciones[c] = new Estacion(ID_Final, Latitud_Inicio);
						estaciones[c].setVisited(visita);
						estacion[p] = new ElementoDecorado(ID_Final, estaciones[c]);
						aux1 = grafo.insertVertex(estacion[p]);

						indice_ini = buscar_indice(ID_Inicio);
						aux2 = grafo.insertVertex(estacion[indice_ini]);
						if (!grafo.areAdjacent(aux1, aux2)) {
							grafo.insertEdge(estacion[indice_ini], estacion[p]);
							aristas++;
							c++;
							p++;
						}
					}

				}
			}
		} while (b.hasNext());
		int con = 0;
		for (int i = 0; i < estaciones.length; i++) {
			if (estaciones[i] != null) {
				con++;
			}
		}
		System.out.println("Numero de estaciones :    " + con);
		int co = 0;

		for (int i = 0; i < estacion.length; i++) {
			if (estacion[i] != null) {
				co++;
			}
		}
		System.out.println("Numero de vertices :      " + co);
		System.out.println("Numero de aristas :       " + aristas);
		return aristas;
	}

	public boolean encontrar_estacion_igual(int ID) {
		/******************************************************************************************************************************************************************************************************
		 *
		 * Method name: encontrar_estacion_igual()
		 *
		 * Name of the original author:------
		 *
		 * Description of the Method: Utilizando el ID que introducimos, recorre
		 * todo el aaray buscando si ya existe o no. Si existe devuelve un true,
		 * y si no existe devuelve un false.
		 *
		 * Calling arguments:------
		 * 
		 * Return value: Este método devuelve o un true o un false, dependiendo
		 * del caso.
		 *
		 * Required Files: Este método requiere que se introduzca un ID de una
		 * estación
		 *
		 * List of Checked Exceptions:------
		 * 
		 *
		 ********************************************************************************************************************************************************************************************************/

		int M = 0;
		String g;
		int id;
		int cont = 0;
		for (int i = 0; i < estaciones.length; i++) {
			if (estacion[i] != null) {
				cont++;
			}
		}

		for (M = 0; M < cont; M++) {

			g = estaciones[M].getID();

			id = Integer.parseInt(g);

			if ((id == ID) && (estaciones[M].getVisited() == true)) {

				return true;

			} else if ((id == ID) && (estaciones[M].getVisited() == false)) {

				return false;

			} else {

				continue;
			}
		}
		return false;
	}

	public int buscar_indice(String ID) {
		/******************************************************************************************************************************************************************************************************
		 *
		 * Method name: buscar_indice()
		 *
		 * Name of the original author:------
		 *
		 * Description of the Method: Tal y como dice el nombre, emplea el dato
		 * introducido, recorre el array y si lo encuentra devuelve el dato que
		 * se busca, sino lo encuentra sigue recorriendo el array.
		 *
		 * Calling arguments:------
		 * 
		 * Return value: Este método devuelve el valor que se solicita.
		 *
		 * Required Files: Este método requiere que se introduzca un fichero
		 * para poder leerlo e introducir los datos en el array
		 *
		 * List of Checked Exceptions:------
		 *
		 ********************************************************************************************************************************************************************************************************/

		int M = 0;
		int cont = 0;

		for (int i = 0; i < estaciones.length; i++) {
			if (estacion[i] != null) {
				cont++;
			}
		}

		for (M = 0; M < cont; M++) {
			if (ID.equals(estacion[M].getID())) {
				return M;
			} else {
				continue;
			}
		}
		return 0;
	}

	public void Pintar_Grafo() {
		/******************************************************************************************************************************************************************************************************
		 *
		 * Method name: Pintar_Grafo()
		 *
		 * Name of the original author:------
		 *
		 * Description of the Method: Este método se encarga de buscar los
		 * vertices y las aristas. Mete los vertices en un array, y con este
		 * array y un stack, y así muestra una estación por línea y, a la
		 * derecha de esta, la lista de estaciones con la que esta se encuentra
		 * conectada mediante trayectos directos
		 *
		 * Calling arguments:------
		 * 
		 * Return value: Este método no devuelve ningún valor.
		 *
		 * Required Files: ------
		 *
		 * List of Checked Exceptions:------
		 *
		 ********************************************************************************************************************************************************************************************************/

		Stack<String> stack;
		viaje[] prueba = new viaje[aristas];
		;
		prueba = new viaje[aristas];
		stack = new Stack();
		Vertex[] v;
		Iterator<Edge> ite;
		ite = grafo.getEdges();

		
		for (int i = 0; i < prueba.length; i++) {
			while (ite.hasNext()) {
				v = grafo.endVertices(ite.next());
				prueba[i] = new viaje(v[0].getElement().toString(), v[1].getElement().toString());
				i++;
			}
		}

		for (int j = 0; j < prueba.length; j++) {
			if (stack.isEmpty()) {
				stack.push(prueba[j].getidini());
				System.out.print(prueba[j]);

			} else if (stack.peek().equals(prueba[j].getidini())) {
				System.out.print(", " + prueba[j].getidfin());

			} else {
				stack.push(prueba[j].getidini());
				System.out.print("\n" + prueba[j]);

			}
		}

	}

	public void Camino_Corto() {

		/******************************************************************************************************************************************************************************************************
		 *
		 * Method name: camino_corto()
		 *
		 * Name of the original author:------
		 *
		 * Description of the Method:
		 *
		 * Calling arguments:------
		 * 
		 * Return value: Este método no devuelve ningún valor.
		 *
		 * Required Files: Este método muestra el camino mas corto entre dos
		 * estaciones
		 *
		 * List of Checked Exceptions:------
		 *
		 ********************************************************************************************************************************************************************************************************/
		boolean B1 = true, B2 = true;
		Iterator<Vertex<ElementoDecorado>> iterator;
		Stack<ElementoDecorado> Stack = new Stack();
		Vertex<ElementoDecorado> aux, X = null, Y = null;
		ElementoDecorado nodo, node = null, INICIO, FIN;
		int size;
		String A;
		String B;
		int O;
		int D;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("DIGA ID ORIGEN: ");
		A = sc.next();
		O = buscar_indice(A);
		System.out.print("DIGA ID DESTINO: ");
		B = sc.next();
		D = buscar_indice(B);

		INICIO = estacion[O];
		FIN = estacion[D];
		iterator= grafo.getVertices();

		
		while (iterator.hasNext() && (B1 || B2)) {
			
			aux = iterator.next();
			nodo = aux.getElement();
			
			if (nodo.equals(INICIO)) {
				X = aux;
				B1 = false;
			}
			
			if (nodo.equals( FIN)) {
				Y = aux;
				B2 = false;
			}
		}
		
		if (!(B1 || B2)) {
			
			node = pathBFS(X, Y);

			if (node.getParent() == null) {
				
				System.out.println("\nNO HAY CAMINO");
			
			} else {
				
				System.out.println("\nCamino");
				
				while (node.getParent() != null) {
					Stack.push(node);
					node = node.getParent();
				}
				
				Stack.push(node);

				size = Stack.size();
				
				for (int i = 0; i < size - 1; i++) {
					
					node = Stack.pop();
					System.out.print(node.getElement().toString() + "(" + node.getDistance() + ")" + "-");
				
				}
				
				node = Stack.pop();
				System.out.print(node.getElement().toString() + "(" + node.getDistance() + ")");
			}
			
		} else {
			
			System.out.println("\n NO ESTA ");
		}
	}

	public ElementoDecorado pathBFS(Vertex<ElementoDecorado> s, Vertex<ElementoDecorado> t) {
		/******************************************************************************************************************************************************************************************************
		 *
		 * Method name: camino_corto()
		 *
		 * Name of the original author:------
		 *
		 * Description of the Method:
		 *
		 * Calling arguments:------
		 * 
		 * Return value: Este método devuelve un nodo
		 *
		 * Required Files: Este método muestra ls nodos existentes entre dos
		 * vertices que se le pasan
		 *
		 * List of Checked Exceptions:------
		 *
		 ********************************************************************************************************************************************************************************************************/

		Queue<Vertex<ElementoDecorado>> q = new LinkedList();
		s.getElement().setVisitado(true);
		Edge Arista;
		Iterator<Edge> iterator;
		q.offer(s);
		Vertex<ElementoDecorado> x, y = null;
		boolean FIN = true;

		while (!q.isEmpty() && FIN) {
			x = q.poll();
			
			iterator = grafo.incidentEdges(x);
			
			while (iterator.hasNext() && FIN) {
				
				Arista = iterator.next();
				
				y = grafo.opposite(x, Arista);
				
				if (!(y.getElement()).getVisited()) {
					(y.getElement()).setVisitado(true);
					
					(y.getElement()).setParent(x.getElement());
					
					(y.getElement()).setDistance(((x.getElement()).getDistance()) + 1);
					
					q.offer(y);
					
					FIN = !(y.getElement().equals(t.getElement()));
				}
			}
		}
		if (FIN)
			
			y.getElement().setParent(null);
		
		return y.getElement();
	}

}
