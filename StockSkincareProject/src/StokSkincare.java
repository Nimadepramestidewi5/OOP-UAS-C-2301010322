
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class StokSkincare extends javax.swing.JFrame {
    private DefaultTableModel tableModel;

    public StokSkincare() {
        initComponents();
        try {
            tableModel = (DefaultTableModel) table.getModel();
            styleTable();
            loadData();
            getContentPane().setBackground(new Color(240, 248, 255));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error initializing form: " + e.getMessage());
        }
    }

    private void styleTable() {
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(70, 130, 180));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 12));
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        lblNo = new javax.swing.JLabel();
        lblNamaSkincare = new javax.swing.JLabel();
        lblTglDatang = new javax.swing.JLabel();
        lblTglExpired = new javax.swing.JLabel();
        lblAlamatGudang = new javax.swing.JLabel();
        txtNo = new javax.swing.JTextField();
        txtNamaSkincare = new javax.swing.JTextField();
        txtTglDatang = new javax.swing.JTextField();
        txtTglExpired = new javax.swing.JTextField();
        txtAlamatGudang = new javax.swing.JTextField();
        btnInput = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCek = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Penyimpanan Stok Skincare");

        lblNo.setFont(new java.awt.Font("Arial", 1, 14));
        lblNo.setText("No:");
        lblNamaSkincare.setFont(new java.awt.Font("Arial", 1, 14));
        lblNamaSkincare.setText("Nama Skincare:");
        lblTglDatang.setFont(new java.awt.Font("Arial", 1, 14));
        lblTglDatang.setText("Tanggal Datang:");
        lblTglExpired.setFont(new java.awt.Font("Arial", 1, 14));
        lblTglExpired.setText("Tanggal Expired:");
        lblAlamatGudang.setFont(new java.awt.Font("Arial", 1, 14));
        lblAlamatGudang.setText("Alamat Gudang:");

        txtNo.setBackground(new java.awt.Color(240, 240, 240));
        txtNo.setFont(new java.awt.Font("Arial", 0, 14));
        txtNamaSkincare.setBackground(new java.awt.Color(240, 240, 240));
        txtNamaSkincare.setFont(new java.awt.Font("Arial", 0, 14));
        txtTglDatang.setBackground(new java.awt.Color(240, 240, 240));
        txtTglDatang.setFont(new java.awt.Font("Arial", 0, 14));
        txtTglExpired.setBackground(new java.awt.Color(240, 240, 240));
        txtTglExpired.setFont(new java.awt.Font("Arial", 0, 14));
        txtAlamatGudang.setBackground(new java.awt.Color(240, 240, 240));
        txtAlamatGudang.setFont(new java.awt.Font("Arial", 0, 14));

        btnInput.setFont(new java.awt.Font("Arial", 1, 14));
        btnInput.setText("Input");
        btnInput.addActionListener(evt -> btnInputActionPerformed(evt));

        btnEdit.setFont(new java.awt.Font("Arial", 1, 14));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(evt -> btnEditActionPerformed(evt));

        btnDelete.setFont(new java.awt.Font("Arial", 1, 14));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(evt -> btnDeleteActionPerformed(evt));

        btnCek.setFont(new java.awt.Font("Arial", 1, 14));
        btnCek.setText("Cek");
        btnCek.addActionListener(evt -> btnCekActionPerformed(evt));

        table.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "No", "Nama Skincare", "Tanggal Datang", "Tanggal Expired", "Alamat Gudang"}
        ) {
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit[columnIndex]; }
        });
        table.setGridColor(new java.awt.Color(204, 204, 204));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNo)
                            .addComponent(lblNamaSkincare)
                            .addComponent(lblTglDatang)
                            .addComponent(lblTglExpired)
                            .addComponent(lblAlamatGudang))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaSkincare, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTglDatang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTglExpired, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAlamatGudang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCek, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNo)
                    .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaSkincare)
                    .addComponent(txtNamaSkincare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTglDatang)
                    .addComponent(txtTglDatang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTglExpired)
                    .addComponent(txtTglExpired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCek))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlamatGudang)
                    .addComponent(txtAlamatGudang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "INSERT INTO skincare (no, nama_skincare, tgl_datang_barang, tgl_expired, alamat_gudang) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, txtNo.getText());
            stmt.setString(2, txtNamaSkincare.getText());
            stmt.setDate(3, java.sql.Date.valueOf(txtTglDatang.getText()));
            stmt.setDate(4, java.sql.Date.valueOf(txtTglExpired.getText()));
            stmt.setString(5, txtAlamatGudang.getText());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
            clearFields();
            loadData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Error: Format tanggal harus YYYY-MM-DD!");
        }
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                Connection conn = Koneksi.getConnection();
                String sql = "UPDATE skincare SET no = ?, nama_skincare = ?, tgl_datang_barang = ?, tgl_expired = ?, alamat_gudang = ? WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, txtNo.getText());
                stmt.setString(2, txtNamaSkincare.getText());
                stmt.setDate(3, java.sql.Date.valueOf(txtTglDatang.getText()));
                stmt.setDate(4, java.sql.Date.valueOf(txtTglExpired.getText()));
                stmt.setString(5, txtAlamatGudang.getText());
                stmt.setInt(6, (Integer) tableModel.getValueAt(selectedRow, 0));
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
                clearFields();
                loadData();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, "Error: Format tanggal harus YYYY-MM-DD!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan diupdate!");
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                Connection conn = Koneksi.getConnection();
                String sql = "DELETE FROM skincare WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, (Integer) tableModel.getValueAt(selectedRow, 0));
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                clearFields();
                loadData();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
        }
    }

    private void btnCekActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            java.util.Date currentDate = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date expiredDate = sdf.parse(txtTglExpired.getText());

            if (expiredDate.before(currentDate) || expiredDate.equals(currentDate)) {
                JOptionPane.showMessageDialog(this, "Peringatan: Skincare ini sudah kadaluarsa per " + sdf.format(currentDate) + "!");
            } else {
                long diff = expiredDate.getTime() - currentDate.getTime();
                long days = diff / (1000 * 60 * 60 * 24);
                JOptionPane.showMessageDialog(this, "Skincare ini masih berlaku selama " + days + " hari lagi.");
            }
        } catch (java.text.ParseException e) {
            JOptionPane.showMessageDialog(this, "Error: Format tanggal harus YYYY-MM-DD!");
        }
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            txtNo.setText(tableModel.getValueAt(selectedRow, 1).toString());
            txtNamaSkincare.setText(tableModel.getValueAt(selectedRow, 2).toString());
            txtTglDatang.setText(tableModel.getValueAt(selectedRow, 3).toString());
            txtTglExpired.setText(tableModel.getValueAt(selectedRow, 4).toString());
            txtAlamatGudang.setText(tableModel.getValueAt(selectedRow, 5).toString());
        }
    }

    private void loadData() {
        tableModel.setRowCount(0);
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "SELECT id, no, nama_skincare, tgl_datang_barang, tgl_expired, alamat_gudang FROM skincare";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("no"),
                    rs.getString("nama_skincare"),
                    rs.getDate("tgl_datang_barang"),
                    rs.getDate("tgl_expired"),
                    rs.getString("alamat_gudang")
                };
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }
    }

    private void clearFields() {
        txtNo.setText("");
        txtNamaSkincare.setText("");
        txtTglDatang.setText("");
        txtTglExpired.setText("");
        txtAlamatGudang.setText("");
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StokSkincare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new StokSkincare().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnInput;
    private javax.swing.JButton btnCek;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlamatGudang;
    private javax.swing.JLabel lblNamaSkincare;
    private javax.swing.JLabel lblNo;
    private javax.swing.JLabel lblTglDatang;
    private javax.swing.JLabel lblTglExpired;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtAlamatGudang;
    private javax.swing.JTextField txtNamaSkincare;
    private javax.swing.JTextField txtNo;
    private javax.swing.JTextField txtTglDatang;
    private javax.swing.JTextField txtTglExpired;
    // End of variables declaration
}
