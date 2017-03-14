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

    public boolean matrixSearch(int num) {
        int[][] multi = new int[][]{
            {1, 3, 7, 8, 8, 9, 12},
            {2, 4, 8, 9, 10, 30, 38},
            {4, 5, 10, 20, 29, 50, 60},
            {8, 10, 11, 30, 50, 60, 61},
            {11, 12, 40, 80, 90, 100, 111},
            {13, 15, 50, 100, 110, 112, 120},
            {22, 27, 61, 112, 119, 138, 153}};

        for (int row = 0; row < multi.length; row++) {
            for (int col = 0; col < multi.length; col++) {
                if (num == multi[row][col]) {
                    return true;
                }
            }
            
        }
    return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number to search for: ");
        int num = scan.nextInt();
    }

}
