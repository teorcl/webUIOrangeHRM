package co.com.sofka.userinterfaces.deleteuser;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class DeleteUser extends PageObject {

    public static final Target ADMIN_MENU= Target
            .the("adminMenu")
            .located(id("menu_admin_viewAdminModule"));

    public static final Target USER_MANAGEMENT= Target
            .the("userManagement")
            .located(id("menu_admin_UserManagement"));

    public static final Target COL_USERNAME= Target
            .the("colUserName")
            .located(xpath("//*[@id=\"resultTable\"]/thead/tr/th[2]/a"));


    public static final Target CHK_SELECT_USER = Target
            .the("chkSelectRow")
            .located(xpath("//body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[4]/table[1]/tbody[1]/tr[1]/td[1]/input[1]"));

    public static final Target BTN_USER_NAME = Target
            .the("chkSelectRow")
            .located(xpath("//body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[4]/table[1]/thead[1]/tr[1]/th[2]/a[1]"));

    public static final Target USER_NAME_COLUMNA_FILA1 = Target
            .the("userNameCF1")
            .located(xpath("//body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[4]/table[1]/tbody[1]/tr[1]/td[2]"));

    public static final Target USER_NAME_COLUMNA_FILA2 = Target
            .the("userNameCF2")
            .located(xpath("//body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[4]/table[1]/tbody[1]/tr[2]/td[2]"));




    public static final Target BTN_DELETE = Target
            .the("btnDelete")
            .located(id("btnDelete"));

    public static final Target BTN_OK= Target
            .the("btnOk")
            .located(id("dialogDeleteBtn"));

}
