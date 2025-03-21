package application.models.user.guest;

import application.models.user.Guest;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class GuestConstructorTest {

    @Test
    void constructorQuest(){
        Guest guest = new Guest();
        assertNotNull(guest);
    }

}