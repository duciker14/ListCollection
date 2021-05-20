package basic.dev;

public class Triangle implements Shape{
	String name;
	float canhA, canhB,canhC;
	
	
	public Triangle(String name, float canhA, float canhB, float canhC) {
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


	public float getCanhA() {
		return canhA;
	}


	public void setCanhA(float canhA) {
		this.canhA = canhA;
	}


	public float getCanhB() {
		return canhB;
	}


	public void setCanhB(float canhB) {
		this.canhB = canhB;
	}


	public float getCanhC() {
		return canhC;
	}


	public void setCanhC(float canhC) {
		this.canhC = canhC;
	}


	@Override
	public float chuVi() {
		return canhA + canhB + canhC;
		
	}

	@Override
	public float dienTich() {
		float p = (canhA + canhB + canhC)/3;
		return (float) Math.sqrt(p*(p-canhA)*(p-canhB)*(p-canhC));
		
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
}
