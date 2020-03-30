/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author Joel Caro G
 */
public class TareaParsersHandler extends DefaultHandler{
private ArrayList<tareParsers> tarea = new ArrayList();
private tareParsers tp;
private StringBuilder buffer = new StringBuilder();

    public ArrayList<tareParsers> getTarea() {
        return tarea;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
            buffer.append(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName)
        {
//            case "concesionario":
//                
//                break;
             
            case "marca":
                 tp.setMarca(buffer.toString());
                 break;
            
            case "modelo":
                  tp.setModelo(buffer.toString());
                break;
            
            case "cilindrada":
                tp.setCilindrada(buffer.toString());
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName)
        {
//            case "concesionario":
//            break;
//            
            case "auto":
                tp = new tareParsers();
                tarea.add(tp);
                tp.setId((attributes.getValue("id")));
            break;
            
            case "marca":
                buffer.delete(0,buffer.length());
            break;
            
            case "modelo":
                buffer.delete(0,buffer.length());
            break;
            
            case "cilindrada":
                buffer.delete(0,buffer.length());
            break;
        }
    }
    
    
}
