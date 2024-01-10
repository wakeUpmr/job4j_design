package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "show")
@XmlAccessorType(XmlAccessType.FIELD)
public class Show {
    @XmlAttribute
    private boolean closed;
    @XmlAttribute
    private int seasonNumber;
    private Cast cast;
    @XmlElementWrapper(name = "genres")
    @XmlElement(name = "genre")
    private String[] genres;

    public Show() { }

    public Show(boolean closed, int seasonNumber, Cast cast, String[] genres) {
        this.closed = closed;
        this.seasonNumber = seasonNumber;
        this.cast = cast;
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Show{"
                + "closed=" + closed
                + ", seasonNumber=" + seasonNumber
                + ", cast=" + cast
                + ", genres=" + Arrays.toString(genres)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Show houseOfCards = new Show(true, 6, new Cast("Kevin Spacey"),
                new String[] {"Drama", "Political Thriller"});
        JAXBContext context = JAXBContext.newInstance(Show.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(houseOfCards, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

