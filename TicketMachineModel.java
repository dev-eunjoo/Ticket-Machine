
/**
 * Desc: Ticket Machine program for an assignment 5
 * Date: March 16, 2020
 *
 * @author Eunjoo Na
 **/

public class TicketMachineModel {
    /** Subway route **/
    private String route="----------";
    /** Subway fee for adult **/
    private double adultFee;
    /** Subway fee for child **/
    private double childFee;
    /** The amount of Chosen ticket for adult **/
    private int adultTicket;
    /** The amount of Chosen ticket for child **/
    private int childTicket;
    /** The amount of money user put in the ticket machine **/
    private double total, credit;

    /** Get the default Subway fee
     * **/
    public void getFee(){
        childFee = 3.75;
        adultFee = 6.25;
    }

    /** set the route for machine 2 ( Main st or King st) according to user's input
     * @param routeType The chosen route from the user
     * **/
    public void setRouteMainKing(String routeType) {
        adultTicket = 0;
        childTicket = 0;
        total = 0;
        if (routeType.equalsIgnoreCase("MAIN")) {
            route = "Main St.";
            getFee();
        } else if (routeType.equalsIgnoreCase("KING")) {
            route = "King St.  ";
            getFee();
        }
    }

    /** set the amount of tickets according to user's input
     * @param choiceNumber The chosen option from the user
     **/
    public void setTicket(int choiceNumber) {
        if(choiceNumber == 3){
            this.adultTicket++;
        } else if(choiceNumber == 4){
            this.adultTicket--;
            if(adultTicket<0){
                adultTicket = 0;
            }
        } else if(choiceNumber == 5){
            this.childTicket++;
        } else if(choiceNumber == 6){
            this.childTicket--;
            if(childTicket<0){
                childTicket = 0;
            }
        }
    }

    /** Get the total amount of cost
     * **/
    public void getTotal(){
        total = adultTicket*adultFee + childTicket*childFee;
    }

    /** Get the total amount of credit
     * **/
    public String creditTotal(){
        return " Credit: $ "+String.format("%.2f",credit) + "  ";
    }

    /** set the amount of user's money according to user's input
     * @param choiceNumber The chosen option from the user
     **/
    public void setCredit(int choiceNumber) {
        if(choiceNumber == 7){
            this.credit+=0.25;
        } else if(choiceNumber == 8) {
            this.credit+=1.00;
        } else if(choiceNumber == 9) {
            this.credit+=2.00;
        }
    }

    /** Get the printed ticket
     * @return the statement which is shown to the user whether ticket is printed or not.
     * **/
    public String getPrintTicket() {
        if(credit >= total && total != 0){
            double change = credit-total;
            routeInitialized();
            setInitialized();
            return "--------------------------------------------------------------\n" +
                    "\tYOU GOT YOUR TICKET!!!\n" +
                    "\tKeep the change: $" + String.format("%.2f",change) + "\n\n" +
                    "--------------------------------------------------------------";
        } else{
            return "--------------------------------------------------------------\n" +
                    "\tSORRY!\n"+
                    "\tNo tickets for you -! \n" +
                    "\tClick the Button 'Back'\n" +
                    "--------------------------------------------------------------";
        }
    }

    /** Set initialization of the route **/
    public void routeInitialized(){
        route = "----------";
    }

    /** Set initialization of the data **/
    public void setInitialized(){
        adultFee = 0;
        childFee = 0;
        adultTicket = 0;
        childTicket = 0;
        credit = 0;
        total = 0;
    }


    @Override
    /** Information about current data of the machine
    * @return the statement that shows updated data according to the user's input.
    **/
    public String toString() {
        return "--------------------------------------------------------------\n" +
                "\tRoute: "+ route +"\t Child: $" + String.format("%.2f",childFee) + "\t Adult: $" +String.format("%" +
                ".2f",adultFee) +
                "\t\n" +
                "\tChildren: " + childTicket + "\t\t Adults: " + adultTicket + "\t\n" +
                "\ttotal: $" + String.format("%.2f",total) + "\n" +
                "--------------------------------------------------------------";
    }

}
