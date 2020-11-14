package com.av.psytest.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "question")
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "text", length = 60)
    private String text;
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="selected_answer_id", referencedColumnName = "id")
    @JsonIgnore
    private SelectedAnswer selectedAnswer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="questionnaire_id", referencedColumnName = "id")
    @JsonIgnore
    private Questionnaire questionnaire;

    public Question() {
    }

    public Question(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Question(Long id, String text, List<Answer> answers,
                    SelectedAnswer selectedAnswer,
                    Questionnaire questionnaire) {
        this.id = id;
        this.text = text;
        this.answers = answers;
        this.selectedAnswer = selectedAnswer;
        this.questionnaire = questionnaire;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public SelectedAnswer getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(SelectedAnswer selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }
}