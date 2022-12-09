
package examenbryanag;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.RadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Formulario extends JFrame{
    
    private JList lista;
    private JComboBox box;
    private JTextField txtNombre,txtId;
    private JButton btnRegistrar,btnSig;
    private ButtonGroup grupo;
    private ButtonGroup grupoIdioma;
    private JLabel labelNombre,labelId,labelArea,labelCategoria,labelStatus,labelIdioma,labelTiempo;
    private ConjuntoProfesores profesores;
   private VentanaTabla ventana;
    private Formulario formulario = this;
    private JRadioButton opc,opc2,opc3;
    private JCheckBox ingles,mandarin,frances;
    private JRadioButton tiempo1,tiempo2,tiempo3;
    private ButtonGroup grupoTiempo;
            
            
    public Formulario(){
        super("Ingreso Profesores");
        profesores = new ConjuntoProfesores();
        setSize(800,600);
        setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
        Componentes(getContentPane());
    }
    
    private void Componentes(Container x){
        x. setLayout(null);
        
        
        labelNombre = new JLabel("Nombre: ");
        labelNombre.setBounds(10,20,100,20);
        
        txtNombre = new JTextField(10);
        txtNombre.setBounds(70,20,100,20);
   
        labelId = new JLabel("Id: ");
        labelId.setBounds(10,50,20,20);
        
        txtId = new JTextField(10);
        txtId.setBounds(70,50,100,20);
        
        labelArea = new JLabel("Area de Especialidad:");
        labelArea.setBounds(10,100,200,20);
        
        String listaAreas[] = {"Ciencias de la Educacion","Ciencias economicas", "ciencas exactas", "Ciencias Sociales", "Ciencias de la salud", "Humanidades","Artes"};
        lista = new JList (listaAreas);
        lista.setBounds(10,125,150,150);
        
        labelCategoria = new JLabel("Categoria: ");
        labelCategoria.setBounds(250,100,150,20);
        
        box = new JComboBox();
        box.addItem("A");
        box.addItem("B");
        box.addItem("C");
        box.addItem("D");
        box.addItem("E");
        box.setBounds(250, 125, 200, 20);
        
        labelStatus = new JLabel("Status");
        labelStatus.setBounds(250, 200, 200, 20);
        
        opc = new JRadioButton();
        opc.setText("Propietario");
        opc.setBounds(250, 230, 100, 20);
        
        opc2 = new JRadioButton();
        opc2.setText("interino");
        opc2.setBounds(400, 230, 100, 20);
        
        opc3 = new JRadioButton();
        opc3.setText("pasante");
        opc3.setBounds(500, 230,100, 20);
        
        grupo = new ButtonGroup();
        grupo.add(opc);
        grupo.add(opc2);
        grupo.add(opc3);
        
        labelIdioma = new JLabel("Idioma: ");
        labelIdioma.setBounds(250, 280, 100, 20);
        
        ingles = new JCheckBox();
        ingles.setText("Ingles");
        ingles.setBounds(250, 320, 100, 20);
        
        mandarin = new JCheckBox();
        mandarin.setText("mandarin");
        mandarin.setBounds(400, 320, 100, 20);
        
        
        frances = new JCheckBox();
        frances.setText("frances");
        frances.setBounds(500, 320, 100, 20);
        
        grupoIdioma = new ButtonGroup();
        grupoIdioma.add(ingles);
        grupoIdioma.add(mandarin);
        grupoIdioma.add(frances);
        
        labelTiempo = new JLabel("Tiempo");
        labelTiempo.setBounds(250, 375, 100, 20);
        
        tiempo1 = new JRadioButton();
        tiempo1.setText("Tiempo Completo");
        tiempo1.setBounds(250, 400, 150, 20);
        
        tiempo2 = new JRadioButton();
        tiempo2.setText("1/2 tiempo");
        tiempo2.setBounds(400,400, 100, 20);
        
        tiempo3 = new JRadioButton();
        tiempo3.setText("1/4 tiempo");
        tiempo3.setBounds(500, 400,100, 20);
        
        grupoTiempo = new ButtonGroup();
        grupoTiempo.add(tiempo1);
        grupoTiempo.add(tiempo2);
        grupoTiempo.add(tiempo3);
        
        btnRegistrar = new JButton ("Registrar");
        btnRegistrar.setBounds(350,500,100,40);
        
        btnSig = new JButton ("Siguiente");
        btnSig.setBounds(650,500,100,50);
        ImageIcon Sig = new ImageIcon("siguiente.jfif");
        btnSig.setIcon(Sig);
        btnSig.setIcon(new ImageIcon(Sig.getImage().getScaledInstance(btnSig.getWidth(),btnSig.getHeight(),Image.SCALE_SMOOTH)));
        
        
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = (String) txtNombre.getText();
                String id = (String) txtId.getText();
                String list = (String) lista.getSelectedValue();
                String cat = (String)box.getSelectedItem();
                
                String op="";
                if(opc.isSelected()){op=(String)opc.getText();}
                if(opc2.isSelected()){op=(String)opc2.getText();}
                if(opc3.isSelected()){op=(String)opc3.getText();}
                
                String leng="";
                if(ingles.isSelected()){leng=(String)ingles.getText();}
                if(mandarin.isSelected()){leng=(String)mandarin.getText();}
                if(frances.isSelected()){leng=(String)frances.getText();}
                
                String time="";
                if(tiempo1.isSelected()){time=(String)tiempo1.getText();}
                if(tiempo2.isSelected()){time=(String)tiempo2.getText();}
                if(tiempo3.isSelected()){time=(String)tiempo3.getText();}
                
                Profesor nuevo = new Profesor(nombre,id,list,cat,op,leng,time);
                profesores.agregar(nuevo);  
            }
            });
        
        btnSig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana = new VentanaTabla(profesores,formulario);
                ventana.iniciar();
                dispose();
                
                txtNombre.setText(null);
                txtId.setText(null);
                lista.clearSelection();
                box.setSelectedItem(null);
                grupo.clearSelection();
                grupoTiempo.clearSelection();
                grupoIdioma.clearSelection();
                
            }
            
        });
        
        
        add(labelNombre);
        add(txtNombre);
        add(labelId);
        add(txtId);
        add(labelArea);
        add(lista);
        add(labelCategoria);
        add(box);
        add(labelStatus);
        add(opc);
        add(opc2);
        add(opc3);
        add(labelIdioma);
        add(ingles);
        add(frances);
        add(mandarin);
        add(labelTiempo);
        add(tiempo1);
        add(tiempo2);
        add(tiempo3);
        add(btnRegistrar);
        add(btnSig);
       
    }
    
}
