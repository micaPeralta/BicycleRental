package daos;

import entities.*;

public class FactoryDAO {

	public static EstacionDAO getEstacionDAO(){
		return new EstacionDAOImp();
	}

	public static BicicletaDAO getBicicletaDAO(){
		return new BicicletaDAOImp();
	}

	public static UsuarioDAO getUsuarioDAO(){
		return new UsuarioDAOImp();
	}

	public static RegistroHistorialDAO  getRegistroHistorialDAO(){
		return new RegistroHistorialDAOImp();
	}

	public static DenunciaDAO getDenunciaDAO(){
		return new DenunciaDAOImp();
	}

	public static PrestamoDAO getPrestamoDAO(){
		return new PrestamoDAOImp();
	}

}
