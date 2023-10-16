import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "coches")
public class ListaCoches {
    private List<Coche> coches;

    public ListaCoches() {
        this.coches = new ArrayList<>();
    }

    @XmlElement(name = "coche")
    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    public void insertarCoche(Coche coche) {
        coches.add(coche);
    }

    @Override
    public String toString() {
        return "ListaCoches " +
                "coches :" + coches;
    }
}

