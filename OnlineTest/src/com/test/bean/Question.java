package com.test.bean;

public class Question {
   private int questionId;
   private int subjectId;
   private String question;
   private int answer;
   
   
@Override
public String toString() {
	return "Question [question_id=" + questionId + ", subject_id=" + subjectId + ", question=" + question + ", answer="
			+ answer + "]";
}
public Question(int question_id, int subjectId, String question, int answer) {
	super();
	this.questionId = question_id;
	this.subjectId = subjectId;
	this.question = question;
	this.answer = answer;
}
public int getQuestionId() {
	return questionId;
}
public void setQuestionId(int questionId) {
	this.questionId = questionId;
}
public int getSubjectId() {
	return subjectId;
}
public void setSubjectId(int subjectId) {
	this.subjectId = subjectId;
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
