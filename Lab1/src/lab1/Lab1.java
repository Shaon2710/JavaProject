/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author SHAON
 */
public class Lab1 {
 public static void task1() {
        // find the average of an array of numbers
        int numbers[] = {13, 4, 5, 2, 3, 1, 3};
        
        int sum = 0;
        for (int i = 0; i < numbers.length; i++)
            sum = sum + numbers[i];
        
        double average = (double) sum / numbers.length;
        
        System.out.printf("Average: %.3f\n", average);
    }
    
    public static void  task2() {
        // find the minimum of an array of numbers
        int numbers[] = {13, 4, 5, 2, 3, 1, 3};
        
        int min = numbers[0];
        
        for (int i = 1; i < numbers.length; i++)
            if (numbers[i] < min)
                min = numbers[i];
        
        System.out.printf("Minimum: %d\n", min);
       
    }
    
    public static void task3() {
        // find the minimum of an array of numbers
        int numbers[] = {13, 4, 5, 2, 3, 1, 3};
        
        int max = numbers[0];
        for(int i=0;i<numbers.length;i++)
        {
            if (numbers[i] > max)
                max = numbers[i];
            
        }
          
        System.out.printf("Maximum: %d\n", max);
        
    }
    
    public static int  task20(int numbers[]) {
        // find the minimum of an array of numbers
        
        
        int min = numbers[0];
        
        for (int i = 1; i < numbers.length; i++)
            if (numbers[i] < min)
                min = numbers[i];
        
        System.out.printf("Minimum: %d\n", min);
        return min;
    }
    
    public static int task30(int numbers[]) {
        // find the minimum of an array of numbers
        
        
        int max = numbers[0];
        for(int i=0;i<numbers.length;i++)
        {
            if (numbers[i] > max)
                max = numbers[i];
            
        }
          
        System.out.printf("Maximum: %d\n", max);
        return max;
    }
    
    // Homework
    public static void task4() {
        // find out the standard deviation of the following
        // array of numbers
        // Reference: https://en.wikipedia.org/wiki/Standard_deviation
        // Hint: to find out square root of 5, we type Math.sqrt(5)
        int numbers[] = {13, 4, 5, 2, 3, 1, 3};
       
        double sd = 0.0;
        int sum = 0;
        for (int i = 0; i < numbers.length; i++)
            sum = sum + numbers[i];
        
        double average = (double) sum / numbers.length;
        for(int i=0;i<numbers.length;i++)
        {
            sd+=Math.pow((numbers[i]-average),2);
        }
        
        double daviation = Math.sqrt(sd/numbers.length-1);
      
        
        System.out.printf("Standard deviation: %.2f\n",daviation);
    }
    
    public static void task5() {
        // find the geometric mean of a list of numbers
        int numbers[] = {13, 4, 5, 2, 3, 1, 3};
        
        int sum = 1;
        for (int i = 0; i < numbers.length; i++){
             sum = sum * numbers[i];
        }
                    
        double x = (double) Math.pow(sum, 1.00/numbers.length);
        
        System.out.printf("Geometric mean: %.2f\n", x);

    }

    public static void task6() {
        // find the maximum distance between a pair of numbers
        int numbers[] = {13, 4, 5, 2, 3, 1, 3};
       
        int min = numbers[0];
        int max = numbers[0];
        
        for (int i = 1; i < numbers.length; i++){
            min = Math.min(min, numbers[i]);
            max =  Math.max(max, numbers[i]);
        }
       
        int largestDistance= max-min;
       
        System.out.printf("Largest distance: %d\n", largestDistance);
    }
   
    public static void main(String[] args) {
        
       task1();
       task2();
       task3();
       task4();
       task5();
       task6();
    }
    
}
