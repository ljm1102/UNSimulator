package un;

// 국가 클래스
public class Country {
	protected String name; // 국가 이름
	protected String continent; // 대륙
	
	// Country 생성자
	public Country(String name, String continent) {
		this.name = name;
		this.continent = continent;
	}
	
	// 국가 이름 얻는 메소드
	public String getName() {
		return name;
	}
	
	// 대륙 이름 얻는 메소드
	public String getContinent() {
		return continent;
	}
	
	// 국가와 대륙 이름을 출력해서 보여주는 메소드
	public void displayInfo() {
		System.out.println("국가" + name + ", 대륙: " + continent);
	}
}
