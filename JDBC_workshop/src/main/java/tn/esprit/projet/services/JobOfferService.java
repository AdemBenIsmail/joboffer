package tn.esprit.projet.services;

import tn.esprit.projet.entities.*;
import tn.esprit.projet.utils.MyDBConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobOfferService implements CRUD<JobOffer> {

    private final Connection cnx = MyDBConnexion.getInstance().getCnx();

    public void add(JobOffer job) {
        try {
            insertOne(job);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertOne(JobOffer job) throws SQLException {
        String sql = "INSERT INTO job_offer (title, description, location, contract_type, category, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = cnx.prepareStatement(sql)) {
            ps.setString(1, job.getTitle());
            ps.setString(2, job.getDescription());
            ps.setString(3, job.getLocation());
            ps.setString(4, job.getContractType());
            ps.setString(5, job.getCategory().name());
            ps.setString(6, job.getStatus().name());
            ps.executeUpdate();
        }
    }

    public List<JobOffer> getAll() {
        try {
            return selectALL();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void updateOne(JobOffer job) throws SQLException {
        String sql = "UPDATE job_offer SET title=?, description=?, location=?, contract_type=?, category=?, status=? WHERE id=?";
        try (PreparedStatement ps = cnx.prepareStatement(sql)) {
            ps.setString(1, job.getTitle());
            ps.setString(2, job.getDescription());
            ps.setString(3, job.getLocation());
            ps.setString(4, job.getContractType());
            ps.setString(5, job.getCategory().name());
            ps.setString(6, job.getStatus().name());
            ps.setLong(7, job.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteOne(JobOffer job) throws SQLException {
        deleteById(job.getId());
    }

    public void deleteById(long id) throws SQLException {
        String sql = "DELETE FROM job_offer WHERE id=?";
        try (PreparedStatement ps = cnx.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<JobOffer> selectALL() throws SQLException {
        List<JobOffer> list = new ArrayList<>();
        String sql = "SELECT id, title, description, location, contract_type, category, status, created_at FROM job_offer";
        try (Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
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
        }
        return list;
    }

    public void update(JobOffer job) {
        try {
            updateOne(job);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        try {
            deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
