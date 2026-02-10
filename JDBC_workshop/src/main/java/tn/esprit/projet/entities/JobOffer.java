package tn.esprit.projet.entities;

import java.sql.Timestamp;

public class JobOffer {

    private Long id;
    private String title;
    private String description;
    private String location;
    private String contractType;
    private JobCategory category;
    private JobStatus status;
    private Timestamp createdAt;

    public JobOffer() {}

    public JobOffer(String title, String description, String location,
                    String contractType, JobCategory category, JobStatus status) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.contractType = contractType;
        this.category = category;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getContractType() { return contractType; }
    public void setContractType(String contractType) { this.contractType = contractType; }

    public JobCategory getCategory() { return category; }
    public void setCategory(JobCategory category) { this.category = category; }

    public JobStatus getStatus() { return status; }
    public void setStatus(JobStatus status) { this.status = status; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}
