package solution.levelTest.level11;

public class 번외_mergeSort {
	
	static int[] sorted = null;
	
	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};

		new 번외_mergeSort().merge_sort(arr);
		
		for(int tmp : arr) {
			System.out.println(tmp);
		}
	}
	public void merge_sort(int[] arr) { // 최초 배열을 파라미터로 받는다
		sorted = new int[arr.length];	// 정렬 결과를 임시로 저장할 배열을 선언
		merge_sort(arr, 0, arr.length-1);
			// 입력받은 배열 / 첫번째 인덱스(왼쪽 끝), / 마지막 인덱스(오른쪽 끝) 을 파라미터로 오버로딩된 머지솔트 매서드 실행
		sorted = null;	// merge_sort가 완료되면 정렬된 배열을 arr에 대입하게 되므로, 사용이 끝난 배열을 비워준다
	}
	
	public void merge_sort(int[] arr, int l, int r) {	// 배열, 왼쪽 끝 인덱스, 오른쪽 끝 인덱스
		int m = (l+r)/2;
			// 왼쪽과 오른쪽 인덱스의 중간지점
			// 착각하면 안되는 것이, 새로운 배열을 만들고 섞는 게 아니라, 기존 배열들의 인덱스 값들을 컨트롤하며 정렬을 만든다.
		if(l==r) {	// l과 r이 같다 = 배열의 길이가 1이다 
			return;	// 더 쪼깨지지 않으므로 리턴
		}
		merge_sort(arr,l,m); //배열의 왼쪽 끝항부터 중간값까지
		merge_sort(arr,m+1,r);	// 배열의 중간+1항부터 오른쪽 끝값까지
		
		merge(arr,l, m,r); // 정렬이 끝나면 merge 
		
		/*
			1단위까지 merge_sort의 분할이 일어남 / 정렬 후 merge
			-> merge되면 arr이 부분적으로 정렬된 상태 / merge_sort가 시작된 곳으로 돌아가 해당단계에서 다시 merge
			-> 반복
		*/
	}
	
	public void merge(int[] arr, int l , int m, int r) {
		int left = l;	// 왼쪽 출발점
		int right = m+1; // 오른쪽 출발점
		int count = l;	
			// 인덱스 카운팅 변수 -> 여기서 계속 0을 대입해서 한참을 헤맸는데...
			// merge가 마지막 과정같아 보이지만, 사실은 입력된 인덱스끼리 비교해서 자기들 끼리만 값을 바꾸고 있고, 그때마다 merge를 통해서 대입이 일어난다 
			// 한마디로 가장 마지막 경우가 계속해서 부분부분만 값을 대입하고 정렬하는 상태이기 떄문에, 대입은 0이 아닌 입력받은 가장 왼쪽 항부터 일어나야 한다는 것이다		
		
		while(left <= m && right<=r) {	// left가 m까지 대입되거나, 우측 출발점이 r까지 
			if(arr[left]<=arr[right]) { // 만약 왼쪽인덱스보다 오른쪽 인덱스가 더 크면
				sorted[count] = arr[left];	// 기본은 오름차순이므로 더 작은 숫자를 정렬용 배열에 대입한 후
				left++;	//왼쪽 출발점을 1 더해준다
				count++;	// 인덱스도 역시 +1
			}else if(arr[left]>=arr[right]){
				sorted[count] = arr[right]; // 반대의 경우 오른쪽을 대입후
				right++;	// 오른쪽 출발점 ++
				count++;	// 인덱스 ++
			}
		}
		
		// left가 m까지 대입되거나, right가 r까지 대입된 뒤 while문을 벗어나면 실행
		
		if(left>m) {	// 만약 left가 m까지 진행해서 배열 왼쪽부분의 대입이 끝났다면
			while(right<=r) {	// 배열의 오른쪽에 남은 값이 있다는 뜻이므로
				sorted[count] = arr[right];	// sorted의 다음 인덱스에 오른쪽 부분을 대입해주고
				count++; // 인덱스와
				right++; // 우측 출발점 ++
			}
		}else if(right>r){ // 우측항이 우측 끝항까지 대입이 끝났다면 right은 r보다 1 큰 상태
			while(left<=m) {	// left를 m항까지 반복해서 증가시키면서
				sorted[count] = arr[left];	// 정렬 배열에 왼쪽 값들을 대입해준다
				count++;
				left++;
			}
		}
		
		// 이러면 끝났다
		
		System.out.println();
		for(int tmp : sorted) {
			System.out.println(tmp);
		};
		System.out.println();		
		
		// 배열을 째로 대입해도 되는건 마지막 정렬 때 뿐이고, 그 전까진 인덱스값들 끼리만 서로 자리를 바꾸고 있을 뿐이다.
		// 그러므로 반드시 인덱스별로 대입해줘야한다.
		for(int i = l; i<=r; i++) {
			arr[i] = sorted[i];
		}
	}
}
	
