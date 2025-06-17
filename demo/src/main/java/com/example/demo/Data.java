package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Data {

    public static void main(String[] args) {

//        Scanner input = new Scanner(System.in);
//        System.out.print("input command : "); // this area is spring web ( by browser, html )
//
//        String cmd = input.nextLine(); // spring web controller
//        System.out.println("cmd : " + cmd);  // spring web controller

        // ... spring web service layer : start
//        Data data = new Data(); //
//        if (cmd.equals("data1")) {
//            data.data1();
//        } else if (cmd.equals("data2")) {
//            data.data2();
//        } else {
//            System.out.println("invalid input");
//        }
        // web service layer : end

        //Called methods
        data1();
        data2();
    }

    static Map<String, String> data1 = new HashMap<>();

    // service layer
    //Method
    public static void data1() {
        data1.put("dataA", "DataAA");
        data1.put("dataB", "DataBB");
        data1.put("dataC", "DataCC");
        data1.put("dataD", "DataDD");

            //Professor code
//        String findValueData1 = "dataB";
//        for (String s : data1.keySet()) {
//            if (data1.get(s).equals(findValueData1)) {
//                System.out.print(data1.get(s));
//            }
//        }

        String findValueData1 = "dataB";// find the key name <dataB> through looping | The goal we want
        for (String s : data1.keySet()) {  //keySet(): use to get only the keys from the map — not the values (HashMap, TreeMap)
            //String m = data1.get(s); //get(your_key): use to get only the value from specific key in the map — not the key (HashMap, TreeMap)
            if (s.equals(findValueData1)) {
                System.out.print("Find tha key: " + s + "\n");
                //System.out.print("Find tha key: " + s + "|" + m +"\n");
            }
        }
        // if the result save in storage --> this layer is repository
    }

    static Map<String, Member> data2 = new HashMap<>();
    //Method
    public static void data2() {
        data2.put("dataA", new Member(1L, "name1"));
        data2.put("dataB", new Member(2L, "name2"));
        data2.put("dataC", new Member(3L, "name3"));
        data2.put("dataD", new Member(4L, "name4"));

        String findValueData2 = "name3"; // The goal we want
        for (String s : data2.keySet()) { //keySet(): use to get only the keys from the map — not the values (HashMap, TreeMap)
            Member m = data2.get(s);//get(your_key): use to get only the value from specific key in the map — not the key (HashMap, TreeMap)
            if (m.getName().equals(findValueData2)) {
                System.out.print("Find the key and value: "+ m.getId() + " | " + m.getName());
            }
        }
    }


}
