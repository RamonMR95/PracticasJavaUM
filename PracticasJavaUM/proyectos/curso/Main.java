package curso;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		Alumno pepe = new Alumno("34678904", "Pepe");
		Alumno andrea = new Alumno("17679456", "Andrea", 125);
		
		CursoPresencial cursoPresencial = new CursoPresencial("Diseño de Bases de Datos", 
				LocalDate.of(2014, 5, 5), LocalDate.of(2014, 5, 5), 1, 50, 20, 1);
		
		CursoOnline cursoOnline = new CursoOnline("Administracion de Bases de Datos", LocalDate.of(2014, 5, 12), 
				LocalDate.of(2014, 5, 16), 5, 25, 4, cursoPresencial);
		
		cursoPresencial.matricular(pepe);
		cursoPresencial.matricular(andrea);
		
		cursoPresencial.registroAsistencia(1, pepe);
		cursoPresencial.calificar();
		
		/* Muestra alumnos aptos */
		for (Alumno alumno : cursoPresencial.getAlumnosAptos()) {
			System.out.println(alumno);
		}
		
		cursoOnline.matricular(pepe);
		cursoOnline.matricular(andrea);
		
		/* Muestra alumnos aptos */
		System.out.println("Alumnos aptos del curso online");
		for (Alumno alumno : cursoOnline.getAlumnosAptos()) {
			System.out.println(alumno);
		}
		
		cursoOnline.superarNivel(pepe);
		cursoOnline.superarNivel(pepe);
		cursoOnline.superarNivel(pepe);
		cursoOnline.superarNivel(pepe);
		cursoOnline.superarNivel(pepe);
		
		cursoOnline.calificar();
		
		/* Muestra alumnos aptos */
		System.out.println("Alumnos aptos del curso online");
		for (Alumno alumno : cursoOnline.getAlumnosAptos()) {
			System.out.println(alumno + " -> con nota : "+ cursoOnline.getSeguimiento().get(alumno));
		}
		System.out.println();
		
		LinkedList<Alumno> listaAlumnosMatriculados = new LinkedList<>();
		
		for (Alumno alumnos : cursoPresencial.getAlumnosMatriculados()) {
			listaAlumnosMatriculados.add(alumnos);
		}
		
		Collections.sort(listaAlumnosMatriculados);
		
		System.out.println("Alumnos matriculados en el curso presencial ordenados por DNI");
		for (Alumno alumno : listaAlumnosMatriculados) {
			System.out.println(alumno);
		}
	}
}
