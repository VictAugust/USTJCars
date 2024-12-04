package gui;

import dao.ConexaoUSTJCars;
import classes.CarroClass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class CrudGUI extends JFrame implements ActionListener {

    // Atributos
    private JTextField txtModelo, txtMarca, txtPlaca, txtCor, txtCategoria, txtQtdLugares, txtObservacoes,
            txtQuilometragem, txtAno, txtValor, txtCambio;
    private JLabel etqModelo, etqMarca, etqPlaca, etqCor, etqCategoria, etqQtdLugares, etObservacoes, etQuilometragem,
            etDisponivel, etCarros, etAno, etValor, etqCambio;
    private JButton btAdicionar, btLimpar, btAtualizar;
    private JMenuBar menuBar;
    private JMenu opcoesMenu;
    private JMenuItem adicionarMenu, consultarMenu, excluirMenu, alterarMenu, sairMenu;
    private ButtonGroup disponibilidade;
    private JRadioButton sim, nao;
    private ConexaoUSTJCars conexao;
    JTable tabela;
    DefaultTableModel tableModel;

    // Construtor da Tela e suas funções
    /**
     * 
     */
    public CrudGUI() {
        // Super
        super("Locadora");

        conexao = new ConexaoUSTJCars();

        // Widgets -> Botões
        btAdicionar = new JButton("Salvar");
        btAtualizar = new JButton("Atualizar");
        btLimpar = new JButton("Limpar");
        disponibilidade = new ButtonGroup();
        sim = new JRadioButton("Sim");
        nao = new JRadioButton("Não");
        disponibilidade.add(sim);
        disponibilidade.add(nao);

        // Widgets -> Menu
        menuBar = new JMenuBar();
        opcoesMenu = new JMenu("Opções");
        adicionarMenu = new JMenuItem("Adicionar");
        consultarMenu = new JMenuItem("Consultar");
        excluirMenu = new JMenuItem("Excluir");
        alterarMenu = new JMenuItem("Alterar");
        sairMenu = new JMenuItem("Sair");

        // Widgets -> JTextField
        etqModelo = new JLabel("Modelo: ");
        etqMarca = new JLabel("Marca: ");
        etqPlaca = new JLabel("Placa: ");
        etqCor = new JLabel("Cor: ");
        etqCategoria = new JLabel("Categoria: ");
        etqQtdLugares = new JLabel("Quantidade de lugares");
        etObservacoes = new JLabel("Observações: ");
        etAno = new JLabel("Ano: ");
        etValor = new JLabel("Valor: ");
        etDisponivel = new JLabel("Disponivel: ");
        etCarros = new JLabel("Carros Adicionados:  ");
        etQuilometragem = new JLabel("Quilometragem");
        etqCambio = new JLabel("Cambio");

        // Widgets -> JTextField
        txtModelo = new JTextField("");
        txtMarca = new JTextField("");
        txtPlaca = new JTextField("");
        txtCor = new JTextField("");
        txtCategoria = new JTextField("");
        txtQtdLugares = new JTextField("");
        txtObservacoes = new JTextField("");
        txtValor = new JTextField("");
        txtAno = new JTextField("");
        txtQuilometragem = new JTextField("");
        txtCambio = new JTextField("");

        // Adicionar Listers nos Wigtes

        btAdicionar.addActionListener(this);
        btLimpar.addActionListener(this);
        btAtualizar.addActionListener(this);
        sairMenu.addActionListener(this);
        adicionarMenu.addActionListener(this);
        consultarMenu.addActionListener(this);
        excluirMenu.addActionListener(this);
        alterarMenu.addActionListener(this);

        // Definições de tela
        // Menu

        setJMenuBar(menuBar);
        menuBar.add(opcoesMenu);
        opcoesMenu.add(adicionarMenu);
        opcoesMenu.add(alterarMenu);
        opcoesMenu.add(consultarMenu);
        opcoesMenu.add(excluirMenu);

        opcoesMenu.add(sairMenu);

        // Criado Tabela
        String[] colunas = { "ID", "Marca", "Modelo", "Ano", "Cor", "Placa", "Preço","Câmbio", "Observações" };
        tableModel = new DefaultTableModel(colunas, 0);
        tabela = new JTable(tableModel);

        // Tela
        Container usuarioGUI = getContentPane();
        usuarioGUI.setLayout(new GridLayout(1, 2));
        JPanel parteUm = new JPanel(new BorderLayout());
        JPanel parteDois = new JPanel(new BorderLayout());
        JPanel caixaTxt = new JPanel(new GridLayout(15, 2));
        JPanel caixaBtDisponivel = new JPanel(new FlowLayout());
        caixaBtDisponivel.add(sim);
        caixaBtDisponivel.add(nao);
        JPanel caixaBt = new JPanel(new FlowLayout());

        caixaTxt.add(etqModelo);
        caixaTxt.add(txtModelo);
        caixaTxt.add(etqMarca);
        caixaTxt.add(txtMarca);
        caixaTxt.add(etqPlaca);
        caixaTxt.add(txtPlaca);
        caixaTxt.add(etqCor);
        caixaTxt.add(txtCor);
        caixaTxt.add(etqCategoria);
        caixaTxt.add(txtCategoria);
        caixaTxt.add(etqQtdLugares);
        caixaTxt.add(txtQtdLugares);
        caixaTxt.add(etValor);
        caixaTxt.add(txtValor);
        caixaTxt.add(etQuilometragem);
        caixaTxt.add(txtQuilometragem);
        caixaTxt.add(etAno);
        caixaTxt.add(txtAno);
        caixaTxt.add(etDisponivel);
        caixaTxt.add(caixaBtDisponivel);
        caixaTxt.add(etqCambio);
        caixaTxt.add(txtCambio);
        caixaTxt.add(etObservacoes);
        caixaTxt.add(txtObservacoes);

        caixaBt.add(btAdicionar);
        caixaBt.add(btAtualizar);
        caixaBt.add(btLimpar);

        parteUm.add(caixaTxt, BorderLayout.CENTER);
        parteUm.add(caixaBt, BorderLayout.SOUTH);

        parteDois.add(etCarros, BorderLayout.NORTH);
        parteDois.add(new JScrollPane(tabela), BorderLayout.CENTER);

        usuarioGUI.add(parteUm);
        usuarioGUI.add(parteDois);

        setTitle("Registro de Veiculo");
        setSize(1360, 600);
        setLocationRelativeTo(null); // Vi esse comando para centralizar em um forum =>
                                     // https://www.guj.com.br/t/como-fazer-para-um-jframe-inicializar-no-meio-da-tela/113064
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Transforma a tela visivel
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btAdicionar) {

            CarroClass carro = new CarroClass();

            carro.setModelo(txtModelo.getText());
            carro.setMarca(txtMarca.getText());
            carro.setPlaca(txtPlaca.getText());
            carro.setCor(txtCor.getText());
            carro.setCategoria(txtCategoria.getText());
            carro.setQtdLugares(Integer.parseInt(txtQtdLugares.getText()));
            carro.setQuilometragem(Integer.parseInt(txtQuilometragem.getText()));
            carro.setAno(Integer.parseInt(txtAno.getText()));
            carro.setValorDiaria(Double.parseDouble(txtValor.getText()));
            carro.setObservacoes(txtObservacoes.getText());

            txtModelo.setText("");
            txtMarca.setText("");
            txtPlaca.setText("");
            txtCor.setText("");
            txtCategoria.setText("");
            txtQtdLugares.setText("");
            txtQuilometragem.setText("");
            txtAno.setText("");
            txtValor.setText("");
            txtCambio.setText("");
            txtObservacoes.setText("");

            conexao.inserir(carro);

        }

        else if (e.getSource() == adicionarMenu) {
            CarroClass carro = new CarroClass();
            carro.setModelo(txtModelo.getText());
            carro.setMarca(txtMarca.getText());
            carro.setPlaca(txtPlaca.getText());
            carro.setCor(txtCor.getText());
            carro.setCategoria(txtCategoria.getText());
            carro.setCambio(txtCambio.getText());
            carro.setQtdLugares(Integer.parseInt(txtQtdLugares.getText()));
            carro.setQuilometragem(Integer.parseInt(txtQuilometragem.getText()));
            carro.setAno(Integer.parseInt(txtAno.getText()));
            carro.setValorDiaria(Double.parseDouble(txtValor.getText()));
            carro.setObservacoes(txtObservacoes.getText());

            txtModelo.setText("");
            txtMarca.setText("");
            txtPlaca.setText("");
            txtCor.setText("");
            txtCategoria.setText("");
            txtCambio.setText("");
            txtQtdLugares.setText("");
            txtQuilometragem.setText("");
            txtAno.setText("");
            txtValor.setText("");
            txtObservacoes.setText("");

            conexao.inserir(carro);
        }

        else if (e.getSource() == btLimpar) {   
            txtModelo.setText("");
            txtMarca.setText("");
            txtPlaca.setText("");
            txtCor.setText("");
            txtCategoria.setText("");
            txtCambio.setText("");
            txtQtdLugares.setText("");
            txtQuilometragem.setText("");
            txtAno.setText("");
            txtValor.setText("");
            txtObservacoes.setText("");

            tableModel.setRowCount(0); // Limpa o modelo

        } 
        
        else if (e.getSource() == consultarMenu) {

            tableModel.setRowCount(0);
            for (String[] carrosDAO : conexao.listar()) {
                tableModel.addRow(carrosDAO);
            }
        }

        else if (e.getSource() == excluirMenu) {
            String exclui = JOptionPane.showInputDialog("Qual carro deseja excluir? \n Placa do carro: ");
            if (exclui != null && !exclui.isEmpty()) {
                conexao.apagar(exclui); 

                
                tableModel.setRowCount(0);
                for (String[] carro : conexao.listar()) {
                    tableModel.addRow(carro); 
                }

                JOptionPane.showMessageDialog(null, "Carro excluído: " + exclui);
            } else {
                JOptionPane.showMessageDialog(null, "Placa inválida ou operação cancelada.");
            }

        } 
        
        else if (e.getSource() == btAtualizar) {
            String placaAtt = JOptionPane.showInputDialog("Qual é a placa do carro que deseja atualizar?");

            if (placaAtt != null && !placaAtt.isEmpty()) {
            
                CarroClass carro = new CarroClass();

                carro.setPlaca(placaAtt); // Mantém a placa original
                carro.setMarca(JOptionPane.showInputDialog("Marca:", txtMarca.getText()));
                carro.setModelo(JOptionPane.showInputDialog("Modelo:", txtModelo.getText()));
                carro.setCor(JOptionPane.showInputDialog("Cor:", txtCor.getText()));
                carro.setCategoria(JOptionPane.showInputDialog("Categoria:", txtCategoria.getText()));
                carro.setQtdLugares(Integer.parseInt(JOptionPane.showInputDialog("Quantidade de lugares:", txtQtdLugares.getText())));
                carro.setQuilometragem(Integer.parseInt(JOptionPane.showInputDialog("Quilometragem:", txtQuilometragem.getText())));
                carro.setAno(Integer.parseInt(JOptionPane.showInputDialog("Ano:", txtAno.getText())));
                carro.setValorDiaria(Double.parseDouble(JOptionPane.showInputDialog("Valor da diária:", txtValor.getText())));
                carro.setCambio(JOptionPane.showInputDialog("Cambio:", txtCategoria.getText()));
                carro.setObservacoes(JOptionPane.showInputDialog("Observações:", txtObservacoes.getText()));

        
                
                conexao.atualizar(carro);
        
                
                tableModel.setRowCount(0); 
                for (String[] carroDAO : conexao.listar()) {
                    tableModel.addRow(carroDAO); 
                }
        
                JOptionPane.showMessageDialog(this, "Carro atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Operação cancelada ou placa inválida.");
            }

        }
        
        else if (e.getSource() == alterarMenu) {
            
           
        }

        else if (e.getSource() == sairMenu) {
            System.exit(0);
        }
    }

}
