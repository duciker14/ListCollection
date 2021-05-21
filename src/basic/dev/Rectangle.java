package basic.dev;

public class Rectangle implements Shape {
	String name;
	double canhA, canhB;
	
	

	public Rectangle(String name, double canhA, double canhB) {
		super();
		this.name = name;
		this.canhA = canhA;
		this.canhB = canhB;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCanhA() {
		return canhA;
	}

	public void setCanhA(float canhA) {
		this.canhA = canhA;
	}

	public double getCanhB() {
		return canhB;
	}

	public void setCanhB(float canhB) {
		this.canhB = canhB;
	}

	public Rectangle(String name, float canhA, float canhB) {
		super();
		this.name = name;
		this.canhA = canhA;
		this.canhB = canhB;
	}

	@Override
	public double chuVi() {
		// TODO Auto-generated method stub
		return 2*(canhA+canhB);
	}

	@Override
	public double dienTich() {
		// TODO Auto-generated method stub
		return canhA*canhB;
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
