package ru.geekbrains.api.lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

class HeapSort {
    public static void buildTree(int[] tree, int sortLength, int i) {
           // Введите свое решение ниже
    int largest = i;
    int right = 2*i+1;
    int left = 2*i+2;
    if (left <sortLength && tree[left] > tree [largest]) {
        largest = left;
    }
    if (right <sortLength && tree[right] > tree [largest]) {
        largest = right;
    }
    if (largest != i) {
        int temp = tree[i] ;
        tree [i] = tree[largest];
        tree[largest] = temp ;
        buildTree(tree, sortLength, largest);
    }
    }

    public static void heapSort(int[] sortArray, int sortLength) {
// Введите свое решение ниже
int n = sortLength;
int[] tree = sortArray.clone();
for (int i = n/2 -1; i>=0; i--) {
    buildTree(tree,n,i);
}
    for (int i = n - 1; i>=0; i--) {
        int temp = tree[0] ;
        tree[0] = tree [i] ;
        tree[i] = temp;
        buildTree(tree, i,0);

    }
for (int i = 0; i<n; i++) {
    sortArray[i] = tree[i] ;
}
}
}


// Не удаляйте и не меняйте метод Main! 
public class Printer {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}
