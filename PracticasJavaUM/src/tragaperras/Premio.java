package tragaperras;

import java.util.ArrayList;
import java.util.Collections;

public class Premio {
	private final ArrayList<Fruta> combinacionGanadora = new ArrayList<Fruta>();
	private final int cantidadPremio;

	public Premio(int cantidadPremio, Fruta... frutas) {
		this.cantidadPremio = cantidadPremio;
		Collections.addAll(combinacionGanadora, frutas);
	}

	public ArrayList<Fruta> getCombinacionGanadora() {
		return combinacionGanadora;
	}

	public int getCantidadPremio() {
		return cantidadPremio;
	}

}
