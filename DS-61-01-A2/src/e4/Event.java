package e4;

import e4.Participants.*;

import java.util.ArrayList;
import java.util.List;

public class Event {

    public ArrayList<Participants> event;

    public Event() { event = new ArrayList<>(); }

    public int size ()
    {
        return event.size();
    }

    public void addParticipant(String name, String surname, Sex sex, Category category, Activity activity, double hours, Faculty teacher) {
        if(!event.contains(teacher) || hours < 0)
            throw new IllegalArgumentException();
        event.add(new Students(name, surname, sex, category, activity, hours, teacher));
    }

    public void addParticipants(List<Participants> tempList) {
        for (Participants participants : tempList) {
            if (participants instanceof Students)
                if (!event.contains(((Students) participants).getTeacher()) || ((Students) participants).getHours() < 0)
                    throw new IllegalArgumentException();
            if (participants instanceof Faculty)
                if (((Faculty) participants).getHours() < 0)
                    throw new IllegalArgumentException();
        }
            event.addAll(tempList);
    }

    public List<Participants> listParticipants() {
        return event.isEmpty() ? null : event;
    }

    public int detailParticipants(Sex sex) {
        int counter = 0;
        for(Participants participants : event) {
            if(participants.getSex() == sex)
                counter++;
        }
        return counter;
    }

}
