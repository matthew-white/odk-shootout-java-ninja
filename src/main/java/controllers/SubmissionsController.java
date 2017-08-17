package controllers;

import com.google.inject.Inject;
import dao.SubmissionDao;
import models.Submission;
import models.SubmissionDto;
import models.SubmissionsDto;
import ninja.Result;
import ninja.Results;
import ninja.params.PathParam;

public class SubmissionsController {
    @Inject
    SubmissionDao submissionDao;

    public Result create(SubmissionDto submissionDto) {
        if (submissionDao.create(submissionDto))
            return Results.json();
        else {
            // TODO: Is there a different error method to use?
            return Results.notFound();
        }
    }

    public Result getSubmissions() {
        SubmissionsDto submissionsDto = new SubmissionsDto(submissionDao.all());
        return Results.json().render(submissionsDto);
    }
    
    public Result getSubmission(@PathParam("id") Long id) {
        Submission submission = submissionDao.findById(id);
        return Results.json().render(submission);
    }
}
