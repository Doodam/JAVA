package edu.java.class02;


// 클래스(class): 프로그램에서 필요한 데이터와 기능을 묶어서 하나의 "데이터 타입"으로 정의한 것.
// - 데이터 -> 필드(field), 멤버 변수, 속성(property)
// - 기능   -> 메서드(method) 선언
// 데이터 타입 -> 변수 선언, parameter 선언, 메서드 리턴 타입 선언.
// 클래스 선언: [수식어] + class + 클래스이름 + {...}
// 클래스 이름 작성: 
// - 영문자, 숫자, _, $ 를 사용할 수 있음.
// - 숫자로 시작할 수 없음.
// - 대문자로 시작하는 camel 표기법을 권장.

public class BasicTv {
	// field - 클래스의 모든 메서드에서 사용 가능.
	private static final int MAX = 5;
	private static final int MIN = 0;
	boolean powerOn; // TV의 전원 상태(true:ON, false:OFF)를 저장하는 필드.
	int channel; // TV의 현재 채널을 저장하는 필드.
	int volume; // TV의 현재 음량을 저장하는 필드.

	// method
	public void powerOnOff() {
		if (powerOn) { // TV가 켜져 있으면
			powerOn = false; // TV를 끔.
			System.out.println("TV OFF");
		} else { // TV가 꺼져 있으면
			powerOn = true; // TV를 켬.
			System.out.println("TV ON");
		}
	}

	public void channelUp() {
		if (powerOn) { // if(powerOn==true)가능. TV전원이 ON인 경우에
			if (channel < MAX) { // TV채널 번호가 최댓값보다 작은 경우 <5
				channel++; // 현재 채널 번호를 1증가.
			} else { // TV채널 번호가 최댓값보다 크거나 같으면
				channel = MIN; // TV채널의 최솟값으로 바꿈(채널을 순환시킨다) =0
			}

		}
		System.out.println("채널 : " + channel);
	}

	public void channelDown() {
		if (powerOn) { // TV전원이 ON인 경우에
			if (channel > MIN) { // 현재 채널이 0보다 클 때(최솟값에 도달하지 않았을때)
				channel--; // 현재 채널 번호를 1감소.
			} else { // 채널이 0보다 작거나 같을 때(최솟값에 도달했을 때)
				channel = MAX; // 현재 채널을 채널 최댓값으로 변경.
			}
		}
		System.out.println("채널 : " + channel);

	}

	public void volumeUp() {
		if (powerOn) {
			if (volume < MAX) {
				volume++; // 현재 음량 1증가.
			}
		}

		System.out.println("음량 : " + volume);

	}

	public void volumeDown() {
		if (powerOn) { // if(powerOn & volume > 0  )
			if (volume > MIN) {
				volume--; // 현재 음량 1감소.
			}
			
		}

		System.out.println("음량 : " + volume);
	}

}
