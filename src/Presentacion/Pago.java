
package Presentacion;
import Negocio.DTOs.DetalleVentaDTO;
import Negocio.DTOs.ProductoDTO;
import Negocio.DTOs.UsuarioDTO;
import Negocio.DTOs.VentasDTO;
import Negocio.FacadeJoyeria;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dórame
 */
public class Pago extends javax.swing.JDialog {
        
        private float totalGeneral;       
        private float monto;
         UsuarioDTO user;   
         private int s;
         private float descuento;
         private int p = 0;
         private DefaultTableModel lista;
         private float totalDescuento;
         private List <ProductoDTO> listaventa;
         private String empleado;
     
    /** 
     * Creates new form Pago
     */
    public Pago(java.awt.Frame parent, boolean modal) {
        super(parent, modal);        
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null); 
        jpanePago.setBackground(Color.WHITE);
        getContentPane().add(jpanePago, BorderLayout.CENTER);
        ocultarComponentes();    
    }

public Pago(java.awt.Frame parent, boolean modal, float tot,  DefaultTableModel tabla,
        UsuarioDTO u, float d, int pp, float totald,List <ProductoDTO> listav, String emp) {
        super(parent, modal);
        this.p = pp;
        s=0;
     
       this.listaventa = listav;
       this.totalDescuento= totald;
       this.totalGeneral = tot;
       this.descuento = d;
       this.lista = tabla;
       this.user = u;
       this.empleado = emp;
      
        initComponents();
        lblTotal.setText("TOTAL; "+ this.totalGeneral + " \n Descuento aplicado; "+ totalDescuento);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null); 
        jpanePago.setBackground(Color.WHITE);
        getContentPane().add(jpanePago, BorderLayout.CENTER);
        ocultarComponentes();    
    }   
    private void mostrarComponentes2(){
        lblMonto.setVisible(true);
        lblCambio.setVisible(true);
        txtMonto.setVisible(true); 
    }
    private void ocultarComponentes(){
        lblCliente.setVisible(false);
        lblMonto.setVisible(false);
        lblCambio.setVisible(false);
        txtCliente.setVisible(false);
        txtMonto.setVisible(false);       
    }
    private void mostrarComponentes(){
        lblCliente.setVisible(true);
        lblMonto.setVisible(true);
        lblCambio.setVisible(true);
        txtCliente.setVisible(true);
        txtMonto.setVisible(true);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanePago = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblogo = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        cbFacturar = new javax.swing.JCheckBox();
        lblCambio = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel1.setText("FORMA DE PAGO");

        lblogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/SDlogoVenta.jpg"))); // NOI18N
        lblogo.setText("jLabel2");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setText("TOTAL;");

        jLabel2.setText("FORMA DE PAGO; ");

        jButton1.setText("EFECTIVO");
        jButton1.setMinimumSize(new java.awt.Dimension(75, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("TARJETA");
        jButton2.setPreferredSize(new java.awt.Dimension(81, 26));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblCliente.setText("CLIENTE; ");

        lblMonto.setText("MONTO; ");

        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMontoKeyPressed(evt);
            }
        });

        cbFacturar.setText(" FACTURAR");

        lblCambio.setText("CAMBIO; ");

        jButton3.setText("PAGAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("CANCELAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanePagoLayout = new javax.swing.GroupLayout(jpanePago);
        jpanePago.setLayout(jpanePagoLayout);
        jpanePagoLayout.setHorizontalGroup(
            jpanePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanePagoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanePagoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jpanePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanePagoLayout.createSequentialGroup()
                                .addGroup(jpanePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpanePagoLayout.createSequentialGroup()
                                        .addComponent(lblCliente)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanePagoLayout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                .addGroup(jpanePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbFacturar)
                                    .addComponent(lblCambio))
                                .addGap(129, 129, 129))
                            .addGroup(jpanePagoLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpanePagoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))))
                    .addGroup(jpanePagoLayout.createSequentialGroup()
                        .addGroup(jpanePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(jpanePagoLayout.createSequentialGroup()
                                .addComponent(lblMonto)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jpanePagoLayout.createSequentialGroup()
                .addGroup(jpanePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanePagoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblogo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1))
                    .addGroup(jpanePagoLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(lblTotal)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanePagoLayout.setVerticalGroup(
            jpanePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanePagoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpanePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblogo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jpanePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCliente)
                    .addGroup(jpanePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbFacturar)))
                .addGap(31, 31, 31)
                .addGroup(jpanePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCambio)
                    .addComponent(lblMonto)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jpanePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanePago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanePago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Menu m = new Menu();
        FrmVenta v = new FrmVenta(m,true,this.user, empleado);
        v.setResizable(false);
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if( s == 0) {
            mostrarComponentes();
        }
        else{
            mostrarComponentes2(); 
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtMontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyPressed
        if (evt.getExtendedKeyCode()==VK_ENTER ||evt.getKeyCode() == KeyEvent.VK_TAB ){
            monto = Integer.parseInt(txtMonto.getText());
           try{
            if( monto > totalGeneral){
                lblCambio.setText("CAMBIO; "+ String.valueOf(monto - totalGeneral));                
            }
            else{JOptionPane.showMessageDialog(null, "Verifique el monto registrado! ");
                    txtMonto.setText("");
            }
          
           }catch(ClassCastException e){
               JOptionPane.showMessageDialog(null, e.getMessage());              
           }
        }
    }//GEN-LAST:event_txtMontoKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (txtCliente.getText().isEmpty() || txtMonto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Verifique que los campos esten llenos ");
        }
       else{
            if(monto < totalGeneral){
               JOptionPane.showMessageDialog(null, "Verifique el monto registrado! ");
            }
            else{
 
            LocalDateTime fecha = LocalDateTime.now();
            ZonedDateTime zdt = fecha.atZone(ZoneId.systemDefault());
            Date date = Date.from(zdt.toInstant());            
             ProductoDTO prod = new ProductoDTO();  
            FacadeJoyeria f = new FacadeJoyeria();
            String folio = f.getPrestamoRepositorio().generarFolio();
            
            VentasDTO v = new VentasDTO(this.user.getId(),date,folio,descuento,txtCliente.getText(),totalGeneral);         
           f.getVentaRepositorio().agregar(v);
            
            DetalleVentaDTO dv ;
            for(int i = 0; i<= p-1; i++){ 
                float r = cas(i);  
                dv = new DetalleVentaDTO(v.getId(),(int)lista.getValueAt(i,0),(int)lista.getValueAt(i,4),r);
                f.getDetalleVentaRepositorio().agregar(dv);
                prod.setId(listaventa.get(i).getId());
                prod.setNombre(listaventa.get(i).getNombre());
                prod.setCodigo(listaventa.get(i).getCodigo());
                prod.setDescripcion(listaventa.get(i).getDescripcion());
                prod.setImagen(listaventa.get(i).getImagen());
                prod.setPrecio(listaventa.get(i).getPrecio());
                int stk = stock(i);
                prod.setStock(stk);
                prod.setEstado(listaventa.get(i).getEstado());
                prod.setIdCategoria(listaventa.get(i).getIdCategoria());
                f.getProductoRepositorio().actualizar(prod);            
              }
            
            JOptionPane.showMessageDialog(null, "Venta guardada correctamente");
            cerrar();
            }
        }       
    }//GEN-LAST:event_jButton3ActionPerformed
   
    public int stock(int i){
    return ( listaventa.get(i).getStock()) - (int)(lista.getValueAt(i, 4));
    }
    
    public void cerrar(){
       Menu m = new Menu();
       FrmVenta v = new FrmVenta(m,true,this.user,empleado);
        v.setResizable(false);
        v.setVisible(true);
       this.dispose();
   }
    public float cas(int i){
        float resultado=0;
        if (this.lista.getValueAt(i, 3) instanceof Number && this.lista.getValueAt(i, 4) instanceof Number){
            float t1 = ((Number) this.lista.getValueAt(i, 3)).floatValue();
            float t2 = ((Number) this.lista.getValueAt(i, 4)).floatValue();  
            resultado = t1*t2;
        }
        else{
            JOptionPane.showMessageDialog(null, "Los datos no son números");
        }
        return resultado;
    }    
    
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
            java.util.logging.Logger.getLogger(Pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Pago dialog = new Pago(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbFacturar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpanePago;
    private javax.swing.JLabel lblCambio;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblogo;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
