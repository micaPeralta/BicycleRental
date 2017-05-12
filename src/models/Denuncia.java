package models;

import java.util.*;

/**
 * 
 */
public class Denuncia {

    /**
     * Default constructor
     */
    public Denuncia(String descripcion,Bicicleta bicicleta) {
    	this.descripcion = descripcion;
    	this.fecha = new Date();
    	this.bicicleta = bicicleta;
    }

    private  String descripcion;
    private Date fecha;
    private Bicicleta bicicleta;


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