package test.spring.bean;

import java.util.Date;

public class TestBean {

	private String text;
	private int number;
	private Date reg;
	
	// 생성자 
	public TestBean() {}
	public TestBean(String text) {
		this.text = text;
	}
	public TestBean(String text, int number, Date reg) {
		this.text = text;
		this.number = number;
		this.reg = reg;
	}
	
	
	// getter/setter
	public Date getReg() {
		return reg;
	}
	public void setReg(Date reg) {
		this.reg = reg;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	// 일반 메서드
	public void func() {
		System.out.println("func!!!");
	}
	
	
	
}
