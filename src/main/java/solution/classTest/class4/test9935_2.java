package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class test9935_2 {
    static Stack<Character> stack = new Stack<>();
    static String str;
    static String pattern;
    static LinkedList<Character> queue = new LinkedList<>();
    static int lng;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        pattern = br.readLine();
        lng = pattern.length();
        arr = pattern.toCharArray();

        for(int i = 0 ; i<str.length(); i++){
            char character = str.charAt(i);
            stack.push( character );

            //System.out.println(stack.toString());
            //System.out.println(queue.size());

            queue.add(character);
            if(queue.size()>lng){
                queue.poll();
            }

            if(queue.size()==lng && checkData()){
                queue.clear();
                char[] tmp = new char[lng-1];
                for(int j = 0; j<lng; j++){
                    stack.pop();
                }

                int stackSize;

                if(stack.size()>=lng-1){
                    stackSize = lng-1;
                }else{
                    stackSize = stack.size();
                }

                for(int j = stackSize-1; j>=0; j--){
                    tmp[j] = stack.pop();
                }
                for(int j = 0; j<stackSize; j++){
                    stack.push(tmp[j]);
                    queue.add(tmp[j]);
                }
            }
        }

        if(stack.isEmpty()){
            System.out.printf("FRULA");
            return;
        }

        Character[] newStr = stack.stream().toArray(Character[]::new);

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i< newStr.length; i++){
            sb.append(newStr[i]);
        }

        System.out.println(sb.toString());
    }
    public static boolean checkData(){
        for(int i=0; i<lng; i++){
            if(queue.get(i)!=arr[i]){
                return false;
            }
        }
        return true;
    }
}

/*
iyZ0xavf9NiyZpiiyZui
iyZ

answer : 0xavf9Npiui

mxezXBGz7ewGhY428yGxylDczmxezXJIYjC1m07pmxezXmxezX
mxezX

answer : BGz7ewGhY428yGxylDczJIYjC1m07p

anananananananananT
ant

answer : anananananananananT

qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq
q

answer : FLURA

99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999VhcL2gG57qPJDQibBkUZArnzxELrLMrXRrutlL57BoQRapABp7quwrhFWpMq5je8CGIDwXcs7UVKNt5eI43v3URmlPOqCDGGJ7O4fe4JWNIhxwtz8W8x94DaTHDNjhjJUax3iAgPvgzkqGyTwQSahgIkRbPXIsaaza0XNcpTutgMUbcdRQi0grPmiQMfIYp9nRFAkPgm
9

abacabcc
abc

acddd
abcd

abdc
abc
 */