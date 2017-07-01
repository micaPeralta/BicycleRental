package entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Estacion {

    public enum EstadoEstacion{
      OPERATIVA, CERRADA, EN_CONTRUCCION
    }
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int capacidad;

    @Column(nullable = false)
    @Enumerated
    private EstadoEstacion estado = EstadoEstacion.EN_CONTRUCCION;

    @OneToMany(mappedBy="estacion",cascade=CascadeType.PERSIST)

    private List<Bicicleta> bicicletas;
    private String latitud;
    private String longitud;

    /**
    * Default constructor
    */

    public Estacion(){}

    public Estacion(String nombre,String longitud,String latitud,int capacidad, EstadoEstacion estado) {
      this.nombre = nombre;
      this.latitud = latitud;
      this.longitud = longitud;
      this.capacidad = capacidad;
      this.estado = estado;
      this.bicicletas = new LinkedList<Bicicleta>();
    }

    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	public String[] getUbicacion() {
	    String[] ubicacion = new String[2];
	    ubicacion[0]= this.latitud;
	    ubicacion[1]= this.longitud;
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String[] ubicacion) {
		this.latitud = ubicacion[0];
		this.longitud = ubicacion[1];
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
	public  EstadoEstacion getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado( EstadoEstacion estado) {
		this.estado = estado;
	}

    public List<Bicicleta> getBicicletas() {
	    return   bicicletas;
	}

	/**
     * @param Bicicleta
     */
    public void agregarBicicleta(Bicicleta bicicleta) {
       bicicletas.add(bicicleta);
    }

    public void eliminarBicicleta(Bicicleta bicicleta) {
        bicicletas.remove(bicicleta);
     }

    /**
     *
     */
    public Bicicleta retirarBicicleta(Usuario usuario) {

    	Bicicleta bicicleta = bicicletas.remove(0);
    	usuario.agregartBicicleta(bicicleta);
    	return bicicleta;

    }

    /**
     *
     */
    public void estacionarBicicleta(Usuario usuario, Bicicleta bicicleta) {
        usuario.eliminartBicicleta(bicicleta);
        this.agregarBicicleta(bicicleta);
    }

	@Override
	public String toString() {
		return "Estacion [id=" + id + ", nombre=" + nombre + ", capacidad=" + capacidad + ", estado=" + estado
				+ ", bicicletas="  + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}

}
