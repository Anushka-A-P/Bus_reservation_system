package demo;

import datastructures.CustomAVLTree;
import java.util.Arrays;

public class Member4_Demo {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== MEMBER 4: AVL TREE, INSERTION SORT & COMPLEXITY ANALYSIS ===\n");

        // 1. Testing AVL Tree from datastructures package
        System.out.println("--- AVL Tree Bus Management ---");
        CustomAVLTree avlTree = new CustomAVLTree();
        avlTree.insert(105, "ND-1111", 40);
        avlTree.insert(102, "CA-2222", 30);
        avlTree.insert(108, "WP-3333", 50);
        avlTree.insert(101, "SG-4444", 25);

        System.out.println("Buses stored in AVL Tree (Inorder Traversal - Sorted by ID):");
        avlTree.display();

        // 2. Testing Insertion Sort
        System.out.println("\n--- Insertion Sort: Sorting Bus Capacities ---");
        int[] busCapacities = {45, 20, 60, 30, 15};
        System.out.println("Before Sorting: " + Arrays.toString(busCapacities));

        insertionSort(busCapacities);

        System.out.println("After Sorting:  " + Arrays.toString(busCapacities));

        // 3. Complexity Analysis Summary
        System.out.println("\n--- Complexity Analysis Summary ---");
        System.out.println("1. AVL Tree Operations (Insert, Search, Delete):");
        System.out.println("   - Time Complexity  : O(log n)");
        System.out.println("   - Space Complexity : O(n)");
        System.out.println("2. Insertion Sort Algorithm:");
        System.out.println("   - Time Complexity  : O(n^2) [Worst/Average], O(n) [Best Case]");
        System.out.println("   - Space Complexity : O(1)");
    }
}