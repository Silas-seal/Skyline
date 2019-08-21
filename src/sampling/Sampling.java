
package sampling;

import java.io.*; 
import java.net.MalformedURLException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import javafx.application.Application; 
//import static javafx.application.Application.launch; 
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.stage.Stage; 
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
/*import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;*/
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;  
import javafx.scene.layout.BackgroundSize;
import javafx.scene.effect.*;
import javafx.animation.*;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.*;
import javafx.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.VPos;
/*import javafx.scene.control.ButtonType;*/
import javafx.scene.shape.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Menu;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.control.*;
import java.util.Date;
import java.util.List;
import javafx.application.HostServices;
import javafx.geometry.Orientation;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.web.*;
/**
 *
 * @author SILMATIC
 */
public class Sampling extends Application { 
    @Override
    public void start(Stage stage) throws Exception { //also in eclipse now
        Date date=new Date(); String time=String.format("%tc",date);System.out.println(time);
    //host services
    HostServices service=getHostServices();
        // this is my sql database connection
                        Connection con;
                        String hostname="jdbc:mysql://localhost:3306/skyline";
                        String user="root";
                        String pass="SkylineDigital001h";
                        con=DriverManager.getConnection(hostname,user,pass);
                        if(con!=null){System.out.println("You are connected to database site");}else System.out.println("Connection Error...");
        stage.initStyle(StageStyle.UNIFIED); stage.setResizable(true); stage.setOpacity(1);
        stage.setHeight(650); stage.setWidth(1000); Image icon=new Image(new FileInputStream("C:/Users/SYRUS/Documents/NetBeansProjects/JavaFX/Skyline D/LOGO.png"));stage.getIcons().add(icon);
        String skyD="The Skyline Digital (c) 2018 All rights reserved ";
        // making up my start scene
       Stop[] stops=new Stop[]{
            new Stop(0,Color.BLACK), new Stop(1,Color.BLUEVIOLET)
        }; LinearGradient linear=new LinearGradient(10,15,17,7,true,CycleMethod.REFLECT,stops);
        Stop[] stop2=new Stop[]{
            new Stop(0,Color.AQUA), new Stop(1,Color.BLUEVIOLET)
        }; LinearGradient linear3=new LinearGradient(20,30,37,19,true,CycleMethod.REFLECT,stop2);
        Stop[] stop3=new Stop[]{
            new Stop(0,Color.DARKCYAN),new Stop(1,Color.BLACK)
        }; LinearGradient linear4=new LinearGradient(20,1,35,2,true,CycleMethod.REFLECT,stop3);
        Stop[] stop4=new Stop[]{
            new Stop(0,Color.ALICEBLUE), new Stop(1,Color.LIGHTSTEELBLUE)
        }; LinearGradient linear5=new LinearGradient(20,30,37,21,true,CycleMethod.REFLECT,stop4);
        Text welcome=new Text("This Is The Skyline Digital"); Reflection flec=new Reflection(0.3,0.2,0.1,0.5); welcome.setFill(Color.AQUA); welcome.setEffect(flec);welcome.setFont(new Font(45));
        Text genst=new Text("          Home of the genius"); FillTransition filt=new FillTransition(Duration.millis(1000)); genst.setFill(Color.GOLD);genst.setFont(new Font(32));
        Rectangle rect=new Rectangle(); rect.setWidth(71); rect.setHeight(42);
        filt.setShape(rect);filt.setFromValue(Color.AQUA);filt.setToValue(Color.IVORY);filt.setCycleCount(100);filt.setAutoReverse(false);filt.play();
        ImageView log01=new ImageView(icon); log01.setFitWidth(220); log01.setFitHeight(270);
        
        //progress indicator 
        ProgressIndicator prog=new ProgressIndicator();prog.autosize();
        
        //making program background fills
        BackgroundFill bgf1= new BackgroundFill(linear,new CornerRadii(5),new Insets(0,0,0,0)); Background bgb=new Background(bgf1);
        BackgroundFill bgf2=new BackgroundFill(Color.ALICEBLUE,new CornerRadii(5),new Insets(0,0,0,0)); Background bgc=new Background(bgf2);
        BackgroundFill bgf3=new BackgroundFill(linear3,new CornerRadii(5),new Insets(0,0,0,0)); Background bgd=new Background(bgf3);
        BackgroundFill bgf4=new BackgroundFill(linear4,new CornerRadii(5),new Insets(0,0,0,0)); Background bge=new Background(bgf4);
        BackgroundFill bgf5=new BackgroundFill(linear5,new CornerRadii(5),new Insets(0,0,0,0)); Background bgf=new Background(bgf5);
        
        //creating a start up pane
        Button bstat=new Button("Start"); bstat.setStyle("-fx-background-color: darkgreen; -fx-text-Fill: lightblue; -fx-font: normal bold 20px 'Bell MT';");
        GridPane strt=new GridPane();strt.setPadding(new Insets(10,10,10,10)); strt.setAlignment(Pos.TOP_CENTER); bstat.setPrefSize(240, 17);
        strt.setVgap(3); strt.setHgap(3); strt.setBackground(bgb);strt.add(welcome,0,1);strt.add(genst,0,2); strt.add(bstat,0,23); strt.add(log01,0,0);
        Scene statscene=new Scene(strt); stage.setTitle("The Skyline Digital"); stage.setScene(statscene); stage.show();
        
         // my additional stuffs
         ObservableList<String> Ads= FXCollections.observableArrayList("Asphalt8","Airborne","Beyond","Heat");
         
         //making an image background
         Image im=new Image(new FileInputStream("C:/Users/SYRUS/Documents/NetBeansProjects/JavaFX/Skyline D/green_nature.jpg"));
         BackgroundSize bgS=new BackgroundSize(90,90,true,true,true,false);
         BackgroundImage bgi=new BackgroundImage(im,BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,BackgroundPosition.CENTER,bgS);
         Background bga=new Background(bgi);
         BoxBlur blur=new BoxBlur(); blur.setWidth(2.5); blur.setHeight(1.15); blur.setIterations(1);
         
        bstat.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            @SuppressWarnings("Convert2Lambda")
            public void handle(ActionEvent events){
            System.out.println("Starting application features...");

        //creating label text for Email & Password 
          Text text1 = new Text("Username");
          Text text2=new Text("Password"); Text sky=new Text("SKYLINE DIGITAL");sky.setFill(Color.PURPLE);
          Text gen=new Text("   Home Of The Genius");gen.setFill(Color.ALICEBLUE);//gen.setFont(Font.font(null,FontWeight.NORMAL,19));
          
          /*gen.setEffect(blur);*/ Hyperlink fpswd=new Hyperlink("Forgot Password?");fpswd.setStyle("-fx-text-fill:white;-fx-font:normal 17px 'Bell MT'");
         //creating textfield for the email and password
         TextField field1=new TextField();
         PasswordField field2=new PasswordField(); 
         
         //creating Buttons
         Button but1=new Button("LogIn");                                                    //this was when i had just started my JavaFx course
         Button but2=new Button("SignUp");                                      String logerr="Can not perform action\n Invalid Username OR Password entered";
                                                                                Text loger=new Text(logerr);loger.setStyle("-fx-font:normal 15px 'Times new roman'");
         /*creating the Gridpane  */                                            loger.setFill(Color.RED);  
         GridPane pane=new GridPane();
         pane.setPadding(new Insets(10,10,10,10));                              Hyperlink hlp=new Hyperlink("Help");
                                                                                hlp.setStyle("-fx-font:normal 17px 'serif';-fx-text-fill:white");
         /*setting vertical and horizontal gaps btn colums & positioning*/
         pane.setVgap(5);pane.setHgap(5);pane.setAlignment(Pos.CENTER);
         
         //Arranging nodes in the grid
         pane.add(sky,1,0);pane.add(gen,1,1);
         pane.add(text1,0,2);pane.add(field1,1,2);
         pane.add(text2,0,3);pane.add(field2,1,3);
         pane.add(but1,1,4);pane.add(but2,2,4); pane.setBackground(bgd); pane.add(fpswd,1,7);pane.add(hlp,1,10);
         
         //styling up the Nodes
         but1.setStyle("-fx-background-color:darkblue; -fx-text-Fill: lightblue;-fx-font:bold 17px 'Bell MT'");
         but2.setStyle("-fx-background-color:darkblue; -fx-text-Fill: lightblue;-fx-font:bold 17px 'Bell MT'");
         text1.setStyle("-fx-font: normal bold 20px 'serif'");text2.setStyle("-fx-font: normal bold 20px 'serif'");
         sky.setStyle("-fx-font: bold 25px 'Bell MT'"); gen.setStyle("-fx-font:normal 21px 'Times new roman'");
         
         //new insert tray
         Text sky1=new Text("REGISTRATION FORM");sky1.setStyle("-fx-font: normal bold 21px 'Bell MT';"); sky1.setFill(Color.DARKBLUE);
                Text fstN=new Text("First Name"); Text lstN=new Text("Last Name"); 
                TextField name1 =new TextField();TextField name2 =new TextField();
                Text dob=new Text("Date of Birth");DatePicker pick=new DatePicker(); 
                Text gender=new Text("Gender");ToggleGroup groupGender=new ToggleGroup();   
                RadioButton maleR=new RadioButton("Male");maleR.setToggleGroup(groupGender); maleR.setUserData("Male");
                
                RadioButton femaleR=new RadioButton("Female");femaleR.setToggleGroup(groupGender); femaleR.setUserData("Female");
                Text identity=new Text("Identification Type");
                ChoiceBox ident=new ChoiceBox(); ident.getItems().addAll("National ID","Passport","Refuge card");
                Button register=new Button("Register"); Button home1=new Button("Back"); 
                Text identn=new Text("Identifiction Number");TextField idn=new TextField(); 
                Text mobile=new Text("Mobile");TextField mob=new TextField();
                
                Text email=new Text("Email");TextField mail=new TextField();
                Text username=new Text("Set User name");TextField suser=new TextField();
                Text password=new Text("Set Password");TextField passwd=new TextField(); 
                Text conpassword=new Text("Confirm Password");TextField conpasswd=new TextField(); 
                Text occup=new Text("Occupation"); TextField occu=new TextField(); String Nogaps="Please fill all the Fields.";
                Text Nogap=new Text(Nogaps); Nogap.setStyle("-fx-font: normal 15px 'Bell MT'"); Nogap.setFill(Color.DARKRED);
                
                // creating and organising objects in the grid pane
                GridPane signup=new GridPane();signup.setPadding(new Insets(12,12,12,12));
                signup.setVgap(9); signup.setHgap(9); signup.setAlignment(Pos.CENTER); signup.add(sky1,1,0);
                signup.add(fstN,0,1);signup.add(name1,1,1);signup.add(lstN,0,2);signup.add(name2,1,2);signup.add(dob,0,3);
                signup.add(pick,1,3);signup.add(gender,0,4);signup.add(maleR,1,4);signup.add(femaleR,2,4);signup.add(identity,0,5);
                
                signup.add(ident,1,5);signup.add(home1,0,17);signup.add(register,2,17);signup.add(identn,0,6);signup.add(idn,1,6);
                signup.add(mobile,0,7);signup.add(mob,1,7);signup.add(email,0,8);signup.add(mail,1,8);signup.add(occup,0,9);signup.add(occu,1,9);
                signup.add(username,0,10);signup.add(suser,1,10);signup.add(password,0,11);signup.add(passwd,1,11);
                signup.add(conpassword,0,12);signup.add(conpasswd,1,12);signup.add(Nogap,1,13);
                
                //Styling up the pane
                signup.setBackground(bgf);
                register.setStyle("-fx-background-color:purple; -fx-text-fill:azure; -fx-font:bold 15px 'Bell MT'"); 
                home1.setStyle("-fx-background-color:purple; -fx-text-fill:azure; -fx-font:bold 15px 'Bell MT'");
                fstN.setStyle("-fx-font: normal 17px'serif'");lstN.setStyle("-fx-font:normal 17px'serif'");
                dob.setStyle("-fx-font:normal 17px'serif'");gender.setStyle("-fx-font:normal 17px'serif'");
                
                maleR.setStyle("-fx-font:normal 17px'serif'");femaleR.setStyle("-fx-font:normal 17px'serif'");
                identity.setStyle("-fx-font:normal 17px'serif'");identn.setStyle("-fx-font:normal 17px'serif'");
                mobile.setStyle("-fx-font:normal 17px'serif'");email.setStyle("-fx-font:normal 17px'serif'");
                username.setStyle("-fx-font:normal 17px'serif'");password.setStyle("-fx-font:normal 17px'serif'");
                conpassword.setStyle("-fx-font:normal 17px'serif'"); occup.setStyle("-fx-font: normal 17px 'serif'");
         
         BorderPane brd=new BorderPane();brd.setCenter(pane);brd.setBackground(bgc);
         //creating the object
         Scene scene=new Scene(brd); 
         stage.setTitle("The Skyline Digital");stage.setScene(scene); stage.show();
         
         field1.setOnAction((new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent ev){
                 brd.setRight(null);
             }
         }));
         
         field2.setOnAction((new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent ev){
                 brd.setRight(null);
             }
         }));
         
         fpswd.setOnAction((new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent ev){
                 try {
                     URL url=new URL("http://localhost:8080/The_Skyline_Digital/FgtPas.jsp");
                     service.showDocument(url.toString());
                 } catch (MalformedURLException ex) {
                     Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }));
         
        but2.setOnAction((new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event3){
                System.out.println("Opening registration Forms site......");
                //Dialog sp=new Dialog();sp.setTitle("SignUp Now");sp.setHeaderText("Fill in all the fields to complete your registration.");
                //DialogPane spp=new DialogPane();spp.setBackground(bgc);spp.setContent(signup);sp.setDialogPane(spp);sp.showAndWait();
                brd.setCenter(signup);
                }
         }));
        
        hlp.setOnAction((new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent ev){
                         try {
                     URL url=new URL("http://localhost:8080/The_Skyline_Digital/Help.jsp");
                     service.showDocument(url.toString());
                 } catch (MalformedURLException ex) {
                     Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
                 } }
                }));
 
        home1.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event2){
            System.out.println("Loading home screen..."); stage.setTitle("The Skyline Digital");stage.setScene(statscene);stage.show();
        }
        }));
                register.setOnAction((new EventHandler<ActionEvent>(){
                    @Override
                    public void handle (ActionEvent event4){ System.out.println("Uploading user data......");
                        // Asigning register form values to valuables
                        String sname1=name1.getCharacters().toString(); String sname2=name2.getCharacters().toString();
                        String sdob=pick.getValue().format(DateTimeFormatter.ISO_DATE);
                        String sgender=groupGender.getSelectedToggle().getUserData().toString();
                        
                        String id1=ident.getValue().toString();
                        String idNo=idn.getCharacters().toString(); String smobile=mob.getCharacters().toString(); String semail=mail.getCharacters().toString(); 
                        String susername=suser.getCharacters().toString(); String setpswd=passwd.getCharacters().toString();
                        
                        String conpswd=conpasswd.getCharacters().toString(); String serror="Please fill in all the missing fields to complete your registration";
                        String Userpswd; if(setpswd.equals(conpswd)){Userpswd=conpswd;}else Userpswd=null;
                        String soccup=occu.getCharacters().toString(); int sbalance=0; String x="*"; Text nulf=new Text(x);nulf.setStyle("-fx-font:normal bold 24px 'serif'");nulf.setFill(Color.RED);
                        
                        //test printing my valuabeles values
                        System.out.println(sname1); System.out.println(sname2); System.out.println(sdob); System.out.println(sgender);
                        System.out.println(id1); System.out.println(idNo); System.out.println(smobile); System.out.println(semail); 
                        System.out.println(soccup);System.out.println(susername); 
                        
                        /*Adding to sql db table*/ Text er=new Text(serror);er.setStyle("-fx-font:normal 17px 'Constantia'");er.setFill(Color.DARKRED);
                        if(sname1!=null){if(sname2!=null){if(sdob!=null){if(sgender!=null){if(id1!=null){if(idNo!=null){if(smobile!=null){if(semail!=null){
                        if(susername!=null){if(soccup!=null){if(conpswd!=null){
                            PreparedStatement pst;
                            String insertString="insert into SkylineDigital (First_Name,Last_Name,Date_Of_Birth,Gender,Identification_Type,Identification_Number,Mobile,Email,User_Name,Password,Occupation,Balance) Values(?,?,?,?,?,?,?,?,?,?,?,?)";
                            try {
                                pst=con.prepareStatement(insertString);
                                pst.setString(1, sname1); pst.setString(2, sname2); pst.setString(3,sdob); pst.setString(4, sgender); pst.setString(5,id1);
                                pst.setString(6,idNo); pst.setString(7,smobile); pst.setString(8, semail); pst.setString(9,susername); pst.setString(10,Userpswd); 
                                pst.setString(11,soccup); pst.setLong(12, sbalance);pst.executeUpdate();
                            } catch (SQLException ex) {
                                Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        // making up account creation success scene 
                        String deta =sname1+"\n"+sname2+"\n"+sdob+"\n"+sgender+"\n"+id1+"\n"+idNo+"\n"+smobile+"\n"+semail+"\n"+soccup+"\n"+susername+"\n"+Userpswd;
                        Text creation=new Text("Account Successfully created and verified"); creation.setStyle("-fx-font: bold 27px 'serif'"); creation.setFill(Color.DARKGREEN);
                        Text detailsV=new Text("Account Details"); detailsV.setStyle("-fx-font: bold 23px 'BellMT'"); detailsV.setFill(Color.DARKBLUE);
                        Text details =new Text(deta); details.setStyle("-fx-font: bold 20px 'serif'"); details.setFill(Color.BLACK);
                        
                        // creating a gridpane
                        GridPane detai=new GridPane(); detai.setPadding(new Insets(13,13,13,13)); detai.setVgap(7); detai.setMinSize(730,500);
                        detai.setHgap(7);detai.setAlignment(Pos.CENTER); detai.setBackground(bgd);
                        detai.add(creation,0,0); detai.add(detailsV,0,4); detai.add(details,0,7); detai.add(home1,1,9);
                        Scene scene4=new Scene(detai); stage.setTitle("Verify Account"); stage.setScene(scene4);
                        }}}}}}}}}}} else System.out.println(serror);
                        
                    }
                }));
          //Adding an event to button1
         but1.setOnAction((new EventHandler<ActionEvent>(){
        @Override
        @SuppressWarnings("Convert2Lambda")
        public void handle(ActionEvent event1){ 
             
            try {System.out.println("Opening transaction work bench on log in....");
            String inputpswd=field2.getCharacters().toString(); String inputuser=field1.getCharacters().toString();
                PreparedStatement pst1;String select="select *from SkylineDigital where User_Name=?";
                pst1=con.prepareStatement(select,ResultSet.FETCH_FORWARD,ResultSet.CONCUR_UPDATABLE);pst1.setString(1,inputuser);  ResultSet res1;res1=pst1.executeQuery();
                
                if(res1.next()){String conuser=res1.getString("User_Name");String conpswd=res1.getString("Password");System.out.println(conuser);
                if(inputpswd.equals(conpswd)) {
                Image Slogo=new Image(new FileInputStream("D:/Syrus/LOGO.png")); ImageView logoview=new ImageView(Slogo);logoview.setFitWidth(74);
                logoview.setFitHeight(90); Button profile=new Button("Profile"); Button logout=new Button("LogOut"); Rectangle Lrect=new Rectangle(170,30);
                Rectangle Lrect2=new Rectangle(170,30); Lrect2.setFill(Color.PLUM);
                
                Text sky2=new Text("THE SKYLINE DIGITAL");sky2.setStyle("-fx-font:normal bold 29px 'Bell MT'");sky2.setFill(Color.AZURE);
                Text gen2=new Text("Home Of The Genius");gen2.setStyle("-fx-font:normal 22px 'serif'");gen2.setFill(Color.WHITESMOKE);
                Button market=new Button("Marketing");Button finance=new Button("Finances");
                
                Button abt=new Button("@");Button help=new Button("?"); Text skyD1=new Text(skyD); GridPane.setValignment(skyD1,VPos.BOTTOM);
                
                profile.setStyle("-fx-background-color:darkblue; -fx-text-fill:lightgrey; -fx-font:normal 15px 'serif'"); Lrect.setFill(Color.PLUM); 
                logout.setStyle("-fx-background-color:darkred; -fx-text-fill:lightgrey;-fx-font:normal 18px 'serif'"); profile.setMinSize(170,50);
                market.setStyle("-fx-background-color:purple; -fx-text-fill:lightgreen; -fx-font:normal 17px 'serif'"); market.setMinSize(170,50);
                
                finance.setStyle("-fx-background-color:darkred; -fx-text-fill:lightgreen; -fx-font:normal 17px 'serif'"); finance.setMinSize(170,50);
                abt.setStyle("-fx-background-color:plum; -fx-text-fill:black; -fx-font:normal 18px 'serif'"); abt.setPrefHeight(28); help.setPrefHeight(28);
                help.setStyle("-fx-background-color:lightsteelblue; -fx-text-fill:black; -fx-font:normal 18px 'serif'"); logout.setPrefHeight(28);
                skyD1.setStyle("-fx-font:normal 17px 'serif'"); skyD1.setFill(Color.WHITE);
                 
                Hyperlink link1=new Hyperlink("Visit Site");link1.setStyle("-fx-text-fill:white; -fx-font: normal 17px 'Times new roman'");
                Hyperlink link2=new Hyperlink("  News"); link2.setStyle("-fx-text-fill:white; -fx-font: normal 17px 'Times new roman'");
                
                GridPane log=new GridPane(); log.setPadding(new Insets(13,13,13,13)); log.setVgap(7); log.setHgap(7);log.setAlignment(Pos.CENTER);log.setBackground(bgb); 
                log.add(gen2,0,0); String skyT="The Skyline Digital";
                
                GridPane log1=new GridPane(); log1.setPadding(new Insets(13,13,13,13)); log1.setVgap(7); log1.setHgap(7); log1.setAlignment(Pos.TOP_LEFT);
                log1.setBackground(bge); log1.add(logoview,0,0);log1.add(market,0,2); log1.add(finance,0,3); log1.add(profile,0,4);
                log1.add(Lrect,0,1); log1.add(link1,0,7);
                
                Menu sil=new Menu("Date"); 
               
                //GridPane log2=new GridPane(); log2.setPadding(new Insets(13,13,13,13)); log2.setVgap(7); log2.setHgap(7); log2.setAlignment(Pos.TOP_CENTER);
                //log2.setBackground(bgd); // log2.add(link1,0,4); log2.add(link2,0,5);
                
                GridPane log3=new GridPane(); log3.setPadding(new Insets(1,1,1,1));log3.setVgap(1);log3.setHgap(1);log3.setAlignment(Pos.BOTTOM_CENTER);
                log3.setStyle("-fx-background-color:navy"); log3.add(skyD1,0,1);
                
                HBox hb=new HBox(); hb.setPadding(new Insets(1)); hb.setSpacing(1); hb.setStyle("-fx-background-color:darkslateblue");
                hb.getChildren().addAll(sky2);
                Rectangle rec1=new Rectangle(30.0,25.0); rec1.setFill(Color.GREEN); Circle crc1=new Circle(30); crc1.setFill(Color.BLUEVIOLET);
                rec1.setStroke(Color.DARKRED);rec1.setArcWidth(4); rec1.setArcHeight(4);  crc1.setStroke(Color.DARKBLUE);
                StackPane stk=new StackPane();StackPane.setMargin(rec1,new Insets(50,50,50,50));
                stk.getChildren().addAll(rec1,help);
                StackPane stk2=new StackPane(); StackPane.setMargin(crc1,new Insets(50,50,50,50));
                stk2.getChildren().addAll(crc1,abt);
                
                HBox bx=new HBox(); bx.setPadding(new Insets(3)); bx.setSpacing(2); bx.setStyle("-fx-background-color:darkslateblue");
                bx.getChildren().addAll(abt,help,logout);
                BorderPane gd=new BorderPane(); gd.setLeft(hb); gd.setRight(bx); gd.setStyle("-fx-background-color:darkslateblue");
                
                BorderPane bord=new BorderPane(); bord.autosize(); bord.setLeft(log1); bord.setBottom(log3); bord.setBackground(bgc);
                bord.setCenter(log); bord.setTop(gd);
                
                Scene scene4=new Scene(bord); stage.setTitle(skyT); stage.setScene(scene4); stage.show();
                
                link1.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent ev){
                         try {
                     URL url=new URL("http://localhost:8080/The_Skyline_Digital/");
                     service.showDocument(url.toString());
                 } catch (MalformedURLException ex) {
                     Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
                 }
                    }
                });
                
                market.setOnAction((new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event5){
                        System.out.println("Entering the marketing room...."); 
                        Text soft=new Text("Skyline Marketing Center           ");soft.setStyle("-fx-font: bold 20px 'Times new roman'");soft.setFill(Color.DARKBLUE);
                        Hyperlink sell=new Hyperlink("Sell Your Products Here");sell.setStyle("-fx-font:normal 17px 'serif'; -fx-text-fill:dodgerblue");
                        Text done=new Text("Buy online and we deliver. No shipping fees needed.");done.setStyle("-fx-font:bold 17px 'serif'");done.setFill(Color.FUCHSIA);
                        
                        try {
                        Image phone1=new Image(new FileInputStream("C:/Users/SYRUS/Documents/NetBeansProjects/JavaFX/Skyline D/Products/Mobile (1).jpg"));
                        ImageView view1=new ImageView(phone1);view1.setFitHeight(250);view1.setFitWidth(250);
                        Image ltop1=new Image(new FileInputStream("C:/Users/SYRUS/Documents/NetBeansProjects/JavaFX/Skyline D/Products/laptop (1).jpg"));
                        ImageView view2=new ImageView(ltop1);view2.setFitHeight(250);view2.setFitWidth(250);
                        
                        Image cam1=new Image(new FileInputStream("C:/Users/SYRUS/Documents/NetBeansProjects/JavaFX/Skyline D/Products/camera (1).jpg"));
                        ImageView view3=new ImageView(cam1);view3.setFitHeight(250);view3.setFitWidth(250);
                        Image spk1=new Image(new FileInputStream("C:/Users/SYRUS/Documents/NetBeansProjects/JavaFX/Skyline D/Products/Speaker (1).jpg"));
                        ImageView view4=new ImageView(spk1);view4.setFitHeight(250);view4.setFitWidth(250);
                        
                        Image phone2=new Image(new FileInputStream("C:/Users/SYRUS/Documents/NetBeansProjects/JavaFX/Skyline D/Products/Mobile (2).jpg"));
                        ImageView view5=new ImageView(phone2);view5.setFitHeight(250);view5.setFitWidth(250);
                        Image ltop2=new Image(new FileInputStream("C:/Users/SYRUS/Documents/NetBeansProjects/JavaFX/Skyline D/Products/laptop (2).jpg"));
                        ImageView view6=new ImageView(ltop2);view6.setFitHeight(250);view6.setFitWidth(250);
                        
                        Image cam2=new Image(new FileInputStream("C:/Users/SYRUS/Documents/NetBeansProjects/JavaFX/Skyline D/Products/camera (2).jpg"));
                        ImageView view7=new ImageView(cam2);view7.setFitHeight(250);view7.setFitWidth(250);
                        Image spk2=new Image(new FileInputStream("C:/Users/SYRUS/Documents/NetBeansProjects/JavaFX/Skyline D/Products/Speaker (2).jpg"));
                        ImageView view8=new ImageView(spk2);view8.setFitHeight(250);view8.setFitWidth(250);
                        
                        Hyperlink fon1=new Hyperlink("Samsung Galaxy S8 plus\n    Ugx.3,170,000");fon1.setStyle("-fx-font:normal bold 15px 'Constantia';-fx-text-fill:purple");
                        Hyperlink lap1=new Hyperlink("Zed-iLife Notebook \n     Ugx.1,170,000");lap1.setStyle("-fx-font:normal bold 15px 'Constantia';-fx-text-fill:purple");
                        Hyperlink cm1=new Hyperlink("CCTV Server Camera 13\n     Ugx.470,000");cm1.setStyle("-fx-font:normal bold 15px 'Constantia';-fx-text-fill:purple");
                        Hyperlink sk1=new Hyperlink("Yamaha Professional Amplifier\n     Ugx.2,240,000");sk1.setStyle("-fx-font:normal bold 15px 'Constantia';-fx-text-fill:purple");
                        
                        Hyperlink fon2=new Hyperlink("Itel SmartPhone SR087\n    Ugx.3,170,000");fon2.setStyle("-fx-font:normal bold 15px 'Constantia';-fx-text-fill:purple");
                        Hyperlink lap2=new Hyperlink("Dell Aspire 231 Notebook \n     Ugx.1,170,000");lap2.setStyle("-fx-font:normal bold 15px 'Constantia';-fx-text-fill:purple");
                        Hyperlink cm2=new Hyperlink("Sony Digital Camera 13\n     Ugx.470,000");cm2.setStyle("-fx-font:normal bold 15px 'Constantia';-fx-text-fill:purple");
                        Hyperlink sk2=new Hyperlink("Sky bass blust HeadPhones\n     Ugx.2,240,000");sk2.setStyle("-fx-font:normal bold 15px 'Constantia';-fx-text-fill:purple");
                        
                        GridPane prod=new GridPane();prod.setVgap(5);prod.setHgap(5);prod.setPadding(new Insets(7,7,7,7));prod.setAlignment(Pos.TOP_LEFT);
                        prod.add(view1,0,0);prod.add(fon1,1,0);prod.add(view2,0,2);prod.add(lap1,1,2);prod.add(view3,0,3);prod.add(cm1,1,3);prod.add(view4,0,4);prod.add(sk1,1,4);
                        prod.add(view5,0,5);prod.add(fon2,1,5);prod.add(view6,0,6);prod.add(lap2,1,6);prod.add(view7,0,7);prod.add(cm2,1,7);prod.add(view8,0,8);prod.add(sk2,1,8);
                        
                        ScrollPane scroll=new ScrollPane();scroll.autosize();scroll.setContent(prod);scroll.setPrefWidth(1170);
                        
                        GridPane mart=new GridPane();mart.setVgap(7);mart.setHgap(7);mart.setPadding(new Insets(7,7,7,7));mart.setAlignment(Pos.TOP_LEFT);
                        mart.add(soft,0,0);mart.add(sell,0,1);mart.add(done,0,2);mart.add(scroll,0,3);
                        
                        bord.setCenter(mart);
                        
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }));
                logout.setOnAction((new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event5){
                        Text atit =new Text("Confirmation"); Text alert=new Text("Are you sure you want to LogOut?");Button yes=new Button("YES");
                        Button no=new Button("NO");no.setPrefSize(70,20);no.setStyle("-fx-background-color:darkslateblue;-fx-font:normal 17px 'serif';-fx-text-fill:white");
                        yes.setStyle("-fx-background-color:darkslateblue;-fx-font:normal 17px 'serif';-fx-text-fill:white"); atit.setStyle("-fx-font:bold 20px 'serif'");
                        atit.setFill(Color.CORNFLOWERBLUE); alert.setStyle("-fx-font:normal bold 18px 'Times new roman'");alert.setFill(Color.ALICEBLUE);
                        
                        GridPane alat=new GridPane();alat.setVgap(7);alat.setHgap(7);alat.setPadding(new Insets(7,7,7,7));alat.setAlignment(Pos.CENTER);
                        BackgroundFill al=new BackgroundFill(Color.DARKSLATEGRAY,new CornerRadii(5),new Insets(2,2,2,2)); Background el=new Background(al);
                        alat.setBackground(el);alat.add(atit,0,0);alat.add(alert, 0, 1);alat.add(yes,0,2);alat.add(no,1,2);
                        
                        Stage aletst=new Stage();aletst.initStyle(StageStyle.DECORATED); aletst.setOpacity(0.9); Scene alt=new Scene(alat);
                        aletst.setScene(alt); aletst.centerOnScreen(); aletst.setHeight(390);aletst.setWidth(570); aletst.setResizable(false);
                        aletst.getIcons().add(icon); aletst.initOwner(stage);aletst.show();
                        
                        yes.setOnAction((new EventHandler<ActionEvent>(){
                            @Override
                            public void handle(ActionEvent alevent){
                                aletst.close(); stage.setTitle("The Skyline Digital");stage.setScene(statscene);stage.show(); 
                            }
                        }));
                        no.setOnAction((new EventHandler<ActionEvent>(){
                            @Override
                            public void handle(ActionEvent alevent2){
                                aletst.close(); stage.show();
                            }
                        }));
                    }
                }));
                profile.setOnAction((new EventHandler<ActionEvent>() {
                	@Override
                	public void handle(ActionEvent event6) {
                		try {
                                    
                                    String dbid=res1.getString("ID");String dbfname=res1.getString("First_Name");String dblname=res1.getString("Last_Name");
                                    String dbdob=res1.getString("Date_Of_Birth");String dbgender=res1.getString("Gender");String dbidt=res1.getString("Identification_Type");
                                    String dbidn=res1.getString("Identification_Number");String dbmob=res1.getString("Mobile");String dbmail=res1.getString("Email");
                                    
                                    String dbuser=res1.getString("User_Name");   String profpic=res1.getString("Profile_Photo");
                                    String profileDs=":"+dbid+"\n:"+dbfname+"\n:"+dblname+"\n:"+dbdob+"\n:"+dbgender+"\n:"+dbidt+"\n:"+dbidn+"\n:"+dbmob+"\n:"+dbmail+"\n:"+dbuser;
                                    System.out.println(profileDs); System.out.println(profpic);
                                    
                                    Text profileD=new Text(profileDs);profileD.setStyle("-fx-font: normal 17px 'Calisto MT'");profileD.setFill(Color.DARKSLATEBLUE);
                                    Image profphoto=new Image(new FileInputStream(profpic));
                                    ImageView prphoto=new ImageView(profphoto);prphoto.setFitWidth(350);prphoto.setFitHeight(450);
                                    
                                    GridPane prof=new GridPane();prof.setVgap(7);prof.setHgap(7);prof.setPadding(new Insets(10,10,10,10));prof.setAlignment(Pos.TOP_LEFT);
                                    String proflabels="Client ID  "+"\nFirst Name  "+"\nLast Name  "+"\nDate Of Birth  "+"\nGender  "+"\nID Type  "+"\nID Number  "+
                                    "\nMobile  "+"\nEmail  "+"\nClient Username";
                                    
                                    Text proflab=new Text(proflabels);proflab.setStyle("-fx-font:normal bold 17px 'Bell MT'");
                                    Button cpr=new Button("Change Profile Picture");cpr.setStyle("-fx-background-color:purple;-fx-text-fill:lightblue;-fx-font:normal bold 15px 'serif'");
                                    ScrollPane pr=new ScrollPane(prof);pr.autosize();cpr.setPrefSize(350,70); FileChooser proff=new FileChooser();
                                    
                                    Button upm=new Button("Update Mobile Number"); Button upp=new Button("Change Password");
                                    upm.setStyle("-fx-background-color:darkolivegreen;-fx-font:normal 15px 'Constantia';-fx-text-fill:aliceblue;");
                                    upp.setStyle("-fx-background-color:darkolivegreen;-fx-font:normal 15px 'Constantia';-fx-text-fill:aliceblue;");
                                    GridPane upd=new GridPane();upd.setVgap(4);upd.setPadding(new Insets(3,3,3,3));
                                    
                                    GridPane pp=new GridPane();pp.setVgap(7);pp.setHgap(7);pp.setPadding(new Insets(10,10,10,10));pp.setAlignment(Pos.TOP_RIGHT);
                                    pp.add(proflab, 0, 0);pp.add(profileD, 1, 0);upd.add(pp,0,0);upd.add(upm,0,1);upd.add(upp,0,4);
                                    
                                    prof.autosize();prof.add(prphoto,0,0);prof.add(cpr,0,1);prof.add(upd,1,0);bord.setCenter(pr);
                                    
                                    cpr.setOnAction((new EventHandler<ActionEvent>(){
                                        @Override
                                        public void handle(ActionEvent event7){
                                            File prr=proff.showOpenDialog(stage); proff.setTitle("Choose Profile picture");proff.getExtensionFilters().addAll(
                                                new FileChooser.ExtensionFilter("JPG Files",".jpg"),
                                                new FileChooser.ExtensionFilter("PNG Files",".png")
                                        );
                                            try {
                                                Image pr=new Image(new FileInputStream(prr));if(prr!=null){prr.toURI();System.out.println(prr);prphoto.setImage(pr);
                                                String update="update skylinedigital set Profile_Photo=? where ID=?;";
                                                PreparedStatement pst; pst=con.prepareStatement(update);pst.setString(1, prr.toString());pst.setString(2,dbid);pst.executeUpdate();res1.refreshRow();}
                                            } catch (FileNotFoundException | SQLException ex) {
                                                Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }));
							
						} catch (SQLException e) {
                                // TODO Auto-generated catch block 

						} catch (FileNotFoundException ex) {
                                Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
                            }
                	}
                }));
                finance.setOnAction((new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event8){
                        System.out.println("Opening finances room....");Text fn=new Text("Skyline Accounts Center");fn.setStyle("-fx-font:bold 27px 'Constantia'");fn.setFill(Color.INDIGO);
                        Button dep=new Button("Deposit Money");dep.setStyle("-fx-background-color:slateblue;-fx-text-fill:white;-fx-font:normal bold 20px 'serif'");dep.setPrefSize(400,50);
                        Button pur=new Button("Purchase Item");pur.setStyle("-fx-background-color:slateblue;-fx-text-fill:white;-fx-font:normal bold 20px 'serif'");pur.setPrefSize(400,50);
                        Button with=new Button("Withdraw Money");with.setStyle("-fx-background-color:slateblue;-fx-text-fill:white;-fx-font:normal bold 20px 'serif'");with.setPrefSize(400,50);
                        Button trans=new Button("Transfer Money");trans.setStyle("-fx-background-color:slateblue;-fx-text-fill:white;-fx-font:normal bold 20px 'serif'");trans.setPrefSize(400,50);
                        Button balin=new Button("My Account");balin.setStyle("-fx-background-color:slateblue;-fx-text-fill:white;-fx-font:normal bold 20px 'serif'");balin.setPrefSize(400,50);
                        
                        dep.setOnMouseMoved(e-> dep.setStyle("-fx-background-color:darkcyan;-fx-text-fill:white;-fx-font:normal bold 20px 'serif'"));
                        dep.setOnMouseExited(e1-> dep.setStyle("-fx-background-color:slateblue;-fx-text-fill:white;-fx-font:normal bold 20px 'serif'"));
                        //some an---
                        pur.setOnMouseMoved(e-> pur.setStyle("-fx-background-color:darkcyan;-fx-text-fill:white;-fx-font:normal bold 20px 'serif'"));
                        pur.setOnMouseExited(e1-> pur.setStyle("-fx-background-color:slateblue;-fx-text-fill:white;-fx-font:normal bold 20px 'serif'"));
                        
                        trans.setOnMouseMoved(e-> trans.setStyle("-fx-background-color:darkcyan;-fx-text-fill:white;-fx-font:normal bold 20px 'serif'"));
                        trans.setOnMouseExited(e1-> trans.setStyle("-fx-background-color:slateblue;-fx-text-fill:white;-fx-font:normal bold 20px 'serif'"));
                        
                        with.setOnMouseMoved(e-> with.setStyle("-fx-background-color:darkcyan;-fx-text-fill:white;-fx-font:normal bold 20px 'serif'"));
                        with.setOnMouseExited(e1-> with.setStyle("-fx-background-color:slateblue;-fx-text-fill:white;-fx-font:normal bold 20px 'serif'"));
                        
                        balin.setOnMouseMoved(e-> balin.setStyle("-fx-background-color:darkcyan;-fx-text-fill:white;-fx-font:normal bold 20px 'serif'"));
                        balin.setOnMouseExited(e1-> balin.setStyle("-fx-background-color:slateblue;-fx-text-fill:white;-fx-font:normal bold 20px 'serif'"));
                        
                        Label entd=new Label("Enter Amount to deposit");entd.setStyle("-fx-font:bold 15px 'Constantia'");
                        Label entw=new Label("Enter Amount to withdraw");entw.setStyle("-fx-font:bold 15px 'Constantia'");
                        Label entt=new Label("Enter Amount to transfer");entt.setStyle("-fx-font:bold 15px 'Constantia'");
                        
                        TextField end=new TextField();end.setPrefSize(100, 30);
                        TextField enw=new TextField();enw.setPrefSize(100, 30);
                        TextField ent=new TextField();ent.setPrefSize(100, 30);
                        
                        Button de=new Button("Deposit");de.setStyle("-fx-background-color:olive;-fx-text-fill:white;-fx-font:normal bold 17px 'Bell MT'");de.setPrefSize(200,50);
                        Button pu=new Button("Go to Market");pu.setStyle("-fx-background-color:olive;-fx-text-fill:white;-fx-font:normal bold 17px 'Bell MT'");pu.setPrefSize(200,50);
                        Button wi=new Button("Withdraw");wi.setStyle("-fx-background-color:olive;-fx-text-fill:white;-fx-font:normal bold 17px 'Bell MT'");wi.setPrefSize(200,50);
                        Button tr=new Button("Transfer");tr.setStyle("-fx-background-color:olive;-fx-text-fill:white;-fx-font:normal bold 17px 'Bell MT'");tr.setPrefSize(200,50);
                        
                        Text gt=new Text("This is the work bench which enables you to manage your skyline account");gt.setStyle("-fx-font:normal 17px 'Times new roman'");
                        GridPane fin=new GridPane();fin.setVgap(3);fin.setHgap(3);fin.setPadding(new Insets(2,2,2,2));fin.setAlignment(Pos.TOP_CENTER);
                        fin.add(fn,0,0);fin.add(gt,0,1);fin.add(dep,0,2);fin.add(pur,0,5);fin.add(with,0,8);fin.add(trans,0,11);fin.add(balin,0,14);
                        
                        ScrollPane fan=new ScrollPane(fin);bord.setCenter(fan);
                        
                        dep.setOnAction(e->{ fin.getChildren().clear();fin.add(fn,0,0);fin.add(gt,0,1);fin.add(dep,0,2);fin.add(pur,0,5);fin.add(with,0,8);fin.add(trans,0,11);fin.add(balin,0,14);
                            GridPane depd=new GridPane();depd.setPadding(new Insets(2,2,2,2));depd.setVgap(2);depd.add(entd,0,0);
                            depd.add(end,0,1);depd.add(de,0,2);fin.add(depd,0,3);
                        }); 
                        de.setOnAction((ActionEvent e)->{  String damt=end.getCharacters().toString(); int dmt=Integer.valueOf(damt); int max=5000000;
                            try { if(dmt<max){ String dbid=res1.getString("ID"); 
                            int bal=Integer.valueOf(res1.getString("Balance")); int Tbal=dmt+bal; 
                            PreparedStatement pst; String insert="update skylinedigital set Balance=? where ID =?"; 
                            pst=con.prepareStatement(insert);pst.setInt(1, Tbal);pst.setString(2,dbid);pst.executeUpdate(); res1.refreshRow();
                            
                            String ttype="Deposit"; String dbname=res1.getString("Last_Name");
                            PreparedStatement pst2;String trs="insert into skylined_transactions(Transaction_Type,Customer_ID,Customer_Names,Amount,Time_and_Date,Balance) Values(?,?,?,?,?,?)";
                            pst2=con.prepareStatement(trs);pst2.setString(1,ttype);pst2.setString(2,dbid);pst2.setString(3,dbname);pst2.setInt(4,dmt);pst2.setString(5,time);pst2.setInt(6,Tbal);
                            pst2.executeUpdate();
                            
                            String di="Transaction Complete \nDeposit of Ugx."+dmt+" has been Successful. \nYour new balance Stands Ugx."+Tbal;
                            Text d=new Text(di);d.setStyle("-fx-font: normal bold 17px 'serif'");d.setFill(Color.NAVY); 
                            Button db=new Button("OK");db.setStyle("-fx-background-color:slateblue;-fx-font:normal bold 20px 'serif';-fx-text-fill:white");
                            GridPane ds=new GridPane();ds.setVgap(12);ds.setHgap(12);ds.setAlignment(Pos.CENTER);ds.autosize();ds.add(d,0,0);ds.add(db,0,1);
                            db.setPrefSize(250,50); bord.setCenter(log);
                            
                            Stage des=new Stage();des.setTitle("deposit succes"); des.initStyle(StageStyle.DECORATED); des.setHeight(390); des.setWidth(570);
                            des.getIcons().addAll(icon);
                            des.setResizable(false); des.initOwner(stage); Scene sn=new Scene(ds); des.setScene(sn); des.show();
                            db.setOnAction(e1->{ des.close(); });
                             }
                            else {Label tm=new Label("Maximum transaction of Ugx.5,000,000 is allowed.");tm.setStyle("-fx-font:bold 15px 'Constantia'");fin.add(tm,0,4);}
                            } catch (SQLException ex) {
                                Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                        });
                        pur.setOnAction(e->{
                            WebView web=new WebView(); WebEngine eng=web.getEngine();
                            
                        });
                        with.setOnAction(e-> {
                            fin.getChildren().clear();fin.add(fn,0,0);fin.add(gt,0,1);fin.add(dep,0,2);fin.add(pur,0,5);fin.add(with,0,8);fin.add(trans,0,11);fin.add(balin,0,14);
                            GridPane wp=new GridPane();wp.setVgap(2);
                            wp.add(entw,0,0);wp.add(enw,0,1);wp.add(wi,0,2); fin.add(wp,0,9);
                            
                            wi.setOnAction(e2->{ try{ 
                                String wamt=enw.getCharacters().toString(); int wmt=Integer.valueOf(wamt);
                                int bal=Integer.valueOf(res1.getString("Balance")); int Tbal=bal-wmt; int max=5000000;
                                
                                if(wmt<max){if(wmt<=bal){ 
                                String wh="Transaction Complete  \nWithdraw of Ugx."+wmt+" has been successful \nYour new balance stands Ugx."+Tbal;
                                Text wt=new Text(wh);wt.setStyle("-fx-font:normal bold 17px 'serif'"); wt.setFill(Color.NAVY);
                                Button db=new Button("OK");db.setStyle("-fx-background-color:slateblue;-fx-font:normal bold 20px 'serif';-fx-text-fill:white");
                                bord.setCenter(log);
                                GridPane ds=new GridPane();ds.setVgap(12);ds.setHgap(12);ds.setAlignment(Pos.CENTER);ds.autosize();ds.add(wt,0,0);ds.add(db,0,1);
                                Stage st=new Stage(); st.initStyle(StageStyle.DECORATED); st.setResizable(false); st.getIcons().addAll(icon);
                                st.setHeight(390); st.setWidth(570); st.initOwner(stage); Scene sn=new Scene(ds); st.setScene(sn); st.setTitle("withdraw succes");
                                st.show();
                                
                                db.setOnAction(e1->{ st.close(); }); 
                                try {String dbid=res1.getString("ID");
                                String up="update skylinedigital set Balance=? where ID=?";PreparedStatement pst;pst=con.prepareStatement(up);
                                pst.setInt(1,Tbal);pst.setString(2,dbid);pst.executeUpdate(); res1.refreshRow();
                                
                                String ttype="Withdraw"; String dbname=res1.getString("Last_Name");
                                PreparedStatement pst2;String trs="insert into skylined_transactions(Transaction_Type,Customer_ID,Customer_Names,Amount,Time_and_Date,Balance) Values(?,?,?,?,?,?)";
                                pst2=con.prepareStatement(trs);pst2.setString(1,ttype);pst2.setString(2,dbid);pst2.setString(3,dbname);pst2.setInt(4,wmt);pst2.setString(5,time);pst2.setInt(6,Tbal);
                                pst2.executeUpdate();
                                
                                } catch (SQLException ex) {
                                    Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }else {Text fail=new Text("Error...Transaction failed.\nYou have Insufficient balance on your account to complete this transaction");
                            fail.setStyle("-fx-font:normal bold 17px 'serif'");fail.setFill(Color.DARKRED); fin.add(fail,0,10);}
                                }else {Label tm=new Label("Maximum transaction of Ugx.5,000,000 is allowed.");tm.setStyle("-fx-font:bold 15px 'Constantia'"); fin.add(tm,0,17);}
                                
                                } catch (SQLException ex) {
                                    Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            });
                        });
                        trans.setOnAction(e->{ 
                            fin.getChildren().clear();fin.add(fn,0,0);fin.add(gt,0,1);fin.add(dep,0,2);fin.add(pur,0,5);fin.add(with,0,8);fin.add(trans,0,11);fin.add(balin,0,14);
                            Label ct=new Label("Enter Client ID");ct.setStyle("-fx-font:bold 15px 'Constantia'");TextField tf=new TextField();
                            tf.autosize(); GridPane trp=new GridPane();trp.setVgap(2);
                            trp.add(ct,0,0);trp.add(tf,0,2);trp.add(entt,0,3);trp.add(ent,0,4);trp.add(tr,0,5);fin.add(trp,0,12);
                           
                            tr.setOnAction(e1-> { String inputid=tf.getCharacters().toString();String tmat=ent.getCharacters().toString();int tmt=Integer.valueOf(tmat); 
                            try {PreparedStatement pst1;String qry="select *from skylinedigital where ID=?";pst1=con.prepareStatement(qry,ResultSet.FETCH_FORWARD,ResultSet.CONCUR_UPDATABLE);int max=5000000;
                            String lid=res1.getString("ID");  int ba=res1.getInt("Balance");
                            
                            pst1.setString(1,inputid);ResultSet res2=pst1.executeQuery(); if(res2.next()&&!inputid.equals(lid)){ if(tmt<max){ if(tmt<=ba){
                            int bala1=Integer.valueOf(res1.getString("Balance")); int bala2=Integer.valueOf(res2.getString("Balance"));
                            int Tbal1=bala1-tmt; int Tbal2=bala2+tmt; String cname1=res2.getString("First_Name"); String cname2=res2.getString("Last_Name");
                            //update database now
                            PreparedStatement pst2;String upl="update skylinedigital set Balance=? where ID=?";pst2=con.prepareStatement(upl);pst2.setInt(1,Tbal1);pst2.setString(2,lid);pst2.executeUpdate();
                            PreparedStatement pst3;String uph="update skylinedigital set Balance=? where ID=?";pst3=con.prepareStatement(uph);pst3.setInt(1,Tbal2);pst3.setString(2,inputid);pst3.executeUpdate();
                            
                            String ttype="Transfer"; String dbname=res1.getString("Last_Name"); String tdbname=dbname+" to "+cname2+" ("+inputid+")";
                            PreparedStatement pst4;String trs="insert into skylined_transactions(Transaction_Type,Customer_ID,Customer_Names,Amount,Time_and_Date,Balance) Values(?,?,?,?,?,?)";
                            pst4=con.prepareStatement(trs);pst4.setString(1,ttype);pst4.setString(2,lid);pst4.setString(3,tdbname);pst4.setInt(4,tmt);pst4.setString(5,time);pst4.setInt(6,Tbal1);
                            pst4.executeUpdate(); res1.refreshRow(); res2.refreshRow(); bord.setCenter(log);
                            
                            GridPane tp=new GridPane();tp.setVgap(5);tp.setHgap(5);tp.autosize();tp.setPadding(new Insets(7,7,7,7));tp.setAlignment(Pos.CENTER);
                            String str="Transfer of Ugx."+tmt+" to "+cname1+" "+cname2+" has been Successful.\n Your new Balance stands Ugx."+Tbal1;
                            Text ui=new Text(str);ui.setStyle("-fx-font:normal bold 17px 'serif'"); ui.setFill(Color.NAVY); tp.add(ui,0,0);
                            Button kk=new Button("OK");kk.setStyle("-fx-background-color:navy; -fx-font:bold 24px 'serif'; -fx-text-fill:lightgrey"); tp.add(kk,0,1);
                            
                            Stage st=new Stage(); st.initStyle(StageStyle.DECORATED); st.setTitle("transfer success"); st.initOwner(stage); st.setHeight(390);
                            st.setWidth(590); st.setResizable(false); st.getIcons().addAll(icon); Scene sn=new Scene(tp); st.setScene(sn); st.show();
                            
                            }else {Label tm=new Label("Error... You have insufficient balance on your A/C.");tm.setStyle("-fx-font:bold 15px 'Constantia'"); fin.add(tm,0,24);}
                            } else {Label tm=new Label("Maximum transaction of Ugx.5,000,000 is allowed.");tm.setStyle("-fx-font:bold 15px 'Constantia'"); fin.add(tm,0,25);}}
                            else {Label tm=new Label("Error.... Client not found.\n Please check client ID and try again.");tm.setStyle("-fx-font:bold 15px 'Constantia'"); fin.add(tm,0,26);}
                            
                            }catch (SQLException ex) {
                                    Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            });
                        });
                        
                        balin.setOnAction(e->{
                            fin.getChildren().clear();fin.add(fn,0,0);fin.add(gt,0,1);fin.add(dep,0,2);fin.add(pur,0,5);fin.add(with,0,8);fin.add(trans,0,11);fin.add(balin,0,14);
                            try {
                                String bal1=res1.getString("Balance"); String bal="Your account balance Stands Ugx."+bal1;
                                Label bals=new Label(bal);bals.setStyle("-fx-font: normal bold 17px 'serif'"); fin.add(bals,0,15);
                                Hyperlink stmt=new Hyperlink("Request Statement"); stmt.setStyle("-fx-font:normal bold 18px 'Constantia'; -fx-text-fill:purple"); fin.add(stmt,0,16);
                                
                                stmt.setOnAction(e1->{ 
                                //Label st=new Label("Statement has been sent to your Email address"); st.setStyle("-fx-font:normal 17px 'serif'");fin.add(st,0,29);
                                ListView<String> view=new ListView(); List<String> list=new ArrayList(); view.setPrefWidth(900); 
                                String qry="select *from skylined_transactions where Customer_ID=?"; 
                                PreparedStatement pst; try { String dbid=res1.getString("ID"); 
                                    pst=con.prepareStatement(qry); pst.setString(1,dbid); ResultSet res3=pst.executeQuery();
                                    while(res3.next()){ String sp="             ";
                                        String trd=res3.getString("Transaction_ID"); String tt=res3.getString("Transaction_Type"); String cid=res3.getString("Customer_ID");
                                        String nam=res3.getString("Customer_Names"); String amt=res3.getString("Amount"); String td=res3.getString("Time_and_Date");
                                        int bl=res3.getInt("Balance"); 
                                        list.add(trd+sp+tt+sp+cid+sp+nam+sp+amt+sp+td+sp+bl);
                                    } ObservableList<String> rd=FXCollections.observableArrayList(list);
                                    view.setOrientation(Orientation.VERTICAL); 
                                    view.setStyle("-fx-font:normal 15px 'serif';-fx-control-inner-background:aliceblue;");view.setItems(rd);fin.add(view,0,17);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                });
                            } catch (SQLException ex) {
                                Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });
                    }
                }));
                
                abt.setOnAction((new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent ev){
                        try { URL url=new URL("http://localhost:8080/The_Skyline_Digital/About.jsp");
                            service.showDocument(url.toString());
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }));
                
                help.setOnAction((new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent ev){
                        try { URL url=new URL("http://localhost:8080/The_Skyline_Digital/Help.jsp");
                            service.showDocument(url.toString());
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }));
                
                } else pane.add(loger, 1, 6); }else pane.add(loger, 1, 6);
            } catch (FileNotFoundException | SQLException ex) {
                Logger.getLogger(Sampling.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        
    })); 
         
    }} ));
        
   } 
     
   public static void main(String args[]){ 
      launch(args); 
   } 
}  
 
