package com.av.psytest.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "selected_answer")
public class SelectedAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToMany(mappedBy = "selectedAnswer")
    private List<Question> questions;
    @OneToMany(mappedBy = "selectedAnswer")
    private List<Answer> answers;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_selected_answer_id", referencedColumnName = "id")
    @JsonIgnore
    private UserSelectedAnswer userSelectedAnswer;

    public SelectedAnswer() {
    }

    public SelectedAnswer(Long id, List<Question> questions, List<Answer> answers) {
        this.id = id;
        this.questions = questions;
        this.answers = answers;
    }

    public SelectedAnswer(Long id, List<Question> questions, List<Answer> answers,
                          UserSelectedAnswer userSelectedAnswer) {
        this.id = id;
        this.questions = questions;
        this.answers = answers;
        this.userSelectedAnswer = userSelectedAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public UserSelectedAnswer getUserSelectedAnswer() {
        return userSelectedAnswer;
    }

    public void setUserSelectedAnswer(UserSelectedAnswer userSelectedAnswer) {
        this.userSelectedAnswer = userSelectedAnswer;
    }
}