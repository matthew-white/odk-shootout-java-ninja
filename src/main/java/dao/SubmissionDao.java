package dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import models.Submission;
import models.SubmissionDto;
import ninja.jpa.UnitOfWork;

import javax.persistence.EntityManager;
import java.util.List;

public class SubmissionDao {
    @Inject
    Provider<EntityManager> entityManagerProvider;

    private EntityManager entityManager() {
        return entityManagerProvider.get();
    }

    @Transactional
    public boolean create(SubmissionDto submissionDto) {
        Submission submission = new Submission(submissionDto);
        entityManager().persist(submission);
        // TODO: Have this method return false upon failure.
        return true;
    }

    @UnitOfWork
    public List<Submission> all() {
        return entityManager()
            .createQuery("SELECT x FROM Submission x", Submission.class)
            .getResultList();
    }

    @UnitOfWork
    public Submission findById(Long id) {
        return entityManager()
            .createQuery("SELECT x FROM Submission x WHERE x.id = :idParam", Submission.class)
            .setParameter("idParam", id)
            .getSingleResult();
    }
}
