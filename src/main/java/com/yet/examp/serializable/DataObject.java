package com.yet.examp.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "dataObj")
public class DataObject extends NonSerializable implements Serializable {

    @XmlElement(required = true, name = "id")
    private int id;

    @XmlElement(required = true, name = "string")
    private String s;

    private transient String[] def;
    private CustomObject co;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(getMyData());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        String aa = (String) in.readObject();
        setMyData(aa);

    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String[] getDef() {
        return def;
    }

    public void setDef(String[] def) {
        this.def = def;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomObject getCo() {
        return co;
    }

    public void setCo(CustomObject co) {
        this.co = co;
    }

    @Override
    public String toString() {
        return "DataObject{" + "i=" + id + ", s=" + s + ", def=" + Arrays.toString(def) + ", co=" + co + '}';
    }

}
