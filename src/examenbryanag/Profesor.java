package examenbryanag;

public class Profesor {

    private static final String[] Titulo = {"nombre","id","area","categoria","status","idioma","tiempo"};
    
    private String nombre;
    private String id;
    private String area, categoria, status, idioma, tiempo;

   public Profesor(String nombre,String id,String area, String categoria,String status,String idioma,String tiempo){
    this.nombre = nombre;
    this.id = id;
    this.area = area;
    this.categoria = categoria;
    this.status = status;
    this.idioma = idioma;
    this.tiempo = tiempo; } 
   
   public String nombre(){ return nombre;}
   public String id(){ return id;}
   public String area(){ return area;}
   public String categoria(){ return categoria;}
   public String status(){ return status;}
   public String idioma(){ return idioma;}
   public String tiempo(){ return tiempo;}
   
   public void setNombre(String nombre){
       this.nombre = nombre;
   }
   public void setId(String id){
       this.id = id;
   }
   public void setArea(String area){
       this.area = area;
   }
   public void setCategoria(String categoria){
       this.categoria = categoria;
   }
   public void setStatus(String status){
       this.status= status;
   }
   public void setIdioma(String idioma){
       this.idioma = idioma;
   }
   public void setTiempo(String tiempo){
       this.tiempo = tiempo;
   }

   public static int numCampos(){
   return Profesor.class.getClass().getFields().length;
    }
      
   public static String[] nombreCampos(){
       return Titulo;
   }
  public Object[] toArray(){
      Object[] a=new Object[7];
      a[0]=nombre();
      a[1]=id();
      a[2]=area();
      a[3]=categoria();
      a[4]=status();
      a[5]=idioma();
      a[6]=tiempo();
      return a;
   }
}

