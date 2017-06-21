package json.jackson.practice.examples;

public class DestinationModel {
	private String val1;
	private Short val2;
	private Integer val3;
	private Long val4;
	private Double val5;

	public String getVal1() {
		return val1;
	}

	public void setVal1(String val1) {
		this.val1 = val1;
	}

	public Short getVal2() {
		return val2;
	}

	public void setVal2(Short val2) {
		this.val2 = val2;
	}

	public Integer getVal3() {
		return val3;
	}

	public void setVal3(Integer val3) {
		this.val3 = val3;
	}

	public Long getVal4() {
		return val4;
	}

	public void setVal4(Long val4) {
		this.val4 = val4;
	}

	public Double getVal5() {
		return val5;
	}

	public void setVal5(Double val5) {
		this.val5 = val5;
	}

	@Override
	public String toString() {
		return "[val1=" + val1 + ", val2=" + val2 + ", val3=" + val3 + ", val4=" + val4 + ", val5=" + val5
				+ "]";
	}

}