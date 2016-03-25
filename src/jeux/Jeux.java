package jeux;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.TransferHandler;

import map.Map;
import outils.ToolInstance;
import run.MineUtils;

public class Jeux {
    private static Map map;
    private static Inventaire inv;
    private static Outils outils;
    private TableCraft craft;
    private JFrame frame = new JFrame();

    public Jeux() {
        super();
        MineUtils.prepareRessource();
        MineUtils.prepareOutils();
        this.map = new Map();
        this.inv = new Inventaire();
        this.inv.addMouseListener(mouselistener);

        this.outils = new Outils();
        this.craft = new TableCraft(frame, "Table de craft", false);

        JButton button = new JButton("Crafting");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionevent) {
                craft.setVisible(true);
            }
        });
        outils.add(button);
        outils.Initialize();

        this.frame = new JFrame("Jeux");
        prepare();
        changeCursorTo();
    }

    private void prepare() {
        frame.add(BorderLayout.WEST, MineUtils.scrollPane(outils));
        frame.add(BorderLayout.EAST, MineUtils.scrollPane(map.grid));
        frame.add(BorderLayout.SOUTH, MineUtils.scrollPane(inv));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

    public static Inventaire getInv() {
        return inv;
    }

    public static Outils getOutils() {
        return outils;
    }

    public static void changeCursorTo() {
        Component[] components = Jeux.getOutils().getComponents();

        for (int i = 1; i < components.length; i++) { // commence a 1 car le
                                                      // premier element est le
                                                      // bouton pour la table
            ToolInstance tmp = (ToolInstance) Jeux.getOutils().getComponent(i);
            if (tmp.isSelect())
                map.grid.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(tmp.getOutils().image.getImage(),
                        new Point(40, 40), ""));
        }
    }

    public static MouseListener mouselistener = new MouseAdapter() {
        public void mousePressed(MouseEvent me) {

            if ((me.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {

                JToggleButton comp = (JToggleButton) me.getSource();
                TransferHandler handler = comp.getTransferHandler();

                handler.exportAsDrag(comp, me, TransferHandler.COPY);
            }

        }
    };

}
