package negocioImpl;

import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio{

	PersonaDao pdao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		
		boolean estado=false;
		if(persona.getNombre().trim().length()>0 
				&& persona.getApellido().trim().length()>0
				&& persona.getDNIPersona().trim().length()>0)
		{
			estado=pdao.insert(persona);
		}
		return estado;
	}

	@Override
	public boolean delete(Persona persona_a_eliminar) {
		boolean estado=false;
		if(!persona_a_eliminar.getDNIPersona().isEmpty() )//También se puede preguntar si existe ese ID 
		{
			estado=pdao.delete(persona_a_eliminar);
		}
		return estado;
	}
	
	
	
	@Override 
	public boolean modify (Persona persona_Modify) {
		
		boolean Estate= true;
		
		if(!persona_Modify.getDNIPersona().isEmpty() 
				&& !persona_Modify.getApellido().isEmpty() 
				&& !persona_Modify.getNombre().isEmpty())//También se puede preguntar si existe ese ID 
		{
			Estate=pdao.modify(persona_Modify);
			
		}
		
		return Estate;
	}
	
	
	
	
	@Override
	public List<Persona> readAll() {
		return pdao.readAll();
	}

	@Override
	public boolean Verify(Persona persona) {
		PersonaDaoImpl personaDaoImpl = new PersonaDaoImpl();
		return personaDaoImpl.Verify(persona);
	}		


	
	
}
