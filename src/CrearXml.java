
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.List;

public class CrearXml {

    public static void main(String[] args) {
        // Crear un objeto de tipo Coche
        Coche coche = new Coche("Seat", "Ibiza", "1234ABC");
        Coche coche2 = new Coche("Citroen", "Xsara", "1234CBD");
        Coche coche3 = new Coche("Audi", "S3", "4574FFD");
        // Crear un objeto de tipo ListaCoches
        ListaCoches listaCoches = new ListaCoches();
        // Insertar el objeto Coche en el objeto ListaCoches
        listaCoches.insertarCoche(coche);
        listaCoches.insertarCoche(coche2);
        listaCoches.insertarCoche(coche3);

        try {
            guardarListaCoches(listaCoches);
            xmlToListaCoches();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Método que recibe un objeto de tipo ListaCoches y lo convierte en un xml
     *
     * @param listaCoches
     * @throws JAXBException
     */
    public static void pasarCochesACocheXml(ListaCoches listaCoches) throws JAXBException {


        /*
         * 1. Crear un objeto de tipo JAXBContext pasándole la clase Coche.class
         * 2. Crear un objeto de tipo Marshaller a partir del objeto de tipo JAXBContext
         * 3. Configurar el objeto Marshaller para que el XML esté bien formateado
         * 4. Llamar al método marshal del objeto Marshaller pasándole el objeto Coche y el destino
         */
        JAXBContext jaxbContext = JAXBContext.newInstance(Coche.class);
        jaxbContext.createMarshaller().marshal(listaCoches, System.out);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(listaCoches, new java.io.File("coche.xml"));

    }

    /**
     * Método que recibe un xml y lo convierte en un objeto de tipo Coche y lo devuelve por pantalla
     * con el método toString de la clase Coche (ya implementado).
     *
     * @throws JAXBException
     */
    public static void guardarListaCoches(ListaCoches listaCoches) throws JAXBException {

            JAXBContext jaxbContext = JAXBContext.newInstance(ListaCoches.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file = new File("coche.xml");
            marshaller.marshal(listaCoches, file);
            marshaller.marshal(listaCoches, System.out);
    }

    /**
     * Método que recibe un xml y lo convierte en un objeto de tipo Coche y lo devuelve por pantalla
     * con el método toString de la clase Coche (ya implementado).
     *
     * @throws JAXBException
     */
    public static void xmlToCoche() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Coche.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("cocheBBDD.xml");
        Coche coche = (Coche) unmarshaller.unmarshal(file);
        System.out.println(coche);
    }

    /**
     * Método que recibe un xml y lo convierte en un objeto de tipo Coche y lo devuelve por pantalla
     * con el método toString de la clase Coche (ya implementado).
     *
     * @throws JAXBException
     */
    public static void xmlToListaCoches() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ListaCoches.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("coche.xml");
        ListaCoches listaCoches = (ListaCoches) unmarshaller.unmarshal(file);
        System.out.println(listaCoches.toString());
    }
}
