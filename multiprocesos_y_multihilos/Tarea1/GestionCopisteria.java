/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.digitech.gestioncopisteria;

/**
 *
 * @author vnn8i
 */
  
import java.util.concurrent.Semaphore;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

//Se aplica buena práctica profesional utilizando un Logger oficial de Java.
//Restaura el estado de interrupción para que el sistema sepa que el hilo debe detenerse si se le solicita.

public class GestionCopisteria {

    // 1. Definimos la copistería con 3 fotocopiadoras usando un Semáforo 
    private static final int NUM_FOTOCOPIADORAS = 3;
    private static final Semaphore fotocopiadoras = new Semaphore(NUM_FOTOCOPIADORAS);
    private static final Random random = new Random();
    
    // Definimos el Logger para sustituir los printStackTrace()
    private static final Logger logger = Logger.getLogger(GestionCopisteria.class.getName());

    public static void main(String[] args) {
        // 2. Creamos 10 hilos (clientes) que accederán de forma aleatoria 
        for (int i = 1; i <= 10; i++) {
            Thread cliente = new Thread(new Cliente(i));
            cliente.start();
        }
    }

    static class Cliente implements Runnable {
        private final int id;

        public Cliente(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                System.out.println("Cliente " + id + " está esperando una fotocopiadora libre...");
                
                // El hilo intenta adquirir un permiso (usar una fotocopiadora) 
                fotocopiadoras.acquire();
                
                System.out.println(">>> Cliente " + id + " ha empezado a imprimir.");

                // 3. Simulación del tiempo de impresión: entre 5 y 15 segundos 
                int tiempoImpresion = (random.nextInt(11) + 5) * 1000; 
                Thread.sleep(tiempoImpresion);

                System.out.println("<<< Cliente " + id + " terminó de imprimir en " + (tiempoImpresion / 1000) + " segundos.");

            } catch (InterruptedException e) {
                // BUENA PRÁCTICA: Usar logger y restaurar la interrupción
                logger.log(Level.SEVERE, "El hilo del cliente {0} fue interrumpido", id);
                Thread.currentThread().interrupt(); 
            } finally {
                // 4. Al terminar, el hilo libera la fotocopiadora para que otro pueda usarla 
                System.out.println("Cliente " + id + " libera la fotocopiadora.");
                fotocopiadoras.release();
            }
        }
    }
}

