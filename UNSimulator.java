/* (주석 1: 과제 설명)
	객체지향 프로그래밍 평가과제 (배점 25점)
	학과 : 컴퓨터전자시스템공학부
	학번 : 202002666
	이름 : 이정민
	
	과제 주제 : UN 시뮬레이터, UN 회원국들인 각 국가들이 결의안에 대해 투표(찬성, 반대)하고 그 결과에 따라 결의안의 상태를 결정하는 시스템을 시뮬레이션하는 프로그램
			

*/
package un;

import java.io.*;
import java.util.*;

// 메인 클래스
public class UNSimulator {

	public static void main(String[] args) {
		// 국가 리스트 생성 (주석 5 : 참조 타입(배열타입)), (주석 7 : 컬렉션 프레임워크인 ArrayList를 사용하여 국가 목록 관리)
		List<Country> countries = new ArrayList<>();
		countries.add(new DevelopedCountry("미국", "북아메리카", 21427));
        countries.add(new DevelopingCountry("인도", "아시아", 1393409038));
        countries.add(new DevelopedCountry("독일", "유럽", 4208));
        countries.add(new DevelopingCountry("베트남", "아시아", 98168829));
		
        // 국가 정보 출력
        System.out.println("국가 목록:");
        for (Country country : countries) {
        	country.displayInfo();
        }
        
        // UN 결의안 생성 및 투표
        UNResolution resolution = new UNResolution("기후 변화 대응");
        try {
        	resolution.vote("미국", true);
        	resolution.vote("인도", false);
        	resolution.vote("독일", true);
        	resolution.vote("베트남", true);
        	
        	// 결의안 상태 업데이트
        	resolution.updateStatus();
        	
        	// 파일에 결과 저장
        	resolution.saveResultToFile("resolution_result.txt");
        	
        	// 파일에서 결과 불러오기
        	resolution.loadResultFromFile("resolution_result.txt");
        } catch (InvalidVoteException e) {
        	System.out.println("예외 발생: " + e.getMessage());
        } catch (IOException e) {
        	System.out.println("입출력 예외 발생: " + e.getMessage());
        }
	}

}
