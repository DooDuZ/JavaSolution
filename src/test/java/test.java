import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.util.*;
class test{
    public static void main(String[] args) {

        int[] arr = {1,2,3};

        int[] arr2 = arr.clone();

        arr2[0] = 2;

        for(int i = 0 ; i<3; i++){
            System.out.println(arr[i] + " : " + arr2[i]);
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
