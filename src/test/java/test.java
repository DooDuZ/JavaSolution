import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.util.*;
class test{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();
        ArrayList<Content> contents = new ArrayList<>();

        while(true){
            System.out.println("=============================================");
            System.out.println("1. 회원가입  2. 로그인 3. 게시판 4. 로그아웃");

            int cmd = scanner.nextInt();

            if(cmd==4){
                break;
            }
        }
    }
}

class User{
    String id;
    String pw;
    String name;
    String email;

    User(String id, String pw, String name, String email){
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.email = email;
    }
}

class Content{
    String title;
    String writer;
    String content;
}
