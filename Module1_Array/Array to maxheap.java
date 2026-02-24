class BiTree {

    Node Ntree[];
    Node head;

    class Node {
        int d;
        Node l, r;

        Node(int d) {
            this.d = d;
            this.l = null;
            this.r = null;
        }
    }

    // convert array into tree
    public Node ArrayToBiTree(int a[]) {
        int n = a.length;
        Ntree = new Node[n];

        // convert elements into nodes
        for (int i = 0; i < n; i++) {
            Node nn = new Node(a[i]);
            Ntree[i] = nn;
        }

        // linking using 2*i+1 and 2*i+2
        for (int i = 0; i < n; i++) {
            int lci = 2 * i + 1;
            int rci = 2 * i + 2;

            if (lci < n) Ntree[i].l = Ntree[lci];
            if (rci < n) Ntree[i].r = Ntree[rci];
        }

        return Ntree[0];   // return head
    }

    // inorder traversal
    void print(Node r) {
        if (r == null) return;
        print(r.l);
        System.out.println(r.d);
        print(r.r);
    }
}


class ArrayToMaxHeapTree {

    int size;
    int cbt[];

    ArrayToMaxHeapTree(int a[]) {
        int n = a.length;
        this.cbt = new int[n];
        this.size = n;

        System.out.println("Before insertion");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");

        // copy elements
        for (int i = 0; i < n; i++) {
            cbt[i] = a[i];
        }

        // build heap
        for (int i = size / 2 - 1; i >= 0; i--) {
            downHeapify(i);
        }

        System.out.println("After insertion");
        for (int i = 0; i < size; i++) {
            System.out.print(cbt[i] + " ");
        }
        System.out.println("\n");
    }

    void downHeapify(int pi) {
        while (true) {
            int lci = 2 * pi + 1;
            int rci = 2 * pi + 2;
            int maxIndex = pi;

            if (lci < size && cbt[lci] > cbt[maxIndex])
                maxIndex = lci;

            if (rci < size && cbt[rci] > cbt[maxIndex])
                maxIndex = rci;

            if (maxIndex == pi)
                break;

            int temp = cbt[pi];
            cbt[pi] = cbt[maxIndex];
            cbt[maxIndex] = temp;

            pi = maxIndex;
        }
    }

    int deletionMaxHeap() {
        int poppedElement = cbt[0];
        cbt[0] = cbt[size - 1];
        size--;

        int pi = 0;

        while (true) {
            int lci = 2 * pi + 1;
            int rci = 2 * pi + 2;
            int maxIndex = pi;

            if (lci < size && cbt[lci] > cbt[maxIndex])
                maxIndex = lci;

            if (rci < size && cbt[rci] > cbt[maxIndex])
                maxIndex = rci;

            if (maxIndex == pi)
                break;

            int temp = cbt[pi];
            cbt[pi] = cbt[maxIndex];
            cbt[maxIndex] = temp;

            pi = maxIndex;
        }

        return poppedElement;
    }

    void heapSort() {
        int originalSize = size;

        while (size > 0) {
            System.out.print(deletionMaxHeap() + " ");
        }

        size = originalSize;  // restore size
    }
}


class Main {
    public static void main(String[] args) {

        System.out.println("Try programiz.pro");

        int a[] = {1, 2, 3, 4, 5, 6};
        System.out.println("Length is " + a.length);

        ArrayToMaxHeapTree obj = new ArrayToMaxHeapTree(a);

        System.out.println("Heap sort:");
        obj.heapSort();
    }
  }
