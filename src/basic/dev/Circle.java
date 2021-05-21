package basic.dev;

public class Circle implements Shape {
	String name;
	double banKinh;
	
	

	public Circle(String name, double banKinh) {
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



	



	public void setBanKinh(float banKinh) {
		this.banKinh = banKinh;
	}



	@Override
	public double chuVi() {
		// TODO Auto-generated method stub
		return (float) (2*Math.PI*banKinh);
	}

	@Override
	public double dienTich() {
		return (float) Math.PI*banKinh*banKinh;
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
