package e3;

import java.util.ArrayList;

public class Melody {

    public ArrayList<MusicalNote> melody; //declare the array

    public Melody () { melody = new ArrayList<>(); } //initialize the array

    public enum Accidentals { FLAT, SHARP, NATURAL }
    public enum Notes { DO, RE, MI, FA, SOL, LA, SI }

    public void addNote ( Notes note , Accidentals accidental , float time )
    {
        if(note == null || accidental == null || time == 0) {
            throw new IllegalArgumentException(); //invalid arguments
        }
        melody.add(new MusicalNote(note, accidental, time));
    }

    public Notes getNote (int index )
    {
        if(index < 0 || index >= melody.size()) { //outside the array
            throw new IllegalArgumentException();
        }
        return melody.get(index).note();
    }

    public Accidentals getAccidental (int index )
    {
        if(index < 0 || index >= melody.size()) { throw new IllegalArgumentException(); }
        return melody.get(index).accidental();
    }

    public float getTime (int index )
    {
        if(index < 0 || index >= melody.size()) { throw new IllegalArgumentException(); }
        return melody.get(index).time();
    }

    public int size ()
    {
        return melody.size();
    }

    public float getDuration ()
    {
        float duration = 0;
        for (MusicalNote musicalNote: melody) duration += musicalNote.time();
        return duration;
    }

    @Override
    public boolean equals (Object o)
    {
        if (this == o) { return true; }
        if (!(o instanceof Melody m)) { return false; }
        if (this.getClass() != o.getClass()) { return false; }

        int i; //counter
        if (this.melody.size() != m.melody.size()) { return false; }
        if (this.getDuration() != m.getDuration()) { return false; }

        //check if they are equal
        boolean not = true, acc = true; //booleans to check notes and accidentals
        for(i = 0; i < melody.size(); i++) {
            if(this.melody.get(i).note() != m.melody.get(i).note()) { not = false; }
            if(this.melody.get(i).accidental() != m.melody.get(i).accidental()) { acc = false; }
        }
        if (not && acc) { return true; }

        //check if they are equivalent
        for(i = 0; i < melody.size(); i++) {
            if (this.melody.get(i).time() != m.melody.get(i).time()) { return false; }
            if(this.melody.get(i).getSemitono() != m.melody.get(i).getSemitono()) { return false; }
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        //return Objects.hash(melody);
        int hash = 0;
        for (MusicalNote musicalNote : melody) { hash = hash * 10 + musicalNote.hashCode(); } //do a hash for the each note
        return hash;
    }

    @Override
    public String toString ()
    {
        int i; //counter
        StringBuilder s = new StringBuilder(); //declare and initilize string
        String not, acc; //string for notes and accidentals
        for(i = 0; i < melody.size(); i++)
        {
            not = melody.get(i).note().name(); //get the notes

            acc = switch (melody.get(i).accidental()) { //get the accidental
                case FLAT -> "b";
                case SHARP -> "#";
                case NATURAL -> "";
            };

            s.append(not).append(acc).append("(").append(melody.get(i).time()).append(")"); //build the string
            if(i != (melody.size() - 1)) { s.append(" "); } //add a new space if not finished
        }
        return s.toString();
    }
}
