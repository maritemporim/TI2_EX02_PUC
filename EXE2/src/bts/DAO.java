package bts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private Connection conn;

    public DAO() {
        try {
            conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/BTS",
                "ti2cc",
                "ti@cc"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Album album) {
        String sql = "INSERT INTO album (titulo, artista, ano_lancamento) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, album.getTitulo());
            stmt.setString(2, album.getArtista());
            stmt.setInt(3, album.getAnoLancamento());
            stmt.executeUpdate();
            System.out.println("Álbum inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Album> listar() {
        List<Album> lista = new ArrayList<>();
        String sql = "SELECT * FROM album ORDER BY id";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Album a = new Album(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("artista"),
                    rs.getInt("ano_lancamento")
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void atualizar(Album album) {
        String sql = "UPDATE album SET titulo=?, artista=?, ano_lancamento=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, album.getTitulo());
            stmt.setString(2, album.getArtista());
            stmt.setInt(3, album.getAnoLancamento());
            stmt.setInt(4, album.getId());
            stmt.executeUpdate();
            System.out.println("Álbum atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM album WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Álbum excluído com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

