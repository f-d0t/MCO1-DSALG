import java.util.Scanner;

public class Tester {

    private static SortingAlgorithms sa = new SortingAlgorithms();

    /**
     * This method prints a divider
     */
    private static void printDivider()
    {
        for (int j = 0; j < 100; j++)
        {
            System.out.print("-");
        }

        System.out.println();
    }

    /**
     * This method is for testing insertion sort
     * @param toSort the array to sort
     */
    private static void testInsertionSort(Record[] toSort)
    {
        //store the current time
        long startTime = System.currentTimeMillis(); 

        //call merge sort
        sa.insertionSort(toSort, toSort.length);

        //store the current time
        long endTime = System.currentTimeMillis(); 

        long executionTime = endTime - startTime;        

        printDivider();
    
        //ITERATE THROUGH EVERY RECORD
        int i = 0;

        for (Record record : toSort)
        {
            System.out.println("Record " + (i + 1) + " : " + record.getIdNumber() + record.getName());
            i++;
        }

        //PRINT EXECUTION TIME
        printDivider();

        System.out.println("Insertion sort finished in " + executionTime + " millisecond/s.");

        printDivider();
    }

    private static void testSelectionSort(Record[] toSort)
    {
        //store the current time
        long startTime = System.currentTimeMillis(); 

        //call merge sort
        sa.selectionSort(toSort, toSort.length);

        //store the current time
        long endTime = System.currentTimeMillis(); 

        long executionTime = endTime - startTime;        

        printDivider();
    
        //ITERATE THROUGH EVERY RECORD
        int i = 0;

        for (Record record : toSort)
        {
            System.out.println("Record " + (i + 1) + " : " + record.getIdNumber() + record.getName());
            i++;
        }

        //PRINT EXECUTION TIME
        printDivider();

        System.out.println("Selection sort finished in " + executionTime + " millisecond/s.");

        printDivider();
    }

    /**
     * This method is to test merge sort
     * @param toSort the array to sort
     */
    private static void testMergeSort(Record[] toSort)
    {
        int firstIndex = 0;
        int lastIndex = toSort.length - 1;

        //store the current time
        long startTime = System.currentTimeMillis(); 

        //call merge sort
        sa.mergeSort(toSort, firstIndex, lastIndex);

        //store the current time
        long endTime = System.currentTimeMillis(); 

        long executionTime = endTime - startTime;        

        printDivider();
    
        //ITERATE THROUGH EVERY RECORD
        int i = 0;

        for (Record record : toSort)
        {
            System.out.println("Record " + (i + 1) + " : " + record.getIdNumber() + record.getName());
            i++;
        }

        //PRINT EXECUTION TIME
        printDivider();

        System.out.println("Merge sort finished in " + executionTime + " millisecond/s.");

        printDivider();
    }

    private static void testTimsort(Record[] toSort)
    {
        int lastIndex = toSort.length - 1;

        //store the current time
        long startTime = System.currentTimeMillis(); 

        //call merge sort
        sa.timsort(toSort);

        //store the current time
        long endTime = System.currentTimeMillis(); 

        long executionTime = endTime - startTime;        

        printDivider();
    
        //ITERATE THROUGH EVERY RECORD
        int i = 0;

        for (Record record : toSort)
        {
            System.out.println("Record " + (i + 1) + " : " + record.getIdNumber() + record.getName());
            i++;
        }

        //PRINT EXECUTION TIME
        printDivider();

        System.out.println("Timsort finished in " + executionTime + " millisecond/s.");

        printDivider();
    }
    
    public static void main(String[] args) {
        FileReader fr = new FileReader();
        Scanner sc = new Scanner(System.in);

        //INDICATE THE FILE TO BE READ
        System.out.print("Copy the path of the text file to test and paste it here (if you are using vscode terminal, right click to paste): ");
        String path = sc.nextLine(); //path of file to be read. This line should be edited to test different files
        Record[] toSort = fr.readFile(path);

        if (toSort != null)
        {
            printDivider();

            //INDICATE THE SORTING METHOD TO TEST
            System.out.println("Currently sorting: " + path);
            System.out.println("[1] Insertion Sort");
            System.out.println("[2] Selection Sort");
            System.out.println("[3] Merge Sort");
            System.out.println("[4] Timsort");
            System.out.print("Indicate the sorting algorithm to test: ");

            switch (sc.nextInt())
            {
                case 1:
                    testInsertionSort(toSort);    
                    break;

                case 2:
                    testSelectionSort(toSort);
                    break;

                case 3:
                    testMergeSort(toSort);
                    break;

                case 4:
                    testTimsort(toSort);
                    break;

                default:
                    System.err.println("Invalid.");
                    break;
            }
            
            System.out.println("First record: " + toSort[0].getIdNumber() + " " + toSort[0].getName());
            System.out.println("Last record: " + toSort[toSort.length - 1].getIdNumber() + " " + toSort[toSort.length - 1].getName());
            printDivider();

            sc.close();            
        }
        
    }
}
