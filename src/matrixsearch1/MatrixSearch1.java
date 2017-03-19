/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixsearch1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author EKillick
 */
public class MatrixSearch1 {

    final static private boolean DEBUG = false;
    final static private boolean TEST = false;
    final static private boolean WORST = true;

    /**
     * A basic search method that searches an unsorted matrix linearly
     * @param num - number being searched for
     * @param size - size of the array being searched
     * @param multi - array to be searched
     * @return - true if number is in matrix, false otherwise
     */
    public static boolean matrixSearch1(int[][] multi, int size, int num) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (num == multi[row][col]) {
//                    System.out.println(num + " was found in row: " + row + " col: " + col);
                    return true;
                }
            }

        }
//        System.out.println(num + " was not found");
        return false;
    }

    /**
     * A method that searches an array sorted by row but not by column
     * @param num - number being searched for
     * @param size - size of the array being searched
     * @param multi - array to be searched
     * @return - true if number is in matrix, false otherwise
     */
    public static boolean matrixSearch2(int[][] multi, int size, int num) {
        int min;
        int max;
        int mid;

        for (int row = 0; row < size; row++) {
            min = 0;
            max = size - 1;
            if (num >= multi[row][0] && num <= multi[row][size - 1]) {
                while (min <= max) {
                    mid = ((max + min) / 2);
                    if (multi[row][mid] == num) {
//                        System.out.println(num + " was found in row: " + row + " col: " + mid);
                        return true;
                    } else if (multi[row][mid] > num) {
                        max = mid - 1;
                    } else {
                        min = mid + 1;
                    }
                }
            }
        }
//        System.out.println(num + " was not found");
        return false;
    }

    /**
     * @param num - number being searched for
     * @param size - size of the array being searched
     * @param multi - array to be searched
     * @return - true if number is in matrix, false otherwise
     */
    public static boolean matrixSearch3(int[][] multi, int size, int num) {
        int col = size - 1;
        int row = 0;
        while (row < (size - 1) && col > 0) {
            if (multi[row][col] == num) {
//                System.out.println(num + " was found in row: " + row + " col: " + col);
                return true;
            } else if (multi[row][col] > num) {
                col--;
            } else {
                row++;
            }
        }
//        System.out.println(num + " was not found");
        return false;
    }
    
    private static int[][] generateMatrix(int n){
        int[][] multi = new int[n][n];
        int num = 1;
        
        for (int row = 0; row < n; row++){
            for (int column = 0; column < n; column++){
                multi[row][column] = num;
                num++;
            }
        }
        return multi;
    }

    public static void main(String[] args) {
        int[][] multi = new int[][]{
            {1, 3, 7, 8, 8, 9, 12},
            {2, 4, 8, 9, 10, 30, 38},
            {4, 5, 10, 20, 29, 50, 60},
            {8, 10, 11, 30, 50, 60, 61},
            {11, 12, 40, 80, 90, 100, 111},
            {13, 15, 50, 100, 110, 112, 120},
            {22, 27, 61, 112, 119, 138, 153}};
        int[] testNumbers = new int[]{4, 12, 110, 5, 6, 111};
        
        if (DEBUG) {
            System.out.print("Question number: ");
            Scanner scan = new Scanner(System.in);
            int question = scan.nextInt();
            System.out.print("Enter a number to search for: ");
            int num = scan.nextInt();
            switch (question) {
                case 1:
                    System.out.println(matrixSearch1(multi, multi.length, num));
                    break;
                case 2:
                    System.out.println(matrixSearch2(multi, multi.length, num));
                    break;
                case 3:
                    System.out.println(matrixSearch3(multi, multi.length, num));
                    break;
                default:
                    break;
            }
        } 
        if (TEST) {
            for (int num : testNumbers) {
                System.out.print("Question number: ");
                Scanner scan = new Scanner(System.in);
                int question = scan.nextInt();
                switch (question) {
                    case 1:
                        System.out.println(matrixSearch1(multi, multi.length, num));
                        break;
                    case 2:
                        System.out.println(matrixSearch2(multi, multi.length, num));
                        break;
                    case 3:
                        System.out.println(matrixSearch3(multi, multi.length, num));
                        break;
                    default:
                        System.out.println("Enter 1, 2 or 3");
                }
            }
        }
        if (WORST){
            int size[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300, 
                400, 500, 600, 700, 800, 900, 1000, 2000, 3000, 4000};
            DecimalFormat df = new DecimalFormat("0.00000");
            System.out.println("Size" + "\t\t" + "Mean" + "\t\t" + "Standard Deviation");
            for (int i = 0; i < size.length; i++) {
                int n = size[i];
                int num = 0;
                int reps = 1000;
                double sum = 0, s = 0;
                double sumSquared = 0;
                num = (n * n) + 1;
                int matrix[][] = generateMatrix(n);

                for (int j = 0; j < reps; j++) {
                    long t1 = System.nanoTime();
                    matrixSearch1(matrix, matrix.length, num);
                    long t2 = System.nanoTime() - t1;
                    sum += (double) t2 / 1000000.0;
                    sumSquared += (t2 / 1000000.0) * (t2 / 1000000.0);
                }
                
                double mean = sum / reps;
                double variance = sumSquared / reps - (mean * mean);
                double stdDev = Math.sqrt(variance);
                
                System.out.println(n + "\t\t" + df.format(mean) + "\t\t" + df.format(stdDev));
            }

        }
    }

}
