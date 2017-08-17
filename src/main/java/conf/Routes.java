package conf;

import controllers.SubmissionsController;
import ninja.Router;
import ninja.application.ApplicationRoutes;

public class Routes implements ApplicationRoutes {
    public void init(Router router) {
        router
            .POST()
            .route("/submission")
            .with(SubmissionsController::create);
        router
            .GET()
            .route("/submission")
            .with(SubmissionsController::getSubmissions);
        router
            .GET()
            .route("/submission/{id}")
            .with(SubmissionsController::getSubmission);
    }
}
