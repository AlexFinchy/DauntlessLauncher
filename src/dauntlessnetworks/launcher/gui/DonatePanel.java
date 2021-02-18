package dauntlessnetworks.launcher.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

import com.sun.javafx.application.PlatformImpl;

import dauntlessnetworks.launcher.startup.Startup;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class DonatePanel extends JPanel {  
    
    private Stage stage;  
    public WebView browser;  
    private JFXPanel jfxPanel;  
    private JButton swingButton;  
    WebEngine webEngine;  
  
    public DonatePanel(){ 
		setOpaque(false);
		setLocation(100,0);
		setSize(900,600);
		setLayout(null);
    	setBorder(BorderFactory.createMatteBorder(Startup.BorderThinkness, 0, Startup.BorderThinkness, Startup.BorderThinkness, java.awt.Color.black));
    	Load();
    }  
  
    public void Load() {
		initComponents();  
    }
     
    public void initComponents(){  
    	
        jfxPanel = new JFXPanel();  
        createScene();  
        setLayout(new BorderLayout());  
        add(jfxPanel, BorderLayout.CENTER); 
        /*
        swingButton = new JButton();  
        swingButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        webEngine.reload();
                    }
                });
            }
        });  
        swingButton.setText("Reload");  
         
        add(swingButton, BorderLayout.SOUTH);  
        */
    }     
     
    private void createScene() {  
        PlatformImpl.startup(new Runnable() {  
            @Override
            public void run() {  
                 
                stage = new Stage();  
                   
                stage.setResizable(false);  
                Group root = new Group();  
                Scene scene = new Scene(root,0,0);  
                stage.setScene(scene);  
                 
                // Set up the embedded browser:
                browser = new WebView();
                webEngine = browser.getEngine();
                webEngine.load("http://dauntlessnetworks.buycraft.net");
                browser.setMinSize(900, 500);
                browser.setMaxSize(900, 580);
                ObservableList<Node> children = root.getChildren();
                children.add(browser);                     
                jfxPanel.setScene(scene);  
            }  
        });  
    }
}

