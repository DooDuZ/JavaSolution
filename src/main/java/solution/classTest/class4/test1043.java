package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test1043 {

    static Integer[] people;
    static ArrayList< ArrayList<Integer> > parties = new ArrayList<>();
    static LinkedList<Integer> memberList = new LinkedList<>();
    static boolean[] visited;
    static boolean[] isMember;
    static int liarParty;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        people = new Integer[N];

        liarParty = M;
        isMember = new boolean[N];
        visited = new boolean[M];

        for(int i = 0 ; i<N; i++){
            people[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int members = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i<members; i++){
            int memNo = Integer.parseInt(st.nextToken())-1;
            isMember[memNo] = true;
            memberList.add( people[memNo] );
        }

        for(int i = 0 ; i<M; i++){
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> party = new ArrayList<>();
            int capacity = Integer.parseInt(st.nextToken());
            for(int j = 0; j< capacity; j++){
                party.add( people[Integer.parseInt(st.nextToken())-1] );
            }
            parties.add(party);
        }

        checkMember();

        System.out.println(liarParty);
    }

    public static void checkMember(){
        if(memberList.isEmpty()){
            return;
        }

        Integer member = memberList.pop();

        // System.out.println("이번 파티의 멤버는 " + member);

        for(int i = 0 ; i<parties.size(); i++){
            ArrayList<Integer> party = parties.get(i);
            if( !visited[i] && party.contains(member)){
                // System.out.println("참여한 파티의 번호는 " + i);
                visited[i] = true;
                liarParty--;
                for(int j = 0; j < party.size(); j++){
                    int mno = party.get(j);
                    if(!isMember[mno]){
                        isMember[mno] = true;
                        memberList.add(people[mno]);
                        // System.out.println("추가된 멤버는 " + people[mno]);
                    }
                }
            }
        }
        checkMember();
    }
}
