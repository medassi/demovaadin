package com.gmail.anthony;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {
	private static final long serialVersionUID = 1L;
	private TextField tfLogin ;
	private PasswordField pf ;
	private static ModelService service ;
	private User user ;

    public MainView(@Autowired ModelService service) {
    	MainView.service = service ;
        tfLogin = new TextField("","Login") ;
        pf = new PasswordField() ;
        pf.setWidthFull();
        tfLogin.setWidthFull();
        Button button = new Button("Connexion");
        button.setWidthFull();
        button.addClickListener( e -> clickConnexion()) ;
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);
        this.addClassName("centered-content");
        this.add(tfLogin,pf,button);
    }

    public static ModelService getService() {
		return service;
	}
	private void clickConnexion() {
		this.user = service.identification(tfLogin.getValue() , pf.getValue()) ; 
		if( user!=null ) {
			Notification.show("Connexion OK",3000 , Position.MIDDLE ) ;	
			this.removeAll();
			this.add(new ViewChats(user)) ;
		}else {
			Notification.show("Connexion KO",3000 , Position.MIDDLE ) ;
		}
	}

}
