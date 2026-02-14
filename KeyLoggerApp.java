import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class KeyLoggerApp extends JFrame implements KeyListener {

    private JTextArea textArea;
    private FileWriter writer;

    public KeyLoggerApp() {
        setTitle("Java Keyboard Logger (Educational)");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.addKeyListener(this);
        add(new JScrollPane(textArea));

        try {
            writer = new FileWriter("key_log.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try {
            writer.write(e.getKeyChar());
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Optional: log special keys
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

    public static void main(String[] args) {
        new KeyLoggerApp();
    }
}