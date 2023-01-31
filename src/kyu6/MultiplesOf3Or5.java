package kyu6;

public class MultiplesOf3Or5 {
    public int solution(int number) {
        if (number < 0) return 0;
        int[] num = new int[number];
        int counter = 0;
        int result = 0;
        for (int i = 0; i < number; i++){
            counter++;
            num[i] = counter;
        }
        for (int i = 0; i < number - 1; i++){
            if (num[i] == 1) continue;
            if (num[i]%3 == 0 || num[i]%5 == 0){
                result += num[i];
            }
        }
        return result;
    }
}
/* Other Solution
    public int solution(int number) {
        int sum=0;

        for (int i=0; i < number; i++){
            if (i%3==0 || i%5==0){sum+=i;}
        }
        return sum;
    }
}*/
