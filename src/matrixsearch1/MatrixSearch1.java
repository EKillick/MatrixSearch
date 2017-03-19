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

    final static private boolean DEBUG = false;

    /**
     * A basic search method that searches an unsorted matrix linearly
     *
     * @param num - number being searched for
     * @param multi - array to be searched
     * @return - true if number is in matrix, false otherwise
     */
    public static boolean matrixSearch1(int[][] multi, int size, int num) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (num == multi[row][col]) {
                    System.out.println(num + " was found in row: " + row + " col: " + col);
                    return true;
                }
            }

        }
        System.out.println(num + " was not found");
        return false;
    }

    /**
     * A method that searches an array sorted by row but not by column
     *
     * @param num - number being searched for
     * @param size
     * @param multi - array to be searched
     * @return - true if number is in matrix, false otherwise
     */
    public static boolean matrixSearch2(int[][] multi, int size, int num) {
        // Start half way through the array
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
                        System.out.println(num + " was found in row: " + row + " col: " + mid);
                        return true;
                    } else if (multi[row][mid] > num) {
                        max = mid - 1;
                    } else {
                        min = mid + 1;
                    }
                }
            }
        }
        System.out.println(num + " was not found");
        return false;
    }

    /**
     * @param num
     * @param size
     * @param multi
     * @return
     */
    public static boolean matrixSearch3(int[][] multi, int size, int num) {
        int col = size - 1;
        int row = 0;
        while (row < (size - 1) && col > 0) {
            if (multi[row][col] == num) {
                System.out.println(num + " was found in row: " + row + " col: " + col);
                return true;
            } else if (multi[row][col] > num) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println(num + " was not found");
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
        int[] testNumbers = new int[]{4, 12, 110, 5, 6, 111};
        System.out.print("Question number: ");
        Scanner scan = new Scanner(System.in);
        int question = scan.nextInt();

        if (DEBUG) {
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
        else {
            for (int num : testNumbers) {
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
    }

}
