package oop1;

public class MusicMain1 {
    public static void main(String[] args) {

        int volume = 0;
        boolean power = false;


        //켜기
        power = true;
        System.out.println("음악이 재생되었습니다");

        //볼륨올리기
        volume ++;
        System.out.println("음악 볼륨 : " + volume);
        volume ++;
        System.out.println("음악 볼륨 : " + volume);

        //내리기
        volume --;
        System.out.println("음악 볼륨 : " + volume);

        //확인
        if (power = true) {
            System.out.println("음악 재생중  볼륨 :" + volume);
            System.out.println("음악을 정지합니다");
                    }else {
            System.out.println("정지상태");
        }
    }
}
