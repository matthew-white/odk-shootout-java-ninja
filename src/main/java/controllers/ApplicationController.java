package controllers;

import com.google.inject.Inject;
import dao.SubmissionDao;
import ninja.Result;
import ninja.Results;

public class ApplicationController {
    @Inject
    SubmissionDao submissionDao;

    // Method to put initial data in the db
    public Result setup() {
        return Results.ok();
    }
}
