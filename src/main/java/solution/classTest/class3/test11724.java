package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test11724 {

    static ArrayList<GraphNode> dots = new ArrayList<>();

    static int line = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i<N; i++){
            dots.add( new GraphNode() );
        }

        for(int i = 0 ; i<M; i++){
            st = new StringTokenizer(br.readLine());
            GraphNode startNode = dots.get(Integer.parseInt(st.nextToken()) - 1);
            GraphNode endNode = dots.get(Integer.parseInt(st.nextToken()) - 1);

            startNode.nodeList.add(endNode);
            endNode.nodeList.add(startNode);
        }

        for(int i = 0 ; i<dots.size(); i++){
            GraphNode node = dots.get(i);
            if(!node.visited){
                node.visited = true;
                if( node.nodeList.size()==0 || node.roundList(0)>0){
                    line++;
                }
            }
        }

        System.out.println(line);
    }
}

class GraphNode{
    boolean visited = false;
    ArrayList<GraphNode> nodeList = new ArrayList<>();
    int roundList(int depth){

        int newDepth = depth;

        for(int i = 0; i<nodeList.size(); i++){
            GraphNode node = nodeList.get(i);
            if(!node.visited){
                node.visited = true;
                newDepth += node.roundList(depth+1);
            }
        }
        return newDepth;
    }
}
