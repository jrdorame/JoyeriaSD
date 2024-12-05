
package Presentacion;

import Negocio.DTOs.ProductoDTO;
import Negocio.DTOs.UsuarioDTO;
import Negocio.FacadeJoyeria;
import Negocio.RenderTabla;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dórame
 */
public class FrmVenta extends javax.swing.JDialog {
    JButton b1 = new JButton("Agregar");
    JButton b2 = new JButton("Eliminar");
    
    public static int columna,row;  
    private int filaseleccionada;
    private ImageIcon imagen;
    private Icon icono;
    private TextAutoCompleter ac;
    private String [] codigo ;
    private int p =0;
    float total =0;
    float totalgeneral=0;
    float descuento=0;
    FacadeJoyeria fv;   
    List <ProductoDTO> li;
    List <ProductoDTO> listaventa;
    DefaultTableModel productosModel;
    private ProductoDTO productoLista;
    private int id;
    UsuarioDTO user;
    private float totalDescuento =0;
    boolean excepcion = false;
    private String empleado;
    
    /**
     * Constructor, establece parametros del JTable y llama al metodo autocompletar
     * @param parent
     * @param modal
     * @param usu
     */
    public FrmVenta(java.awt.Frame parent, boolean modal, UsuarioDTO usu, String emp) {       
        super(parent, modal);
        this.user = usu;
        initComponents();
        txtProducto.requestFocus();
        productosModel = (DefaultTableModel)
        tblLista.getModel();
        fv = new FacadeJoyeria();
        listaventa = new ArrayList<>();
        setTitle("Venta");
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null); 
        jPanel1.setBackground(Color.WHITE);
        ac = new TextAutoCompleter(txtProducto);  
        this.empleado = emp;
        inicio(); 
        MostrarTabla();
       
        b1.setName("btn1");b2.setName("btn2");               
        b1.setPreferredSize(new Dimension(100,100));
        b2.setPreferredSize(new Dimension(100,100));
        
        tblLista.setDefaultRenderer(Object.class, new RenderTabla());
        productosModel.setColumnIdentifiers(new String[]{"ID","CODIGO","NOMBRE",
        "PRECIO","CANTIDAD", "",""});
        b1.setText(""); b2.setText("");
        tblLista.getColumnModel().getColumn(5).setPreferredWidth(20);
        tblLista.getColumnModel().getColumn(6).setPreferredWidth(20);
        tblLista.setModel(productosModel);
        lblEmpleado.setText(emp);
    }
   
     public FrmVenta(java.awt.Frame parent, boolean modal){
          super(parent, modal);
          initComponents();            
     }
     
     /**
      * Establece caracteristicas de botones dentro del JTable
      */
    public void inicio(){
     this.setTitle("Botones en Jtable");this.setResizable(false);this.setLocationRelativeTo(null);
     b1.setText(" + "); b2.setText(" - ");
     InsertarIcono(b1, "/imgs/mas.png");
     InsertarIcono(b2, "/imgs/menos.png");
}
    /**
     * Metodo para agregar más caracteristicas del JTable
     * @param btn
     * @param ruta 
     */
    public void InsertarIcono(JButton btn,String ruta){
    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta)));
}
    /**
     * Muestra la tabla con titulos
     */
    public void MostrarTabla(){
       tblLista.setDefaultRenderer(Object.class,new RenderTabla());
       productosModel.setColumnIdentifiers(new String[]{"ID","CODIGO","NOMBRE",
        "PRECIO","",""});
        tblLista.setModel(productosModel);
        tblLista.setRowHeight(40);
    }
    
    /**
     * Agrega un nuevo renglon con los botones
     * @param dn
     * @param nomb
     * @param pre 
     */
    public void TablaDinamico(String dn, String nomb,float pre){
     Object struct[]={dn,nomb,pre,b1,b2};
     productosModel .addRow(struct);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtAgregar = new javax.swing.JButton();
        txtProducto = new javax.swing.JTextField();
        lblBuscar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblImagen = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        lblDescuento = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblEmpleado = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblTotalGeneral = new javax.swing.JLabel();
        brnCancelar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        brnCancelar1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        lblExistencia = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtAgregar.setText("AGREGAR");
        txtAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgregarActionPerformed(evt);
            }
        });

        txtProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtProductoMousePressed(evt);
            }
        });
        txtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoActionPerformed(evt);
            }
        });
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoKeyPressed(evt);
            }
        });

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBuscar.setText("BUSCAR");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea1.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(102, 102, 102), null, null));

        tblLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "NOMBRE", "PRECIO", "CANTIDAD", "", ""
            }
        ));
        tblLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLista);

        lblDescuento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDescuento.setText("DESCUENTO");

        txtDescuento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyPressed(evt);
            }
        });

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/SDlogoVenta.jpg"))); // NOI18N

        jLabel1.setText("ATENDIO;");

        lblEmpleado.setText("Empeado");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setText("TOTAL; ");

        lblTotalGeneral.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotalGeneral.setText("TOTAL GENERAL;");

        brnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        brnCancelar.setText("CERRAR");
        brnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnCancelarActionPerformed(evt);
            }
        });

        btnPagar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPagar.setText("PAGAR");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        brnCancelar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        brnCancelar1.setText("CANCELAR");
        brnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnCancelar1ActionPerformed(evt);
            }
        });

        jSeparator2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblExistencia.setText("Existencia; ");

        lblDesc.setText("DESCONTADO; ");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/descuentos.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblExistencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(44, 44, 44))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(brnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(450, 450, 450))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(brnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)
                                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(70, 70, 70))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addComponent(lblLogo)
                                        .addGap(29, 29, 29))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(lblDescuento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotalGeneral)
                                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDesc))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtProducto)
                                    .addComponent(txtAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(lblExistencia)
                                .addGap(35, 35, 35)))))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(33, 33, 33)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTotalGeneral)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDesc)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblEmpleado))
                            .addComponent(lblLogo, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Lllama al método agregar
     * @param evt 
     */
    private void txtAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgregarActionPerformed
        agregar();     
    }//GEN-LAST:event_txtAgregarActionPerformed
    
    /**
     * Método para agregar un nuevo producto seleccionado
     */
    public void agregar(){    
        productoLista = fv.getProductoRepositorio().obtener(id);       
       
  if(fv.repetido(listaventa, productoLista, productosModel)) {  // verifica que no se haya repetido el producto en la lista de venta               
             }         
     else {
           listaventa.add(productoLista); //Si no es repetido se agrega 
           llenarTabla(1);
           p = p + 1;
          } 
           calculaTotal();
           calcularDescuento(); 
      }
      
    /**
     * Método apra aumentar cantidad al presionar el boton + dentro del JTable
     * @param producto 
     */
    public void agregarBtn(ProductoDTO producto){
         if(fv.repetido(listaventa, producto, productosModel)) {
         
          if(excepcion== false){         
          calculaTotal();
          calcularDescuento(); 
         }
         else{
            JOptionPane.showMessageDialog(null, "No hay stock suficiente, Verifique el pedido");}
            }    
    }
    
    /**
     * Método para restar o eliminar un producto de la lista desde el boton - en JTable
     * @param producto 
     */
    public void eliminarProducto(ProductoDTO producto){
       listaventa = fv.eliminar(listaventa, producto, productosModel);  
       if(listaventa.isEmpty()){
           CancelarVenta();
       }
       else{
            calculaTotal();
            calcularDescuento();}       
    }
    
    /**
     * Metodo apra calcular el total de la venta
     */
    public void calculaTotal(){
       total = fv.calcularTotal(productosModel, listaventa);
        lblTotal.setText("TOTAL; " + total);
    }
    
    /*
    Método apra llenar la tabla
    */
    public void llenarTabla( int cantidad){
        int a = productosModel.getRowCount();
        
         Object[] nuevaFila = {listaventa.get(a).getId(), listaventa.get(a).getCodigo(), listaventa.get(a).getNombre()
         , listaventa.get(a).getPrecio(), cantidad,b1,b2};
         productosModel.addRow(nuevaFila);   
         calculaTotal();
         calcularDescuento(); 
    }
    
    /**
     * Método apra calcular el descuento asignado //mover a facadae 
     */
    public void calcularDescuento(){
       
        totalgeneral = total - (descuento * (total / 100));         
        lblTotalGeneral.setText("TOTAL GENERAL; "+ String.valueOf(totalgeneral));
        totalDescuento = descuento * (total / 100);
        lblDesc.setText("DESCONTADO; " + totalDescuento);
    }
     
    /*
    Cierra el JDialog
    */
    private void brnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnCancelarActionPerformed
      this.dispose();
    }//GEN-LAST:event_brnCancelarActionPerformed
    
    /**
     * Limpia los campos
     */
    public void limpiarCampos(){
        txtProducto.setText("");
        jTextArea1.setText("");
        lblImagen.setIcon(null);
        lblExistencia.setText("Existencias; ");          
   }
    
    /**
     * Limpia todos los datos
     */
    public void CancelarVenta(){
        limpiarCampos();    
        lblTotal.setText("TOTAL; ");
        lblTotalGeneral.setText("TOTAL GENERAL; ");
        txtDescuento.setText("");      
        excepcion = false;
    }
    
    /**
     * Botón que cancela venta, llama al metodo cancelarVenta para limpiar todo,
     * aqui inicialiaz variables locales
     * @param evt 
     */
    private void brnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnCancelar1ActionPerformed
        listaventa.clear();
        productosModel.setRowCount(0); 
        descuento = 0;
        total =0;
        totalgeneral =0;
        CancelarVenta();
    }//GEN-LAST:event_brnCancelar1ActionPerformed
    
    /*
    Metofo que abre el JDialog para pagar, pasandole variables por el constructor
    */
    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        Menu m = new Menu(user, empleado); 
       
        Pago pa = new Pago(m, true, totalgeneral, productosModel, user ,descuento,p, totalDescuento,listaventa, empleado);
        pa.setResizable(false);
        pa.setVisible(true);
        this.dispose();       
    }//GEN-LAST:event_btnPagarActionPerformed
    
    /*
    Método para mostrar los datos del producto seleccionado al dar Enter
    */
    private void txtProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyPressed
    
    if (evt.getExtendedKeyCode()==VK_ENTER ||evt.getKeyCode() == KeyEvent.VK_TAB ) {
            mostrar();
        }
    }//GEN-LAST:event_txtProductoKeyPressed

    /**
     * Método para limpiar datos al querer escribir en el TextBox de productos
     * @param evt 
     */
    private void txtProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProductoMousePressed
      limpiarCampos();
    }//GEN-LAST:event_txtProductoMousePressed

    /**
     * verifica descuento ingresado en el TextBox y calcula el Total general
     * @param evt 
     */
    private void txtDescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyPressed
        
    if (evt.getExtendedKeyCode()==VK_ENTER ||evt.getKeyCode() == KeyEvent.VK_TAB ) {

        try{
             descuento = Integer.parseInt( txtDescuento.getText());
             if(descuento >= 1 && descuento<= 100){
                 calcularDescuento();
             }
             else{
                JOptionPane.showMessageDialog(null, "Ingrese el % del descuento correctamente!");
                txtDescuento.setText("");                
             }
        }catch (NumberFormatException e) 
                     {
                        JOptionPane.showMessageDialog(null, e.getMessage()+" Verifique el descuento");
                        txtDescuento.setText(""); 
                     }
         }
    }//GEN-LAST:event_txtDescuentoKeyPressed
 
    /**
     * Método para realizar accion dependiendo del boton que se presione dentro del jTable (+ ó -)
     * @param evt 
     */
    private void tblListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMouseClicked
        columna = tblLista.getColumnModel().getColumnIndexAtX(evt.getX());
        row = evt.getY()/tblLista.getHeight();
        
        if (columna <= tblLista.getColumnCount() && columna >= 0 && row <= tblLista.getRowCount() && row >= 0) {
            Object ob = tblLista.getValueAt(row, columna);
          
            if(ob instanceof JButton){
               ((JButton)ob).doClick();
               JButton bot = (JButton) ob;
               
               if(bot.getName().equals("btn1")){                   
                    filaseleccionada =tblLista.getSelectedRow();
                    ProductoDTO pd = new ProductoDTO();
                    pd.setCodigo((String) productosModel.getValueAt(filaseleccionada, 1));       
                    agregarBtn(pd);                    
               }
               
          else if ( bot.getName().equals("btn2")){
                    filaseleccionada =tblLista.getSelectedRow();
                    ProductoDTO pr = new ProductoDTO();
                    pr.setCodigo((String) productosModel.getValueAt(filaseleccionada, 1)); 
                    eliminarProducto(pr);
               }
            }        
        }
    }//GEN-LAST:event_tblListaMouseClicked

    private void txtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoActionPerformed
  
     /**
      * Muestra la imagen de del producto que se seleccionó
      */
    public void mostrar(){
         codigo = txtProducto.getText().split("\\s+");   
        
         for(int i = 0; i<= li.size()-1;i++)
         { 
             if (li.get(i).getCodigo().equals(codigo[codigo.length-1])){
                printImagen(lblImagen,  li.get(i).getImagen());
                jTextArea1.setText(li.get(i).getDescripcion() +"\n Precio al contado ; " + li.get(i).getPrecio());
                this.id = li.get(i).getId();         
                lblExistencia.setText("Existencias; "+String.valueOf(li.get(i).getStock())); 
                
             }
         }      
     }
     
    /**
     * Metodo que recive la lista de productos para 
     * autocompletar la busqueda que tenga coincidencias con el nombre
     * @param p
     */
    public void cargar(List <ProductoDTO> p){
      li = p;
        for(int i = 0; i<= p.size()-1;i++)
         { 
             ac.addItem(p.get(i).getNombre()+" "+ p.get(i).getCodigo());
           
         }      
     }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {  
        
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
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmVenta dialog = new FrmVenta(new javax.swing.JFrame(), true);
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
    /**
     * Método para mostrar la imagen del producto seleccionado
     * @param jl
     * @param ruta 
     */
       private void printImagen (JLabel jl, String ruta){
       this.imagen = new ImageIcon(ruta);
       this.icono = new ImageIcon 
         (this.imagen.getImage().getScaledInstance (jl.getWidth(), jl.getWidth(), Image.SCALE_DEFAULT));
       jl.setIcon(icono);
       this.repaint();
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnCancelar;
    private javax.swing.JButton brnCancelar1;
    private javax.swing.JButton btnPagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblExistencia;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalGeneral;
    private javax.swing.JTable tblLista;
    private javax.swing.JButton txtAgregar;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
