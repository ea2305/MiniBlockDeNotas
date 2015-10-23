/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microblockdenotas;

/**
* Simulacion de una Pila con caracteres
* @author Elihu Alejandro Cruz Albores
* @version 1.3
*/

public class PilaChar{

	private char Pila [];
	private int tope;
	
	/**
	*	Metodo Constructor
	* @param Valor entero : capacidad 
	*/
	public PilaChar(int capacidad){

		Pila = new char[capacidad];
		this.tope = 0;
	}	

	/**
	* Metodo Push de la pila
	* @param Variable tipo Char : A
	*/
	public void Push(char A){

		if((tope + 1) < this.Pila.length)
			Pila[tope++] = A;
	}

	/**
	* Metodo pop de la pila
	*@return Variable tipo char : Pila
	*/
	public char Pop(){

		if(isEmpty())
			return 0;

		return Pila[tope--];
	}

	public char Peek(){

		if(isEmpty())
			return 0;

		return Pila[tope-1];
	}


	/**
	*-validador de tope
	* @return booleano 
	*/
	public boolean isEmpty(){
		return tope == -1;
	}

	/**
	* Datos de la pila en String
	* @return String con datos de la pila
	*/
	public String toString(){
		return new String(Pila,0,tope + 1);
	}

	/**
	* Obtiene el numero de elementos en la pila
	* @return valor entero : tope
	*/
	public int numberOfElements(){
		return this.tope;
	}
}