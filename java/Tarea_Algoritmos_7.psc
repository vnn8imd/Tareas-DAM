Algoritmo Tarea_Algoritmo_7
	
	//Con este algoritmo vamos a plantear si una venta tiene descuento o no. 
	//Si la venta supera los 100 euros, se aplicará un descuento del 2% y se mostrará el total de la venta. 
	
	//Defino variables y Asigno variables
	
	Definir importe_venta Como Real;
	Definir dto Como Real;
	Definir imp_dto Como Real;
	Definir total_venta Como Real;
	
	//Pedimos por pantalla importe de venta
	
	Escribir "importe_venta";
	Leer importe_venta
	
	//Condicionamos el descuento del 2 % si la venta es superior a 100 euros, sino lo es no aplica dto.
	
	Si importe_venta>100 Entonces	
		Escribir "Aplicar imp_dto:", (importe_venta * 0.02)
		Leer imp_dto
		Escribir "total_venta:", (importe_venta - imp_dto)
	SiNo
	    Escribir "no aplica dto:¡compras muy barato!"
		
	Fin si
	
	////CONSULTAR A SARA COMO PUEDO GUARDAR EL DATO DE imp_dto SIN TENER QUE PEDIR AL USUARIO QUE LO INTRODUZCA MANUALMENTE Y ASÍ 
	///SEGUIR CALCULANDO EL RESULTADO FINAL.
	
FinAlgoritmo