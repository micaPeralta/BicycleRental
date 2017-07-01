package daos;


import entities.Usuario;

public class UsuarioDAOImp extends GenericDAOImp<Usuario> implements UsuarioDAO {

	public boolean exist(Long id){
		 Usuario b = (Usuario)this.entityManager.createQuery("select e from Usuario where id = "+id).getSingleResult();
		 return b != null;
	}
}
