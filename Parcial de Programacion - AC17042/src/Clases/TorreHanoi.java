/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Ronald
 */
public class TorreHanoi {
        public static void Hanoi (int discos, int inicio, int auxiliar, int destino) {
        if (discos == 1){
            System.out.println("Mueve el disco de la torre " + inicio + " a la torre " + destino);
        }
        else {
            Hanoi (discos -1, inicio, destino, auxiliar);
            System.out.println("Mueve el disco de la torre " + inicio + " a la torre " + destino);
            Hanoi (discos -1, auxiliar, inicio, destino);
        }
    }
}
