package jeux;

import java.awt.datatransfer.Transferable;
import java.io.Serializable;

/**
 * Interface Prototype
 */
public interface Prototype extends Transferable, Serializable {
    Prototype clone();
}
