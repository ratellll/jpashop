package oop1;

public class MusicMain3 {
    public static void main(String[] args) {

        MusicPlayerData music = new MusicPlayerData();


        //켜기
       on(music);

        //볼륨올리기
        volumeUp(music);
        volumeUp(music);


        //내리기
        volumeDn(music);


        //확인
        showStatus(music);
    }

    static void on(MusicPlayerData data) {
        data.isOn = true;
        System.out.println("음악이 재생되었습니다");
    }
    static void off(MusicPlayerData data) {
        data.isOn = false;
        System.out.println("음악이 정지되었습니다");
    }

    static void volumeUp(MusicPlayerData data) {
        data.volume++;
        System.out.println("음악 볼륨 : " + data.volume + "으로 올라갔습니다");
    }
    static void volumeDn(MusicPlayerData data) {
        data.volume--;
        System.out.println("음악 볼륨 : " + data.volume + "으로 내려갔습니다");
    }

    static void showStatus(MusicPlayerData data) {
        if (data.isOn == true) {
            System.out.println("음악 재생중  볼륨 :" + data.volume);
        }else {
            System.out.println("정지상태");
        }
    }
}
