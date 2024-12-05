
package Presentacion;

import Negocio.DTOs.DetallePrestamoDTO;
import Negocio.DTOs.PrestamoDTO;
import Negocio.DTOs.ProductoDTO;
import Negocio.DTOs.UsuarioDTO;
import Negocio.DTOs.VendedorDTO;
import Negocio.FacadeJoyeria;
import Negocio.RenderTabla;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dórame
 */
public final class Prestamos extends javax.swing.JDialog {
    private UsuarioDTO user;
    private String [] codigo ;
    private int filaseleccionada;
    private ProductoDTO productoLista;
    public static int columna,row;
    private int id;
    private int cantidad =0;
    private FacadeJoyeria fj;
    private ImageIcon imagen;
     float comision=0;
    private Icon icono;
    private TextAutoCompleter ac;
     DefaultTableModel productosModel;
     List <ProductoDTO> listaventa;
    List <ProductoDTO> li;
    boolean excepcion = false;
    float total =0;
    private int p =0;
    private VendedorDTO vendedor;
    JButton b1 = new JButton("Agregar");
    private Date fech;
    private Date fechLi;
    JButton b2 = new JButton("Eliminar");
    /**
     * Creates new form Prestamos
     * @param parent
     * @param modal
     * @param u
     */
    public Prestamos(java.awt.Frame parent, boolean modal, UsuarioDTO u, String e) {
        super(parent, modal);
        initComponents();
        limpiar();
        setTitle("Nuevo Prestamo");
        this.user = u;
        listaventa = new ArrayList<>();
        productosModel = (DefaultTableModel) 
        tblLista.getModel();
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null); 
        lblNombre.setBackground(Color.WHITE);
        getContentPane().add(lblNombre, BorderLayout.CENTER);
        lblUsuario.setText(e);
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
        
        ac = new TextAutoCompleter(txtProducto); 
        fj = new FacadeJoyeria();
        mostrarVendedores();
    }
    public void inicio(){
     this.setTitle("Botones en Jtable");this.setResizable(false);this.setLocationRelativeTo(null);
     b1.setText(" + "); b2.setText(" - ");
     InsertarIcono(b1, "/imgs/mas.png");
     InsertarIcono(b2, "/imgs/menos.png");
}
     public void InsertarIcono(JButton btn,String ruta){
         btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta)));
}
     public void MostrarTabla(){
       tblLista.setDefaultRenderer(Object.class,new RenderTabla());
       productosModel.setColumnIdentifiers(new String[]{"ID","CODIGO","NOMBRE",
        "PRECIO","",""});
        tblLista.setModel(productosModel);
        tblLista.setRowHeight(40);
    }
     public Prestamos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null); 
        lblNombre.setBackground(Color.WHITE);
        getContentPane().add(lblNombre, BorderLayout.CENTER);
    }
        public void limpiar(){
            lblActivos.setText(""); lblDireccion.setText(""); lblFechaInicio.setText("");
            lblLimite.setText(""); jLabel1.setText(""); lblProducto.setText("");lblTelefono.setText("");
           
        }
 
        public void mostrarVendedores(){
            try{
           fj.mostrarVendedores(cbxVendedor);} catch(Exception e){JOptionPane.showMessageDialog(null, "Error en " + e);}
        }
        
        public void cargar(List <ProductoDTO> p){
         li = p;
        for(int i = 0; i<= p.size()-1;i++)
         { 
             ac.addItem(p.get(i).getNombre()+" "+ p.get(i).getCodigo());
           
         }      
     }
        
     public void mostrar(){
         codigo = txtProducto.getText().split("\\s+");   
        
         for(int i = 0; i<= li.size()-1;i++)
         { 
             if (li.get(i).getCodigo().equals(codigo[codigo.length-1])){
                printImagen(lblImagen,  li.get(i).getImagen());
                jTextArea1.setText(li.get(i).getDescripcion() +"\n Precio al contado ; " + li.get(i).getPrecio());
                this.id = li.get(i).getId();         
                lblExistencias.setText("Existencias; "+String.valueOf(li.get(i).getStock())); 
                
             }
         }      
     }
     
    private void printImagen (JLabel jl, String ruta){
       this.imagen = new ImageIcon(ruta);
       this.icono = new ImageIcon 
         (this.imagen.getImage().getScaledInstance (jl.getWidth(), jl.getWidth(), Image.SCALE_DEFAULT));
       jl.setIcon(icono);
       this.repaint();
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JPanel();
        lblVendedor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblActivos = new javax.swing.JLabel();
        lblLimite = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblProducto = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        cbxVendedor = new javax.swing.JComboBox<>();
        lblExistencias = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblPorcen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNombre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVendedor.setText("VENDEDOR; ");
        lblNombre.add(lblVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 53, -1, -1));

        jLabel1.setText("NOMBRE; ");
        lblNombre.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 90, -1, -1));

        lblDireccion.setText("DIRECCION; ");
        lblNombre.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 53, -1, -1));

        lblTelefono.setText("TEELFONO; ");
        lblNombre.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        lblActivos.setText("PRESTAMOS ACTIVOS;");
        lblNombre.add(lblActivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        lblLimite.setText("LIMITE DE PRESTAMO; ");
        lblNombre.add(lblLimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, -1, -1));

        lblFechaInicio.setText("FECHA INICIO;");
        lblNombre.add(lblFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/SDlogoVenta.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        lblNombre.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 400, 104, 103));
        lblNombre.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 134, 1083, 13));

        lblProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblProducto.setText("PRODUCTO; ");
        lblNombre.add(lblProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 165, -1, -1));

        txtProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtProductoMousePressed(evt);
            }
        });
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoKeyPressed(evt);
            }
        });
        lblNombre.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 165, 133, -1));

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        lblNombre.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 165, -1, -1));

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
        jScrollPane1.setViewportView(tblLista);

        lblNombre.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 583, 343));

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setText("TOTAL; ");
        lblNombre.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));
        lblNombre.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 180, 221, 179));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("FECHA DE LIQUIDACION;");
        lblNombre.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("CANTIDAD DE PRODUCTOS;");
        lblNombre.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("COMISION; ");
        lblNombre.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 460, -1, -1));
        lblNombre.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 1160, 10));

        jButton1.setText("GENERAR PRESTAMO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        lblNombre.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 610, 154, 43));

        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        lblNombre.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 610, 153, 42));

        jButton3.setText("CERRAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        lblNombre.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 170, 43));

        jLabel8.setText("ATENDIDO POR;");
        lblNombre.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 520, -1, -1));

        lblUsuario.setText("JESSICA DORAME");
        lblNombre.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 550, -1, -1));

        cbxVendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LISTA" }));
        cbxVendedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxVendedorItemStateChanged(evt);
            }
        });
        lblNombre.add(cbxVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 50, 157, -1));

        lblExistencias.setText("Existencias; ");
        lblNombre.add(lblExistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        lblNombre.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 280, 140));

        lblPorcen.setText("PORCENTAJE; ");
        lblNombre.add(lblPorcen, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 500, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ProductoDTO prod = new ProductoDTO();
        String folio = fj.getPrestamoRepositorio().generarFolio(); // genera folio
        PrestamoDTO prestamo = new PrestamoDTO(vendedor.getIdVendedor(),this.user.getId(), folio,fech,fechLi,comision,total,'P');
        fj.getPrestamoRepositorio().agregar(prestamo);
       
         DetallePrestamoDTO dp;
        for(int i =0; i<= p-1;i++){
            float r = cas(i);
           dp = new DetallePrestamoDTO(prestamo.getIdPrestamo(), productoLista.getId(),(int)productosModel.getValueAt(i,4), r);
           fj.getDetallPrestamoRepositorio().agregar(dp);
           //Actualizar stock de productos
            prod.setId(listaventa.get(i).getId());
            prod.setNombre(listaventa.get(i).getNombre());
            prod.setCodigo(listaventa.get(i).getCodigo());
            prod.setDescripcion(listaventa.get(i).getDescripcion());
            prod.setImagen(listaventa.get(i).getImagen());
            prod.setPrecio(listaventa.get(i).getPrecio());
            int stk = stock(i);
            prod.setStock(stk);
            prod.setEstado('S');
            prod.setIdCategoria(listaventa.get(i).getIdCategoria());
            fj.getProductoRepositorio().actualizar(prod);
           
        }
 
        JFrame frame = new JFrame("Imprimir hoja de Consigna");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        JButton printButton = new JButton("Imprimir"); 
        printButton.addActionListener((ActionEvent e) -> {
            // Aquí colocas la lógica de impresión
            //generacion de hoja de consigna

        });
        
        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
                frame.dispose(); // Cerrar la ventana
            }
        });
        
                panel.add(printButton);
        panel.add(cancelButton);
             ImageIcon icono = new ImageIcon("C:\\Users\\jessi\\Documents\\JoyeriaSD_V0\\JoyeriaSD\\src\\imgs\\impresion.png");
       
        JOptionPane.showOptionDialog(frame,
                "¿Deseas imprimir?",
                "Confirmar Acción",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                icono, new Object[] {panel}, null);

        limpiarCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

     public int stock(int i){
    return ( listaventa.get(i).getStock()) - (int)(productosModel.getValueAt(i, 4));
    }
        public float cas(int i){
        float resultado=0;
        if (this.productosModel.getValueAt(i, 3) instanceof Number && this.productosModel.getValueAt(i, 4) instanceof Number){
            float t1 = ((Number) this.productosModel.getValueAt(i, 3)).floatValue();
            float t2 = ((Number) this.productosModel.getValueAt(i, 4)).floatValue();  
            resultado = t1*t2;
        }
        else{
            JOptionPane.showMessageDialog(null, "Los datos no son números");
        }
        return resultado;
    } 
    private void cbxVendedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxVendedorItemStateChanged
        if(evt.getStateChange()== ItemEvent.SELECTED){
            vendedor = new VendedorDTO();
            int id =0;
            String vend = (String) cbxVendedor.getSelectedItem();
            if(vend != null){
                id = Integer.parseInt(vend.split(" ")[0]);
            }
            try{
               vendedor = fj.getVendedorRepositorio().obtener(id);
               jLabel1.setText("NOMBRE; "+ vendedor.getNombres() + " "+ vendedor.getApellidos());
               lblDireccion.setText("DIRECCION; "+ vendedor.getDireccion());
               lblTelefono.setText("TELEFONO; "+ vendedor.getTelefono());
               
               LocalDate fecha = LocalDate.now();
               DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
               fech = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());

               String fechaFormateada = fecha.format(formato);
               
              fechLi = fj.getPrestamoRepositorio().calcularFechaLiquidacion(); 
              
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             String fechaFormateadaa = sdf.format(fechLi);
             
              jLabel5.setText("FECHA DE LIQUIDACION; "+fechaFormateadaa);
                
               
               lblFechaInicio.setText("FECHA INICIO; " + fechaFormateada);
               lblLimite.setText( "LIMITE DE PRESTAMO; "+ String.valueOf(vendedor.getLimitePrestamo()));
               
                List <Object[]> ews =fj.getPrestamoRepositorio().buscarPrestamosPendientes(fj.getEntituManager(), vendedor);
                if(ews.get(0)== null)   {
                    lblActivos.setText("PRESTAMOS ACTIVOS; " + 0);}
                else{
                    
                   for(Object[] res : ews){
                       String folio = (String) res[0];
                       lblActivos.setText("PRESTAMOS ACTIVOS; " + folio);
                   }
                }

            }
        catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error en isdfiusdh "+e);
                }
        }
    }//GEN-LAST:event_cbxVendedorItemStateChanged

    private void txtProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyPressed
         if (evt.getExtendedKeyCode()==VK_ENTER ||evt.getKeyCode() == KeyEvent.VK_TAB ) {
            mostrar();
        }
    }//GEN-LAST:event_txtProductoKeyPressed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(total < vendedor.getLimitePrestamo()){
        productoLista = fj.getProductoRepositorio().obtener(id);       
       
        if(fj.repetido(listaventa, productoLista, productosModel)) {  // verifica que no se haya repetido el producto en la lista de venta               
             }         
         else {
           listaventa.add(productoLista); //Si no es repetido se agrega 
           llenarTabla(1);
           p = p + 1;
             } 
            calculaTotal(); 
            calcularComision(); 
            comision();
           }
        else{
            JOptionPane.showMessageDialog(null, "El limite de prestamo autorizado ha excedido");
        }
}
    
      
    /**
     * Método apra aumentar cantidad al presionar el boton + dentro del JTable
     * @param producto 
     */
    public void agregarBtn(ProductoDTO producto){
         if(fj.repetido(listaventa, producto, productosModel)) {
         
          if(excepcion== false){         
             calculaTotal(); 
            calcularComision();
            comision();
         }
         else{
            JOptionPane.showMessageDialog(null, "No hay stock suficiente, Verifique el pedido");}
            }   
    }//GEN-LAST:event_btnAgregarActionPerformed

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

    private void txtProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProductoMousePressed
        limpiarCampos();
    }//GEN-LAST:event_txtProductoMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       cancelar();
    }//GEN-LAST:event_jButton2ActionPerformed
        public void limpiarCampos(){
            txtProducto.setText(""); jTextArea1.setText("");
            lblImagen.setIcon(null); lblTotal.setText("");
            lblExistencias.setText(""); jLabel5.setText("");
            jLabel6.setText(""); jLabel7.setText("");
            lblPorcen.setText("");

        }
        
        public void cancelar(){
            limpiar();
             codigo = null; filaseleccionada = 0;
            columna =0;
            row=0;
            id = 0;
            cantidad =0;
            listaventa= null;
            total =0;
            productosModel.setRowCount(0);
        }
        
    public void eliminarProducto(ProductoDTO producto){
       listaventa = fj.eliminar(listaventa, producto, productosModel);  
       if(listaventa.isEmpty()){
         //  CancelarVenta();
       }
       else{
            calculaTotal(); 
            calcularComision();
            comision();
    }
    }
    
    /**
     * Metodo apra calcular el total de la venta
     */
    public void calculaTotal(){
       total = fj.calcularTotal(productosModel, listaventa);
        lblTotal.setText("TOTAL; " + total);
    }
        public void llenarTabla(int i){
        int a = productosModel.getRowCount();
        
         Object[] nuevaFila = {listaventa.get(a).getId(), listaventa.get(a).getCodigo(), listaventa.get(a).getNombre()
         , listaventa.get(a).getPrecio(), i,b1,b2};
         productosModel.addRow(nuevaFila);   
         cantidad = cantidad + 1;
         jLabel6.setText("CANTIDAD DE PRODUCTOS; "+ cantidad);
         calculaTotal();
         calcularComision();
          comision();
    }
        public void calcularComision(){
            comision = fj.getPrestamoRepositorio().calcularComision(total, vendedor);
            jLabel7.setText("COMISION; " + comision );
        }
        public void comision(){
              if(total >= 301 && total <= 999){
              lblPorcen.setText("PORCENTAJE; "+ 35);
          } 
            if(total >=1000 && total <= 1999){
           lblPorcen.setText("PORCENTAJE; "+ 40);
            }
            if(total >= 2000 && total <= 2999){
             lblPorcen.setText("PORCENTAJE; "+ 45);
            }
            if(total >= 3000){
              lblPorcen.setText("PORCENTAJE; "+ 50);
            }
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
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Prestamos dialog = new Prestamos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> cbxVendedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblActivos;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblExistencias;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblLimite;
    private javax.swing.JPanel lblNombre;
    private javax.swing.JLabel lblPorcen;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JTable tblLista;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
