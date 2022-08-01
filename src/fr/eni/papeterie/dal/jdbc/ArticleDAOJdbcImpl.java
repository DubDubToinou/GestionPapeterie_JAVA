package fr.eni.papeterie.dal.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.bo.Ramette;

public class ArticleDAOJdbcImpl implements ArticleDAO {

    private static final String TYPE_STYLO = "STYLO";
    private static final String TYPE_RAMETTE = "RAMETTE";

    public Article selectById(int id) {

        Article s = null;

        try {

            Connection con = JdbcTools.getConnection();

            PreparedStatement stmt = con.prepareStatement(
                    "SELECT idArticle,  reference, marque, designation, prixUnitaire,  qteStock,  grammage, couleur, type FROM Articles WHERE idArticle = ?");

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())) {
                    s = new Stylo(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
                            rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
                            rs.getString("couleur"));
                }
                if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())) {
                    s = new Ramette(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
                            rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
                            rs.getInt("grammage"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }

    public List<Article> selectAll() {
        List<Article> listeArticle = new ArrayList<Article>();
        Statement stmt;

        try {

            Connection con = JdbcTools.getConnection();
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "SELECT idArticle,reference,marque,designation,prixUnitaire,qteStock,grammage,couleur,type FROM Articles");
            Article art = null;

            while (rs.next()) {
                if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())) {
                    art = new Stylo(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
                            rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
                            rs.getString("couleur"));
                }
                if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())) {
                    art = new Ramette(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
                            rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
                            rs.getInt("grammage"));
                }
                listeArticle.add(art);
            }

            stmt.close();
            JdbcTools.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        
        
        return listeArticle;

        
    }

    public void update(Article art) {

        try {

            Connection con = JdbcTools.getConnection();

            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE articles set reference=?,marque=?,designation=?,prixUnitaire=?,qteStock=?,grammage=?,couleur=? where idArticle=?");

            stmt.setString(1, art.getReference());
            stmt.setString(2, art.getMarque());
            stmt.setString(3, art.getDesignation());
            stmt.setFloat(4, art.getPrixUnitaire());
            stmt.setInt(5, art.getQteStock());
            stmt.setInt(8, art.getIdArticle());

            if(art instanceof  Stylo){
                Stylo s =  (Stylo) art;
                stmt.setNull(6, Types.INTEGER);
                stmt.setString(7, s.getCouleur());
            }else{
                Ramette r = (Ramette) art;
                stmt.setNull(7, Types.VARCHAR);
                stmt.setInt(6, r.getGrammage());
            }

            stmt.executeUpdate();
            stmt.close();
            JdbcTools.closeConnection();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        

    }

    public void insert(Article art) {

        try {

            Connection con = JdbcTools.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO Articles (reference,marque,designation,prixUnitaire,qteStock,grammage,couleur,type) VALUES (?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, art.getReference());
            stmt.setString(2, art.getMarque());
            stmt.setString(3, art.getDesignation());
            stmt.setFloat(4, art.getPrixUnitaire());
            stmt.setInt(5, art.getQteStock());

            if (art instanceof Stylo) {
                Stylo stylo = (Stylo) art;
                stmt.setNull(6, Types.INTEGER);
                stmt.setString(7, stylo.getCouleur());
                stmt.setString(8, TYPE_STYLO);
            } else {
                Ramette ramette = (Ramette) art;
                stmt.setInt(6, ramette.getGrammage());
                stmt.setNull(7, Types.VARCHAR);
                stmt.setString(8, TYPE_RAMETTE);
            }

            int nbLigne = stmt.executeUpdate();
            if (nbLigne == 1) {

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    art.setIdArticle(rs.getInt(1));
                }

            }

            stmt.close();
            JdbcTools.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int idArticle) {

        try {

            Connection con = JdbcTools.getConnection();

            PreparedStatement  stmt = con.prepareStatement("DELETE FROM Articles WHERE idArticle = ?");

            stmt.setInt(1, idArticle);

            stmt.executeUpdate();
            stmt.close();
            JdbcTools.closeConnection();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
