package klinik;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainClass extends javax.swing.JFrame {
    
    int PasID;
    Pasien pasien;

    public MainClass() {
        initComponents();
        ViewDataPasien(""); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(608, 50));

        btnTambah.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnCari.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit)
                .addGap(18, 18, 18)
                .addComponent(btnHapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCari)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnCari)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        
        TambahPasien TP = new TambahPasien(this, true);
        TP.setVisible(true); 
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
         EditData();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        HapusData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:
        int index = tblData.getSelectedRow();
        if(index != -1){
            String id = tblData.getValueAt(index, 0).toString();
            int TheID = Integer.parseInt(id);
            PasID = TheID;
            
            String nama_pasien = tblData.getValueAt(index, 1).toString();
            String jk = tblData.getValueAt(index, 2).toString();
            String alamat = tblData.getValueAt(index, 3).toString();
            String no_hp = tblData.getValueAt(index, 4).toString();
            String tgl_lahir = tblData.getValueAt(index, 5).toString();
            String tgl_daftar = tblData.getValueAt(index, 6).toString();
            pasien = new Pasien();
            pasien.setId_pasien(id);
            pasien.setNama_pasien(nama_pasien); 
            pasien.setJk(jk); 
            pasien.setAlamat(alamat); 
            pasien.setNo_hp(no_hp); 
            pasien.setTgl_lahir(tgl_lahir); 
            pasien.setTgl_daftar(tgl_daftar); 
            
        }
    }//GEN-LAST:event_tblDataMouseClicked

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        String key = txtCari.getText();
        String where = " WHERE "
                + "nama_pasien LIKE '%"+key+"%' OR "
                + "jk LIKE '%"+key+"%' OR "
                + "alamat LIKE '%"+key+"%' OR "
                + "no_hp LIKE '%"+key+"%' OR "
                + "tgl_lahir LIKE '%"+key+"%' OR "
                + "tgl_daftar LIKE '%"+key+"%'";
        ViewDataPasien(where); 
    }//GEN-LAST:event_txtCariKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainClass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblData;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables

public static void ViewDataPasien(String where){
        Object[] kolom = {"id_pasien","nama_pasien","jk","alamat","no_hp","tgl_lahir","tgl_daftar"};
        DefaultTableModel model = new DefaultTableModel(null, kolom);
        tblData.setModel(model); 
        
        //ambil data dari database
        
        try {
            Connection c = Koneksi.sambungkeDB();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM pasien "+where;
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            //dan tambahkan data ke dalam tabel
            while (rs.next()) {                 
                int id_pasien = rs.getInt("id_pasien");
                String nama_pasien= rs.getString("nama_pasien");
                String jk = rs.getString("jk");
                String alamat = rs.getString("alamat");
                String no_hp = rs.getString("no_hp");
                Date tgl_lahir = rs.getDate("tgl_lahir");
                Date tgl_daftar = rs.getDate("tgl_daftar");
                Object[] data = {id_pasien, nama_pasien,jk,alamat,no_hp,tgl_lahir,tgl_daftar};
                model.addRow(data); 
            }
        } catch (SQLException e) {
        }
    }

    private void HapusData() {
        if(PasID > 0){
            try {
                Object[] tombol = {"YA", "Tidak"};
                int option = JOptionPane.showOptionDialog(this, 
                        "Apakah anda ingin menghapus data?", 
                        "Konfirmasi", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.INFORMATION_MESSAGE, null, tombol, 0);
                if(option == 0){
                    //YA
                    //YES
                    Connection c = Koneksi.sambungkeDB();
                    Statement st = c.createStatement();
                    String sql = "DELETE FROM pasien WHERE id_pasien='"+PasID+"'";
                    //eksekusi query
                    st.executeUpdate(sql);
                    //refresh view table
                    ViewDataPasien(""); 
                    JOptionPane.showMessageDialog(this, "Data telah dihapus");
                }                
            } catch (HeadlessException | SQLException e) {
            }
        }else {
            JOptionPane.showMessageDialog(this, "Anda belum memilih Data"); 
        }
    }
    
    private void EditData() {
        if(PasID > 0){
            EditPasien edit = new EditPasien(this, true);
            edit.Pas = pasien;
            edit.setVisible(true); 
        }
    }
}
