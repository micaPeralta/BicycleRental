package models;


import java.util.*;

/**
 *
 */
public class Bicicleta {

    /**
     * Default constructor
     */
    public Bicicleta(Date fechaIngreso,String estado ,String ubicacion,Estacion estacion) {
    	this.fechaIngreso = fechaIngreso;
    	this.estadoActual = estado;
    	this.ubicacionActual = ubicacion;
    	this.historial = new HashSet<RegistroHistorial>();
    	this.estacion = estacion;
    }


    private Integer id;

    /**
     *
     */
    private Date fechaIngreso;
    private String estadoActual;
    private String ubicacionActual;
    private Estacion estacion;
    private HashSet<RegistroHistorial> historial;


     /**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
	public String getEstadoActual() {
		return estadoActual;
	}

	/**
	 * @param estadoActual the estadoActual to set
	 */
	public void setEstadoActual(String estadoActual) {
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
	public HashSet<RegistroHistorial> getHistorial() {
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
