/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author kmhasan
 */
public class ComplexNumber {
    private double real;
    private double imaginary;
    
    // CONSTRUCTOR
    public ComplexNumber(double r, double i) {
        real = r;
        imaginary = i;
    }
    
    public ComplexNumber() {
        
    }
    
    public ComplexNumber add(ComplexNumber b) {
        ComplexNumber a = this;
        
        double r = a.real + b.real;
        double i = a.imaginary + b.imaginary;
        ComplexNumber c = new ComplexNumber(r, i);
        
        return c;
    }
    
    public ComplexNumber subtract(ComplexNumber b) {
        ComplexNumber a = this;
        double r = a.real - b.real;
        double i = a.imaginary + b.imaginary;
        ComplexNumber c = new ComplexNumber(r, i);
        
        return c;
    }
    
    public ComplexNumber multiply(ComplexNumber b) {
        ComplexNumber a = this;

        //(a+bi)(c+di)=(ac-bd)+(bc+ad)i.
        
        double r = (a.real * b.real) -  (a.imaginary*b.imaginary);
        double i = (a.imaginary*b.real)+(a.real+b.imaginary);
        ComplexNumber c = new ComplexNumber(r, i);
        
        return c;
        
    }
    
    public ComplexNumber divide(ComplexNumber b) {
        ComplexNumber a = this;
        //{a+bi}{c+di}}= (ac+bd \c^2+d^2)+  (bc-ad \ c^2+d^2)i.
        double d = b.real*b.real + b.imaginary* b.imaginary;
        
        double r = (a.real*b.real + a.imaginary*b.imaginary)/d;
        double i = (a.imaginary*b.real - a.real * b.imaginary)/d;
        ComplexNumber c = new ComplexNumber(r, i);
        
        return c;
    }
    
    
    public String toString() {
        return String.format("%.2f + %.2fi", real, imaginary);
    }
}
