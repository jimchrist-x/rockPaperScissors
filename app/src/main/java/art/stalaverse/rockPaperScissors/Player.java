package art.stalaverse.rockPaperScissors;

public class Player {
	private String nickname;
	private int timesWon, timesLost;
	private Weapon weapon;
	public Player() {
		this.timesWon=0;
		this.timesLost=0;
	}
	public String getNickname() {
		return nickname;
	}
	public int getTimesWon() {
		return timesWon;
	}
	public int getTimesLost() {
		return timesLost;
	}
	public double getWinRate() {
		return (double)timesWon/(timesWon+timesLost);
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void incrementTimesWon() {
		this.timesWon++;
	}
	public void incrementTimesLost() {
		this.timesLost++;
	}
	public void setChoice(Weapon weapon) {
		this.weapon=weapon;
	}
	public void setNickname(String nickname) {
		this.nickname=nickname;
	}
	public void reset() {
		this.timesWon=0;
		this.timesLost=0;
		this.nickname="";
	}
}