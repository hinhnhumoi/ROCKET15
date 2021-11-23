package org.VTI.Entity;

import javax.persistence.*;
import java.security.PrivateKey;

@Entity
@Table(name = "Answer", catalog = "testingsystem2")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Answers", nullable = false )
    private short id;

    @Column(name = "Content", nullable = false,  length = 100)
    private String content;

    @Column (name = "isCorrect")
    private boolean isCorrect;

    public Answer() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
