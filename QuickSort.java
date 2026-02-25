package assignment2;

public class QuickSort {

    private static int partition(int[] A, int p, int r)
    {
        // TASK 2.B.a
        int pivot = A[r];
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (A[j] <= pivot) {
                i++;
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
        }

        int t = A[i + 1];
        A[i + 1] = A[r];
        A[r] = t;

        return i + 1;
    }

    private static void quicksort(int[] A, int p, int r)
    {
        // TASK 2.B.b
        if (p < r) {
            int q = partition(A, p, r);
            quicksort(A, p, q - 1);
            quicksort(A, q + 1, r);
        }
    }

    public static void quicksort(int[] A)
    {
        quicksort(A, 0, A.length-1);
    }

    private static void print(int[] A)
    {
        for (int i=0; i<A.length; i++)
        {
            System.out.print(A[i] + ((i<A.length-1)?", ":""));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = new int[] {5,2,8,1,3,9,7,4,6};
        quicksort(A);
        print(A);
    }

}

