package tests;
import java.util.Date;
import entities.*;
import entities.Bicicleta.EstadoBicicleta;
import daos.BicicletaDAO;
import daos.EstacionDAO;
import entities.Estacion.EstadoEstacion;
import daos.FactoryDAO;
import daos.GenericDAO;
import daos.UsuarioDAO;

public class Main {
	public static void main(String[] args) {
		BicicletaDAO bicicletaDAO = FactoryDAO.getBicicletaDAO();
		EstacionDAO estacionDAO =FactoryDAO.getEstacionDAO();

		Estacion  e = new Estacion("PLaza San Martin","892","-232",60,EstadoEstacion.OPERATIVA);
		Bicicleta b = new Bicicleta(new Date(),EstadoBicicleta.APTA,"Una ubicacion",e);

		e.agregarBicicleta(b);
		estacionDAO.persist(e);

		Long id = new Long(1);

		e = estacionDAO.find(id);
		System.out.println("-------------------Persistió una estacion y una bicicleta por cascada-----------------------");
		System.out.println("");
		System.out.println(e.toString());
		System.out.println("");


		System.out.println("------------Bicicleta---------------");

		

		b= bicicletaDAO.find(id);
		System.out.println("");
		System.out.println(b.toString());
		System.out.println("");



		b= bicicletaDAO.find(id);
		b.setEstadoActual(EstadoBicicleta.DENUNCIADA);;
		bicicletaDAO.update(b);
		System.out.println("SE MODIFICÓ EL ESTADO DE LA BICICLETA");
		System.out.println(b.toString());


		UsuarioDAO usuarioDAO = FactoryDAO.getUsuarioDAO();
		Usuario u= new Usuario("Micaela","Peralta","mika@gmail.com");
		usuarioDAO.persist(u);

		u = usuarioDAO.find(id);
		System.out.println("SE HA CREADO UN USUARIO");
		System.out.println(u.toString());

		usuarioDAO.remove(id);
		if (usuarioDAO.find(id)== null) {

			System.out.println("usuario "+ u.getNombre() + u.getApellido()+ " eliminado");
		}
		else {
			System.out.println("usuario "+ u.getNombre() + u.getApellido()+ " no fue eliminado");
		}

	}


}
