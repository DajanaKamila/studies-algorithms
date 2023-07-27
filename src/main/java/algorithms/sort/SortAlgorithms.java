package algorithms.sort;

public class SortAlgorithms {

    //TASK 1 - Euclid's algorithm
    public static int euclideanAlgorithm(int x, int y) {
        while (x != y) {
            if (x > y) {
                x = x - y;
            } else if (y > x) {
                x = y - x;
            } else {
                return x;
            }
        }
        return x;
    }

    //TASK 2 - Blum Blum Shub PRNG
    public static int[] blumBlumShub(int n) {
        int xn;
        int[] randomNumbers = new int[n];
        int x0 = 234;
        int p = 2287;
        int q = 3079;

        int N = p * q;
        for (int i=0; i<n; i++){
            xn = (x0*x0)%N;
            randomNumbers[i] = xn;
            x0 = xn;
        }
        return randomNumbers;
    }
    public static void displayTable(int[] table) {
        for (int i = 0; i<table.length; i++){
            System.out.println(table[i]);
        }
    }

    //TASK 3 - Selection sort

    public static void selectionSort(int[] table) {
        for (int i=0; i<table.length; i++){
            int minIndex = findMin(i, table);
            if (i != minIndex){
                swapValues(i, minIndex, table);
            }
        }
    }
    public static int findMin(int startIndex, int[] table) {
        int minValue = table[startIndex];
        int minIndex = startIndex;
        for (int i = startIndex; i<table.length; i++ ){
            if(table[i] < minValue){
                minValue = table[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    public static void swapValues(int i, int j, int[] table) {
        int temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }

    //TASK 4 - Bubble sort
    public static void bubbleSort(int[] table) {
        int lastIndex = table.length - 1;
        boolean flag;
        do {
            flag = false;
            for (int i=0; i<lastIndex; i++){
                if (table[i]>table[i+1]){
                    int temp = table[i];
                    table[i] = table[i+1];
                    table[i+1] = temp;
                    flag = true;
                }
            }
            lastIndex = lastIndex - 1;
        } while(flag);
    }

    //TASK 6 - Quick sort
    public static void quickSort(int startIndex, int stopIndex, int[] table) {

        if (startIndex >= stopIndex) {
            return;
        }

        int pivot = stopIndex;
        int leftPointer = startIndex;
        int rightPointer = stopIndex;

        do {
            while (table[leftPointer] <= table[pivot] && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (table[rightPointer] >= table[pivot] && leftPointer < rightPointer) {
                rightPointer--;
            }
            swapValues(leftPointer, rightPointer, table);
        } while (leftPointer < rightPointer);

        swapValues(pivot, rightPointer, table);

        if (startIndex < leftPointer){
            quickSort(startIndex, leftPointer-1, table);
        }
        if (leftPointer < stopIndex) {
            quickSort(leftPointer + 1, stopIndex, table);
        }
    }


}
