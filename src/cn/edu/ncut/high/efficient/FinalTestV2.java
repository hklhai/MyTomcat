package cn.edu.ncut.high.efficient;

public class FinalTestV2 {
	// final加在类上不能被重写，加在类上不能被继承 
	private String name;

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

}
