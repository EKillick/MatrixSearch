/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixsearch1;

import java.util.Scanner;

/**
 *
 * @author EKillick
 */
public class MatrixSearch1 {

    /**
     * A basic search method that searches an unsorted matrix linearly
     * @param num - number being searched for
     * @param multi - array to be searched
     * @return - true if number is in matrix, false otherwise
     */
    public static boolean matrixSearch1(int num, int[][] multi) {
        for (int row = 0; row < multi.length; row++) {
            for (int col = 0; col < multi.length; col++) {
                if (num == multi[row][col]) {
                    System.out.println("Found in row: " + row + " col: " + col);
                    return true;
                }
            }
            
        }
    return false;
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
        System.out.print("Question number: ");
        Scanner scan = new Scanner(System.in);
        int question = scan.nextInt();
        System.out.print("Enter a number to search for: ");
        int num = scan.nextInt();
        switch(question){
            case 1: System.out.println(matrixSearch1(num, multi));
                    break;
            case 2: System.out.println("Not yet implemented");
                    break;
            case 3: System.out.println("Not yet implemented");
                    break;
            default: break;
        }  
    }
}
