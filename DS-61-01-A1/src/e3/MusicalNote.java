package e3;

import java.util.Objects;

import static e3.Melody.Accidentals.*;

public record MusicalNote(Melody.Notes note, Melody.Accidentals accidental, float time) {

    public int getSemitono(){
        int semi = 0;
        switch(note) {
            case DO -> {
                switch (accidental) {
                    case FLAT -> semi = 12;
                    case NATURAL -> semi = 1;
                    case SHARP -> semi = 2;
                }
            }
            case RE -> {
                switch (accidental) {
                    case FLAT -> semi = 2;
                    case NATURAL -> semi = 3;
                    case SHARP -> semi = 4;
                }
            }
            case MI -> {
                switch (accidental) {
                    case FLAT -> semi = 4;
                    case NATURAL -> semi = 5;
                    case SHARP -> semi = 6;
                }
            }
            case FA -> {
                switch (accidental) {
                    case FLAT -> semi = 5;
                    case NATURAL -> semi = 6;
                    case SHARP -> semi = 7;
                }
            }
            case SOL -> {
                switch (accidental) {
                    case FLAT -> semi = 7;
                    case NATURAL -> semi = 8;
                    case SHARP -> semi = 9;
                }
            }
            case LA -> {
                switch (accidental) {
                    case FLAT -> semi = 9;
                    case NATURAL -> semi = 10;
                    case SHARP -> semi = 11;
                }
            }
            case SI -> {
                switch (accidental) {
                    case FLAT -> semi = 11;
                    case NATURAL -> semi = 12;
                    case SHARP -> semi = 1;
                }
            }
        }
        return semi;
    }

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
