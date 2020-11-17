package programmers.카카오코딩테스트.오픈채팅방;

import java.util.*;

public class Solution {
    /*
Enter uid1234 Muzi
Enter uid4567 Prodo
Leave uid1234
Enter uid1234 Prodo
Change uid4567 Ryan
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] request = new String[5];
        for (int i = 0; i < 5; i++) {
            request[i] = sc.nextLine();
        }

        String[] result = solution(request);

        for (String text : result) {
            System.out.println(text);
        }
    }

    public static String[] solution(String[] record) {
        String[] answer;
        int answerSize = 0;
        Map<String, String> nicknameMap = new HashMap<>();

        for (String request : record) {
            String[] requestArray = request.split(" ");

            String action = requestArray[0];
            String uid = requestArray[1];
            String nickname;

            switch (action) {
                case "Enter":
                    answerSize++;
                    // uid - nickname 데이터 추가
                    nickname = requestArray[2];
                    nicknameMap.put(uid,nickname);
                    break;
                case "Change":
                    // uid - nickname 데이터 추가
                    nickname = requestArray[2];
                    nicknameMap.put(uid,nickname);
                    break;
                case "Leave":
                    answerSize++;
                    break;
            }
        }

        answer = new String[answerSize];

        int index = 0;
        for (String request : record) {
            String[] requestArray = request.split(" ");

            String action = requestArray[0];
            if (!"Change".equals(action)) {
                String uid = requestArray[1];
                String nickname = nicknameMap.get(uid);

                answer[index] = nickname + ("Enter".equals(action) ? "님이 들어왔습니다." :"님이 나갔습니다.");

                index++;
            }
        }

        return answer;
    }
}
