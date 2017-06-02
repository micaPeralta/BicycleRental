package entities;

import javax.persistence.*;
import java.util.*;

/**​
 *
 */
@Entity
public class Bicicleta {
    
	public enum EstadoBicicleta{
        APTA,REPARACION,DESUSO,DENUNCIADA
    }

    @Id @GeneratedValue( strategy = GenerationType.AUTO) 
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Enumerated
    private EstadoBicicleta estadoActual;
    private String ubicacionActual;
    @ManyToOne
    private Estacion estacion;
    @OneToMany(mappedBy="bicicleta")
    private Set<RegistroHistorial> historial;

    /**
     * Default constructor
     */

    public Bicicleta (){}

    public Bicicleta(Date fechaIngreso,EstadoBicicleta estado, String ubicacion, Estacion estacion ) {
    	this.fechaIngreso = fechaIngreso;
    	this.estadoActual = estado;
    	this.ubicacionActual = ubicacion;
    	this.estacion = estacion;
    	this.historial = new HashSet<RegistroHistorial>();
    }

     /**
  	 * @return the id
  	 */
  	public Long getId() {
  		return id;
  	}

  	/**
  	 * @param id the id to set
  	 */
  	public void setId(Long id) {
  		this.id = id;
  	}

  	/**
  	 * @return the fechaIngreso
  	 */
  	public Date getFechaIngreso() {
  		return fechaIngreso;
  	}

  	/**
  	 * @param fechaIngreso the fechaIngreso to set
  	 */
  	public void setFechaIngreso(Date fechaIngreso) {
  		this.fechaIngreso = fechaIngreso;
  	}

  	/**
  	 * @return the estadoActual
  	 */
  	public EstadoBicicleta getEstadoActual() {
  		return estadoActual;
  	}

  	/**
  	 * @param estadoActual the estadoActual to set
  	 */
  	public void setEstadoActual(EstadoBicicleta estadoActual) {
  		this.estadoActual = estadoActual;
  	}

  	/**
  	 * @return the ubicacionActual
  	 */
  	public String getUbicacionActual() {
  		return ubicacionActual;
  	}

  	/**
  	 * @param ubicacionActual the ubicacionActual to set
  	 */
  	public void setUbicacionActual(String ubicacionActual) {
  		this.ubicacionActual = ubicacionActual;
  	}

  	/**
  	 * @return the historial
  	 */
  	public Set<RegistroHistorial> getHistorial() {
  		return historial;
  	}

  	/**
  	 * @param Registrohistorial the historial to set
  	 */
  	public void agregarRegistroHistorial(RegistroHistorial registro) {
  		historial.add(registro);
  	}

  	public void eliminarRegistroHistorial(RegistroHistorial registro) {
  		historial.remove(registro);
  	}

  	/**
  	 * @return the estacion
  	 */
  	public Estacion getEstacion() {
  		return estacion;
  	}

  	/**
  	 * @param estacion the estacion to set
  	 */
  	public void setEstacion(Estacion estacion) {
  		this.estacion = estacion;
  	}



  }
