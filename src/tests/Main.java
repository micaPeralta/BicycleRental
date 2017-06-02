package tests;
import java.util.Date;
import java.util.List;
import entities.*;
import entities.Bicicleta.EstadoBicicleta;
import daos.BicicletaDAOImp;
import daos.EstacionDAOImp;
import entities.Estacion;
import entities.Estacion.EstadoEstacion;
import daos.FactoryDAO;

public class Main {
	public static void main(String[] args) {
		System.out.println("persist estacion-----------------------");
		EstacionDAOImp estacion =FactoryDAO.getEstacionDAO();
		Estacion  e = new Estacion("PLaza San Martin","Lat","Long",60,EstadoEstacion.OPERATIVA);
		
		estacion.persist(e);
		
		
		
		System.out.println("persist bicicleta-------------------------");
		BicicletaDAOImp bicicleta =FactoryDAO.getBicicletaDAO();
		Bicicleta b = new Bicicleta(new Date(),EstadoBicicleta.APTA,"Una ubicacion",e);
		
		bicicleta.persist(b);
		
	}
	
	
}
