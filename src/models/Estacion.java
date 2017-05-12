package models;
import java.util.*;

/**
 *
 */
public class Estacion {

    /**
     * Default constructor
     */
    public Estacion(String nombre, String ubicacion,int capacidad,String estado) {
    	this.nombre = nombre;
    	this.ubicacion = ubicacion;
    	this.capacidad = capacidad;
    	this.estado = estado;
    	this.bicicletas = new LinkedList<Bicicleta>();
    }


    private String nombre;
    private String ubicacion;
    private int capacidad;
    private String estado;
    private LinkedList<Bicicleta> bicicletas;



    /**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
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

    public LinkedList<Bicicleta> getBicicletas() {
	    return   bicicletas;
	}

	/**
     * @param Bicicleta
     */
    public void agregarbicicleta(Bicicleta bicicleta) {
       bicicletas.add(bicicleta);
    }

    public void eliminarbicicleta(Bicicleta bicicleta) {
        bicicletas.remove(bicicleta);
     }

    /**
     *
     */
    public Bicicleta retirarBicicleta(Usuario usuario) {
       
    	Bicicleta bicicleta = bicicletas.remove();
    	usuario.agregartBicicleta(bicicleta);
    	return bicicleta;
    
    }

    /**
     *
     */
    public void estacionarBicicleta(Usuario usuario, Bicicleta bicicleta) {
        usuario.eliminartBicicleta(bicicleta);
        this.agregarbicicleta(bicicleta);
    }

}
