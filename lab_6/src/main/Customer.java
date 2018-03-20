public class Customer{
    String name;
    boolean gender; // true -> female
    int age;
    
    // constructor
    public Customer(String name, boolean gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    // methods
    public Ticket orderTicket(Theater theater, String title, String day, String type){
        for(int i=0; i < theater.getTicket().size(); i++){
            Ticket ticket = theater.getTicket().get(i);
            if(ticket.getMovie().getTitle().equals(title)){
                // if there is matching day and type(3D or 2D) for this show
                if(ticket.getDay().equals(day) && ( (ticket.type == true && type.toLowerCase().equals("3 dimensi")) || (ticket.type == false && type.toLowerCase().equals("biasa"))) ){
                    System.out.println(String.format("%s has purchased tickets for %s type %s at %s on %s for Rp.%d", this.name, title, type, theater.getName(), day, ticket.getPrice()));
                    theater.setBalance(theater.getBalance() + ticket.getPrice());
                    return ticket;
                }
            }
        }
        System.out.println(String.format("Tickets for the movie %s type %s on %s are not available at %s",title, type, day, theater.getName()));
        return null;
    }

    public void findMovie(Theater theater, String title){
        for(int i=0; i < theater.getTicket().size(); i++){
            Ticket ticket = theater.getTicket().get(i);
            if(ticket.getMovie().getTitle().equals(title)){
                // if customer does not meet age requirements of movie
                if( (ticket.getMovie().getRating().toLowerCase().equals("teenager") && this.age < 13) || (ticket.getMovie().getRating().toLowerCase().equals("adult") && this.age < 17) ){
                    System.out.println(String.format("%s is not old enought to watch movie %s", this.name, title));
                }else{
                    System.out.println(ticket.getMovie()); 
                }
                return;
            }
        }
        System.out.println(String.format("Movie %s searched by %s is not in the cinema %s", title, this.name, theater.getName()));
    }
}