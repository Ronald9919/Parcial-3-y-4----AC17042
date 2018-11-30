/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial;
/**
 *
 * @author Ronald
 */
import Clases.FuntionRunge;
import Clases.SimulacionMonteCarlo;
import static Clases.TorreHanoi.Hanoi;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Parcial extends NewtonRaphson {
    ArrayList<NewtonRaphson>newton = new ArrayList();
    
    public static double fdada(double x1){
     return Math.cos(x1)-Math.pow(x1, 3);
    }
    
    public static double dfdada(double x1){
        return Math.sin(x1)-(3.0*x1*x1);
    }

    
    public static void main(String[] args) {
        NewtonRaphson newton = new NewtonRaphson();
        Scanner sc = new Scanner(System.in);
            boolean salir = false;
            int opcion; 
            double H= 0;
            double x0=0;
            double inst=0;
        
        while (!salir) {
            System.out.println("");
            System.out.println("");
            System.out.println("*******************MENU*******************");
            System.out.println("------------------------------------------");
            System.out.println("1. Metodo MonteCarlo para PI");
            System.out.println("2. Resolucion de las Torres de Hanoi");
            System.out.println("3. Runge Kutta");
            System.out.println("4. Newton Raphson");
            System.out.println("5. Salir");
            System.out.println("------------------------------------------");
 
            try {
 
                    System.out.print("Escribe una de las opciones: ");
                        opcion = sc.nextInt();
                    System.out.println("");
 
                switch (opcion) {
                    case 1:  
                            SimulacionMonteCarlo sim = new SimulacionMonteCarlo(6, (int) 1e7); 
                                System.out.println("El numero que se aporxima mas a PI es: " + sim.pi());
                        break;
                    case 2:
                                System.out.println("Cuantos discos quiere jugar?");
                                    int discos = sc.nextInt();
                                    Hanoi(discos, 1, 2, 3);
                                    int movimientos = (int)(Math.pow(2, discos)-1);
                                System.out.println("");
                                System.out.println("El numero minimo de movimientos para " + discos + " discos es " + movimientos + " movimientos.");
                        break;
                    case 3:
                        try{
                            System.out.print("Ingrese el valor de h (paso) : " );
                                H = sc.nextDouble();
                            System.out.print("Ingrese el valor de x0 (inicial) : ");
                                x0 = sc.nextDouble();
                            System.out.println("Ingrese el valor de t (instante a evaluar) : ");
                                inst = sc.nextDouble();
        
                        }catch(Exception ex){
                
                                }
       
                        double x=new FuntionRunge().resolver(inst, 0, x0, H);
                            System.out.println("Valor aproximado de x es : "+(double)x);
                
                                x=(int)(x0*Math.exp(-0.1*inst));
                            System.out.println("Valor exacto de x es :"+(double)x);
                        break;
                    case 4:
                            double x1=0, temp, e;
                            String data;    
                        try{
                            System.out.println("Ingrese el valor de x: ");
                            x1=sc.nextDouble();
                        }catch(Exception ex){System.out.println("Error valor invalido: " + ex);}
                            int i = 0;
        
                        do{
                                temp = x1;
                                x1 = x1 - fdada(x1)/dfdada(x1);
                                e = Math.abs((x1-temp)/x1);
                    
                                data = "x " +i+" = "+x1+"  Error "+"= "+e+"\n";
                            System.out.println(data);
                                i=i+1;
            
                        }while(x1 != temp && i < 100);
        
                            if(i==100){
                            System.out.println("\nNo converge");
                                newton.X = x1;
                                newton.dato = data;
                            }else{
                            System.out.println("\nSolucion x: "+x1);
                                newton.X = x1;
                                newton.dato = data;
                        }
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
                }
            }
        }
    }
    
