package jeux;

import java.awt.datatransfer.Transferable;
import java.io.Serializable;

public interface Prototype extends Transferable, Serializable {
    Prototype clone();
}
