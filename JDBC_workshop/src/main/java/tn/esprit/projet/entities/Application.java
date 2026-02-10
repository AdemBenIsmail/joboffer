package tn.esprit.projet.entities;

import java.sql.Timestamp;

public class Application {

    private Long id;
    private Long candidatId;
    private Long jobOfferId;
    private String cvFilePath;
    private Timestamp applicationDate;
    private Timestamp lastUpdate;
    private ApplicationStatus status;

    public Application() {}

    public Application(Long candidatId, Long jobOfferId,
                       String cvFilePath, ApplicationStatus status) {
        this.candidatId = candidatId;
        this.jobOfferId = jobOfferId;
        this.cvFilePath = cvFilePath;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCandidatId() { return candidatId; }
    public void setCandidatId(Long candidatId) { this.candidatId = candidatId; }

    public Long getJobOfferId() { return jobOfferId; }
    public void setJobOfferId(Long jobOfferId) { this.jobOfferId = jobOfferId; }

    public String getCvFilePath() { return cvFilePath; }
    public void setCvFilePath(String cvFilePath) { this.cvFilePath = cvFilePath; }

    public Timestamp getApplicationDate() { return applicationDate; }
    public void setApplicationDate(Timestamp applicationDate) { this.applicationDate = applicationDate; }

    public Timestamp getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(Timestamp lastUpdate) { this.lastUpdate = lastUpdate; }

    public ApplicationStatus getStatus() { return status; }
    public void setStatus(ApplicationStatus status) { this.status = status; }
}
