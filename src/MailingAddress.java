public class MailingAddress {
    private static String primaryStreet;
    private static String secondaryStreet;
    private static String city;
    private static String state;
    private static String postalCode;

    public MailingAddress(String primaryStreet, String secondaryStreet, String city, String state, String postalCode){
        this.primaryStreet = primaryStreet;
        this.secondaryStreet = secondaryStreet;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public static String getPrimaryStreet() {
        return primaryStreet;
    }

    public static String getSecondaryStreet() {
        return secondaryStreet;
    }

    public static String getCity() {
        return city;
    }

    public static String getState() {
        return state;
    }

    public static String getPostalCode() {
        return postalCode;
    }

    public void setPrimaryStreet(String primaryStreet) {
        MailingAddress.primaryStreet = primaryStreet;
    }

    public void setSecondaryStreet(String secondaryStreet) {
        MailingAddress.secondaryStreet = secondaryStreet;
    }

    public void setCity(String city) {
        MailingAddress.city = city;
    }

    public void setState(String state) {
        MailingAddress.state = state;
    }

    public void setPostalCode(String postalCode) {
        MailingAddress.postalCode = postalCode;
    }

    public String getFormattedAddress(){
        String formattedAdd = primaryStreet + "\n";
        if(secondaryStreet != null){
            formattedAdd+=secondaryStreet+"\n";
        }
        formattedAdd+=city + ", ";
        formattedAdd+=state + " ";
        formattedAdd+=postalCode;
        return formattedAdd;
    }
}
