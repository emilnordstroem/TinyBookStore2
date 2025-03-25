package view.mainWindow.fixedComponents;

import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MenuBar {
    private final TabPane menuOptions = new TabPane();
    private final Tab[] menuTabs = new Tab[4];

    public MenuBar(int width) {
        implementRestriction(width);
        implementMenuOptionsTabPane();
    }

    private void implementRestriction(int prefWidth){
        menuOptions.prefWidth(prefWidth);
        menuOptions.setSide(Side.BOTTOM);
        menuOptions.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        menuOptions.setTabMinWidth(prefWidth * 0.15);
    }

    public void implementMenuOptionsTabPane(){
        char[] menuOptionsIcons = {'H', 'P', 'S', 'M'}; //Home, Profile, Shopping bag, Menu
        for(int tabIndex = 0; tabIndex < menuTabs.length; tabIndex++){
            menuTabs[tabIndex] = new Tab(String.valueOf(menuOptionsIcons[tabIndex]));
            menuOptions.getTabs().add(menuTabs[tabIndex]);
        }
    }

    public TabPane getMenuBar() {
        return menuOptions;
    }

    public Tab[] getMenuTabs() {
        return menuTabs;
    }

}
