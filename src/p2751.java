import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class p2751 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int num = sc.nextInt();
        int arr[] = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
      int[]result= new quickSort().sort(arr);
        for(int i=0;i<num;i++){
            System.out.println(result[i]);
        }
    }

    static class quickSort {
        public int[] sort(int[] a) {
            sort(a,0,a.length-1);
            return a;
        }

        public void sort(int[] a, int low, int high) {
            if (high <= low) {
                return;
            }
            int j = partition(a, low, high);
            sort(a, low, j - 1);
            sort(a, j, high);
        }

        public int partition(int[] a, int pivot, int high) {
            int i = pivot + 1;
            int j = high;
            int memory = a[pivot];
            while (true) {
                while (i < high && a[i] <= memory) {
                    i++;
                }
                while (j > pivot && a[j] > memory) {
                    j++;

                }
                if (i >= j) {
                    swap(a, i, j);
                    break;
                }

            }
            swap(a, pivot, j);
            return j;
        }

        public void swap(int[] a, int first, int second) {
            int memory = a[first];
            a[first] = a[second];
            a[second] = memory;
        }

    }

}
