package beakjoon;

import java.util.Scanner;

public class n10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, H, W, N, Y, X;
        T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            H = sc.nextInt();
            W = sc.nextInt();
            N = sc.nextInt();

            Y = (int) Math.ceil((double) N / (double)H);
            X = N - (H * (Y -1));

            System.out.println(X * 100 + Y);
        }
    }
}
/*

<풀이>


### 접근 방식
> 호수를 기준으로 1층부터 H층 까지 채워야 한다.
> 규칙을 찾아 층과 호를 각자 구해보았다.

(층, 호)
```
5 (5, 1)      (H * 1)+5       (H * 2)+5
4 (4, 1)      (H * 1)+4       (H * 2)+4
3 (3, 1)      (H * 1)+3       (H * 2)+3
2 (2, 1)      (H * 1)+2       (H * 2)+2
1 (1, 1)      (H * 1)+1       (H * 2)+1
```
따라서 각 층,호에 투숙하게 될 손님은 다음과 같은 수식으로 호수를 배정받는다.
```
 N = (H * (Y-1)) + X
```

먼저 구해볼 숫자는 호.<br>
Y = N / H 한 값의 올림을 하면 된다.<br>
예를 들어 H = 6일 때
```
6 / 6 = 1
5 / 6 = 0.XX
4 / 6 = 0.XX
3 / 6 = 0.XX
2 / 6 = 0.XX
1 / 6 = 0.XX
```
로 떨어지기 때문에 '올림'처리 해주면 1~6 까지 호수는 '1'이 된다.

위의 수식을 기반으로 X를 구하는 식은
```
X = N - (H * (Y-1))
```

위의 식들을 기반으로 코드를 작성해보면 다음과 같다.
```java
Y = (int) Math.ceil((double) N / (double)H);
X = N - (H * (Y -1));
```

*/

