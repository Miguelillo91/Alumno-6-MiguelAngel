package es.indra.academia.controller.profesores;

import java.util.List;

import es.indra.academia.model.entities.Profesor;

import javax.servlet.http.HttpServletRequest;

public class ProfesorForm extends Profesor {
	
	public ProfesorForm() {
		super();
		setNif("");
		setNombre("");
		setApellido1("");
		setApellido2("");
		setTelefono("");
		setCorreo("");
		setTitulacion("");
	}
	
	public ProfesorForm(Profesor a) {
		super();
		setId(a.getId());
		setNif(a.getNif());
		setNombre(a.getNombre());
		setApellido1(a.getApellido1());
		setApellido2(a.getApellido2());
		setTelefono(a.getTelefono());
		setCorreo(a.getCorreo());
	}

	public void validar(List<String> errores) {
		if (getNif() == null || getNif().equals("")) {
			errores.add("El nif es obligatorio");

		}
		if (getNif().length() != 9) {
			errores.add("El formato de NIF no es correcto");

		}
		if (getNombre() == null || getNombre().equals("")) {
			errores.add("El Nombre es obligatorio");

		}
		if (getApellido1() == null || getApellido1().equals("")) {
			errores.add("El Primero Apellido es obligatorio");

		}

	}
	
	public static ProfesorForm obtenerProfesorForm(HttpServletRequest request) {
		String id = request.getParameter("id");
		String nif = request.getParameter("nif");
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String telefono = request.getParameter("telefono");
		String correo = request.getParameter("email");
		
		ProfesorForm profesor = new ProfesorForm();
		Long idLong = null;
		try {
			idLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			idLong = null;
		}

		profesor.setId(idLong);
		profesor.setCorreo(correo);
		profesor.setApellido2(apellido2);
		profesor.setApellido1(apellido1);
		profesor.setNif(nif);
		profesor.setNombre(nombre);
		profesor.setTelefono(telefono);
		return profesor;
	}
}
