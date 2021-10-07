package e3;

import java.util.Objects;

import static e3.Melody.Accidentals.*;

public record MusicalNote(Melody.Notes note, Melody.Accidentals accidental, float time) {

    //new equals to compare notes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicalNote musicalNote = (MusicalNote) o;
        return Float.compare(musicalNote.time, time) == 0 && note == musicalNote.note && accidental == musicalNote.accidental;
    }

    //new hash to compare notes
    @Override
    public int hashCode() {
        switch (note) {
            case DO, RE, FA, SOL, LA -> {
                if (accidental == SHARP) {
                    return Objects.hash(Melody.Notes.values()[note.ordinal() + 1], FLAT, time);
                }
            }
            case MI, SI -> {
                if (accidental == SHARP) {
                    return Objects.hash(Melody.Notes.values()[(note.ordinal() + 1) % 7], NATURAL, time);
                }
                if (accidental == NATURAL) {
                    return Objects.hash(Melody.Notes.values()[(note.ordinal() + 1) % 7], FLAT, time);
                }
            }
        }
        return Objects.hash(note, accidental, time);
    }
}
