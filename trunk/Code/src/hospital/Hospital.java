package hospital;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Deze klasse stelt het ziekenhuis zelf voor. De tijd zit hardcoded in deze
 * klasse. Deze wordt ge•nitialiseerd op 8 november 2011 8:00 am. Elke minuut
 * zal de tijd stijgen met 30 min.
 * 
 */
// FIXME Hospital is een vreemde naam voor iets dat de tijd bijhoudt
// FIXME Tijd dmv een thread is zeer icky: je hebt totaal geen controle meer
// over de tijd en je moet overal synchronizeren, wat je niet eens doet
public class Hospital implements Runnable
{
    private GregorianCalendar now;

    public Hospital()
    {
        this.now = new GregorianCalendar( 2011, 10, 8, 8, 0 );
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep( 60000 );
        }
        catch ( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // FIXME Is add wel thread-safe?
        // Dit zou je veel gemakkelijker kunnen oplossen door gewoon een nieuw object aan te maken en dat
        // toe te kennen aan now. Dan werkt meteen alles naar behoren zonder dat je ook maar ergens
        // in je ganse programma hoeft te synchronizeren. Nu, omdat je het object zelf wijzigt,
        // moet je op correctheid te garanderen overal in je programma beginnen locken.
        now.add( Calendar.MINUTE, 30 );
        run();
    }

    // FIXME: Rechtstreeks werken met GregorianCalendar is niet echt aangeraden
    // Best een eigen type die inwendig dan wel GregorianCalendar gebruikt
    public GregorianCalendar getTime()
    {
        // FIXME: GregorianCalendar is mutable, dus je mag niet zomaar het object zelf naar buiten brengen, dan laat je toe
        // dat om 't even wie de tijd verzet
        return this.now;
    }
}
