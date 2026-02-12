package art.stalaverse.rockPaperScissors;

public class Player {
	private String nickname;
	private int timesWon, timesLost;
	private Object object;
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
	public Object getObject() {
		return object;
	}
	public void incrementTimesWon() {
		this.timesWon++;
	}
	public void incrementTimesLost() {
		this.timesLost++;
	}
	public void setChoice(Object object) {
		this.object=object;
	}
	public void setNickname(String nickname) {
		this.nickname=nickname;
	}
}