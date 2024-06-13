package solution.implement_sort;

public class MergeSort {
    public void sort(int[] arr) {
        mergeSort(arr);
    }


    private void mergeSort(int[] arr) {
        int[] sorted = new int[arr.length];

        mergeSort(0, arr.length - 1, sorted, arr);
    }


    private void mergeSort(int left, int right, int[] sorted, int[] arr) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(left, mid, sorted, arr);
        mergeSort(mid + 1, right, sorted, arr);

        merge(left, right, sorted, arr);
    }

    private void merge(int left, int right, int[] sorted, int[] arr) {
        int index = left;
        int l = left;
        int mid = (left + right) / 2;
        int r = mid + 1;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                sorted[index] = arr[l];
                l++;
            } else {
                sorted[index] = arr[r];
                r++;
            }
            index++;
        }

        if (l <= mid) {
            while (index <= right) {
                sorted[index] = arr[l];
                index++;
                l++;
            }
        } else {
            while (index <= right) {
                sorted[index++] = arr[r++];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }
}
