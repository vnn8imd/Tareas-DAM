Algoritmo Tarea_Algoritmo_8
	
	//Se piden dos números por pantalla. Al mayor se le multiplica por dos y se muestra su valor. 
	//Al menor se le divide entre 2 y se muestra su resultado. 
	
	//Defino variables y asigno variables
	
	Definir n1,n2 Como Real;
	Definir n_mayor Como Real;
	Definir n_menor Como Real;
		
	//Pedimos por pantalla valores
	
	Escribir "Escribe numero1";
	Leer n1
	
	Escribir "Escribe numero2";
	Leer n2
	
	Si n1>n2 Entonces
		Escribir "El número:", n1 , "es el mayor"
		Escribir "Multiplicamos por 2 el número mayor:", (n1 * 2)
	SiNo
		Escribir "El número:", n2, "es mayor"
		Escribir "Multiplicamos por 2 el número mayor:", (n2 * 2)
			
	Si n1<n2 Entonces
				Escribir "El número:", n1 , "es el menor"
				Escribir "Dividimos entre 2 el número menor:", (n1 / 2)
		Sino
			Escribir "El número:", n2 , "es el menor"
			Escribir "Dividimos entre 2 el número menor:", (n2 / 2)
			
		FinSi
	FinSi
	
FinAlgoritmo
