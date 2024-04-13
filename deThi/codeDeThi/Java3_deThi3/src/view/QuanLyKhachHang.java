package view;

import repository.KhachHangRepository;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import service.KhachHangService;

public class QuanLyKhachHang extends javax.swing.JFrame {

    KhachHangService khachHangRepository = new KhachHangService();

    public QuanLyKhachHang() {
        initComponents();
        loadTable();

        KhachHang khachHang = khachHangRepository.findAll().get(0);
        show(0);
    }

    public void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblKhachHang.getModel();
        dtm.setRowCount(0);
        for (KhachHang khachHang : khachHangRepository.findAll()) {
            Object[] rowData = {
                khachHang.getId(),
                khachHang.getTen(),
                khachHang.getDiaChi(),
                khachHang.getEmail(),
                khachHang.getTuoi(),
                khachHang.getGioiTinh() == 1 ? "Nam" : "Nu"
            };
            dtm.addRow(rowData);
        }
    }

    // show phai dung set (doiTuong.get de lay ra gia tri)
    // if else doi voi rdo
    public void show(int index) {
        KhachHang khachHang = khachHangRepository.findAll().get(index);
        txtID.setText(String.valueOf(khachHang.getId()));
        txtTen.setText(khachHang.getTen());
        txtDiaChi.setText(khachHang.getDiaChi());
        txtEmail.setText(khachHang.getEmail());
        txtTuoi.setText(String.valueOf(khachHang.getTuoi()));
        int gioiTinh = khachHang.getGioiTinh();
        if (gioiTinh == 1) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
    }

    public KhachHang getForm() {
        if (txtTen.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Nhap ten de");
            return null;
        }
        if (txtDiaChi.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Nhap dia chi de");
            return null;
        }
        if (txtEmail.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Nhap email de");
            return null;
        }
        if (Integer.valueOf(txtTuoi.getText().trim().length()) == 0) {
            JOptionPane.showMessageDialog(this, "Nhap tuoi de");
            return null;
        }

        // Check if age is a valid non-negative integer 
        String tuoiSTr = txtTuoi.getText();
        try {
            int tuoi = Integer.parseInt(tuoiSTr);
            if (tuoi <= 0) {
                JOptionPane.showMessageDialog(this, "Tuoi phai la so nguyen khong am");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tuoi phai la so");
            return null;
        }

        // Validate email format
        String email = txtEmail.getText().trim();
        if (!email.matches("^([a-zA-Z])([a-zA-Z0-9_.]*)([a-zA-Z0-9])@([a-zA-Z0-9]*\\.)*[a-zA-Z0-9]*")) {
            JOptionPane.showMessageDialog(this, "Email khong dung dinh dang");
            return null;
        }

        int id = Integer.valueOf(txtID.getText());
        String ten = txtTen.getText();
        String diaChi = txtDiaChi.getText();
        int trangThai = Integer.valueOf(rdoNam.isSelected() ? 1 : 0);
        KhachHang khachHang = new KhachHang(id, ten, diaChi, email, Integer.valueOf(tuoiSTr), Integer.valueOf(trangThai));
        return khachHang;
    }

    public void clearData() {
        txtTen.setText("");
        txtID.setText("");
        txtDiaChi.setText("");
        txtTuoi.setText("");
        txtEmail.setText("");
        rdoNam.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("khach_hang");

        jLabel1.setText("ID");

        txtID.setEditable(false);
        txtID.setBorder(null);
        txtID.setEnabled(false);

        jLabel2.setText("Ten");

        jLabel3.setText("Dia chi");

        jLabel4.setText("Email");

        jLabel5.setText("Tuoi");

        jLabel6.setText("GioiTinh");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nu");

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ten", "Dia chi", "Email", "Tuoi", "Gioi tinh"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(38, 38, 38)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(55, 55, 55)
                                .addComponent(rdoNam)
                                .addGap(128, 128, 128)
                                .addComponent(rdoNu)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnThem)
                .addGap(31, 31, 31)
                .addComponent(btnSua)
                .addGap(40, 40, 40)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addGap(31, 31, 31)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(rdoNu)
                    .addComponent(rdoNam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnClear)
                    .addComponent(btnExit))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        int row = tblKhachHang.getSelectedRow();
        if (row == -1) {
            return;
        }

        KhachHang khachHang = khachHangRepository.findAll().get(row);
        show(row);
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "Ban co muon nhap tiep khong ?", "Thong Bao", WIDTH);
        if (hoi == JOptionPane.YES_OPTION) {
            txtTen.setText("");
            txtID.setText("");
            txtDiaChi.setText("");
            txtTuoi.setText("");
            txtEmail.setText("");
            rdoNam.setSelected(true);
        }
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "Ban chac chu", "Thong Bao", WIDTH);
        if (hoi == JOptionPane.YES_OPTION) {
            int row = tblKhachHang.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Chon dong de");
                return;
            }

            int id = Integer.valueOf(tblKhachHang.getValueAt(row, 0).toString());
            try {
                khachHangRepository.xoa(id);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            loadTable();
            clearData();
            JOptionPane.showMessageDialog(this, "Xoa thanh cong");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "Ban chac chu", "Thong Bao", WIDTH);
        if (hoi == JOptionPane.YES_OPTION) {
            KhachHang khachHang = getForm();
            if (khachHang == null) {
                return;
            }

            try {
                if (khachHangRepository.them(khachHang) != null) {
                    loadTable();
                    JOptionPane.showMessageDialog(this, "Them thanh cong");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "Ban chac chu", "Thong Bao", WIDTH);
        if (hoi == JOptionPane.YES_OPTION) {
            int row = tblKhachHang.getSelectedRow();
            if (row == -1) {
                return;
            }

            KhachHang khachHang = getForm();
            if (khachHang == null) {
                JOptionPane.showMessageDialog(null, "Chon dong de");
                return;
            }

            try {
                if (khachHangRepository.sua(khachHang, row) != null) {
                    loadTable();
                    JOptionPane.showMessageDialog(this, "Sua thanh cong");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
