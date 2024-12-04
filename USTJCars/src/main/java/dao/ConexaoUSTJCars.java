package dao;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import classes.CarroClass;
import gui.CrudGUI;

public class ConexaoUSTJCars {
    private String usuario = "root";
    private String senha = "@root123";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "USTJCars_db?serverTimezone=America/Sao_Paulo";

    public Connection obtemConexao() {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bd, usuario, senha);
            return c;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    public void inserir(CarroClass carro) {
        // 1: Definir o comando SQL
        String sql = "INSERT INTO carros(modelo, marca, placa, cor, qtdLugares, quilometragem, ano, valorDiaria,categoria, cambio,  observacoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // 2: Abrir uma conexão
        try (Connection c = obtemConexao()) {
            // 3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            // 4 Preenche os dados faltantes
            ps.setString(1, carro.getModelo());
            ps.setString(2, carro.getMarca());
            ps.setString(3, carro.getPlaca());
            ps.setString(4, carro.getCor());
            ps.setInt(5, carro.getQtdLugares());
            ps.setInt(6, carro.getQuilometragem());
            ps.setInt(7, carro.getAno());
            ps.setDouble(8, carro.getValorDiaria());
            ps.setString(9, carro.getCategoria());
            ps.setString(10, carro.getCambio());
            ps.setString(11, carro.getObservacoes());

            // 5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String[]> listar() { // Retorna Ocorrência da tabela como uma lista de String
        // 1: Definir o comando SQL
        String sql = "SELECT * FROM carros";

        List<String[]> lista = new ArrayList<String[]>();
        // 2: Abrir uma conexão
        try (Connection c = obtemConexao()) { // 3: Pré compila o comando

            PreparedStatement ps = c.prepareStatement(sql); // 4: Executa o comando e guarda resultado
            ResultSet rs = ps.executeQuery(); // resultado fica em um ResultSet

            while (rs.next()) { // 5: itera sobre o resultado
                //Array carros
                String[] carrosDAO = {
                        Integer.toString(rs.getInt("id")), // Transforma String
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("ano"),
                        rs.getString("cor"),
                        rs.getString("placa"),
                        Double.toString(rs.getDouble("valorDiaria")), // Transforma String
                        rs.getString("cambio"), 
                        rs.getString("observacoes")
                };

                lista.add(carrosDAO);

            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    public void atualizar(CarroClass carro){
        String sql = "UPDATE carros SET modelo = ?, marca = ?, cor = ?, qtdLugares = ?,  quilometragem = ?, ano = ?, valorDiaria = ?, categoria = ?, cambio = ?, observacoes = ? WHERE placa = ? ";

        try (Connection c = obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, carro.getModelo());          
            ps.setString(2, carro.getMarca());
            ps.setString(3, carro.getCor());
            ps.setInt(4, carro.getQtdLugares());
            ps.setInt(5, carro.getQuilometragem());
            ps.setInt(6, carro.getAno());
            ps.setDouble(7, carro.getValorDiaria());
            ps.setString(8, carro.getCategoria());
            ps.setString(9, carro.getCambio());
            ps.setString(10, carro.getObservacoes());
            ps.setString(11, carro.getPlaca());

            ps.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void apagar (String placa){
        String sql = "DELETE FROM carros WHERE placa = ?";

        try (Connection c = obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1,placa);

            ps.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            

        }
    }

}
