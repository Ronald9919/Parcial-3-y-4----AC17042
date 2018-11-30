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
public abstract class RUNGEKUTTA {
    
    public double resolver(double tf, double t0, double x, double h){
    double K1, K2, K3,K4;
    for(double t=t0;t<tf;t++){
        K1=h*f(x, t);
        System.out.println(K1);
        K2=h*f(x+K1/2, t+h/2);
        System.out.println(K2);
        K3=h*f(x+K2/2, t+h/2);
        System.out.println(K3);
        K4=h*f(x+K3, t+h);
        System.out.println(K4);
        x+=(K1+2*K2+2*K3+K4)/6; 
    }
        return x;
    }
    abstract public double f(double x, double t);
}
