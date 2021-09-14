package java_erp_teacher.dto;

public class Trade {
	int code;
	String name;
	String repr;
	String number;
	String address;
	public Trade() {
	}
	public Trade(int code) {
		this.code = code;
	}
	public Trade(int code, String name, String repr, String number, String address) {
		this.code = code;
		this.name = name;
		this.repr = repr;
		this.number = number;
		this.address = address;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRepr() {
		return repr;
	}
	public void setRepr(String repr) {
		this.repr = repr;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return String.format("Trade [code=%s, name=%s, repr=%s, number=%s, address=%s]", code, name, repr, number,
				address);
	}
	
	
	

}
