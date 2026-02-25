package assignment2;

public class MergeSort {

    private static int[] merge(int[] A1, int[] A2)
    {
        // TASK 2.A.a
        int[] R = new int[A1.length + A2.length];
        int i = 0, j = 0, k = 0;

        while (i < A1.length && j < A2.length) {
            if (A1[i] <= A2[j]) {
                R[k++] = A1[i++];
            } else {
                R[k++] = A2[j++];
            }
        }

        while (i < A1.length) R[k++] = A1[i++];
        while (j < A2.length) R[k++] = A2[j++];

        return R;
    }

    public static int[] mergesort(int[] A)
    {
        // TASK 2.A.b
        if (A.length <= 1) return A;

        int mid = A.length / 2;
        int[] L = new int[mid];
        int[] R = new int[A.length - mid];

        System.arraycopy(A, 0, L, 0, mid);
        System.arraycopy(A, mid, R, 0, A.length - mid);

        L = mergesort(L);
        R = mergesort(R);

        return merge(L, R);
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
        print(merge(new int[] {1,3,5,7,9}, new int[] {2,4,6,8}));
        print(mergesort(new int[] {5,2,8,1,3,9,7,4,6} ));
    }

}

