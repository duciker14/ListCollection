package basic.dev;

public class Circle implements Shape {
	String name;
	float banKinh;
	
	

	public Circle(String name, float banKinh) {
		super();
		this.name = name;
		this.banKinh = banKinh;
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public float getBanKinh() {
		return banKinh;
	}



	public void setBanKinh(float banKinh) {
		this.banKinh = banKinh;
	}



	@Override
	public float chuVi() {
		// TODO Auto-generated method stub
		return (float) (2*Math.PI*banKinh);
	}

	@Override
	public float dienTich() {
		return (float) Math.PI*banKinh*banKinh;
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
