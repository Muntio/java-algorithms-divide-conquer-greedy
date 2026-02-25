package assignment2;

public class DivideAndConquer {

    public static int fibonacci(int n) {
        // TASK 1.A.a
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int search(int[] A, int v)
    {
        // TASK 1.A.b
        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == v) return mid;
            if (A[mid] < v) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public static void hanoi(int n, char A, char B, char C)
    {
        // TASK 1.A.c
        if (n == 1) {
            System.out.println(A + " -> " + C);
            return;
        }
        hanoi(n - 1, A, C, B);
        System.out.println(A + " -> " + C);
        hanoi(n - 1, B, A, C);
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            System.out.println(fibonacci(i));
        }
        System.out.println();
        for (int i=0; i<10; i++) {
            System.out.println(search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, i));
        }
        System.out.println();
        hanoi(4, 'A', 'B', 'C');
    }
}
