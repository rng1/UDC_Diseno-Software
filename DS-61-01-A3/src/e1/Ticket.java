package e1;

import java.time.LocalDate;

record Ticket(String origin, String destination, double price, LocalDate date) {
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ticket ticket = (Ticket) obj;
        if(!this.origin.equals(ticket.origin))
            return false;
        if(!this.destination.equals(ticket.destination))
            return false;
        if(this.price != ticket.price)
            return false;
        return true;
    }
}
