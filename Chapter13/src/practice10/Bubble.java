package practice10;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class BubbleThread extends Thread {
    private JLabel jlb;
    private volatile boolean isPaused = false;

    public BubbleThread(JLabel jlb) {
        this.jlb = jlb;
    }

    public void pauseThread() {
        isPaused = true;
    }

    public void resumeThread() {
        isPaused = false;
        synchronized (this) {
            notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this) {
                    while (isPaused) {
                        wait();
                    }
                }
                Thread.sleep(100);
                if (jlb.getY() > 0) {
                    jlb.setLocation(jlb.getX(), jlb.getY() - 10);
                    jlb.getParent().repaint();
                }

                if (jlb.getY() <= 0) {
                    jlb.getParent().remove(jlb);
                    //jlb.getParent().repaint();
                    return;
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

public class Bubble extends JFrame {
    private ImageIcon bubbleImage = new ImageIcon(Bubble.class.getResource("bubble.png"));
    private Vector<BubbleThread> v = new Vector<>();

    public Bubble() {
        setTitle("ex10");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JLabel jlb = new JLabel(bubbleImage);
                jlb.setSize(50, 50);
                jlb.setLocation(e.getX() - 25, e.getY() - 25);
                c.add(jlb);

                BubbleThread th = new BubbleThread(jlb);
                v.add(th);
                th.start();
            }
        });

        c.setFocusable(true);
        c.requestFocus();

        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_S) { // Pause all threads
                    for (BubbleThread th : v) {
                        th.pauseThread();
                    }
                } else if (keyCode == KeyEvent.VK_R) { // Resume all threads
                    for (BubbleThread th : v) {
                        th.resumeThread();
                    }
                }
            }
        });

        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Bubble();
    }
}
