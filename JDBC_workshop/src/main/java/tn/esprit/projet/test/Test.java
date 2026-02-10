package tn.esprit.projet.main;

import tn.esprit.projet.entities.JobCategory;
import tn.esprit.projet.entities.JobOffer;
import tn.esprit.projet.entities.JobStatus;
import tn.esprit.projet.services.JobOfferService;

public class Test {

    public static void main(String[] args) {

        JobOfferService service = new JobOfferService();

        JobOffer job = new JobOffer(
                "Java Developer",
                "Backend Java / Spring",
                "Tunis",
                "CDI",
                JobCategory.IT,
                JobStatus.OPEN
        );

        // CREATE
        service.add(job);

        // READ
        service.getAll().forEach(j ->
                System.out.println(j.getId() + " | " + j.getTitle() + " | " + j.getStatus())
        );
    }
}
