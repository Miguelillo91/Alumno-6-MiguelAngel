package es.indra.academiamvc.controller.alumnos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.indra.academiamvc.model.entities.Alumno;
import es.indra.academiamvc.model.service.AlumnoService;

@Component
public class AlumnoFormValidator implements Validator {
	@Autowired
	private AlumnoService alumnoService;

	public boolean supports(Class<?> clazz) {
		return AlumnoForm.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		AlumnoForm form = (AlumnoForm) target;
		if (form.getNif() != null && !form.getNif().equals("")) {
			List<Alumno> listado = this.alumnoService.buscarNif(form.getNif());
			if (listado != null && !listado.isEmpty()) {
				Alumno alumno = listado.get(0);
				if (form.getId() == null || (!alumno.getId().equals(form.getId()))) {
					errors.rejectValue("nif", "nif.unico");
				}

			}
		}
	}

}