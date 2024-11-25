package com.itwll.inheritance01;

public class BasicTv /* extends Object */ {
	// 상수 선언
	public static final int MAX_CHANNEL = 3;
	public static final int MIN_CHANNER = 0;
	public static final int MAX_VOLUME = 3;
	public static final int MIN_VOLUME = 0;
	
	// field
	private boolean powerOn; // 전원 상태(true : ON, false : OFF)
	private int channel; // 현재 채널 번호
	private int volume; // 현재 음량 크기
	
	public BasicTv() {}
	
	public BasicTv(boolean powerOn, int channel, int volume) {
		this.powerOn = powerOn;
		this.channel = channel;
		this.volume = volume;
	}
	
	// method
	// (1) getter & setters
	// (2) powerOnOff: TV가 꺼져 있으면 키고, 켜져 있으면 끔. 현재 전원 상태를 리턴.
	// (3) channelUp : 채널 값을 1 증가. 증가된 채널 값을 리턴.
	// (4) channelDown : 채널 값을 1 감소. 감소된 채널 값을 리턴./
	// (5) volumeUp : 음량 1 증가. 증가된 음량 값을 리턴.
	// (6) volumeDown : 음량 1 감소. 감소된 음량 값을 리턴.
	// (7) toString : TV 객체의 정보를 문자열로 리턴.
	
	public boolean isPowerOn() { //get 은 가져오다인데 Is 는 의문문이라서 boolean인 경우만 is 또는 get
		return this.powerOn;
	}
	public int getChannel() {
		return this.channel;
	}
	public int getVolume() {
		return this.volume;
	}
	public void setPowerOn(boolean powerOn) {
		this.powerOn = powerOn;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	
    /**
     * powerOnOff. TV가 켜져 있으면 끄고, TV가 꺼져 있는 켬.
     * 필드 powerOn의 값이 true이면 false로 변경, powerOn의 값이 false이면 true로 변경.
     * 
     * @return powerOn의 값.
     */
	
	public boolean powerOnOff() {
		
		if(powerOn) { // TV가 켜져 있으면
			powerOn = false;
		} else { // TV가 꺼져 있으면
			powerOn = true;
		}
		System.out.println("powerOn: " + powerOn);
		return powerOn;
	}
	
	
	 /**
     * channelUp. TV가 켜져 있을 때 현재 채널의 값을 1 증가.
     * 만약 현재 채널 값이 채널의 최댓값(MAX_CHANNEL)인 경우, 채널의 최솟값(MIN_CHANNEL)으로 변경.
     * 
     * @return 바뀐 현재 채널 값.
     */
	
	public int channelUp() {
		if(powerOn) {
			if(channel < MAX_CHANNEL) {
				channel++;
			} else {
				channel = MIN_CHANNER;
			}
		}
		System.out.println("channel: " + channel);
				
//		if(powerOn == true) {
//			if(channel == MAX_CHANNEL) {
//				channel = MIN_CHANNER - 1;
//			}
//			channel++;
//		} 
		
		return channel;
	}
	
	
	  /**
     * channelDown. TV가 켜져 있을 때 현재 채널의 값을 1 감소.
     * 만약 현재 채널 값이 채널의 최솟값(MIN_CHANNEL)인 경우, 채널의 최댓값(MAX_CHANNEL)으로 변경.
     * 
     * @return 바뀐 현재 채널 값.
     */
	
	public int channelDown() {
		if(powerOn) {
			if(channel > MIN_CHANNER) {
				channel--;
			} else {
				channel = MAX_CHANNEL;
			}
		}
		System.out.println("channel: " + channel);
//		if(powerOn == true) {
//			if(channel == MIN_CHANNER) {
//				channel = MAX_CHANNEL + 1;
//			}
//			channel--;
//		} 
		return channel;
	}
	
	
    /**
     * volumeUp. TV가 켜져 있을 때 현재 음량의 값을 1 증가.
     * 만약 현재 음량 값이 음량의 최댓값(MAX_VOLUME)인 경우, 음량을 변경하지 않음.
     * 
     * @return 바뀐 현재 음량 값.
     */
	public int volumeUp() {
//		if(powerOn && voiume < MAX_VOLUME) {...}
		
		if(powerOn) {
			if(volume < MAX_VOLUME) {
				volume++;
			} 
		}
//		if(powerOn == true) {
//			if(volume == MAX_CHANNEL) {
//				volume = MIN_CHANNER - 1;
//			}
//			volume++;
//		} 
		System.out.println("volume: " + volume);
		return volume;
	}
				
		
	
	 /**
     * volumeDown. TV가 켜져 있을 때 현재 음량의 값을 1 감소.
     * 만약 현재 음량 값이 음량의 최솟값(MIN_VOLUME)인 경우, 음량을 변경하지 않음.
     * 
     * @return 바뀐 현재 음량 값.
     */
	public int volumeDown() {

//		if(powerOn && voiume < MAX_VOLUME) {...}
		if(powerOn) {
			if(volume > MIN_VOLUME) {
				volume--;
			} 
		}
		System.out.println("volume: " + volume);
		
		
		
//		if(powerOn == true) {
//			if(volume == MIN_CHANNER) {
//				volume = MAX_CHANNEL + 1;
//			}
//			volume--;
//		} 
		return volume;
	}
	
	public String toString() {
		return "BasicTv(powerOn= " + this.powerOn
				+ ", channel= " + this.channel
				+ ", volume= " + this.volume
				+ ")";
		
	}
	
}
