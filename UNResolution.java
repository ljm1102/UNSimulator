package un;

import java.io.*;
import java.util.*;

// UN 결의안을 처리하는 클래스 (주석 3: Voting 인터페이스 구현 클래스 선언)
public class UNResolution implements Voting {
	private String title; // 결의안 제목
	private ResolutionStatus status; // 결의안 상태
	private Map<String, Boolean> votes; // 국가별 투표 결과 (주석 7 : 컬렉션 프레임워크 중 Map을 투표 결과로 사용)
	
	
	// 클래스 생성자
	public UNResolution(String title) {
		this.title = title;
		this.status = ResolutionStatus.PENDING;
		this.votes = new HashMap<>(); // (주석 7 : 컬렉션 프레임워크 HashMap으로 정의하여 국가 이름과 투표 데이터를 매핑)
	}
	
	// 투표를 처리하는 메소드 (주석 3 : 다형성, Voting 추상화 인터페이스에서 정의된 vote 메소드 구체적으로 정의)
	@Override
	public void vote(String countryName, boolean decision) throws InvalidVoteException {
		if (votes.containsKey(countryName)) {
			throw new InvalidVoteException("이미 투표한 국가입니다: " + countryName);
		}
		votes.put(countryName, decision);
		System.out.println(countryName + "이(가) 투표했습니다.");
	}
	
	// 결의안 상태를 업데이트하는 메소드
	public void updateStatus() {
		long approveCount = votes.values().stream().filter(v -> v).count(); // 찬성표 카운트
		long rejectCount = votes.size() - approveCount; // 전체 투표 수에서 찬성표를 빼 반대표 카운트
		
		if (approveCount > rejectCount) {
			status = ResolutionStatus.APPROVED; // 과반수가 찬성일 때 status를 승인으로 만듦
		} else {
			status = ResolutionStatus.REJECTED; // 과반수가 반대일 때 status를 거절로 만듦
		}
	}
	
	
	// 투표 결과를 파일에 저장 (주석 8 : 파일 입력 사용)
	public void saveResultToFile(String filename) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			writer.write("결의안: " + title + "\n");
			writer.write("상태: " + status + "\n");
			for (Map.Entry<String, Boolean> entry : votes.entrySet()) {
				writer.write(entry.getKey() + ": " + (entry.getValue() ? "찬성" : "반대") + "\n");
			}
		}
	}
	
	// 투표 결과를 파일에서 불러오기 (주석 8 : 파일 출력 사용)
	public void loadResultFromFile(String filename) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			System.out.println("전체 투표 결과:");
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
}
