package bitacoras;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Entrada {
	private final String suceso;
	private final GregorianCalendar fecha;

	public Entrada(String suceso) {
		this.suceso = suceso;
		this.fecha = new GregorianCalendar();
	}

	public String getSuceso() {
		return suceso;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "Entrada [suceso=" + suceso + ", fecha=" + fecha.get(Calendar.DAY_OF_MONTH) + "-" + (fecha.get(Calendar.MONTH) + 1 )+ "-" + fecha.get(Calendar.YEAR)+ "]";
	}

}
