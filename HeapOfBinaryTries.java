package assignment2;

public class HeapOfBinaryTries {
    private BinaryTrie[] A;
    private int heapsize;

    private void heapify(int i)
    {
        // TASK 3.A.a
        int l = 2*i + 1;
        int r = 2*i + 2;
        int smallest = i;

        if (l < heapsize && A[l].compare(A[smallest])) smallest = l;
        if (r < heapsize && A[r].compare(A[smallest])) smallest = r;

        if (smallest != i) {
            BinaryTrie t = A[i];
            A[i] = A[smallest];
            A[smallest] = t;
            heapify(smallest);
        }
    }

    public HeapOfBinaryTries(BinaryTrie[] A)
    {
        // TASK 3.A.b
        this.A = A;
        heapsize = A.length;

        for (int i = heapsize/2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public BinaryTrie extractMin()
    {
        // TASK 3.A.c
        BinaryTrie min = A[0];
        A[0] = A[heapsize - 1];
        heapsize--;
        heapify(0);
        return min;
    }

    public void insert(BinaryTrie x) {
        // TASK 3.A.d
        BinaryTrie[] B = new BinaryTrie[heapsize + 1];
        System.arraycopy(A, 0, B, 0, heapsize);
        A = B;

        int i = heapsize;
        A[i] = x;
        heapsize++;

        while (i > 0 && A[i].compare(A[(i-1)/2])) {
            BinaryTrie t = A[i];
            A[i] = A[(i-1)/2];
            A[(i-1)/2] = t;
            i = (i-1)/2;
        }
    }

    public int size()
    {
        return heapsize;
    }
}

