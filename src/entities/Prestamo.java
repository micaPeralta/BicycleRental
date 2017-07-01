package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Prestamo {
	 @Id @GeneratedValue( strategy = GenerationType.AUTO) 
      private Long id;
	 
	  @Column(nullable = false)
      @Temporal(TemporalType.TIMESTAMP)
      private Date fecha;
	  
	  @Column(nullable = false)
      private String accion;
	  
      @OneToOne(optional = false)
      private Estacion estacion;
      
      @OneToOne(optional = false)
      private Usuario usuario;

     
      
      public Prestamo(){}

      public Prestamo(Date fecha, String accion, Usuario usuario, Estacion estacion){
        this.accion = accion;
        this.fecha = fecha;
        this.usuario = usuario;
        this.estacion = estacion;
      }

      public Date getFecha(){
        return fecha;
      }

      public void setFecha(Date fecha){
        this.fecha = fecha;
      }

      public String getAccion(){
        return accion;
      }

      public void setAccion(String accion){
        this.accion= accion;
      }

      public Usuario getUsuario(){
        return usuario;
      }

      public void setUsuario(Usuario usuario){
        this.usuario = usuario;
      }

      public Estacion getEstacion(){
        return estacion;
      }

      public void setEstacion(Estacion estacion){
        this.estacion = estacion;
      }
}
