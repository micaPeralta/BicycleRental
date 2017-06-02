package daos;
public class FactoryDAO {

	public static EstacionDAOImp getEstacionDAO(){
		return new EstacionDAOImp();
	}

	public static BicicletaDAOImp getBicicletaDAO(){
		return new BicicletaDAOImp();
	}
	
	public static UsuarioDAOImp getUsuarioDAO(){
		return new UsuarioDAOImp();
	}
	
	public static RegistroHistorialDAOImp getRegistriHistorialDAO(){
		return new RegistroHistorialDAOImp();
	}
	
	public static DenunciaDAOImp getDenunciaDAO(){
		return new DenunciaDAOImp();
	}
	
	public static PrestamoDAOImp getPrestamoDAO(){
		return new PrestamoDAOImp();
	}
	
}
