package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Submission {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
    
    public String xml;

    public Submission() { }
    
    public Submission(SubmissionDto submission) {
        xml = submission.xml;
    }
}
