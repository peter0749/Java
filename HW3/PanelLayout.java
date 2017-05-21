import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.util.Map;
import java.util.HashMap;

public class PanelLayout extends JFrame implements KeyListener
{
    // Layout:
    //
    // InfoText(Left) + 1 * GetAccuary button(Right)
    // TextArea(Align:left)
    // Label(Align:left)
    // Keyboard Layer [0]
    // Keyboard Layer [1]
    // Keyboard Layer [2]
    // Keyboard Layer [3]
    // Keyboard Layer [4]
    //
    private final String context;
    private final JLabel sampleText;
    private final JLabel infoText;
    private final JTextArea typeIn;
    private final JPanel[] buttonPanels;
    private final JPanel mainPanel;
    private final JButton getAccuracy;
    private final JButton[] buttons;
    private final String[] buttonName;
    private final int[] buttonLevel;
    private final Map<Integer,Integer> revKeyCodes;
    private final int[] keyCodes;
    private final Color[] oldColor;

    public PanelLayout() {
        super("Type Tutor");
        final int buttonNum = 57;
        final int panelNum  = 8;
        // Initialize buttonName:

        buttonName = new String[]{
            "~", "1", "2", "3",
            "4", "5", "6", "7",
            "8", "9", "0", "-",
            "=+", "Backspace", "Tab", "Q",
            "W", "E", "R", "T",
            "Y", "U", "I", "O",
            "P", "[", "]", "\\",
            "Caps", "A", "S", "D",
            "F", "G", "H", "J",
            "K", "L", ";:", "\'\"",
            "Enter", "Shift", "Z", "X",
            "C", "V", "B", "N",
            "M", ",", ".", "/?",
            "Space", "↑", "←", "↓", "→"
        };

        keyCodes = new int[]{
            192, 49, 50, 51, 52, 53, 54, 55, 56, 57,
            48 , 45, 61, 8 , 9 , 81, 87, 69, 82, 84,
            89 , 85, 73, 79, 80, 91, 93, 92, 20, 65,
            83 , 68, 70, 71, 72, 74, 75, 76, 59, 222,
            10 , 16, 90, 88, 67, 86, 66, 78, 77, 44,
            46 , 47, 32, 38, 37, 40, 39
        };

        buttonLevel = new int[]{ 14, 14, 13, 11, 5 };

        int buttonLevSum = 0;
        for (int v: buttonLevel) buttonLevSum+=v;
        if (keyCodes.length!=buttonNum || buttonName.length!=buttonNum || buttonLevSum!=buttonNum)
            throw new RuntimeException("Button Number not match!");

        oldColor = new Color[buttonNum];
        revKeyCodes = new HashMap<Integer,Integer>();
        for (int i=0; i<buttonNum; ++i) {
            revKeyCodes.put(keyCodes[i],i);
        }

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        infoText = new JLabel("<html> Type some text using your keyboard.<br/> The keys you press will be highlighted and the text will be displayed.<br/> <html>");
        buttons = new JButton[buttonNum]; 
        // Keyboard + GetAccuary (Top-Down)

        buttonPanels = new JPanel[panelNum];
        buttonPanels[0] = new JPanel();
        buttonPanels[0].setLayout(new BorderLayout());
        buttonPanels[0].add(infoText, BorderLayout.WEST);
        getAccuracy = new JButton("GetAccuary");
        buttonPanels[0].add(getAccuracy, BorderLayout.EAST);
        mainPanel.add(buttonPanels[0]);
        buttonPanels[1] = new JPanel();
        buttonPanels[1].setLayout(new BorderLayout());
        typeIn = new JTextArea();
        typeIn.setEnabled(false);
        buttonPanels[1].add(typeIn, BorderLayout.CENTER);
        mainPanel.add(buttonPanels[1]);
        buttonPanels[2] = new JPanel();
        buttonPanels[2].setLayout(new BorderLayout());
        context = new String("The quick brown fox jumped over a lazy dog.");
        sampleText = new JLabel("<html> Target: <br/>"+context+" </html>");
        buttonPanels[2].add(sampleText, BorderLayout.WEST);
        mainPanel.add(buttonPanels[2]);
        for (int pLev=3, bLev=0, buttCount=0; pLev!=buttonPanels.length; ++pLev, ++bLev) {
            buttonPanels[pLev] = new JPanel(new GridLayout(1, buttonLevel[bLev], 0, 0));
            for (int i=0; i!=buttonLevel[bLev]; ++i, ++buttCount) {
                buttons[buttCount] = new JButton( buttonName[buttCount] );
                buttons[buttCount].setEnabled(false);
                buttonPanels[pLev].add(buttons[buttCount]);
            }
            mainPanel.add(buttonPanels[pLev]);
        }
        add(mainPanel);
        this.setFocusable(true);
        addKeyListener(this);
    }
    @Override
    public void keyPressed(KeyEvent event) {
        Integer butt_idx = revKeyCodes.get(event.getKeyCode());
        if (butt_idx==null) return;
        oldColor[butt_idx] = buttons[butt_idx].getBackground();
        buttons[butt_idx].setBackground(Color.BLUE);
        buttons[butt_idx].setOpaque(true);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        Integer butt_idx = revKeyCodes.get(event.getKeyCode());
        if (butt_idx==null) return;
        buttons[butt_idx].setBackground(oldColor[butt_idx]);
        buttons[butt_idx].setOpaque(true);
    }

    @Override
    public void keyTyped(KeyEvent event) {
        // do nothing
    }
}
