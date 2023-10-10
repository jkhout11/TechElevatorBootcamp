package com.techelevator.model;

import java.util.Objects;

public class CatPic {
	private String file;
	
	public String getFile() {
		return this.file;
	}
	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CatPic catPic = (CatPic) o;
		return file.equals(catPic.file);
	}

	@Override
	public int hashCode() {
		return Objects.hash(file);
	}
}
