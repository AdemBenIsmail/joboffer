package tn.esprit.projet.services;

import tn.esprit.projet.entities.Person;
import tn.esprit.projet.utils.MyDBConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonService implements CRUD<Person> {

    private Connection cnx;

    public PersonService(){
        cnx = MyDBConnexion.getInstance().getCnx();
    }

    @Override
    public void insertOne(Person person) throws SQLException {
        String req = "INSERT INTO `person`(`nom`, `prenom`, `salaire`) VALUES (?, ?, ?)";
        try (PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setString(1, person.getNom());
            ps.setString(2, person.getPrenom());
            ps.setDouble(3, person.getSalaire());
            ps.executeUpdate();
        }
    }

    public void insertOneUpdated(Person person) throws SQLException {
        insertOne(person);
    }

    @Override
    public void updateOne(Person person) throws SQLException {
        String req = "UPDATE `person` SET `nom` = ?, `prenom` = ?, `salaire` = ? WHERE `id` = ?";
        try (PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setString(1, person.getNom());
            ps.setString(2, person.getPrenom());
            ps.setDouble(3, person.getSalaire());
            ps.setInt(4, person.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteOne(Person person) throws SQLException {
        String req = "DELETE FROM `person` WHERE `id` = ?";
        try (PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setInt(1, person.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public List<Person> selectALL() throws SQLException {
        List<Person> userList = new ArrayList<>();

        String req = "SELECT id, nom, prenom, salaire FROM `person`";
        try (Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(req)) {
            while (rs.next()) {
                Person p = new Person(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getDouble("salaire")
                );

                userList.add(p);
            }
        }

        return userList;
    }
}
