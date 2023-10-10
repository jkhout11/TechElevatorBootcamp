package com.techelevator.model;

import java.util.Objects;

public class CatFact {
	private String text;

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CatFact catFact = (CatFact) o;
		return text.equals(catFact.text);
	}

	@Override
	public int hashCode() {
		return Objects.hash(text);
	}
}
