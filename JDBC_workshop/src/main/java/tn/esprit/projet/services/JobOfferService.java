package tn.esprit.projet.services;

import tn.esprit.projet.entities.*;
import tn.esprit.projet.utils.MyDBConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobOfferService {

    Connection cnx = MyDBConnexion.getInstance().getCnx();

    public void add(JobOffer job) {
        String sql = "INSERT INTO job_offer (title, description, location, contract_type, category, status) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, job.getTitle());
            ps.setString(2, job.getDescription());
            ps.setString(3, job.getLocation());
            ps.setString(4, job.getContractType());
            ps.setString(5, job.getCategory().name());
            ps.setString(6, job.getStatus().name());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<JobOffer> getAll() {
        List<JobOffer> list = new ArrayList<>();
        String sql = "SELECT * FROM job_offer";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                JobOffer job = new JobOffer();
                job.setId(rs.getLong("id"));
                job.setTitle(rs.getString("title"));
                job.setDescription(rs.getString("description"));
                job.setLocation(rs.getString("location"));
                job.setContractType(rs.getString("contract_type"));
                job.setCategory(JobCategory.valueOf(rs.getString("category")));
                job.setStatus(JobStatus.valueOf(rs.getString("status")));
                job.setCreatedAt(rs.getTimestamp("created_at"));
                list.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(JobOffer job) {
        String sql = "UPDATE job_offer SET title=?, description=?, location=?, contract_type=?, category=?, status=? WHERE id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, job.getTitle());
            ps.setString(2, job.getDescription());
            ps.setString(3, job.getLocation());
            ps.setString(4, job.getContractType());
            ps.setString(5, job.getCategory().name());
            ps.setString(6, job.getStatus().name());
            ps.setLong(7, job.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        String sql = "DELETE FROM job_offer WHERE id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
