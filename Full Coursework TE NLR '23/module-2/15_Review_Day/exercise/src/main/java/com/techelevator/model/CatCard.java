package com.techelevator.model;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class CatCard {

	private int catCardId;
	@NotEmpty
	private String catFact;
	@NotEmpty
	private String imgUrl;
	@NotEmpty
	private String caption;

	public int getCatCardId() {
		return catCardId;
	}
	public void setCatCardId(int catCardId) {
		this.catCardId = catCardId;
	}
	
	public String getCatFact() {
		return catFact;
	}
	public void setCatFact(String catFact) {
		this.catFact = catFact;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CatCard catCard = (CatCard) o;
		return catCardId == catCard.catCardId && catFact.equals(catCard.catFact) && imgUrl.equals(catCard.imgUrl) && caption.equals(catCard.caption);
	}

	@Override
	public int hashCode() {
		return Objects.hash(catCardId, catFact, imgUrl, caption);
	}
}
