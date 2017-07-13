package com.yet.examp.serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Driver {

    static final String PACKAGE = DataObject.class.getPackage().getName();

    public static void main(String[] args) throws IOException, ClassNotFoundException, JAXBException {

        DataObject dataObject = new DataObject();
        dataObject.setId(10);
        dataObject.setS("Some string");
        
        CustomObject co = new CustomObject();
        co.setB(true);
        dataObject.setCo(co);
        
        dataObject.setDef(new String[]{"one", "two"});
        System.out.println("Original: "+dataObject);
        File f = new File("store.bin");

        //------------------------Serialization---------------------
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(f))) {
            objectOutputStream.writeObject(dataObject);
            objectOutputStream.flush();
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(f))) {
            DataObject newObj = (DataObject) inputStream.readObject();
            System.out.println("Serialization: "+newObj);
        }

        //------------------------JAXB------------------------------
        JAXBContext jc = JAXBContext.newInstance(PACKAGE);
        Marshaller m = jc.createMarshaller();
        Unmarshaller u = jc.createUnmarshaller();
        File f2 = new File("store2.bin");
        m.marshal(dataObject, f2);
        DataObject object = (DataObject) u.unmarshal(f2);
        System.out.println("JAXB: "+object);

        //------------------------GSON------------------------------
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(dataObject);
        System.out.println(json);
        DataObject obj = gson.fromJson(json, DataObject.class);
        System.out.println("JSON: "+obj);

    }
}
