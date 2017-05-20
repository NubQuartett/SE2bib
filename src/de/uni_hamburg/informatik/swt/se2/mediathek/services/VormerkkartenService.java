package de.uni_hamburg.informatik.swt.se2.mediathek.services.vormerken;

import java.awt.List;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.Kunde;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.Vormerkkarte;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;
import de.uni_hamburg.informatik.swt.se2.mediathek.services.verleih.VerleihService;

public class VormerkkartenService
{
    
    public boolean istVormerkkarteVoll(Medium medium)
    {
    	assert medium != null : "Vorbedingung verletzt: kundenstamm  != null";
    	
        Vormerkkarte vormerkkarte = medium.getVormerkkarte();
        if(vormerkkarte.getVormerker3() == null)
        {
            return false;
        }
        return true;
    }
    
    //TODO rückmeldung ob geklappt hat?, schlechte implementierung
    //
    public void neueVormerkungHinzufuegen(Medium medium, Kunde kunde)
    {
    	assert medium != null : "Vorbedingung verletzt: medium != null";
    	assert kunde != null : "Vorbedingung verletzt: kunde != null";
    	assert medium.getVormerkkarte().getVormerker3() == null : 
    		"Vorbedingung verletzt : Vormerker3 == null";
    	
        Vormerkkarte vormerkkarte = medium.getVormerkkarte();
        if(vormerkkarte.getVormerker1() == null)
        {
            vormerkkarte.setVormerker1(kunde);
        }
        else if(vormerkkarte.getVormerker2() == null)
        {
            vormerkkarte.setVormerker2(kunde);
        }
        else vormerkkarte.setVormerker3(kunde);
    }
    
    public boolean istVormerkkarteLeer(Medium medium)
    {
        if(medium.getVormerkkarte().getVormerker1() == null) return true;
    	return false;
    }
    
}
