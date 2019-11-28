package main.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import main.model.CargoType;
import main.model.Fleet;
import main.model.Vehicle;

public class VehicleDBService implements IDBService {

	private String dbPath = "src/main/service/vehicles.xml";
	private Document dataDoc;
	private Fleet vehicles = new Fleet();

	public VehicleDBService(String filepath) throws ParserConfigurationException, SAXException, IOException {

		this.dbPath = filepath;
		File data = new File(dbPath);
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = dbfactory.newDocumentBuilder();
		dataDoc = documentBuilder.parse(data);

		NodeList vehicleNodes = dataDoc.getElementsByTagName("vehicle");

		for (int i = 0; i < vehicleNodes.getLength(); i++) {
			String tempFName = dataDoc.getElementsByTagName("capacity").item(i).getTextContent();
			String tempLName = dataDoc.getElementsByTagName("volume").item(i).getTextContent();
			String tempID = dataDoc.getElementsByTagName("ID").item(i).getTextContent();
			String tempPersonNo = dataDoc.getElementsByTagName("cargo").item(i).getTextContent();
			Vehicle tempVehicle = new Vehicle();

			tempVehicle.setCapacity(Integer.parseInt(tempFName));
			tempVehicle.setVolume(Integer.parseInt(tempLName));
			tempVehicle.setID(tempID);
			tempVehicle.setCargoType(Enum.valueOf(CargoType.class, tempPersonNo));

			vehicles.addVehicle(tempVehicle);

		}
	}

	@Override
	public boolean write() throws Exception {

		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

		Document document = documentBuilder.newDocument();

		// root element
		Element root = document.createElement("root");
		document.appendChild(root);

		// list of members
		Element vehicleNodes = document.createElement("vehicles");

		root.appendChild(vehicleNodes);

		// create members

		for (Vehicle v : vehicles) {

			// create member

			Element vehicleElement = document.createElement("vehicle");

			// add fName
			Element capacity = document.createElement("capacity");
			capacity.appendChild(document.createTextNode(Integer.toString(v.getCapacity())));
			vehicleElement.appendChild(capacity);

			// add lName
			Element volume = document.createElement("volume");
			volume.appendChild(document.createTextNode(Integer.toString(v.getVolume())));
			vehicleElement.appendChild(volume);

			// add memberID
			Element ID = document.createElement("ID");
			ID.appendChild(document.createTextNode(v.getID()));
			vehicleElement.appendChild(ID);

			// add phoneNo
			Element cargo = document.createElement("cargo");
			cargo.appendChild(document.createTextNode(v.getCargoType().toString()));
			vehicleElement.appendChild(cargo);

			// add member to memberlist
			vehicleNodes.appendChild(vehicleElement);
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;

		transformer = transformerFactory.newTransformer();

		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new File(dbPath));

		// If you use
		// StreamResult result = new StreamResult(System.out);
		// the output will be pushed to the standard output ...
		// You can use that for debugging

		transformer.transform(domSource, streamResult);

		return true;

	}

	public boolean addVehicle(Vehicle vehicle) throws Exception {
		if (vehicle.getID() == null || vehicle.getID() == "") {
			vehicle.setID(generateID());
		}

		return vehicles.addVehicle(vehicle) && write();
	}

	private String generateID() {
		return UUID.randomUUID().toString();
	}

	public boolean removeVehicle(Vehicle vehicle) throws Exception {
		return vehicles.removeVehicle(vehicle) && write();
	}

	public Fleet getFleet() {
		return this.vehicles;
	}

}
