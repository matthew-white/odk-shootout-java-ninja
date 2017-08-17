package models;

import java.util.List;

public class SubmissionsDto {
    public List<Submission> submissions;

    public SubmissionsDto() { }

    public SubmissionsDto(List<Submission> submissions) {
        this.submissions = submissions;
    }
}
