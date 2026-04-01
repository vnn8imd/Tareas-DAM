package com.digitech.mavenproject2;

import java.io.RandomAccessFile;
import java.io.IOException;

public class Tarea_complementaria_3_RandomAccessFile_conIndice {

    // --- FORMATO DE LOS REGISTROS ---
    private static final int RECORD_SIZE = 48;      // 4 + 40 + 4
    private static final int NAME_CHARS = 20;       // 20 chars = 40 bytes
    private static final int INDEX_ENTRY_SIZE = 12; // 4 + 8

    private static final String DAT_FILE = "personas.dat";
    private static final String IDX_FILE = "personas.idx";

    // --- Función para escribir nombre fijo de 20 chars ---
    private static void writeFixedString(RandomAccessFile raf, String s) throws IOException {
        StringBuilder sb = new StringBuilder(s);
        sb.setLength(NAME_CHARS);  // Rellena o recorta a 20 chars
        raf.writeChars(sb.toString());
    }

    // --- 1. Crear personas.dat respetando EXACTAMENTE los 48 bytes ---
    public static void crearArchivoDatos() {
        System.out.println("--- CREANDO personas.dat ---");

        try (RandomAccessFile raf = new RandomAccessFile(DAT_FILE, "rw")) {

            raf.setLength(0);

            // Registro 1
            raf.writeInt(101);
            writeFixedString(raf, "Ana");
            raf.writeInt(25);

            // Registro 2
            raf.writeInt(150);
            writeFixedString(raf, "Berto");
            raf.writeInt(30);

            // Registro 3
            raf.writeInt(310);
            writeFixedString(raf, "Carla");
            raf.writeInt(22);

            // Registro 4
            raf.writeInt(400);
            writeFixedString(raf, "David");
            raf.writeInt(40);

            System.out.println("Archivo creado con " + (raf.length() / RECORD_SIZE) + " registros.");
        } catch (IOException e) {
          System.err.println("Error: " + e.getMessage());
        }
    }

    // --- 2. Construir personas.idx ---
    public static void construirIndice() {
        System.out.println("\n--- CREANDO personas.idx ---");

        try (RandomAccessFile datRaf = new RandomAccessFile(DAT_FILE, "r");
             RandomAccessFile idxRaf = new RandomAccessFile(IDX_FILE, "rw")) {

            idxRaf.setLength(0);

            long offset = 0;
            long len = datRaf.length();

            while (offset < len) {
                datRaf.seek(offset);

                int id = datRaf.readInt();

                idxRaf.writeInt(id);
                idxRaf.writeLong(offset);

                System.out.printf("Indexando id=%d offset=%d\n", id, offset);

                offset += RECORD_SIZE;
            }

            System.out.println("Índice generado correctamente.");

        } catch (IOException e) {
          System.err.println("Error: " + e.getMessage());
        }
    }

    // --- 3. Buscar por ID utilizando el índice ---
    public static void buscarPersonaPorId(int idBuscado) {
        System.out.println("\n--- BUSCANDO id " + idBuscado + " ---");

        try (RandomAccessFile idxRaf = new RandomAccessFile(IDX_FILE, "r")) {

            long fileLength = idxRaf.length();
            long offset = -1;

            // Búsqueda lineal en personas.idx
            for (long pos = 0; pos < fileLength; pos += INDEX_ENTRY_SIZE) {
                idxRaf.seek(pos);

                int id = idxRaf.readInt();
                long registroOffset = idxRaf.readLong();

                if (id == idBuscado) {
                    offset = registroOffset;
                    break;
                }
            }

            // Si existe en el índice, ir directo al registro
            if (offset != -1) {
                try (RandomAccessFile datRaf = new RandomAccessFile(DAT_FILE, "r")) {
                    datRaf.seek(offset);

                    int id = datRaf.readInt();

                    char[] nombreChars = new char[NAME_CHARS];
                    for (int i = 0; i < NAME_CHARS; i++) {
                        nombreChars[i] = datRaf.readChar();
                    }
                    String nombre = new String(nombreChars).trim();

                    int edad = datRaf.readInt();

                    System.out.println("Registro encontrado:");
                    System.out.println("   ID: " + id);
                    System.out.println("   Nombre: " + nombre);
                    System.out.println("   Edad: " + edad);
                }
            } else {
                System.out.println("ID no encontrado.");
            }

        } catch (IOException e) {
          System.err.println("Error: " + e.getMessage());

        }
    }

    // --- MAIN ---
    public static void main(String[] args) {
        crearArchivoDatos();
        construirIndice();

        buscarPersonaPorId(101);
        buscarPersonaPorId(150);
        buscarPersonaPorId(480);
        buscarPersonaPorId(400);
        buscarPersonaPorId(999);
       }
}