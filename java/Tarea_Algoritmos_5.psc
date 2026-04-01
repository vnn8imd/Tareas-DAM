Algoritmo Tarea_Algoritmo_5
	  
	//Se pide por pantalla el importe de un artículo, y se calcula su precio con iva (21%).
	
	//Defino variables y Asigno variables
	
	Definir base_imponible Como Real;
	Definir porcentaje_IVA Como Entero;
	Definir imp_IVA como Real;
	Definir total_art Como Real;
	
	//Pedimos por pantalla valores
	
	Escribir "Teclea importe de un articulo";
	Leer base_imponible
	
	//Cálculo importe de IVA sumado a la base imponible
	
	Escribir (base_imponible * 0.21) + base_imponible
	
	////CONSULTAR CON SARA COMO SE PUEDE ASIGNAR LA VARIABLE porcentaje_IVA QUE ES 0,21 SIN TENER QUE PONERLO MANUALMENTE EN LA FORMULA.
	
FinAlgoritmo
