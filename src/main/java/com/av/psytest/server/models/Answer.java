package com.av.psytest.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "answer")
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "text", length = 100)
    private String text;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id", referencedColumnName = "id")
    @JsonIgnore
    private Question question;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="selected_answer_id", referencedColumnName = "id")
    @JsonIgnore
    private SelectedAnswer selectedAnswer;

    public Answer() {
    }

    public Answer(Long id, String text, Question question) {
        this.id = id;
        this.text = text;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public SelectedAnswer getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(SelectedAnswer selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}