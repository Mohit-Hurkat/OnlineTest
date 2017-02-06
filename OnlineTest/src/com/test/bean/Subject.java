package com.test.bean;

public class Subject {
	private int subjectId;
	private String Subject;
	
	public Subject(int subjectId, String subject) {
		super();
		this.subjectId = subjectId;
		Subject = subject;
	}
	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", Subject=" + Subject + "]";
	}
	
	
	
}
