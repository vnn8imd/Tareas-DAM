Algoritmo Estructuras_cíclicas_1
	
	//Definimos variable
	//Anidamos valor del número
	
	Definir n Como Real;
	n=0
	
	//Pedimos por pantalla valor
	
	Escribir "Escribe numero";
	Leer n	
	
	//Condicionamos dependiendo del valor introducido; 
	//Si es mayor a cero, escribe que el número es mayor a 0, sino mira si el número es igual a cero y sino lo es escribe que es menor de 0.
	
			Si n>0 Entonces
				Escribir "El número es mayor a 0";
			SiNo
				Si n=0 Entonces
					Escribir "El número es 0";
				SiNo
					Escribir "El número es menor de 0";
					
		FinSi
	FinSi
	
FinAlgoritmo
