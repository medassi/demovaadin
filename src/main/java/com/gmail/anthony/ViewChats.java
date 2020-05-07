package com.gmail.anthony;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class ViewChats extends VerticalLayout {
	private static final long serialVersionUID = 1L;
	private User u ;
	private ListBox<Chat> lbChats = new ListBox<>();
	private TextField tfChat = new TextField("", "Nom du chat à ajouter");
	private Button button ;
	
	
	public ViewChats(User u) {
		super() ;
		this.u = u ;
		lbChats.setItems(u.getSesChats());
		button = new Button(VaadinIcon.ADD_DOCK.create(), e->ajouterChat())  ;
		this.add(lbChats,tfChat,button) ;
	}
	private void ajouterChat() {
		Chat chat = new Chat() ;
		chat.setNom(tfChat.getValue());
		MainView.getService().donnerChat(u, chat);
	}
}
