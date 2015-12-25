package com.excelResearchers.domain;

public class Project extends BaseEntity {
	private String projName;
	private String projDate;
	private String phValue;
	private String description;

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getProjDate() {
		return projDate;
	}

	public void setProjDate(String projDate) {
		this.projDate = projDate;
	}

	public String getPhValue() {
		return phValue;
	}

	public void setPhValue(String phValue) {
		this.phValue = phValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Project [projName=" + projName + ", projDate=" + projDate
				+ ", phValue=" + phValue + ", description=" + description + "]";
	}

}
