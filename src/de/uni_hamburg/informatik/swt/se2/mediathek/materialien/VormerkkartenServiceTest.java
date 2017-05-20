package de.uni_hamburg.informatik.swt.se2.mediathek.services.vormerken;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.Kunde;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.Vormerkkarte;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class VormerkkartenServiceTest {

	private VormerkkartenService _vormerkkartenService;
	private Medium _medium1;
	private Kunde _kunde1;
	private Kunde _kunde2;
	private Kunde _kunde3;

	public VormerkkartenServiceTest() {
		_vormerkkartenService = new VormerkkartenService();
		_medium1 = new CD("titel", "kommentar", "interpret", 34);
		_kunde1 = new Kunde(new Kundennummer(111111), "Andreas", "May");
		_kunde2 = new Kunde(new Kundennummer(111112), "Andreas", "May");
		_kunde3 = new Kunde(new Kundennummer(111113), "Andreas", "May");
	}

	@Test
	public void testeIstVormerkkarteVoll() {
		// false wenn vormerkkarte leer ist
		assertFalse(_vormerkkartenService.istVormerkkarteVoll(_medium1));
		
		_vormerkkartenService.neueVormerkungHinzufuegen(_medium1, _kunde1);
		_vormerkkartenService.neueVormerkungHinzufuegen(_medium1, _kunde2);
		_vormerkkartenService.neueVormerkungHinzufuegen(_medium1, _kunde3);
		
		assertTrue(_vormerkkartenService.istVormerkkarteVoll(_medium1));

	}

	@Test
	public void testeNeueVormerkungHinzufuegen() {
		assertTrue(_medium1.getVormerkkarte().getVormerker1() == null);
		assertTrue(_medium1.getVormerkkarte().getVormerker2() == null);
		assertTrue(_medium1.getVormerkkarte().getVormerker3() == null);

		_vormerkkartenService.neueVormerkungHinzufuegen(_medium1, _kunde1);
		_vormerkkartenService.neueVormerkungHinzufuegen(_medium1, _kunde2);
		_vormerkkartenService.neueVormerkungHinzufuegen(_medium1, _kunde3);

		assertTrue(_medium1.getVormerkkarte().getVormerker1() == _kunde1);
		assertTrue(_medium1.getVormerkkarte().getVormerker2() == _kunde2);
		assertTrue(_medium1.getVormerkkarte().getVormerker3() == _kunde3);

	}

	@Test
	public void testeIstVormerkkarteLeer() {

		assertTrue(_vormerkkartenService.istVormerkkarteLeer(_medium1));
		
		_vormerkkartenService.neueVormerkungHinzufuegen(_medium1, _kunde1);
		
		assertFalse(_vormerkkartenService.istVormerkkarteLeer(_medium1));

	}
}
