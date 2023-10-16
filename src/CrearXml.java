
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

public class CrearXml {

    public static void main(String[] args) {
        Coche coche = new Coche("Seat", "Ibiza", "1234ABC");
        Coche coche2 = new Coche("Citroen", "Xsara", "1234CBD");
        Coche.getCoches(coche);
        Coche.getCoches(coche2);
        try {
            cochesToXml(Coche.getCoches(coche));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void pasarCochesACocheXml(Coche c) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Coche.class);
        jaxbContext.createMarshaller().marshal(c, System.out);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(c, new java.io.File("coche.xml"));

    }

    public static void cochesToXml(List<Coche> coches) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Coche.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        marshaller.marshal(coches, sw);
        String xmlString = sw.toString();
        System.out.println(xmlString);
    }
}
