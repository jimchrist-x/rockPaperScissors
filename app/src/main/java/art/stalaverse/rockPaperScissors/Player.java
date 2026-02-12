package art.stalaverse.rockPaperScissors;

public class Player {
	private String nickname;
	private int timesWon, timesLost;
	private Object object;
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
	public void setTimesWon(int timesWon) {
		this.timesWon=timesWon;
	}
	public void setTimesLost(int timesLost) {
		this.timesLost=timesLost;
	}
	public void setChoice(Object object) {
		this.object=object;
	}
	public void setNickname(String nickname) {
		this.nickname=nickname;
	}
}