package curso;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class CursoPresencial extends Curso {

	private final int cupo;
	private final int numeroMinimoAsistencia;
	private HashMap<Integer, HashSet<Alumno>> asistencia;
	private int plazasLibres;
	
	/* CONSTRUCTOR */
	public CursoPresencial(String titulo, LocalDate fechaInicio, LocalDate fechaFinalizacion, int numeroDias,
			double precioMatricula, int cupo, int numeroMinimoAsistencia) {
		super(titulo, fechaInicio, fechaFinalizacion, numeroDias, precioMatricula);
		this.cupo = cupo;
		this.plazasLibres = cupo - numeroAlumnosMatriculados;
		this.numeroMinimoAsistencia = numeroMinimoAsistencia;
		this.asistencia = new HashMap<>();
		
	}
	
	public int getCupo() {
		return cupo;
	}


	public int getNumeroMinimoAsistencia() {
		return numeroMinimoAsistencia;
	}


	public HashMap<Integer, HashSet<Alumno>> getAsistencia() {
		return asistencia;
	}


	public int getPlazasLibres() {
		return plazasLibres;
	}


	/* FUNCIONALIDAD */
	public boolean registroAsistencia(int dia, Alumno alumno) {
		HashSet<Alumno> alumnos = new HashSet<>();
		alumnos.add(alumno);
		this.asistencia.put(dia, alumnos);
		return true;
	}
	
	public int diasAsistencia(Alumno alumno) {
		int dias = 0;
		
		for(Entry<Integer, HashSet<Alumno>> al : asistencia.entrySet()) {
			if (al.getValue().contains(alumno)) {
				dias++;
			}
		}
		return dias;
	}
	
	@Override
	public boolean matricular(Alumno alumno) {
		if (this.precioMatricula - alumno.getCredito() <= 0 && numeroAlumnosMatriculados < cupo) {
			this.plazasLibres--;
			super.matricular(alumno);
		}
		return false;
	}
	
	@Override
	protected boolean isApto(Alumno alumno) {
		return diasAsistencia(alumno) >= numeroMinimoAsistencia;
		
	}

	
}
