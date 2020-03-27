package Grafo;
/*******************************************************************************************************************************************************
*
* Class Name: Estacion
* Author/s name: Eduardo Mora Gonzalez y Lucia Rosa Alonso
* Release/Creation date: 17/12/2016
* Class version: 1.0 
* Class description:Clase creada para definir a un estacion, en la cual se le asigna un ID y una latitud. 
* Además de los metodos para cambiar, obtener y mostrar la información de lo atributos.
*
********************************************************************************************************************************************************
*/

public class Estacion {

	String ID;
	
	String Latitud_Inicio;

	private boolean visited=false;

	public Estacion(String id,String Latitud_Inicio) {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: Estacion()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método es el constructor, el cual nos proporciona un ID y una latitud
		*
		* Calling arguments:------
		* 
		* Return value: Este método no devuelve ningún valor.
		*
		* Required Files:---------------- 
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/


		this.ID = id;
		this.Latitud_Inicio=Latitud_Inicio;

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


		return ID;
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


		return visited;
	}
	
	public void setVisited(boolean v){
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

		visited=v;	
	}
	
	
	public String toString() {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: toString()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método nos escribe el ID y la latitud de la estacion
		*
		* Calling arguments:------
		* 
		* Return value: Este método devuelve una frase
		*
		* Required Files:---------------- 
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/
		
		return  "ID :  " + getID() +" Latitud: "+Latitud_Inicio;

	}
}