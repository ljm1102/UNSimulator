package un;

// 예외 정의 -> 중복 투표 방지 (주석 4 : 예외 처리)
public class InvalidVoteException extends Exception {
	public InvalidVoteException(String message) {
		super(message);
	}
}
