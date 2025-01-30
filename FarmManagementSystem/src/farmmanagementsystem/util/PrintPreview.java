package farmmanagementsystem.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.MessageFormat;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;


/**
 * Add print preview functionality to any Swing Text component.
 *
 * <p>When active, the print preview frame temporary replaces on-screen the 
 * text component's window.</p>
 * 
 * <p>Keyboard shortcuts are available for zooming print preview images in and
 * out and for invoking the standard print dialog for the text component.</p>
 */
public class PrintPreview {
    
    private String headerText="";
    private String footerText="";
    
    public static final String Text_center = "(center)";
    public static final String Text_tab = "(tab)";
    public static final String Text_bold = "(bold)";
    public boolean ISLR = false;
    
    /** Swing Text component to generate preview for.  */
    private JTextComponent textPane = null;
    
    private JTable table = null;
    
    /** Container hosting the text component.  */
    private Container textHost = null;
    
    /** Pane holding the print preview images.  */
    private final JPanel previewPane;
    
    /** Container hosting the print preview pane.  */
    private final JFrame previewHost;
    
    /** Background thread for generating the print preview images.  */
    private Thread previewThread = null;
    
    /** Distance between images in the print preview pane.  */
    private static final int GAP = 5;
    
    /** Scale factor for the print preview images.  */
    private double previewScale = 0.75;

    // A set of user interface actions related to the print preview.
    
    private final Action printComponent = new AbstractAction("Print...") {
        public void actionPerformed(ActionEvent e) {
            printComponent();
        }
    };
    private final Action zoomIn = new AbstractAction("Zoom In") {
        public void actionPerformed(ActionEvent e) {
            setScale(previewScale * 1.1);
        }
    };
    private final Action zoomOut = new AbstractAction("Zoom Out") {
        public void actionPerformed(ActionEvent e) {
            setScale(previewScale / 1.1);
        }
    };
    private final Action closePreview = new AbstractAction("Close") {
        public void actionPerformed(ActionEvent e) {
            closePreview();
        }
    };

    // Keyboard shortcuts for the print preview actions.

    private static final KeyStroke PRINT_KEY =
            KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK);
    private static final KeyStroke ZOOM_IN_KEY =
            KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, ActionEvent.CTRL_MASK);
    private static final KeyStroke ZOOM_OUT_KEY =
            KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, ActionEvent.CTRL_MASK);
    private static final KeyStroke CLOSE_KEY =
            KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK);
    private static final KeyStroke ESCAPE_KEY =
            KeyStroke.getKeyStroke((char) KeyEvent.VK_ESCAPE);


    // The two methods that actually generate the print preview.

    /** Generate print preview images for the cached text component.  */
    MessageFormat fs,fd;
    private void generatePreview() {

        // What to print: the Printable object.
       //  p = textPane.getPrintable(null, null);
        previewHost.setIconImage(IconProvider.getImage());
        
        fs = new MessageFormat(headerText);
        String strDate = MessageFormat.format("{0,date,short} {0,time,short}", new java.util.Date());
                strDate +=" Page {0} "; 
        fd = new MessageFormat(footerText+"\n"+strDate);
//        Printable   p = table.getPrintable(JTable.PrintMode.FIT_WIDTH, fs, fd);
        Printable   p = GenerateTablePrintable.getPrintable(table,JTable.PrintMode.FIT_WIDTH, headerText, footerText);
        pri = p;
        // Print parameters: page width and height.
        PageFormat f = new PageFormat();         
        
            Paper pa = new Paper();
            pa.setSize((8.5 * 72), (13 * 72));
            pa.setImageableArea(0.5 * 72, 1 * 72, 6.5 * 72, 11 * 72);            
            f.setPaper(pa);            
            f.setOrientation(PageFormat.PORTRAIT);
        
        int width = (int) f.getWidth();
        int height = (int) f.getHeight();
//        System.out.println(f.getPaper().getWidth()+" "+f.getPaper().getHeight());

        // Stop generating images when the preview thread is interrupted.
        for (int n = 0; ! Thread.currentThread().isInterrupted(); n++) {
            
            // Where to print: the Graphics object.
            final Image pageImage = new BufferedImage(
                                width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics g = pageImage.getGraphics();

            
            try {
                // How to print: generate preview image of the n-th page.
                if (p.print(g, f, n) != Printable.PAGE_EXISTS) {
                    break;
                }
            } catch (Exception e) {
                break;
            }
            
            // This calls into Swing and should be scheduled to run on EDT.
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    addPage(pageImage);
                }
            });
        }
    }
 
    /** Scale the generated image and add it to the print preview pane.  */
    private void addPage(final Image pageImage) {

        // Create a component representing the scaled page preview image.
        JPanel p = new JPanel() {
            Image scaled = null;
            Dimension d = new Dimension();

            /** Return preview dimensions using the current scale factor.  */
            public Dimension getPreferredSize() {
                int w = (int) (pageImage.getWidth(null) * previewScale);
                int h = (int) (pageImage.getHeight(null) * previewScale);
                if ((d.width != w) || (d.height != h)) {
                    // Cached dimensions are invalid, re-scale the image.
                    scaled = pageImage.getScaledInstance(
                                d.width = w, d.height = h, Image.SCALE_SMOOTH);
                    setPreferredSize(new Dimension(
                                        d.width + 2 * GAP, d.height + 2 * GAP));
                }
                return super.getPreferredSize();
            }

            /** Minimum preview size is the same as the preferred size.  */
            public Dimension getMinimumSize() {
                return getPreferredSize();
            }

            /** Maximum preview size is the same as the preferred size.  */
            public Dimension getMaximumSize() {
                return getPreferredSize();
            }

            /** Clear the drawing area and paint the scaled image.  */
            public void paintComponent(Graphics g) {
                g.setColor(previewPane.getBackground());
                g.fillRect(0, 0, d.width + 2 * GAP, d.height + 2 * GAP);
                g.setColor(Color.WHITE);
                g.fillRect(GAP, GAP, d.width, d.height);
                if (scaled != null) {
                    g.drawImage(scaled, GAP, GAP, d.width, d.height, null);
                }
            }
        };

        // Add scaled image to the print preview pane and re-layout the pane.
        previewPane.add(p);
        previewPane.revalidate();
        previewPane.repaint();
    }


    // The PrintPreview public API methods.

    /**
     * Show the print preview frame and start generating preview images.
     *
     * @param pane      the text pane to generate preview for
     * @throws IllegalArgumentException     if {@code pane} is {@code null}
     */
    public void showPreview( JTable tab) {
        if (tab == null) {
            throw new IllegalArgumentException("text component required");
        }
        
        table = tab;
        

        if (previewThread == null) {
            // Place print preview frame over the text component's window.
           // textHost = textPane.getParent();
            textHost =  table.getParent();
            while ((textHost != null) && ! (textHost instanceof Window)) {
                textHost = textHost.getParent();
            }
            
            // Don't generate preview if the text component is not in a window.
            if ((textHost != null) && textHost.isVisible()) {
                previewPane.removeAll();
                replaceContainer(textHost, previewHost);
                
                // Rendering is time-consuming task and should be run off-EDT.
                previewThread = new Thread(new Runnable() {
                    public void run() {
                        generatePreview();
                    }
                });
                previewThread.start();
            }
        }
    }

    private BufferedImage imaged;
   public void showIMAGEPreview( BufferedImage img,Component c) {
        if (img == null) {
            throw new IllegalArgumentException("text component required");
        }
        table = null;
        imaged = img;
        

        if (previewThread == null) {
            // Place print preview frame over the text component's window.
           // textHost = textPane.getParent();
            textHost =  c.getParent();
            while ((textHost != null) && ! (textHost instanceof Window)) {
                textHost = textHost.getParent();
            }
            
            // Don't generate preview if the text component is not in a window.
            if ((textHost != null) && textHost.isVisible()) {
                previewPane.removeAll();
                replaceContainer(textHost, previewHost);
                // Rendering is time-consuming task and should be run off-EDT.
                previewThread = new Thread(new Runnable() {
                    public void run() {
                        generateIMAGEPreview();
                    }
                });
                previewThread.start();                                
            }
        }
    }

   private Image printingImage;
   private PageFormat Pformat;
    private void generateIMAGEPreview() {
    
        // What to print: the Printable object.
       //  p = textPane.getPrintable(null, null);
       // previewHost.setIconImage(PRINT_TEST.utilities.IconProvider.getImage());
        fs = new MessageFormat(headerText);
        String strDate = MessageFormat.format("{0,date,short} {0,time,short}", new java.util.Date());
                strDate +=" Page {0} "; 
        fd = new MessageFormat(footerText+"\n"+strDate);
//        Printable   p = table.getPrintable(JTable.PrintMode.FIT_WIDTH, fs, fd);


        // Print parameters: page width and height.
        PageFormat f = new PageFormat();         
        
            Paper pa = new Paper();
            pa.setSize((8.5 * 72), (13 * 72));
            pa.setImageableArea(0, 0,(8.5 * 72), (11 * 72));
            f.setPaper(pa);            
            f.setOrientation(PageFormat.PORTRAIT);
            Pformat = f;
        
        int width = (int) f.getWidth();
        int height = (int) f.getHeight();
//        System.out.println(f.getPaper().getWidth()+" "+f.getPaper().getHeight());

        // Stop generating images when the preview thread is interrupted.
//        for (int n = 0; ! Thread.currentThread().isInterrupted(); n++) {
//
//
            final Image pageImage = ComponentHouseResizer.resizeImageWithHint(imaged, width, height);
            Graphics g = pageImage.getGraphics();
            printingImage =  pageImage;

//  
//            try {
//                // How to print: generate preview image of the n-th page.
//                if (p.print(g, f, n) != Printable.PAGE_EXISTS) {
//                    break;
//                }
//            } catch (Exception e) {
//                break;
//            }
            
            // This calls into Swing and should be scheduled to run on EDT.
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    addPage(pageImage);
                }
            });
//        }
    }

        public BufferedImage generateOrientedIMAGE(BufferedImage image, boolean port) {
        // Print parameters: page width and height.
        PageFormat f = new PageFormat();

            Paper pa = new Paper();
            pa.setSize((8.5 * 72), (13 * 72));
            pa.setImageableArea(0, 0,(8.5 * 72), (11 * 72));
            f.setPaper(pa);
            if(port)
                f.setOrientation(PageFormat.PORTRAIT);
            else
                f.setOrientation(PageFormat.LANDSCAPE);         

        int width = (int) f.getWidth();
        int height = (int) f.getHeight();
//        System.out.println(f.getPaper().getWidth()+" "+f.getPaper().getHeight());

        // Stop generating images when the preview thread is interrupted.
//        for (int n = 0; ! Thread.currentThread().isInterrupted(); n++) {
//
//
           BufferedImage bg = ComponentHouseResizer.resizeImageWithHint(image, width, height);
           ((Graphics2D)bg.getGraphics()).rotate(Math.toRadians(10));
           return bg;
    }

    /**
     * Hide the print preview frame and stop generating preview images.
     */
    public void closePreview() {
        if (previewThread != null) {
            previewThread.interrupt();
            previewThread = null;
            replaceContainer(previewHost, textHost);
        }
    }

    /**
     * Display the standard print dialog for the text component.
     */
    public void printComponent() {

        if (table == null) {
            PrinterJob pr = PrinterJob.getPrinterJob();
            pr.pageDialog(Pformat);
            pr.setPrintable(new Printable() {

                @Override
                public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                    if (pageIndex != 0) {
                        return NO_SUCH_PAGE;
                    }
                    graphics.drawImage(printingImage, 0, 0, printingImage.getWidth(null), printingImage.getHeight(null), null);

                    return PAGE_EXISTS;
                }
            });
            try {
                pr.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        } else {
                    PrinterJob pr = PrinterJob.getPrinterJob();
                    pr.setPrintable(pri);
                try {
                    pr.print();
                } catch (PrinterException ex) {
                    ex.printStackTrace();
                 }
        }
    }

    Printable pri;


    /**
     * Set scale factor for the displayed print preview images.
     *
     * @param scale     the new scale factor for the preview images
     */
    public void setScale(double scale) {
        this.previewScale = scale;
        previewPane.revalidate();
        previewPane.repaint();
    }
    
    /**
     * Destroy the print preview frame and associated resources.
     */
    public void deletePreview() {
        closePreview();
        previewHost.dispose();
    }
        

    /** Replace on-screen the "from" Container by the "to" Container.  */
    private void replaceContainer(Container from, Container to) {
        to.setSize(from.getSize());
        to.setLocation(from.getLocation());
        to.setVisible(true);
        from.setVisible(false);
    }

    /**
     * Create and initialize the print preview components.
     */
    public PrintPreview() {
        previewPane = new JPanel();
        previewPane.setLayout(new BoxLayout(previewPane, BoxLayout.Y_AXIS));
        previewPane.registerKeyboardAction(closePreview, ESCAPE_KEY,
                                                    JComponent.WHEN_FOCUSED);

        JMenu menu = new JMenu("Preview");
        menu.setMnemonic(KeyEvent.VK_P);
        menu.add(createMenuItem(printComponent, KeyEvent.VK_P, PRINT_KEY));
        menu.add(createMenuItem(zoomIn, KeyEvent.VK_I, ZOOM_IN_KEY));
        menu.add(createMenuItem(zoomOut, KeyEvent.VK_O, ZOOM_OUT_KEY));
        menu.add(createMenuItem(closePreview, KeyEvent.VK_C, CLOSE_KEY));
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        previewHost = new JFrame("Print Preview") {
            protected void processWindowEvent(WindowEvent e) {
                super.processWindowEvent(e);
                if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                    closePreview();
                }
            }
            @Override
            public void setResizable(boolean resizable) {
                super.setResizable(resizable);
            }
        };
        previewHost.setJMenuBar(menuBar);
        previewHost.add(new JScrollPane(previewPane));

    }

    private JMenuItem createMenuItem(Action a, int mnemonic, KeyStroke accel) {
        JMenuItem item = new JMenuItem(a);
        item.setMnemonic(mnemonic);
        item.setAccelerator(accel);
        return item;
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public String getFooterText() {
        return footerText;
    }

    public void setFooterText(String footerText) {
        this.footerText = footerText;
    }
}

//printing image
//
//PrinterJob printJob = PrinterJob.getPrinterJob();
//printJob.setPrintable(new Printable() {
//        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
//                if (pageIndex != 0) {
//                    return NO_SUCH_PAGE;
//                }
//                graphics.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
//                return PAGE_EXISTS;
//        }
//});
//try {
//    printJob.print();
//} catch (PrinterException e1) {
//    e1.printStackTrace();
//}


