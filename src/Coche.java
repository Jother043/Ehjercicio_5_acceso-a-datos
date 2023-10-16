import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Coche {
    String marca;
    String modelo;
    String matricula;

    static List<Coche> coches;


    public Coche(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        coches = new ArrayList<>();
    }

    public Coche() {

    }

    @XmlElement(name = "marca")
    public String getMarca() {
        return marca;
    }

    @XmlElement
    public String getModelo() {
        return modelo;
    }
    @XmlElement
    public String getMatricula() {
        return matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public static List<Coche> getCoches(Coche c) {
        coches = new ArrayList<>();
        coches.add(c);
        return coches;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }


}
