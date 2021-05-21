package basic.dev;

public class Triangle implements Shape{
	String name;
	double canhA, canhB,canhC;
	
	
	public Triangle(String name, double canhA, double canhB, double canhC) {
		super();
		this.name = name;
		this.canhA = canhA;
		this.canhB = canhB;
		this.canhC = canhC;
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


	public double getCanhC() {
		return canhC;
	}


	public void setCanhC(float canhC) {
		this.canhC = canhC;
	}


	@Override
	public double chuVi() {
		return canhA + canhB + canhC;
		
	}

	@Override
	public double dienTich() {
		double p = (canhA + canhB + canhC)/2;
		return (double) Math.sqrt(p*(p-canhA)*(p-canhB)*(p-canhC));
		
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
}
