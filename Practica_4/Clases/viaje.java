package Grafo;
/*****************************************************************************************************************************************************************************
*
* Class Name: viaje
* Author/s name: Eduardo Mora Gonzalez y Lucia Rosa Alonso
* Release/Creation date: 17/12/2016
* Class version: 1.0 
* Class description:  Clase para describir los viajes
* 
******************************************************************************************************************************************************************************
*/
public class viaje {
	
	String idini;//id de la estacion de inicio del viaje
	String idfin;//id de la estacion de fin del viaje

	public viaje(String idini, String idfin) {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: viaje()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método es el constructor, el cual nos proporciona un ID inicio y otro de fin
		*
		* Calling arguments:------
		* 
		* Return value: Este método no devuelve ningún valor.
		*
		* Required Files:---------------- 
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/

		this.idini = idini;
		this.idfin = idfin;
	}

	public String getidini() {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: getidini()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método nos proporciona el valor del ID inicio
		*
		* Calling arguments:------
		* 
		* Return value: Este método devuelve el valor del ID inicio
		*
		* Required Files:---------------- 
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/
		return idini;

	}

	public String getidfin() {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: getidfin()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método nos proporciona el valor del ID fin
		*
		* Calling arguments:------
		* 
		* Return value: Este método devuelve el valor del ID fin
		*
		* Required Files:---------------- 
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/
		return idfin;

	}

	public String toString() {
		/******************************************************************************************************************************************************************************************************
		*
		* Method name: toString()
		*
		* Name of the original author:------
		*
		* Description of the Method: Este método nos escribe el ID inicio y el de fin
		*
		* Calling arguments:------
		* 
		* Return value: Este método devuelve una frase
		*
		* Required Files:---------------- 
		*
		* List of Checked Exceptions:----------------------------
		********************************************************************************************************************************************************************************************************/
		return getidini() + ", " + getidfin();
	}
}
