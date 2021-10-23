package co.com.sofka.userinterfaces.deleteuser;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;

public class DeleteUser extends PageObject {

    public static final Target ADMIN_MENU= Target.the("adminMenu").located(id("menu_admin_viewAdminModule"));
}
