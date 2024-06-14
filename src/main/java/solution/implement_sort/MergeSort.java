package solution.implement_sort;


public class MergeSort {

    // 외부에서 호출되는 메서드
    public void sort(int[] arr) {
        mergeSort(arr);
    }

    // 최초 호출
    // 배열을 입력 받고, 정렬에 임시로 사용할 sorted배열을 선언해서 넘겨준다
    private void mergeSort(int[] arr) {
        int[] sorted = new int[arr.length];

        mergeSort(0, arr.length - 1, sorted, arr);
    }

    // 인자로 좌/우 범위의 인덱스를 받는다
    // 매 비교마다 배열을 생성한다면 메모리 할당을 계속해서 해야한다
    // 파라미터로 받아온 sorted배열에 각 인덱스를 통해 값을 저장한다
    private void mergeSort(int left, int right, int[] sorted, int[] arr) {
        // 좌, 우 값이 같다면 값이 하나만 있으므로 return
        if (left == right) {
            return;
        }

        // 중간 값을 구하고
        int mid = (left + right) / 2;

        // 양쪽으로 나눠서 재귀 호출
        mergeSort(left, mid, sorted, arr);
        mergeSort(mid + 1, right, sorted, arr);

        // 양쪽 배열 병합
        merge(left, right, sorted, arr);
    }

    // 역시 좌/우 값을 파라미터로 받는다
    private void merge(int left, int right, int[] sorted, int[] arr) {

        // 저장용 배열의 인덱스. 가장 왼쪽 값부터 시작
        int index = left;
        // 왼쪽은 시작점부터
        int l = left;
        int mid = (left + right) / 2;
        // 오른쪽 배열은 중간값 + 1부터 시작
        int r = mid + 1;

        // 양쪽 배열 중 한쪽의 모든 값을 다 사용할 때까지
        while (l <= mid && r <= right) {
            // 왼쪽이 오른쪽 보다 작거나 같다면 왼쪽 값을 임시 배열에 삽입한다.
            // 만약 <=이 아닌 <를 사용한다면 뒷 순서의 값이 앞쪽으로 삽입되므로 stable한 상태가 깨지게 된다.
            if (arr[l] <= arr[r]) {
                sorted[index] = arr[l];
                l++;
            } else {
                sorted[index] = arr[r];
                r++;
            }
            index++;
        }

        // 한쪽 배열 다 채운 뒤, 남은 값을 끝까지 채워준다
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

        // 주어진 구간의 값을 정렬해서 교체하는 과정
        // 임시 배열의 값을 원본 배열로 복사해준다
        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }
}
