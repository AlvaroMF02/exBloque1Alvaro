package prueba;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alvaro
 */
public class Margaritas {

    public static void main(String[] args) {
        //VARIABLES
        String seguirJugando;
        int cantidadMarg;
        int petalosMarg;
        int numDado;
        boolean asigDado;
        String valorPetalo;

        //BUCLE PARA LA SALIDA DEL PROGRAMA
        do {

            cantidadMarg = numMargaritas();

            //CANTIDAD DE PETALOS EN CADA MARGARITA
            for (int i = 1; i < cantidadMarg + 1; i++) {
                //CANTIDAD DE PETALOS EN CADA MARGARITA
                petalosMarg = petalosMargarita(i);

                //NUMERO DEL DADO
                numDado = tiradaDado();

                //ASIGNACION DEL NUMERO QUE HA SALIDO
                asigDado = salidaDado(numDado);

                //ASIGNACION DE EL VALOR QUE TIENE EL DADO
                if (asigDado == true) {
                    valorPetalo = "<< ME QUIERE >>";
                } else {
                    valorPetalo = "<< NO ME QUIERE >>";
                }

                //SWITCH CON LA SALIDA DIFERENCIANDO DEL PRIMER VALOR DEL DADO
                switch (valorPetalo) {

                    case "<< ME QUIERE >>" -> { //SI TE QUIERE Y ES PAR NO TE QUIERE
                        if (petalosMarg % 2 == 0) {
                            System.out.println("LA MARGARITA TIENE " + petalosMarg + " HOJAS,\n"
                                    + "ROMEO SACÓ " + numDado + " EN EL DADO, \nEMPEZO A QUITAR "
                                    + "HOJAS CON " + valorPetalo + ", \nY EL RESULTADO "
                                    + "FINAL ES QUE NO LE QUIERE\n");

                        } else if (petalosMarg % 2 != 0) { //SI TE QUIERE Y ES IMPAR TE QUIERE
                            System.out.println("LA MARGARITA TIENE " + petalosMarg + " HOJAS,\n"
                                    + "ROMEO SACÓ " + numDado + " EN EL DADO, \nEMPEZO A QUITAR "
                                    + "HOJAS CON " + valorPetalo + ", \nY EL RESULTADO "
                                    + "FINAL ES QUE LE QUIERE\n");
                        }
                    }

                    case "<< NO ME QUIERE >>" -> {  //SI NO TE QUIERE Y ES PAR TE QUIERE
                        if (petalosMarg % 2 == 0) {
                            System.out.println("LA MARGARITA TIENE " + petalosMarg + " HOJAS,\n"
                                    + "ROMEO SACÓ " + numDado + " EN EL DADO, \nEMPEZO A QUITAR "
                                    + "HOJAS CON " + valorPetalo + ", \nY EL RESULTADO "
                                    + "FINAL ES QUE LE QUIERE\n");

                        } else if (petalosMarg % 2 != 0) {  //SI NO TE QUIERE Y ES IMPAR NO TE QUIERE
                            System.out.println("LA MARGARITA TIENE " + petalosMarg + " HOJAS,\n"
                                    + "ROMEO SACÓ " + numDado + " EN EL DADO, \nEMPEZO A QUITAR "
                                    + "HOJAS CON " + valorPetalo + ", \nY EL RESULTADO "
                                    + "FINAL ES QUE NO LE QUIERE\n");
                        }
                    }

                }

            }

            //VARIABLE PARA VER SI SE REPITE EL PROGRAMA O NO
            seguirJugando = repeProg();

        } while (!seguirJugando.equalsIgnoreCase("no"));

    }

    private static Scanner teclado = new Scanner(System.in);
    private static Random alea = new Random();

    //METODO PARA PREGUNTAR EL NUMERO DE MARGARITAS QUE VA A DESHOJAR
    public static int numMargaritas() {
        int numMarg = 0;
        boolean repetir = true;

        //FILTROS PARA QUE NO SE PUEDAN METER OTROS CARACTERES Y 
        //PARA QUE SEA ENTRE DOS NUMEROS
        do {
            do {
                try {
                    System.out.println("¿CUÁNTAS MARGARITAS VAS A DESHOJAR?");
                    numMarg = teclado.nextInt();

                    if (numMarg < 1 || numMarg > 10) {
                        System.out.println("## DEBES PONER DE 1 A 10 ##\n");
                    }

                    repetir = false;

                } catch (InputMismatchException ime) {
                    System.out.println("## DEBES ESCRIBIR UN NUMERO ##\n");
                    teclado.nextLine();
                }

            } while (repetir);

        } while (numMarg < 1 || numMarg > 10);

        return numMarg;
    }

    //PETALOS QUE HAY EN CADA MARGARITA
    public static int petalosMargarita(int numMargarita) {
        int petalos = 0;
        boolean repetir = true;

        //FILTROS PARA QUE NO SE PUEDAN METER OTROS CARACTERES Y 
        //PARA QUE SEA ENTRE DOS NUMEROS
        do {
            do {
                try {
                    System.out.println("¿CUANTOS PETALOS HAY EN LA " + numMargarita
                            + "º MARGARITA?");
                    petalos = teclado.nextInt();

                    if (petalos < 0) {
                        System.out.println("## NO PUEDE TENER PETALOS NEGATIVOS ##\n");
                    }

                    repetir = false;

                } catch (InputMismatchException ime) {
                    System.out.println("## DEBES ESCRIBIR UN NUMERO ##\n");
                    teclado.nextLine();
                }

            } while (repetir);

        } while (petalos < 0);

        return petalos;
    }

    //DEVUELVE EL NUMERO QUE HA SALIDO DEL DADO
    //SI ES 3 SE REPITE LA TIRADA HASTA QUE SALGA OTRO
    public static int tiradaDado() {
        int dado = 0;

        //BUCLE PARA QUE SE REPITA LA TIRADA SI SALE 3
        do {

            dado = alea.nextInt(1, 6 + 1);

            if (dado == 3) {

                System.out.println("SE REPITE TIRADA (HA SALIDO UN 3)");

            } else {
                System.out.println("HA SALIDO: " + dado + "\n");
            }
        } while (dado == 3);

        return dado;
    }

    //FILTRA EL NUMERO DEL DADO
    public static boolean salidaDado(int numDado) {
        boolean meQuiere;

        if (numDado % 2 == 0) {
            meQuiere = true;

        } else {
            meQuiere = false;
        }

        //SE PUEDE HACER ASÍ
        //meQuiere = numDado % 2 == 0;
        return meQuiere;
    }

    //REPETICION DEL PROGRAMA
    public static String repeProg() {
        String opcion;

        //LIMPIEZA BUFFER
        teclado.nextLine();

        //FILTRO PARA QUE SOLO SE PUEDA ESCRIBIR SI O NO
        do {

            System.out.println("\n¿QUIERES PROBAR OTRA VEZ?");
            opcion = teclado.nextLine();

            if (!opcion.equalsIgnoreCase("si")
                    && !opcion.equalsIgnoreCase("no")) {
                System.out.println("## ESCRIBE (SI) PARA REPETIR Y (NO) PARA SALIR ##");
            }

        } while (!opcion.equalsIgnoreCase("si")
                && !opcion.equalsIgnoreCase("no"));

        return opcion;
    }

}
