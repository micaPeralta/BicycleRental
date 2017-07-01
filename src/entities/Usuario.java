package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.RandomStringUtils;

import entityListeners.UsuarioListener;

import java.util.*;


@Entity
@EntityListeners(UsuarioListener.class)
@XmlRootElement
public class Usuario {
	
    public enum Rol{
        COMUN, ADMIN
    }
    @Id @GeneratedValue( strategy = GenerationType.AUTO) 
    private Long id;
    private Integer dni;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String nombre;
    private String domicilio;
    private Date fechaNacimiento;
    private String sexo;
    private Date fechaInhabilitacion;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String clave;
    @Enumerated
    private Rol rol;
    @OneToMany
    private  Set<Bicicleta> bicicletas;


    /**
    * Default constructor
    */
    public Usuario(){}
    
    // Crea un usuario administrador
    public Usuario(String nombre, String apellido, String email){
    	this.nombre = nombre;
    	this.apellido = apellido;
    	this.email = email;
        this.clave = RandomStringUtils.randomAlphabetic(10);
    	this.rol = Rol.ADMIN;
   }
    
    
    public Usuario(Integer dni,
    String apellido,
    String nombre,
    String domicilio,
    Date fechaNacimiento,
    String sexo,
    String email,
    Rol rol) {

      this.dni = dni;
      this.apellido = apellido;
      this.nombre = nombre;
      this.domicilio = domicilio;
      this.fechaNacimiento = fechaNacimiento;
      this.sexo = sexo;
      this.email = email;
      this.clave = RandomStringUtils.randomAlphabetic(10);
      this.rol = rol;
      this.fechaInhabilitacion= null;
  	    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dni
	 */
	public Integer getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	 * @return the domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}
	/**
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the habilitado
	 */
	public boolean isHabilitado() {
		return fechaInhabilitacion == null;
	}
	/**
	 * @param habilitado the habilitado to set
	 */
	public void setfechaInhabilitacion(Date fecha) {
		this.fechaInhabilitacion = fecha;
	}

  public Date getfechaInhabilitacion() {
    return this.fechaInhabilitacion;
  }
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}
	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}
	/**
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}
	/**
	 * @param rol the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	/**
	 * @return the bicicletas
	 */
	public Set<Bicicleta> getBicicletas() {
		return bicicletas;
	}
	/**
	 * @param bicicletas the bicicletas to set
	 */
	public void agregartBicicleta(Bicicleta bicicleta) {
		this.bicicletas.add(bicicleta);
	}

	public void eliminartBicicleta(Bicicleta bicicleta) {
		this.bicicletas.remove(bicicleta);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", domicilio="
				+ domicilio + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", fechaInhabilitacion="
				+ fechaInhabilitacion + ", email=" + email + ", clave=" + clave + ", rol=" + rol + "]";
	}






}
