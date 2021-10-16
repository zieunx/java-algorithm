package com.example.demo.beakjoon;

import java.util.Scanner;

public class n2292 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(getStep(sc.nextInt()));
        sc.close();
    }
    static int getStep(int n) {
        int step = 1;
        int lastNumber = 1;
        while (n > lastNumber) {
            lastNumber += 6*(step);
            step++;
        }
        return step;
    }
}

/*

<풀이>

1칸 : 1
2칸 : 2~7
3칸 : 8~19
4칸 : 20~37

접근 방식 :
        입력 값이 어떤 구간의 숫자인지 알아 낸다.
        구간을 알아내기 위해서 각 구간의 끝 숫자의 규칙을 찾아내보았다.

구간의 끝
1 - 7 - 19 - 37 ...

1 = 6 * 0
7 = 6 * 1 + 6 * 0
19 = 6 * 2 + 6 * 1 + 6 * 0
37 = 6 * 3 + 6 * 2 + 6 * 1 + 6 * 0

따라서, 찾아낸 구간의 끝 숫자 규칙.
step = 구간
lastNumber = step구간의 끝숫자
>> lastNumber = 6*(step-1) + 6*(step-2) .... 6*(0)


입력받은 N의 구간을 알아내기 위해
while문을 사용해보았다.

```
int step = 1;
int lastNumber = 1;
while (n > lastNumber) {
    lastNumber += 6*(step);
    step++;
}
```

*/
