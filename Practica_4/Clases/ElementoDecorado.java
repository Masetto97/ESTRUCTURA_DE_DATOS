package Grafo;
/*******************************************************************************************************************************************************
*
* Class Name: ElementoDecorado
* Author/s name: Eduardo Mora Gonzalez y Lucia Rosa Alonso
* Release/Creation date: 17/12/2016
* Class version: 1.0 
* Class description:Clase creada para definir a un elemento decorado. 
* Además de los metodos para cambiar, obtener y mostrar la información de lo atributos.
*
********************************************************************************************************************************************************
*/
import graphsDSESIUCLM.*;

public class ElementoDecorado<T> implements Element {

	private String id;

	private T estacion;

	private ElementoDecorado<T> parent;

	private int distance;

	private boolean visitado;

	public ElementoDecorado(String id, T estacion) {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: Estacion()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método es el constructor, el cual nos proporciona un valor para cada atributo
		*
		* Calling arguments:------
		* 
		* Return value: Este método no devuelve ningún valor.
		*
		* Required Files:---------------- 
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/


		this.id = id;

		this.estacion = estacion;

		parent = null;

		distance = 0;

		this.visitado = false;
	}

	public ElementoDecorado<T> getParent() {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: getParent()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método nos proporciona el vertice antecesor
		*
		* Calling arguments:------
		* 
		* Return value: Este método devuelve el valor del vertice antecesor
		*
		* Required Files:---------------- 
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/
		
		return parent;
	}

	public void setParent(ElementoDecorado<T> u) {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: setParent()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método nos modifica el vertice antecesor
		*
		* Calling arguments:------
		* 
		* Return value: Este método no devuelve ningun valor
		*
		* Required Files:Requiere que se introduzca un elemento decorado
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/
		
		parent = u;
	}

	public String getID() {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: getID()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método nos proporciona el valor del ID
		*
		* Calling arguments:------
		* 
		* Return value: Este método devuelve el valor del ID
		*
		* Required Files:---------------- 
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/


		return id;
	}

	public boolean getVisited() {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: getVisited()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método nos proporciona si esta visitado o no
		*
		* Calling arguments:------
		* 
		* Return value: Este método devuelve el valor boolean visited
		*
		* Required Files:---------------- 
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/


		return this.visitado;
	}

	public void setVisitado(boolean visitado) {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: setVisited()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método nos cambia el valor de si es visitado o no
		*
		* Calling arguments:------
		* 
		* Return value: Este método no devuelve nada
		*
		* Required Files: Requiere que se introduzca un boolean true o false
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/


		this.visitado = visitado;
	}

	public T getElement() {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: getElement()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método nos proporciona un elemento decorado
		*
		* Calling arguments:------
		* 
		* Return value: Este método devuelve un elemento decorado
		*
		* Required Files:---------------- 
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/

		
		return estacion;
	}

	public String toString() {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: toString()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método nos escribe el ID del elemento
		*
		* Calling arguments:------
		* 
		* Return value: Este método devuelve una frase
		*
		* Required Files:---------------- 
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/
	

		return estacion.toString();

	}

	public int getDistance() {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: getDistance()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método nos proporciona una distancia
		*
		* Calling arguments:------
		* 
		* Return value: Este método devuelve un int con la distancia desde el origen
		*
		* Required Files:---------------- 
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/

		
		return distance;
	}

	public void setDistance(int d) {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: setVisited()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método nos cambia el valor de la distancia
		*
		* Calling arguments:------
		* 
		* Return value: Este método no devuelve nada
		*
		* Required Files: Requiere que se introduzca un int
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/

		distance = d;
	}

}
