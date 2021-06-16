package entidad;


public class Persona 
{
	private String dni;
	private String nombre;
	private String apellido;

	public Persona(String dni, String nombre, String apellido)
	{
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public String getDNIPersona() 
	{
		return this.dni;
	}

	public void setDNIPersona(String dni) 
	{
		this.dni = dni;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getApellido() 
	{
		return this.apellido;
	}

	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		
		return getNombre()+" "+getApellido()+" "+getDNIPersona();
	}
	
}
