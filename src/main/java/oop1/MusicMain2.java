package oop1;

public class MusicMain2 {
    public static void main(String[] args) {

        MusicPlayerData music = new MusicPlayerData();


        //켜기
        music.isOn = true;
        System.out.println("음악이 재생되었습니다");

        //볼륨올리기
        music.volume ++;
        System.out.println("음악 볼륨 : " + music.volume);
        music.volume ++;
        System.out.println("음악 볼륨 : " + music.volume);

        //내리기
        music.volume --;
        System.out.println("음악 볼륨 : " + music.volume);

        //확인
        if (music.isOn = true) {
            System.out.println("음악 재생중  볼륨 :" + music.volume);
            System.out.println("음악을 정지합니다");
                    }else {
            System.out.println("정지상태");
        }
    }
}
