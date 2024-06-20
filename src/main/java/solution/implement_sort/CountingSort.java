package solution.implement_sort;

public class CountingSort {
    private int min;
    private int max;

    // 외부에서 호출되는 메서드
    public int[] sort(int[] arr) {
        if (arr == null || arr.length == 0){
            return arr;
        }
        return countingSort(arr, getCountArray(arr));
    }

    private int[] countingSort(int[] arr, int[] count) {
        // 입력 배열에 있는 각 값의 개수를 센다
        countElements(arr, count);
        // counting 배열 누적합
        prefixSum(count);

        int[] sorted = new int[arr.length];

        // 안정 상태 유지를 위해 뒤부터 순회
        for (int i = arr.length - 1; i >= 0; i--) {

            // 0인덱스이므로 - 1
            sorted[--count[arr[i] - min]] = arr[i];
        }

        return sorted;
    }

    private void countElements(int[] arr, int[] count) {
        for (int number : arr) {
            // arr의 value를 count 배열의 index로 사용한다
            count[number - min] += 1;
        }
    }

    private void prefixSum(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i] + numbers[i - 1];
        }
    }

    private int[] getCountArray(int[] arr) throws IllegalArgumentException {
        findRangeBound(arr);
        // 유효 범위가 아니라면 exception이 발생한다.
        validateRange();

        return new int[max - min + 1];
    }

    private void validateRange() {
        // 찾은 범위로 배열을 생성한다.
        // 범위가 천만을 넘어가면 exception을 발생 시킨다.
        if (max - min >= 10_000_000) {
            throw new IllegalArgumentException("범위 초과");
        }
    }

    private void findRangeBound(int[] arr) {
        // count 배열 생성을 위한 범위가 필요하다.
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // N번 순회하며 최대값과 최소값을 찾는다
        for (int number : arr) {
            max = Math.max(max, number);
            min = Math.min(min, number);
        }

        // 클래스의 필드 멤버에 저장
        this.max = max;
        this.min = min;
    }
}
