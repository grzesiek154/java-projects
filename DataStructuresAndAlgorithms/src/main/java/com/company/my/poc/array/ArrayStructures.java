package com.company.my.poc.array;

public class ArrayStructures {

    private int[] theArray = new int[50];
    private int arraySize = 10;

    public void generateRandomArray() {

        for(int i = 0; i< arraySize; i++) {

            theArray[i] = (int)(Math.random()*10)+10;
        }
    }

    public void printArray() {

        System.out.println("---------");
        for(int i =0; i < arraySize; i++) {
            System.out.print("| " + i + " |");
            System.out.println(theArray[i] + " |");

            System.out.println("---------");
        }
    }
    public int getValAtIndex(int index) {

        if(index < arraySize) return theArray[index];

        return 0;
    }

    public boolean doesArrayContainsThisValue(int searchValue) {

        boolean valueInArray = false;

        for (int i = 0; i < arraySize; i++) {
            if(theArray[i] == searchValue) {
                valueInArray = true;
            }
        }
        return valueInArray;
    }

    public void deleteIndex(int index) {

        if(index < arraySize) {

            for (int i = 0; i < arraySize; i++) {
                theArray[i] = theArray[i+1];
            }
            this.arraySize--;
        }
    }

    public void insertValue(int value) {
        if(arraySize < 50) {
            theArray[arraySize] = value;
            arraySize++;
        }
    }
    public String linearSearchForValue(int value) {

        boolean valueInArray = false;
        String indexWithValue = "";

        System.out.println("The value  was found in the following indexes");

        for(int i = 0; i < arraySize; i++) {

            if(theArray[i] == value) {
                valueInArray = true;

                System.out.print(i + " ");

                indexWithValue+= i + " ";
            }
        }
        if(!valueInArray){
            System.out.println(indexWithValue);
        }

        System.out.println();
        return indexWithValue;
    }

    public static void main(String[] args) {

        ArrayStructures newArray = new ArrayStructures();
        newArray.generateRandomArray();
        newArray.printArray();
        System.out.println(newArray.getValAtIndex(4));
        System.out.println(newArray.doesArrayContainsThisValue(15));
        newArray.deleteIndex(3);
        newArray.printArray();
        newArray.insertValue(55);
        newArray.printArray();
        newArray.linearSearchForValue(18);
    }
}

