package com.yet.examp.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class CustomObject implements Externalizable{

    private boolean b;

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }
    
    @Override
    public String toString() {
        return "CustomObject{" + "b=" + b + '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
       out.writeBoolean(b);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        in.readBoolean();
    }
    
    
}
