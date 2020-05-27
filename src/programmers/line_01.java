package programmers;

import java.util.ArrayList;
import java.util.List;

public class line_01 {
    public static void main(String[] args) {
        List<List<String>> snapshots = new ArrayList<>();
        List<String> data = new ArrayList<>();
        data.add("ACCOUNT1");
        data.add("100");

        snapshots.add(data);


        // String[][] transactions =
        // {
        //     {
        //         "1", "SAVE", "ACCOUNT2", "100"
        //     },
        //     {
        //         "2", "WITHDRAW", "ACCOUNT1", "50"
        //     },
        //     {
        //         "1", "SAVE", "ACCOUNT2", "100"
        //     },
        //     {
        //         "4", "SAVE", "ACCOUNT3", "500"
        //     },
        //     {
        //         "3", "WITHDRAW", "ACCOUNT2", "30"
        //     }
        // };


//        String[][] answer = solution(snapshots, transactions);

//        for (int i=0 ; i<answer.length ; i++) {
//            System.out.print("[\"");
//            for (int j=0; j<answer[0].length; j++) {
//                System.out.print(answer[i][j] + "\", \"");
//            }
//            System.out.println("]");
//        }

    }
//    public static String[][] solution(List<List<String>> snapshots, List<List<String>>  transactions) {
//        String[][] answer = {};
//
//        for (int i=0 ; i < transactions.size() ; i++) {
//            int index = checkAccount(snapshots, transactions.get(i).get(2));
//
//            if (index == -1) {
//
//                List<String> data = new ArrayList<>();
//                data.add(Integer.parseInt(transactions.get(i).get(2)), transactions.get(i).get(3));
//                snapshots.add(data);
//            } else {
//                if (transactions.get(i).get(1).equals("SAVE")) {
//                    snapshots.get(index).set(1, String.valueOf(Integer.parseInt(transactions.get(i).get(3)) + Integer.parseInt(snapshots.get(index).get(1))));
//                } else {
//                    snapshots.get(index).set(1, String.valueOf(Integer.parseInt(snapshots.get(index).get(1)) - Integer.parseInt(transactions.get(i).get(3))));
//                }
//            }
//        }
//        return answer;
//    }

    public static int checkAccount(List<List<String>>  snapshots, String data) {
        for (int j=0 ; j < snapshots.size() ; j++) {
            if (data.equals(snapshots.get(j).get(0))) {
                return j;
            }
        }
        return -1;
    }
}
