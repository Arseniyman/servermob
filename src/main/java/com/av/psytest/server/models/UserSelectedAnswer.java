package com.av.psytest.server.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_selected_answer")
public class UserSelectedAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @OneToMany(mappedBy = "userSelectedAnswer")
    private List<User> users;
    @OneToMany(mappedBy = "userSelectedAnswer")
    private List<SelectedAnswer> selectedAnswers;

    public UserSelectedAnswer() {
    }

    public UserSelectedAnswer(Long id, List<User> users,
                              List<SelectedAnswer> selectedAnswers) {
        this.id = id;
        this.users = users;
        this.selectedAnswers = selectedAnswers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<SelectedAnswer> getSelectedAnswers() {
        return selectedAnswers;
    }

    public void setSelectedAnswers(List<SelectedAnswer> selectedAnswers) {
        this.selectedAnswers = selectedAnswers;
    }
}