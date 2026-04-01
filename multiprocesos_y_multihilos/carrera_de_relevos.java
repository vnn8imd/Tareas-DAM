package com.digitech.carrera_de_relevos;

import java.util.Random;

class Corredor extends Thread {
    private final Object monitorEquipo;
    private final String nombreEquipo;
    private final int dorsal;
    private static int[] relevoActual = new int[7]; // Control para los 6 equipos

    public Corredor(Object monitor, String equipo, int dorsal, int idEquipo) {
        this.monitorEquipo = monitor;
        this.nombreEquipo = equipo;
        this.dorsal = dorsal;
        // El relevo 0 indica que el equipo está listo para empezar
    }

    @Override
    public void run() {
        synchronized (monitorEquipo) {
            try {
                // El corredor espera hasta que sea su turno (aleatorio según notify)
                // En este diseño, el primer notify en el Main arranca a uno al azar
                monitorEquipo.wait(); 

                // Simulación de carrera: entre 5 y 10 segundos [cite: 65]
                int tiempoCarrera = new Random().nextInt(6) + 5; 
                System.out.println("[" + nombreEquipo + "] Corredor #" + dorsal + " recibe el testigo y sale a correr...");
                
                Thread.sleep(tiempoCarrera * 1000); 

                System.out.println("[" + nombreEquipo + "] Corredor #" + dorsal + " llega a meta tras " + tiempoCarrera + "s.");

                // Entrega el testigo (despierta al siguiente hilo aleatorio) [cite: 63, 64]
                monitorEquipo.notify(); 

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Carrera_De_Relevos {
    public static void main(String[] args) {
        int numEquipos = 6; 
        int corredoresPorEquipo = 4; 

        System.out.println("--- ¡COMIENZA LA CARRERA DE RELEVOS! ---");

        for (int i = 1; i <= numEquipos; i++) {
            Object monitor = new Object(); // Objeto de sincronización único por equipo 
            String nombreEq = "Equipo " + i;

            for (int j = 1; j <= corredoresPorEquipo; j++) {
                new Corredor(monitor, nombreEq, j, i).start(); // Instancia los 24 hilos totales 
            }

            // Pequeña pausa para asegurar que los hilos estén en wait()
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            // El "juez" da la salida al primer corredor de cada equipo
            synchronized (monitor) {
                monitor.notify(); 
            }
        }
    }
}