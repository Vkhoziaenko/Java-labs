import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserDom {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        List<User> users = new ArrayList<>();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("src\\dataset.xml"));
        NodeList elements = doc.getElementsByTagName("record");
        for (int i = 0; i < elements.getLength(); i++) {
            NodeList child = elements.item(i).getChildNodes();
            List<String> list = new ArrayList<>();
            for(int j=0;j<child.getLength();j++){
                list.add(child.item(j).getTextContent());
                //System.out.println("\t"+child.item(j).getTextContent());
            }
            users.add(new User(Integer.parseInt(list.get(0)), list.get(1), list.get(2), list.get(3), list.get(4)));
        }
        for(User u : users){
            System.out.println(u.toString());
        }
    }
}
