package section_3_classes;

public class Cookie {
	private String color;
	
	public Cookie(String color) {
		this.color=color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color=color;
	}
	
	
	public static void main(String[] args) {
		
		Cookie cookieOne=new Cookie("green");
		Cookie cookieTwo=new Cookie("blue");
		
		cookieOne.setColor("yellow");
		
		System.out.println(cookieOne.getColor());
		System.out.println(cookieTwo.getColor());
		
		
	}

}



