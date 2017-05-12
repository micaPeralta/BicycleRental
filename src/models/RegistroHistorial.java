package models;
import java.util.*;

/**
 * Destinada para mantener un regstros de los retiros y las devoluciones de una bicicleta en una estacion
 */
public class RegistroHistorial {

    /**
     * Default constructor
     */
    public RegistroHistorial(String estado,Estacion estacion, Bicicleta bicicleta) {
    	this.estado = estado;
    	// this.fechaHora = Fecha y hora actual
      this.estacion = estacion;
      this.bicicleta = bicicleta;
    }


    private Date fechaHora;
    private  String estado;
    private Bicicleta bicicleta;
    private Estacion estacion;

	/**
	 * @return the fechaHora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
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

  /**
   * @return the bicicleta
   */
  public Estacion getEstacion() {
    return estacion;
  }

  /**
   * @param bicicleta the bicicleta to set
   */
  public void setEstacion(Estacion estacion) {
    this.estacion = estacion;
  }



}
