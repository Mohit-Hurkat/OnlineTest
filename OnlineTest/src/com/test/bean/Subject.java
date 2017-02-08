package com.test.bean;

public class Subject {
	private int subjectId;
	private String subject;
	
	public Subject(int subjectId, String subject) {
		super();
		this.subjectId = subjectId;
		this.subject = subject;
	}
	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Subject Id=" + subjectId + ",\t Subject=" + subject;
	}
	
	
	
}
