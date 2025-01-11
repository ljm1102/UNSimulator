package un;

// 선진국 클래스로 Country를 상속 (주석 2 : 클래스 상속)
public class DevelopedCountry extends Country {
	private int gdp; // GDP 정보
	
	// 선진국 클래스 생성자
	public DevelopedCountry(String name, String continent, int gdp) {
		super(name, continent);
		this.gdp = gdp;
	}
	
	//(주석 5 : 다형성, 부모 클래스에서 정의된 메소드 자식 클래스에서 재정의))
	@Override
	public void displayInfo() {
		System.out.println("국가: " + name + " (선진국), 대륙: " + continent + ", GDP: $" + gdp + "억");
	}
}
