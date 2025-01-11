package un;

// 개발도상국 클래스로 Country를 상속 (주석 2 : 클래스 상속)
public class DevelopingCountry extends Country {
	private int population; // 인구 정보
	
	public DevelopingCountry(String name, String continent, int population) {
		super(name, continent);
		this.population = population;
	}
	
	//(주석 5 : 다형성, 부모 클래스에서 정의된 메소드 자식 클래스에서 재정의))
	@Override
	public void displayInfo() {
		System.out.println("국가: " + name + " (개발도상국), 대륙: " + continent + ", 인구: " + population + "명");
	}
}
