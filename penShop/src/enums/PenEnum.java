package enums;

public enum PenEnum {
	PARKER(0), REYNOLD(1), NATRAJ(2), CLASSMATE(3);

	private int val;

	private PenEnum(int val) {
		this.val = val;
	}

	public void setVal(int val) {
		this.val = val;
	}
}
