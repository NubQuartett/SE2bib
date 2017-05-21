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
    
    
    public boolean istVormerkkarteLeer(Medium medium)
    {
        if(medium.getVormerkkarte().getVormerker1() == null) return true;
    	return false;
    }
    
}
