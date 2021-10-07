package e3;

import java.util.ArrayList;
import java.util.Objects;

import static e3.Melody.Accidentals.*;

public class Melody {

    public ArrayList<tNote> melody; //declare the array

    public Melody () { melody = new ArrayList<>(); } //initialize the array

    public enum Accidentals { FLAT, SHARP, NATURAL }
    public enum Notes { DO, RE, MI, FA, SOL, LA, SI }

    public static class tNote {
        public Notes note;
        public Accidentals accidental;
        public float time;

        public void setNotes(Notes n) { note = n; }
        public Notes getNotes() { return note; }

        public void setAccidentals(Accidentals a) { accidental = a; }
        public Accidentals getAccidental() { return accidental; }

        public void setTime(float t) { time = t; }
        public float getTime() { return time; }

        //new equals to compare notes
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            tNote tNote = (tNote) o;
            return Float.compare(tNote.time, time) == 0 && note == tNote.note && accidental == tNote.accidental;
        }

        //new hash to compare notes
        @Override
        public int hashCode() {
            switch (note) {
                case DO, RE, FA, SOL, LA -> {   if (accidental == SHARP) { return Objects.hash(Notes.values()[note.ordinal() + 1], FLAT, time); } }
                case MI, SI -> {                if (accidental == SHARP) { return Objects.hash(Notes.values()[(note.ordinal() + 1) % 7], NATURAL, time); }
                                                if (accidental == NATURAL) { return Objects.hash(Notes.values()[(note.ordinal() + 1) % 7], FLAT, time); } }
                }
                return Objects.hash(note,accidental,time);
            }
        }



    public void addNote ( Notes note , Accidentals accidental , float time )
    {
        if(note == null || accidental == null || time == 0) { throw new IllegalArgumentException(); } //invalid arguments
        tNote newNote = new tNote();
        newNote.setNotes(note);
        newNote.setAccidentals(accidental);
        newNote.setTime(time);
        melody.add(newNote);
    }

    public Notes getNote (int index )
    {
        if(index < 0 || index >= melody.size()) { throw new IllegalArgumentException(); } //outside the array
        return melody.get(index).getNotes();
    }

    public Accidentals getAccidental (int index )
    {
        if(index < 0 || index >= melody.size()) { throw new IllegalArgumentException(); }
        return melody.get(index).getAccidental();
    }

    public float getTime (int index )
    {
        if(index < 0 || index >= melody.size()) { throw new IllegalArgumentException(); }
        return melody.get(index).getTime();
    }

    public int size ()
    {
        return melody.size();
    }

    public float getDuration ()
    {
        float duration = 0;
        for (Melody.tNote tNote : melody) duration += tNote.getTime();
        return duration;
    }

    @Override
    public boolean equals ( Object o)
    {
        if (this == o) { return true; }
        if (!(o instanceof Melody m)) { return false; }
        if (this.getClass() != o.getClass()) { return false; }

        int i;
        boolean not = true, acc = true;
        if (this.melody.size() != m.melody.size()) { return false; }
        if (this.getDuration() != m.getDuration()) { return false; }
        for(i = 0; i < melody.size(); i++) {
            if(this.melody.get(i).getNotes() != m.melody.get(i).getNotes()) { not = false; }
            if(this.melody.get(i).getAccidental() != m.melody.get(i).getAccidental()) { acc = false; }
        }
        if (not && acc) { return true; }

        for(i = 0; i < melody.size(); i++) {
            switch(this.melody.get(i).getNotes()){
                case DO:
                    switch (this.melody.get(i).getAccidental()){
                        case NATURAL: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.SI && m.melody.get(i).getAccidental() == Accidentals.SHARP)) { return false; } break;
                        case SHARP: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.RE &&   m.melody.get(i).getAccidental() == Accidentals.FLAT)) { return false; } break;
                        case FLAT: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.SI &&   m.melody.get(i).getAccidental() == Accidentals.NATURAL)) { return false; } break;
                    } break;
                case RE:
                    switch (this.melody.get(i).getAccidental()){
                        case NATURAL: if(!this.melody.get(i).equals(m.melody.get(i))) { return false; } break;
                        case SHARP: if(!(this.melody.get(i).equals(m.melody.get(i))) &&  !(m.melody.get(i).getNotes() == Notes.MI &&   m.melody.get(i).getAccidental() == Accidentals.FLAT)) { return false; } break;
                        case FLAT: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.DO &&   m.melody.get(i).getAccidental() == Accidentals.SHARP)) { return false; } break;
                    } break;
                case MI:
                    switch (this.melody.get(i).getAccidental()){
                        case NATURAL: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.FA &&   m.melody.get(i).getAccidental() == Accidentals.FLAT)) { return false; } break;
                        case SHARP: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.FA &&   m.melody.get(i).getAccidental() == Accidentals.NATURAL)) { return false; } break;
                        case FLAT: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.RE &&   m.melody.get(i).getAccidental() == Accidentals.SHARP)) { return false; } break;
                    } break;
                case FA:
                    switch (this.melody.get(i).getAccidental()){
                        case NATURAL: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.MI &&   m.melody.get(i).getAccidental() == Accidentals.SHARP)) { return false; } break;
                        case SHARP: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.SOL &&   m.melody.get(i).getAccidental() == Accidentals.FLAT)) { return false; } break;
                        case FLAT: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.MI &&   m.melody.get(i).getAccidental() == Accidentals.NATURAL)) { return false; } break;
                    } break;
                case SOL:
                    switch (this.melody.get(i).getAccidental()){
                        case NATURAL: if(!this.melody.get(i).equals(m.melody.get(i))) { return false; } break;
                        case SHARP: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.LA &&   m.melody.get(i).getAccidental() == Accidentals.FLAT)) { return false; } break;
                        case FLAT: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.FA &&   m.melody.get(i).getAccidental() == Accidentals.SHARP)) { return false; } break;
                    } break;
                case LA:
                    switch (this.melody.get(i).getAccidental()){
                        case NATURAL: if(!this.melody.get(i).equals(m.melody.get(i))) { return false; } break;
                        case SHARP: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.SI &&   m.melody.get(i).getAccidental() == Accidentals.FLAT)) { return false; } break;
                        case FLAT: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.SOL &&   m.melody.get(i).getAccidental() == Accidentals.SHARP)) { return false; } break;
                    } break;
                case SI:
                    switch (this.melody.get(i).getAccidental()){
                        case NATURAL: if((!this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.DO &&   m.melody.get(i).getAccidental() == Accidentals.FLAT)) { return false; } break;
                        case SHARP: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.DO &&   m.melody.get(i).getAccidental() == Accidentals.NATURAL)) { return false; } break;
                        case FLAT: if(!(this.melody.get(i).equals(m.melody.get(i))) && !(m.melody.get(i).getNotes() == Notes.LA &&   m.melody.get(i).getAccidental() == Accidentals.SHARP)) { return false; } break;
                    } break;
            }
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        //return Objects.hash(melody);
        int hash = 0;
        for (Melody.tNote tNote : melody) { hash = hash * 10 + tNote.hashCode(); } //do a hash for the each note
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
            not = melody.get(i).getNotes().name(); //get the notes

            acc = switch (melody.get(i).getAccidental()) { //get the accidental
                case FLAT -> "b";
                case SHARP -> "#";
                case NATURAL -> "";
            };

            s.append(not).append(acc).append("(").append(melody.get(i).getTime()).append(")"); //build the string
            if(i != (melody.size() - 1)) { s.append(" "); } //add a new space if not finished
        }
        return s.toString();
    }
}
