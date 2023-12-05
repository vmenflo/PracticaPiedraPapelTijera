/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Juego;

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 *
 * @author victor
 */
public class JuegoPPTVictorMenaFlores {

    public static void main(String[] args) {

        // Bucle principal para controlar si continuar en el juego o salir
        Scanner teclado = new Scanner(System.in);
        Random numAleatorio = new Random();
        // Crea el objeto para leer los datos de entrada

        //Texto Menu Inicial
        String menu = """
                      --------------------------------------
                      Bienvenido a Piedra, Papel y Tijeras.
                      ¿Qué desea hacer?, indique 1, 2 o 3. 
                            1 - Dos jugadores
                            2 - Vs yo
                            3 - Salir
                      
                      --------------------------------------
                      """;
        int opcionMenu = 0;
        final int RONDAS = 5;
        do {

            // Excepcion para controlar el JOptionPane
            boolean validoValores = false;
            // Bucle para controlar la excepcion y que solo se admita 1 2 o 3
            do {

                try {
                    opcionMenu = Integer.parseInt(
                            JOptionPane.showInputDialog(menu));
                    validoValores = true;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showConfirmDialog(null,
                            "No has introducido un número entero.");
                }
            } while (!validoValores | opcionMenu < 1 || opcionMenu > 3);

            switch (opcionMenu) {

                case 1 -> {
                    System.out.println("Has seleccionado DOS JUGADORES");
                    System.out.println("¿Cómo se llama el jugador 1?");
                    String nombreJugadorUno = teclado.nextLine();
                    System.out.println("¿Cómo se llama el jugador 2?");
                    String nombreJugadorDos = teclado.nextLine();

                    System.out.println("Lanzamos el dado para ver "
                            + "quien empieza");
                    int quienEmpieza = numAleatorio.nextInt(1, 2);
                    String primerJugador;
                    String segundoJugador;
                    if (quienEmpieza == 1) {
                        primerJugador = nombreJugadorUno;
                        segundoJugador = nombreJugadorDos;
                    } else {
                        primerJugador = nombreJugadorDos;
                        segundoJugador = nombreJugadorUno;
                    }
                    System.out.println("Ha salido : " + quienEmpieza
                            + " empieza: " + primerJugador);

                    int puntosJugadorUno = 0; // La cuenta del uno
                    int puntosJugadorDos = 0; // La cuenta del dos

                    for (int i = 1; i <= RONDAS; i++) { // Bucle para controlar
                        // las rondas
                        
                       // Pedimos que elija
                        System.out.println(primerJugador + " Elige Piedra"
                                + " / Papel / Tijera ");
                        String eleccionPrimerJugador = teclado.nextLine();

                        // Pedimos que elija el segundo jugador
                        System.out.println(segundoJugador + " Elige Piedra"
                                + " / Papel / Tijera ");
                        String eleccionSegundoJugador = teclado.nextLine();
                        
                        
                        // Tiejra con piedra y piedra con Tijera
                        if ((eleccionPrimerJugador.equalsIgnoreCase(
                                "piedra"))
                                && (eleccionSegundoJugador.equalsIgnoreCase(
                                        "tijera"))) {
                            System.out.println("Esta la gana " + primerJugador);
                            puntosJugadorUno += 1;
                        } else if ((eleccionPrimerJugador.equalsIgnoreCase(
                                "tijera"))
                                && (eleccionSegundoJugador.equalsIgnoreCase(
                                        "piedra"))) {
                            System.out.println("Esta la gana :" + segundoJugador);
                            puntosJugadorDos += 1;
                        }
                        // piedra con papel y papel con piedra
                        if ((eleccionPrimerJugador.equalsIgnoreCase(
                                "piedra"))
                                && (eleccionSegundoJugador.equalsIgnoreCase(
                                        "papel"))) {
                            System.out.println("Esta la gana :" + segundoJugador);
                            puntosJugadorDos += 1;
                        } else if ((eleccionPrimerJugador.equalsIgnoreCase(
                                "papel"))
                                && (eleccionSegundoJugador.equalsIgnoreCase(
                                        "piedra"))) {
                            System.out.println("Esta la gana : " + primerJugador);
                            puntosJugadorUno += 1;
                        }
                        // tijera con papel y papel con tijera
                        if ((eleccionPrimerJugador.equalsIgnoreCase(
                                "tijera"))
                                && (eleccionSegundoJugador.equalsIgnoreCase(
                                        "papel"))) {
                            System.out.println("Esta la gana : " + primerJugador);
                            puntosJugadorUno += 1;
                        } else if ((eleccionPrimerJugador.equalsIgnoreCase(
                                "papel"))
                                && (eleccionSegundoJugador.equalsIgnoreCase(
                                        "tijera"))) {
                            System.out.println("Esta la gana : " + segundoJugador);
                            puntosJugadorDos += 1;
                        }
                        // En caso de empate
                        if (eleccionPrimerJugador.equalsIgnoreCase(eleccionSegundoJugador)) {
                            System.out.println("Oh no! se ha producido un empate");
                            puntosJugadorUno += 0;
                            puntosJugadorDos += 0;
                            i -= 1;
                            
                        }
                        
                        if ((puntosJugadorUno == 3) || (puntosJugadorDos == 3)) {break;}

                    }
                    System.out.println("La partida ha quedado así : "
                            + puntosJugadorUno + " para " + primerJugador
                            + " y " + puntosJugadorDos + " para " + segundoJugador);

                    // Esto es cuando gana el uno
                    if (puntosJugadorUno > puntosJugadorDos) {
                        System.out.println("FELICIDADES!! " + primerJugador
                                + " has ganado la partida");
                        // Esto es cuando gana el dos
                    } else if (puntosJugadorUno < puntosJugadorDos) {
                        System.out.println("FELICIDADES!! " + segundoJugador
                                + " has ganado la partida");
                        // Esto es cuando empatan
                    } else if (puntosJugadorUno == puntosJugadorDos) {
                        System.out.println("VAYA! parece que los dos "
                                + "sois igual de malos. Probad a echar otra para"
                                + " desempatar");
                    }
                }
                // Caso para cuando elige jugador vs maquina
                case 2 -> {
                    System.out.println("Has elegido vs YO.");
                    // Pido el nombre
                    System.out.println("¿Cómo te llamas?");
                    String nombreJugador = teclado.nextLine();

                    System.out.println("Bien. " + nombreJugador + " comencemos");

                    int puntosJugador = 0;
                    int puntosMaquina = 0;

                    for (int i = 1; i <= 5; i++) {
                            String eleccionJugador;
                            System.out.println("Piedra, papel o tijera."
                                        + " Una, dos y tres..");
                            eleccionJugador = teclado.nextLine();
                                
                            int eleccionMaquinaNum = numAleatorio.nextInt(1, 4);
                            String eleccionMaquina = "";
                            if (eleccionMaquinaNum == 1) {
                                    eleccionMaquina = "tijera";
                            } else if (eleccionMaquinaNum == 2) {
                                    eleccionMaquina = "papel";
                            } else {
                                    eleccionMaquina = "piedra";
                            }
                                
                            System.out.println("Yo he eledigo: " 
                                        + eleccionMaquina);
                            // Piedra con tijera y tijera con piedra
                            if ((eleccionJugador.equalsIgnoreCase(
                                        "piedra"))
                                        && (eleccionMaquina.equalsIgnoreCase(
                                                "tijera"))) {
                                    System.out.println("Esta la gana " + nombreJugador);
                                    puntosJugador += 1;
                            } else if ((eleccionJugador.equalsIgnoreCase(
                                        "tijera"))
                                        && (eleccionMaquina.equalsIgnoreCase(
                                                "piedra"))) {
                             System.out.println("Esta la gana yo");
                                    puntosMaquina += 1;
                            }
                            // piedra con papel y papel con piedra
                            if ((eleccionJugador.equalsIgnoreCase(
                                        "piedra"))
                                        && (eleccionMaquina.equalsIgnoreCase(
                                                "papel"))) {
                                    System.out.println("Esta la gana yo");
                                    puntosMaquina += 1;
                            } else if ((eleccionJugador.equalsIgnoreCase(
                                        "papel"))
                                        && (eleccionMaquina.equalsIgnoreCase(
                                                "piedra"))) {
                                    System.out.println("Esta la gana : " + nombreJugador);
                                    puntosJugador += 1;
                            }
                            // tijera con papel y papel con tijera
                            if ((eleccionJugador.equalsIgnoreCase(
                                        "tijera"))
                                        && (eleccionMaquina.equalsIgnoreCase(
                                                "papel"))) {
                                    System.out.println("Esta la gana : " + nombreJugador);
                                    puntosJugador += 1;
                            } else if ((eleccionJugador.equalsIgnoreCase(
                                        "papel"))
                                        && (eleccionMaquina.equalsIgnoreCase(
                                                "tijera"))) {
                                    System.out.println("Esta la gana : Yo");
                                    puntosMaquina += 1;
                            }
                            // En caso de empate
                            if (eleccionJugador.equalsIgnoreCase(eleccionMaquina)) {
                                    System.out.println("Vaya! se ha producido un empate");
                                    puntosJugador += 0;
                                    puntosMaquina += 0;
                                    i-=1;
                                }
                            
                            if ((puntosJugador == 3) || (puntosMaquina == 3)) {break;}

                            }
                            System.out.println("Los puntos quedan así: "
                                    + puntosJugador + " para "
                                    + nombreJugador + " y " + puntosMaquina
                                    + " para mi.");
                            if (puntosJugador > puntosMaquina) {
                        System.out.println("FELICIDADES!! " + nombreJugador
                                + " has ganado la partida");
                        // Esto es cuando gana el dos
                    } else if (puntosJugador < puntosMaquina) {
                        System.out.println("Lo siento, esta partida es mía. !! ");
                       
                    }
                }

            }

        } while (opcionMenu != 3);

        JOptionPane.showMessageDialog(null, "Hasta Pronto!!");
    }
}

