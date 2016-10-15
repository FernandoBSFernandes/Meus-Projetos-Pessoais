package DAO;

import Conexao.Conexao;
import JavaBeans.Aluno;
import java.sql.*;

public class AlunoDAO {

    private Connection c;
    private Statement a, a1;
    private ResultSet r2;

    public AlunoDAO() throws ClassNotFoundException, SQLException {
        c = Conexao.getConnection();
        a = c.createStatement();

        a1 = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        r2 = a1.executeQuery("Select * from ROOT.ALUNOS");
    }

    public Aluno First() throws SQLException {
        if (r2.first()) {
            Aluno a = new Aluno();
            a.setCode(r2.getInt("code"));
            a.setNome(r2.getString("nome"));
            a.setSobrenome(r2.getString("sobrenome"));
            a.setCodCidade(r2.getInt("codcity"));
            return a;
        }
        return null;
    }

    public Aluno Anterior() throws SQLException {

        if (!r2.isFirst()) {
            r2.previous();
            Aluno a = new Aluno();
            a.setCode(r2.getInt("code"));
            a.setNome(r2.getString("nome"));
            a.setSobrenome(r2.getString("sobrenome"));
            a.setCodCidade(r2.getInt("codcity"));
            return a;
        }
        return null;
    }

    public Aluno Proximo() throws SQLException {
        if (!r2.isLast()) {
            r2.next();
            Aluno a = new Aluno();
            a.setCode(r2.getInt("code"));
            a.setNome(r2.getString("nome"));
            a.setSobrenome(r2.getString("sobrenome"));
            a.setCodCidade(r2.getInt("codcity"));
            return a;
        }
        return null;
    }

    public Aluno Last() throws SQLException {
        if (r2.last()) {
            Aluno a = new Aluno();
            a.setCode(r2.getInt("code"));
            a.setNome(r2.getString("nome"));
            a.setSobrenome(r2.getString("sobrenome"));
            a.setCodCidade(r2.getInt("codcity"));
            return a;
        }
        return null;
    }

    public Aluno Pesquisar(int code) throws SQLException {
        ResultSet r2 = a.executeQuery("Select * from ROOT.ALUNOS where code = " + code + " ");
        if (r2.next()) {
            Aluno a1 = new Aluno();

            a1.setCode(r2.getInt("code"));
            a1.setNome(r2.getString("nome"));
            a1.setSobrenome(r2.getString("sobrenome"));
            a1.setCodCidade(r2.getInt("codcity"));
            return a1;
        }
        return null;
    }

    public boolean Excluir(int code) throws SQLException {
        a.executeUpdate("Delete from ROOT.ALUNOS where CODE = " + code + " ");
        return true;
    }

    public boolean Salvar(Aluno a1) throws SQLException {
        int cod = a1.getCodCidade();
        String nome = a1.getNome();
        String sobrenome = a1.getSobrenome();
        int cidade = a1.getCodCidade();
        try {
            a.executeUpdate("Insert into ROOT.ALUNOS values (" + cod + ", '" + nome + "', '" + sobrenome + "', " + cidade + ")");
            return true;
        } catch (SQLException e) {
            a.executeUpdate("Update ROOT.ALUNOS set NOME = '" + nome + "', SOBRENOME = '" + sobrenome + "', CODCITY = " + cidade + " where code = " + cod + " ");
            return true;
        }
    }
}