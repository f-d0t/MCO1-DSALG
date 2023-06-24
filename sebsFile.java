/* This file contains implementations of sorting algorithms.
 * You are NOT allowed to modify any of the given method headers.
 */

public class SortingAlgorithms {

    /*
     * You may define additional helper functions here if you need to.
     * Make sure the helper functions have the private access modifier, as
     * they will only be used in this class.
     */

    public void insertionSort(Record[] arr, int p, int r) {
        // TODO: Implement this sorting algorithm here.
        // p = first/left r = second/right

        for (int i = p + 1; i <= r; i++) {
            Record key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].getIdNumber() > key.getIdNumber()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public void selectionSort(Record[] arr, int n) {
        // TODO: Implement this sorting algorithm here.

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= n; j++) {
                if (arr[minIndex].getIdNumber() > arr[j].getIdNumber())
                    minIndex = j;
                Record temp = arr[minIndex];
                arr[minIndex] = arr[j];
                arr[j] = temp;

            }
        }

    }

    public void mergeSort(Record[] arr, int p, int r) {
        // TODO: Implement this sorting algorithm here.
        // p = first/left r = second/right
        int m = (p + r) / 2;
        int len1 = m - p + 1;
        int len2 = r - m;
        Record[] leftArr = new Record[len1];
        Record[] rightArr = new Record[len2];

        for (int i = 0; i < len1; i++)
            leftArr[i] = arr[p + i];
        for (int i = 0; i < len2; i++)
            rightArr[i] = arr[m + 1 + i];

        int i = 0, j = 0, k = p;
        while (i < len1 && j < len2) {
            if (leftArr[i].getIdNumber() <= rightArr[j].getIdNumber()) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < len2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    /*
     * Define AT LEAST ONE more sorting algorithm here, apart from the
     * ones given above. Make sure that the method accepts an array of
     * records
     */

    public void timSort(Record[] arr, int n) {
        // TODO: Implement this sorting algorithm here.

        for (int i = 0; i < n; i += 32)
            insertionSort(arr, i, Math.min((i + 32 - 1), (n - 1)));

        for (int size = 32; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                mergeSort(arr, left, right);
            }
        }

    }

}
