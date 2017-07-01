package entityListeners;

//para encriptar la clave
import org.apache.commons.codec.digest.DigestUtils;
import javax.persistence.PrePersist;

import entities.Usuario;

public class UsuarioListener {

	@PrePersist
	public void Persist(Usuario u) {
	 
		String claveSinEncriptar= u.getClave();
		String claveEncriptada = DigestUtils.md5Hex(claveSinEncriptar); 
		u.setClave(claveEncriptada);
		
	 
	}
	 
	
}
