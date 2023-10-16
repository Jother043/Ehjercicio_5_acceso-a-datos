import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExtraerXML {
    private static List<Coche> coches;

    public ExtraerXML(List<Coche> coches) {
        ExtraerXML.coches = new ArrayList<>();
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        ExtraerXML.coches = coches;
    }

    public static void main(String[] args) {
        try {
            recuperarCocheDeXml();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Recupera un coche de un fichero XML
     *
     * @throws JAXBException
     */
    public static void recuperarCocheDeXml() throws JAXBException {
        try {
            File file = new File("coche.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Coche.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Coche coche = (Coche) jaxbUnmarshaller.unmarshal(file);
            System.out.println(Coche.coches.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
