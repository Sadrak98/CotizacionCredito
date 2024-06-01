package com.mycompany.cotizacioncredito;

public class InterfazPrincipal extends javax.swing.JFrame {

    public InterfazPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAdminProductos = new javax.swing.JButton();
        btnAdminPlazos = new javax.swing.JButton();
        btnCotizacionCreditos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sistema"));

        btnAdminProductos.setText("Administración de Productos");
        btnAdminProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminProductosActionPerformed(evt);
            }
        });

        btnAdminPlazos.setText("Administración de Plazos");
        btnAdminPlazos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminPlazosActionPerformed(evt);
            }
        });

        btnCotizacionCreditos.setText("Cotización de Créditos");
        btnCotizacionCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCotizacionCreditosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdminProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(btnAdminPlazos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCotizacionCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnAdminProductos)
                .addGap(41, 41, 41)
                .addComponent(btnAdminPlazos)
                .addGap(33, 33, 33)
                .addComponent(btnCotizacionCreditos)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminProductosActionPerformed
        IntefazProductos objetoProducto = new IntefazProductos();
        objetoProducto.setInterfazPrincipal(this);
        objetoProducto.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAdminProductosActionPerformed

    private void btnAdminPlazosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminPlazosActionPerformed
        IntefazPlazos objetoPlazos = new IntefazPlazos();
        objetoPlazos.setInterfazPrincipal2(this);
        objetoPlazos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAdminPlazosActionPerformed

    private void btnCotizacionCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCotizacionCreditosActionPerformed
        InterfazCotizacion interfazCotizacion = new InterfazCotizacion();
        interfazCotizacion.setInterfazPrincipal3(this);
        interfazCotizacion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCotizacionCreditosActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminPlazos;
    private javax.swing.JButton btnAdminProductos;
    private javax.swing.JButton btnCotizacionCreditos;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
