package solution.programmers;
import java.util.*;

// 당연히 시간초과 및 메모리 초과를 상정하고 풀었다.
    // dfs를 이용한 단순 탐색에 약간의 조건 제어만 추가해준 형태
    // 1~11, 22-24 만 통과
    // 그 외에는 메모리, 시간 초과 다수에 12번은 그냥 오답이 나온다(단순 로직인데 어째서...?)
public class Kakao2022_hikingCourse_v1 {

    class Solution {

        int count = 0; // test값

        boolean[] visited;

        ArrayList<Node> nodeList = new ArrayList<>();

        ArrayList<Integer[]> visitedTops = new ArrayList<>();

        int n;

        // 정답에 관여 X. 탐색 시간 줄이기용.
        int min = Integer.MAX_VALUE;

        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            this.n = n;
            visited = new boolean[n];

            for(int i = 0 ; i<n; i++){
                nodeList.add(new Node(i));
            }

            for(int i = 0 ; i<paths.length; i++){
                int[] path = paths[i];
                int from = path[0]-1;
                int to = path[1]-1;
                int distance = path[2];

                nodeList.get(from).connected.add(new Integer[]{to, distance});
                nodeList.get(to).connected.add(new Integer[]{from, distance});
            }

            for(int i = 0 ; i<gates.length; i++){
                nodeList.get(gates[i]-1).isStart=true;
            }

            for(int i = 0 ; i<summits.length; i++){
                nodeList.get(summits[i]-1).isTop=true;
            }

            // 로직

            for(int i = 0 ; i<n; i++){
                Node node = nodeList.get(i);
                if(node.isStart){
                    visited[i] = true;
                    dfs(new Integer[]{ node.idx, Integer.MIN_VALUE }); // 초기 출발값은 충분히 작은 값으로
                    // 출발점은 방문하면 안되기 때문에 굳이 false로 돌려줄 필요가 없다.
                }
            }

            Collections.sort( visitedTops, (e1,e2)->{
                if(e1[1]==e2[1]){
                    return e1[0] - e2[0];
                }
                return e1[1] - e2[1];
            });

            Integer[] least = visitedTops.get(0);
            int[] answer = {least[0]+1, least[1]};

            return answer;
        }

        public void dfs(Integer[] info){
            Node node = nodeList.get(info[0]);
            int value = info[1];

            //System.out.println("현재 방문 노드는" + (node.idx+1));
            //System.out.println("현재 visited 대상은 " + node.connected.size() + "개 입니다.");

            if(node.isTop){ // 정상인 경우
                // System.out.println("들어옴");
                min = Math.min(value, min); // 최소값 갱신 후
                visitedTops.add(info);  // 방문한 정상 리스트에 데이터 추가
                return; // 탐색 종료
            }

            ArrayList<Integer[]> connected = node.connected; // 연결된 노드 리스트를 가져와서
            for(int i = 0 ; i<connected.size(); i++){   // 순회
                Integer[] next = connected.get(i);   // 다음 노드 정보
                int idx = next[0];
                int distance = next[1];

                // System.out.print(!visited[idx] +" ");
                // System.out.print(min>=distance +" ");
                // System.out.println(!nodeList.get(i).isStart +" ");
                if(!visited[idx] && min>=distance && !nodeList.get(idx).isStart){
                    // 방문하지 않았으면서 거리가 최소값 이하이면서 출발점이 아니면
                    visited[idx] = true; // 방문 체크 해주고
                    dfs(new Integer[]{idx, Math.max(value, distance)}); // 최소값을 추가해서 해당 노드에서 탐색
                    visited[idx] = false; // 순회 종료 후 방문 체크 해제
                }
            }
        }

        class Node{
            int idx;
            ArrayList<Integer[]> connected = new ArrayList<>();
            boolean isTop = false;
            boolean isStart = false;

            Node(int idx){
                this.idx = idx;
            }
        }
    }
}
