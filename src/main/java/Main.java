/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
//import javax.swing.text.Document;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Joel Caro G
 */
public class Main {
    private final static Logger log = Logger.getLogger(Main.class); 
    private static Element elementoRaiz;
    private static String nomArchivo= "autos";
    private static ArrayList<tareParsers> tp = new ArrayList<tareParsers>();
     
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException 
    {
//        
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
 
        while (!salir) {
 
            System.out.println("1. Opcion 1 Loggin");
            System.out.println("2. Opcion 2 Properties");
            System.out.println("3. Opcion 3 Recorrido SAX");
            System.out.println("4. Opcion 4 Recorrido DOM");
            System.out.println("5. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1 Loggin");
                        
                    //        Loggin

                            PropertyConfigurator.configure("E://users//joel caro g//documents//NetBeansProjects//TareaLog4j//log4j.properties");

                            log.info("Informacion de logging joel");
                        
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2 Properties");
                        
                                                        //Properties

                                        Properties oProperties = new Properties();
                                        
                                        InputStream inArchivo;
                                        
                                         try{
                                             inArchivo = new FileInputStream("E://users//joel caro g//documents//NetBeansProjects//TFP_DS_JoelCaro_814//WebServive.properties");
                                        //("E://users//joel caro g//documents//NetBeansProjects//TareaLog4j//configuracion.properties");
                                             oProperties.load(inArchivo);
                                             
                                         }  catch(IOException e)
                                         {  
                                             System.out.println(e.toString());
                                         }  
                                         
                                         System.out.println("Propiedades");
                                         System.out.println("--------------------");
                                         System.out.println(oProperties.getProperty("servidor.nombre"));
                                         System.out.println(oProperties.getProperty("servidor.usuario"));
                                         System.out.println(oProperties.getProperty("servidor.password"));
                                         
                                         System.out.println("Propiedades For:");
                                         System.out.println("--------------------");
                                         
                                         for(Enumeration e = oProperties.keys(); e.hasMoreElements();)
                                         {
                                             Object obj = e.nextElement();
                                             System.out.println(obj + ":" + oProperties.getProperty(obj.toString()));
                                         }
                        
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3 Recorrido SAX");

                                        //Recorrido SAX

                                        SAXParserFactory saxPF = SAXParserFactory.newInstance();
                                        SAXParser saxParser = saxPF.newSAXParser();
                                        File file = new File("E://users//joel caro g//documents//NetBeansProjects//TareaLog4j//tareaParsers.xml");
                                        TareaParsersHandler handler = new TareaParsersHandler();
                                        saxParser.parse(file, handler);
                                        
                                        ArrayList<tareParsers> tarea = handler.getTarea();
                                        
                                        for(tareParsers tp : tarea ){
                                            System.out.println(tp);
                                        }
        
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 4 recorrido DOM");
                         //Recorrido DOM
       
                                DocumentBuilderFactory fact1 = DocumentBuilderFactory.newInstance();
                                DocumentBuilder crateDocument1 = fact1.newDocumentBuilder();
                                Document doc = crateDocument1.parse("E://users//joel caro g//documents//NetBeansProjects//TareaLog4j//tareaParsers.xml");
                                
                                elementoRaiz = doc.getDocumentElement();
                                NodeList lisAutos = elementoRaiz.getElementsByTagName("auto");
                                
                                for (int i = 0; i < lisAutos.getLength(); i++) {
                                    Node conse = lisAutos.item(i);
                                    System.out.println("auto: " + i);
                                    
                                    NodeList datosAutos = conse.getChildNodes();
                                    
                                    for (int j = 0; j < datosAutos.getLength() ; j++) {
                                        Node datos = datosAutos.item(j);
                                        
                                        if(datos.getNodeType() == Node.ELEMENT_NODE)
                                        {
                                                System.out.print(datos.getNodeName());
                                        }
                                        
                                        Node contenido = datos.getFirstChild();
                                        if(contenido != null){
                                            System.out.println(": " + contenido.getNodeValue());
                                        }
                                    }
                                    System.out.println("");
                                }
                        break;
                   
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        
     } 
  } 
    
