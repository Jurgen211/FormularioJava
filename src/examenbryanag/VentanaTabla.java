
package examenbryanag;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class VentanaTabla extends JFrame{
    
  private JTable tabla;
   private Modelo modelo;
   private Formulario ventana;
   private JButton btnRegresar;
    private JButton btnBuscar;
   
    
    public VentanaTabla(ConjuntoProfesores profesores, Formulario formulario){
        super("Lista Profesores");
       setSize(1000,700);
       setMinimumSize(new Dimension(400,320));
       
       ventana = formulario;
       modelo=new Modelo(profesores);
       
       ajustar(getContentPane());
       setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    private void ajustar(Container c){
        c.setLayout(new BorderLayout());
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(6, 12, 12, 12));
        
        JScrollPane desplzTabla =
                new JScrollPane(tabla = new JTable(),
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
       
        
        mainPanel.add(BorderLayout.CENTER, desplzTabla);

        configurarTabla(tabla);

        c.add(BorderLayout.CENTER, mainPanel);
        
        JPanel panelInferior = new JPanel();
        btnRegresar = new JButton("Regresar");
        
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnRegresar){
                    dispose();
                    Formulario formula=new Formulario();
                    ventana.setVisible(false);
                }
                ventana.setVisible(true);
                
            }
        });
        
        panelInferior.add(btnRegresar);
        c.add(panelInferior, BorderLayout.PAGE_END);
    }
    
    private void configurarTabla(JTable tabla) {
     
        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(48);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(48);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(120);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(120);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(120);


    }
    
    //btnBuscar = new JButton("Buscar");
    
    public void iniciar(){
        setVisible(true);
    }
}
