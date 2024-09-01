import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2751Merge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Merge m = new Merge();
        m.sort(arr);

        for (int i = 0; i < num; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

class Merge {
    public void merge(int[] a, int[] b, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                b[k] = a[j++];
            } else if (j > high) {
                b[k] = a[i++];
            } else if (isLess(a[j], a[i])) {
                b[k] = a[j++];
            } else {
                b[k] = a[i++];
            }
        }

        for (int k = low; k <= high; k++) {
            a[k] = b[k];
        }
    }

    public void sort(int[] a) {
        int[] b = new int[a.length];
        sort(a, b, 0, a.length - 1);
    }

    public void sort(int[] a, int[] b, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(a, b, low, mid);
        sort(a, b, mid + 1, high);
        merge(a, b, low, mid, high);
    }

    public boolean isLess(int a, int b) {
        return a < b;
    }
}
