package un;

// 투표 인터페이스 (주석 3 : 인터페이스)
public interface Voting {
	void vote(String countryName, boolean decision) throws InvalidVoteException;
}
