package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test5639 {
    static ArrayList<Integer> nodeList = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 마지막 입력 케이스를 주지 않은 문제였다
            // 이런걸 EOF라고 부르는듯 함..
            // break조건을 str.equals("")로 하면 nullPointerException이 나온다
        while (true){
            String str = br.readLine();
            if(str==null){
               break;
            }
            nodeList.add(Integer.parseInt(str));
        }

        // System.out.println("탈출 성공");
        // System.out.println(nodeList.toString());

        root = new Node( nodeList.get(0) );

        Node currentNode = root;

        for(int i = 1; i<nodeList.size(); i++){
            int value = nodeList.get(i);
            Node node = new Node(value);
            while (true){
                if(value < currentNode.value){
                    if(currentNode.left==null){
                        node.parent = currentNode;
                        currentNode.left = node;
                        currentNode = root;
                        break;
                    }else{
                        currentNode = currentNode.left;
                    }
                }else{
                    if(currentNode.right==null){
                        node.parent = currentNode;
                        currentNode.right = node;
                        currentNode = root;
                        break;
                    }else{
                        currentNode = currentNode.right;
                    }
                }
            }
        }

        postorder(root);

        System.out.println(sb);
    }

    static public void postorder(Node currentNode){
        if(currentNode.left==null && currentNode.right==null){
            sb.append( currentNode.value ).append("\n");
            return;
        }
        if(currentNode.left!=null){
            postorder(currentNode.left);
        }
        if(currentNode.right!=null){
            postorder(currentNode.right);
        }
        sb.append( currentNode.value ).append("\n");
    }

}

class Node{
    int value;

    Node parent;
    Node left;
    Node right;

    Node(int value){
        this.value = value;
    }

    @Override
    public String toString(){

        String str = String.valueOf(value+" ");

        if(left!=null){
            str += left.toString() + " ";
        }

        if(right!=null){
            str += right.toString() + " ";
        }

        return str;
    }
}
