package entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Denuncia {

	@Id @GeneratedValue( strategy = GenerationType.AUTO) 
    private Long id;
	@Column(nullable = false)
    private  String descripcion;
	@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToOne(optional = false)
    private Bicicleta bicicleta;
    @OneToOne(optional = false)
    private Usuario usuario;

    /**
    * Default constructor
    */
    public Denuncia(){}

    public Denuncia(String descripcion,Bicicleta bicicleta, Usuario usuario) {
      this.descripcion = descripcion;
      this.fecha = new Date();
      this.bicicleta = bicicleta;
      this.usuario = usuario;
    }



	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}


	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	/**
	 * @return the bicicleta
	 */
	public Bicicleta getBicicleta() {
		return bicicleta;
	}


	/**
	 * @param bicicleta the bicicleta to set
	 */
	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}


}
