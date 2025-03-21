package application.models.user;

public class Guest extends User{
    private static int tempID = 1_000;

    public Guest() {
        super();
        tempID += 1;
    }

    public static int getTempID() {
        return tempID;
    }
}
