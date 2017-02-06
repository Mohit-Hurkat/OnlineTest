package com.test.bean;

public class Question {
   private int questionId;
   private String subject;
   private String question;
   private int answer;
@Override
public String toString() {
	return "Question [question_id=" + questionId + ", subject=" + subject + ", question=" + question + ", answer="
			+ answer + "]";
}
public Question(int question_id, String subject, String question, int answer) {
	super();
	this.questionId = question_id;
	this.subject = subject;
	this.question = question;
	this.answer = answer;
}
public int getQuestion_id() {
	return questionId;
}
public void setQuestion_id(int question_id) {
	this.questionId = question_id;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public int getAnswer() {
	return answer;
}
public void setAnswer(int answer) {
	this.answer = answer;
}
   
   
   
   
}
