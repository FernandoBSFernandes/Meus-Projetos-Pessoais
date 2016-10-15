package DAO;

import Conexao.Conexao;
import JavaBeans.Cidade;
import java.sql.*;
import java.util.*;

public class CidadeDAO {

    private Connection c;
    private Statement a, a1;
    private ResultSet r2;

    public CidadeDAO() throws ClassNotFoundException, SQLException {
        c = Conexao.getConnection();
        a = c.createStatement();

        a1 = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        r2 = a1.executeQuery("Select * from ROOT.CIDADE");
    }

    public Cidade First() throws SQLException {
        if (r2.first()) {
            Cidade a = new Cidade();
            a.setCode(r2.getInt("codcidade"));
            a.setCidade(r2.getString("nome"));
            a.setUf(r2.getString("uf"));
            return a;
        }
        return null;
    }

    public Cidade Anterior() throws SQLException {

        if (!r2.isFirst()) {
            r2.previous();
            Cidade a = new Cidade();
            a.setCode(r2.getInt("codcidade"));
            a.setCidade(r2.getString("nome"));
            a.setUf(r2.getString("uf"));
            return a;
        }
        return null;
    }

    public Cidade Proximo() throws SQLException {
        if (!r2.isLast()) {
            r2.next();
            Cidade a = new Cidade();
            a.setCode(r2.getInt("codcidade"));
            a.setCidade(r2.getString("nome"));
            a.setUf(r2.getString("uf"));
            return a;
        }
        return null;
    }

    public Cidade Last() throws SQLException {
        if (r2.last()) {
            Cidade a = new Cidade();
            a.setCode(r2.getInt("codcidade"));
            a.setCidade(r2.getString("nome"));
            a.setUf(r2.getString("uf"));
            return a;
        }
        return null;
    }

    public Cidade Pesquisar(int code) throws SQLException {
        ResultSet r2 = a.executeQuery("Select * from ROOT.CIDADE where codcidade = " + code + " ");
        if (r2.next()) {
            Cidade a1 = new Cidade();
            a1.setCode(r2.getInt("codcidade"));
            a1.setCidade(r2.getString("nome"));
            a1.setUf(r2.getString("uf"));
            return a1;
        }
        return null;
    }

    public boolean Excluir(int code) throws SQLException {
        a.executeUpdate("Delete from ROOT.CIDADE where codcidade = " + code + " ");
        return true;
    }

    public boolean Salvar(Cidade a1) throws SQLException {
        int cod = a1.getCode();
        String cidade = a1.getCidade();
        String uf = a1.getUf();
        try {
            a.executeUpdate("Insert into ROOT.CIDADE values (" + cod + ", '" + cidade + "', '" + uf + "')");
            return true;
        } catch (SQLException e) {
            a.executeUpdate("Update ROOT.CIDADE set NOME = '" + cidade + "', UF = '" + uf + "' where codcidade = " + cod + " ");
            return true;
        }
    }

    public List<Cidade> montarCidade() throws SQLException {
        ArrayList<Cidade> city = new ArrayList<>();

        ResultSet rs1 = a.executeQuery("Select * from ROOT.CIDADE");
        while (rs1.next()) {
            Cidade cidade = new Cidade();
            cidade.setCode(rs1.getInt("codcidade"));
            cidade.setCidade(rs1.getString("nome"));
            cidade.setUf(rs1.getString("uf"));
            city.add(cidade);
        }
        return city;
    }

    public int getCodigo(String nome) throws SQLException {
        ResultSet rs1 = a.executeQuery("Select * from ROOT.CIDADE where nome = '" + nome + "' ");
        if (rs1.next()) {
            return rs1.getInt("codcidade");
        } else {
            return -1;
        }
    }

    public String getCidade(int codigo) throws SQLException {
        ResultSet rs1 = a.executeQuery("Select * from ROOT.CIDADE where codcidade = " + codigo + " ");
        if (rs1.next()) {
            return rs1.getString("nome");
        } else {
            return "";
        }
    }
}