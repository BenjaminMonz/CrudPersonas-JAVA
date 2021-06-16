package negocio;

import java.util.List;

import entidad.Persona;

public interface PersonaNegocio {

	public boolean insert(Persona persona);
	public boolean delete(Persona persona_a_eliminar);
	public boolean modify (Persona persona_modify);
	public boolean Verify(Persona persona);
	public List<Persona> readAll();
}
