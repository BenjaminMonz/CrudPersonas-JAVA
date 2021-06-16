package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;


public class PersonaDaoImpl implements PersonaDao
{
	
	
	@Override
	public boolean modify(Persona personaModify) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean ModifyEstate = false;
		try
		{
			statement = conexion.prepareStatement(modify);
			statement.setString(1, personaModify.getNombre());
			statement.setString(2, personaModify.getApellido());
			statement.setString(3, personaModify.getDNIPersona());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				ModifyEstate = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			//ModifyEstate = true;
		}
		return ModifyEstate;
	}


	private static final String insert = "INSERT INTO Personas(Dni, Nombre, Apellido) VALUES(?, ?, ?)";
	private static final String modify = "UPDATE Personas SET Nombre = ? , Apellido=?  WHERE Dni = ? "; //1 nombre , 2 apellido , 3 dni
	private static final String delete = "DELETE FROM Personas WHERE Dni = ?";
	private static final String readall = "SELECT * FROM Personas";
		
	private static final String Verify = "SELECT * FROM Personas WHERE Dni = ? ";
	
	
	
	
	public boolean insert(Persona persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, persona.getDNIPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean Verify(Persona persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet resultSet;
		try
		{
			statement = conexion.prepareStatement(Verify);
			statement.setString(1, persona.getDNIPersona());
			resultSet = statement.executeQuery();
			if(resultSet.next() == false)
			{
				conexion.commit();
				return true;
			}
			return false;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

	public boolean delete(Persona persona_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, persona_a_eliminar.getDNIPersona());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	
	
	
	public List<Persona> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersona(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		String dni = resultSet.getString("Dni");
		String nombre = resultSet.getString("Nombre");
		String apellido = resultSet.getString("Apellido");
		return new Persona(dni, nombre, apellido);
	}
}
