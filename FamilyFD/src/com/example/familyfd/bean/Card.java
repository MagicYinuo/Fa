package com.example.familyfd.bean;

import java.io.Serializable;
import java.util.List;

public class Card implements Serializable{
	private int id;
	private String card_name;
	private String golden_advantage;
	String webaddress;
	public String getWebaddress() {
		return webaddress;
	}
	public void setWebaddress(String webaddress) {
		this.webaddress = webaddress;
	}
	public String getGolden_advantage() {
		return golden_advantage;
	}
	public void setGolden_advantage(String golden_advantage) {
		this.golden_advantage = golden_advantage;
	}
	private List<String> advantage;
	private int apply_num;
	private int pic;
	String kind;
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getPic() {
		return pic;
	}
	public void setPic(int pic) {
		this.pic = pic;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCard_name() {
		return card_name;
	}
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	public List<String> getAdvantage() {
		return advantage;
	}
	public void setAdvantage(List<String> advantage) {
		this.advantage = advantage;
	}
	public int getApply_num() {
		return apply_num;
	}
	
	
	
	public Card(int id, String card_name, String golden_advantage,
			List<String> advantage, int apply_num, int pic) {
		super();
		this.id = id;
		this.card_name = card_name;
		this.golden_advantage = golden_advantage;
		this.advantage = advantage;
		this.apply_num = apply_num;
		this.pic = pic;
	}
	public void setApply_num(int apply_num) {
		this.apply_num = apply_num;
	}
	public Card() {
		super();
	}
	
	
}
