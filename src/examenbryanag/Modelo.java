package examenbryanag;

import javax.swing.table.AbstractTableModel;


public class Modelo extends AbstractTableModel {
    private ConjuntoProfesores profesores;
    
    public Modelo(ConjuntoProfesores profesores){
    this.profesores=profesores;
    }
    
       @Override
    public String getColumnName(int col){
        return Profesor.nombreCampos()[col];
    }
    
        @Override
    public int getRowCount(){
       return profesores.numProfesores();
    }
    
    @Override
    public int getColumnCount(){
      return Profesor.nombreCampos().length;
    }
    
     @Override
    public Object getValueAt(int fila,int col){
        return profesores.recuperar(fila).toArray()[col];
    }
    
    
}
