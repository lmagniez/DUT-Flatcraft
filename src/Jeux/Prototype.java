package Jeux;

import java.awt.datatransfer.Transferable;

public interface Prototype extends Transferable {
    Prototype clone();
}
