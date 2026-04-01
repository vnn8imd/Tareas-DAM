Algoritmo entrada_datos
	
	//Defino variables y Asigno variables
	
	Definir nombre Como Caracter;
	Definir edad Como Entero;
	Definir n_horas_trabajadas,salario_x_horas, salario_neto Como Real;
	
	//Pedimos por pantalla valores
	
	Escribir "Escribe tu nombre";
	Leer nombre
	Escribir "Escribe tu edad";
	Leer edad
	Escribir "Escribe n_horas_trabajadas a la semana";
	Leer n_horas_trabajadas
	Escribir "Escribe el salario_x_horas que recibes";
	Leer salario_x_horas
	Escribir (n_horas_trabajadas*salario_x_horas)=salario_neto
	
	//Analizamos si calculamos el salario o no por la edad del usuario
	
	Si edad<18 Entonces
		Escribir "el usuario es menor de edad y no puede calcular el salario"
	SiNo
		Escribir "salario_neto";
	Fin Si
	
	
	
	
	
FinAlgoritmo
