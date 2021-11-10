package com.emergentes.dao;

import com.emergentes.modelo.Seminario;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeminarioDAOImplementacion extends ConexionBD implements SeminarioDAO {

    @Override
    public void insert(Seminario seminario) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO seminarios(titulo, expositor, fecha, hora, cupo) VALUE(?, ?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, seminario.getTitulo());
            ps.setString(2, seminario.getExpositor());
            ps.setString(3, seminario.getFecha());
            ps.setString(4, seminario.getHora());
            ps.setInt(5, seminario.getCupo());
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Seminario seminario) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE seminarios SET titulo=?, expositor=?, fecha=?, hora=?, cupo=? WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, seminario.getTitulo());
            ps.setString(2, seminario.getExpositor());
            ps.setString(3, seminario.getFecha());
            ps.setString(4, seminario.getHora());
            ps.setInt(5, seminario.getCupo());
            ps.setInt(6, seminario.getId());
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM seminarios WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Seminario getById(int id) throws Exception {
        Seminario sem = new Seminario();
        try {
            this.conectar();
            String sql = "SEELCT * FROM seminarios WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sem.setId(rs.getInt("id"));
                sem.setTitulo(rs.getString("titulo"));
                sem.setExpositor(rs.getString("expositor"));
                sem.setFecha(rs.getString("fecha"));
                sem.setHora(rs.getString("hora"));
                sem.setCupo(rs.getInt("cupo"));
                
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return sem;
    }

    @Override
    public List<Seminario> getAll() throws Exception {
        List <Seminario> lista = null;
        try {
            this.conectar();
            String sql = "SEELCT * FROM seminarios";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Seminario>();
            while (rs.next()) {
                Seminario sem = new Seminario();
                sem.setId(rs.getInt("id"));
                sem.setTitulo(rs.getString("titulo"));
                sem.setExpositor(rs.getString("expositor"));
                sem.setFecha(rs.getString("fecha"));
                sem.setHora(rs.getString("hora"));
                sem.setCupo(rs.getInt("cupo"));
                lista.add(sem);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
