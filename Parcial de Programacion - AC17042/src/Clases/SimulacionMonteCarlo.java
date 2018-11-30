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
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulacionMonteCarlo {
    
    public SimulacionMonteCarlo(int cantHilos,int cantI) {
        this.cantHilos = cantHilos;
        cantIter = cantI;
        hilos = new LinkedList();
        threadPool = Executors.newFixedThreadPool(cantHilos);
        iniciarProcesos();
    }
    
    public void iniciarProcesos(){
        Random rnd = new Random();
        for(int i = 0; i < cantHilos; i++)
            hilos.add(new SubProcesoMonteCarlo(rnd,cantIter/cantHilos)); //Lo que le tocara a cada hilo
    }
    
    public void iniciarTodos(){
        for(SubProcesoMonteCarlo s : hilos){
            threadPool.execute(s);
        }
        threadPool.shutdown();    
    }
    
    public double pi(){
        iniciarTodos();
        long totalDentro = 0;long totalTotal = 0;
            while (!threadPool.isTerminated());///Barrera
            for (SubProcesoMonteCarlo t : hilos) {
                totalDentro += t.getCantidadDentro();
                totalTotal += t.getCantidadTotal();
            }
            return 4.0 * totalDentro / totalTotal;
    }
      
    private int cantHilos = 0;
    private int cantIter = 0;
    private LinkedList<SubProcesoMonteCarlo> hilos;
    private ExecutorService threadPool;
}
