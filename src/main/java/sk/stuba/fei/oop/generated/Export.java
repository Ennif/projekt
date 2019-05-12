package sk.stuba.fei.oop.generated;



import sk.stuba.fei.oop.implemented.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


public class Export {

    private String path;
    private PetriNets net;

    public Export(PetriNets net) {
        this.net = net;
    }


    public void exportToXml(String path){
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            ObjectFactory of = new ObjectFactory();
            Document document = of.createDocument();
            marshalTransition(document,of);
            marshalPlaces(document,of);

            File file = new File(path+ ".xml");


            marshaller.marshal(document,file);
        } catch (JAXBException e) {

        }
    }

    private void marshalTransition(Document document, ObjectFactory of){
        for (sk.stuba.fei.oop.implemented.Transition tr : net.getTransition()) {
            Transition transition =of.createTransition();
            transition.setId((int)tr.getID());
            transition.setX((int)tr.getxPosition());
            transition.setY((int)tr.getyPosition());
            transition.setLabel(tr.getName());
            document.getTransition().add(transition);
            marshalEdges(document,of,tr);
        }
    }

    private void marshalEdges(Document document, ObjectFactory of, sk.stuba.fei.oop.implemented.Transition transition){

        for (EdgeFromTransitionToPlace edge : transition.getListOfTransitionToPlaceEdges()){
            Arc arc = of.createArc();
            arc.setId((int)edge.getID());
            arc.setSourceId((int)(edge.getFirstElement().getID()));
            arc.setDestinationId((int)(edge.getSecondElement().getID()));
            arc.setMultiplicity(edge.getWeight());
            arc.setType(ArcType.REGULAR);
            document.getArc().add(arc);
        }
        for (EdgeFromPlaceToTransition edge : transition.getListOfPlaceToTransitionEdges()){
            Arc arc = of.createArc();
            arc.setId((int)edge.getID());
            arc.setSourceId((int)(edge.getFirstElement().getID()));
            arc.setDestinationId((int)(edge.getSecondElement().getID()));
            arc.setMultiplicity(edge.getWeight());
            arc.setType(ArcType.REGULAR);
            document.getArc().add(arc);
        }

        for (ResetEdge resetEdge : transition.getListOfResetEdges()) {
            Arc arc = of.createArc();
            arc.setId((int)resetEdge.getID());
            arc.setSourceId((int)(resetEdge.getFirstElement().getID()));
            arc.setDestinationId((int)(resetEdge.getSecondElement().getID()));
            arc.setType(ArcType.RESET);
            document.getArc().add(arc);

        }

    }

    private void marshalPlaces(Document document, ObjectFactory of){
        for (sk.stuba.fei.oop.implemented.Place pl : net.getPlace()) {
            Place place =of.createPlace();
            place.setId((int)pl.getID());
            place.setX((int)pl.getxPosition());
            place.setY((int)pl.getyPosition());
            place.setLabel(pl.getName());
            place.setTokens((int)pl.getTokens());
            document.getPlace().add(place);
        }
    }
}
