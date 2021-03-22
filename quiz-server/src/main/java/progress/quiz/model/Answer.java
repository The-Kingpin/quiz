package progress.quiz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "answer")
@JsonIgnoreProperties({"question"})
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @JsonProperty("answerText")
    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    @JsonProperty("isCorrect")
    public boolean isCorrect() {
        return this.isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return id == answer.id && isCorrect == answer.isCorrect && question.equals(answer.question) && answerText.equals(answer.answerText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answerText, isCorrect);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", question=" + question +
                ", answerText='" + answerText + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
