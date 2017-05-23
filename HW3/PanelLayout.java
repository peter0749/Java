import java.io.*;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.text.DefaultCaret;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JOptionPane;

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
    private final JLabel getAccuracy;
    private final JButton[] buttons;
    private final String[] buttonName;
    private final int[] buttonLevel;
    private final Map<Integer,Integer> revKeyCodes;
    private final int[] keyCodes;
    private final Color[] oldColor;
    private String inputText;
    private boolean capital;
    private File file;
    private BufferedReader reader;
    private final JScrollBar verticalSample;
    private final JScrollPane sampleScroll;

    public PanelLayout() {
        super("Type Tutor");
        final int buttonNum = 57;
        final int panelNum  = 10;
        File file = new File("context.txt");
        BufferedReader reader = null;
        String fullText = new String("");
        // try to open file

        try {
            reader = new BufferedReader(new FileReader(file));
            String textLine = null;
            while ((textLine = reader.readLine()) != null) {
                fullText += (textLine+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                // do nothing
            }
        }

        // Initialize buttonName:

        inputText = new String("");
        capital = false;

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
                "↑", "←", "↓", "→", "Space"
        };

        keyCodes = new int[]{
            192, 49, 50, 51, 52, 53, 54, 55, 56, 57,
                48 , 45, 61, 8 , 9 , 81, 87, 69, 82, 84,
                89 , 85, 73, 79, 80, 91, 93, 92, 20, 65,
                83 , 68, 70, 71, 72, 74, 75, 76, 59, 222,
                10 , 16, 90, 88, 67, 86, 66, 78, 77, 44,
                46 , 47, 38, 37, 40, 39, 32
        };

        buttonLevel = new int[]{ 14, 14, 13, 11, 1, 3, 1 };

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
        getAccuracy = new JLabel("Get Accuracy");
        buttonPanels[0].add( new JScrollPane(getAccuracy, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED) , BorderLayout.EAST);
        mainPanel.add(buttonPanels[0]);
        buttonPanels[1] = new JPanel();
        buttonPanels[1].setLayout(new BorderLayout());
        typeIn = new JTextArea();
        typeIn.setEnabled(false);
        buttonPanels[1].add( new JScrollPane(typeIn, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED) , BorderLayout.CENTER);
        mainPanel.add(buttonPanels[1]);
        buttonPanels[2] = new JPanel();
        buttonPanels[2].setLayout(new BorderLayout());
        context = fullText;
        sampleText = new JLabel("Press any key...");
        sampleScroll = new JScrollPane(sampleText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        verticalSample = sampleScroll.getVerticalScrollBar();
        buttonPanels[2].add( sampleScroll , BorderLayout.CENTER);
        mainPanel.add(buttonPanels[2]);
        int buttCount=0, bLev=0, pLev=3;
        for (; pLev!=buttonPanels.length; ++pLev, ++bLev) {
            buttonPanels[pLev] = new JPanel(new GridLayout(1, buttonLevel[bLev], 0, 0));
            if (bLev==5) {
                int n=buttonLevel[3]-buttonLevel[5];
                while(n-->0) buttonPanels[pLev].add(new JLabel());
            } else if (bLev==4) {
                int n=9;
                while(n-->0) buttonPanels[pLev].add(new JLabel());
            }
            for (int i=0; i!=buttonLevel[bLev]; ++i, ++buttCount) {
                buttons[buttCount] = new JButton( buttonName[buttCount] );
                buttons[buttCount].setEnabled(false);
                buttonPanels[pLev].add(buttons[buttCount]);
            }
            if (bLev==3) {
                buttonPanels[pLev].add(new JLabel());
                buttonPanels[pLev].add(new JLabel());
            } else if (bLev==4) {
                buttonPanels[pLev].add(new JLabel());
            }
            mainPanel.add(buttonPanels[pLev]);
        }
        add(mainPanel);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false); // disable built-in behavior
        addKeyListener(this);
    }
    @Override
    public void keyPressed(KeyEvent event) {
        Integer butt_idx = revKeyCodes.get(event.getKeyCode());
        if (butt_idx==null) return;
        oldColor[butt_idx] = buttons[butt_idx].getBackground();
        if (event.getKeyCode()==KeyEvent.VK_CAPS_LOCK || event.getKeyCode()==KeyEvent.VK_SHIFT) {
            buttons[butt_idx].setBackground(Color.BLUE);
            capital=!capital;
        } else if (textProcess(event)) {
            buttons[butt_idx].setBackground(Color.BLUE);
        } else {
            buttons[butt_idx].setBackground(Color.RED);
        }
        buttons[butt_idx].setOpaque(true);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        Integer butt_idx = revKeyCodes.get(event.getKeyCode());
        if (butt_idx==null) return;
        if (event.getKeyCode()==KeyEvent.VK_SHIFT) capital=!capital;
        buttons[butt_idx].setBackground(oldColor[butt_idx]);
        buttons[butt_idx].setOpaque(true);
    }

    @Override
    public void keyTyped(KeyEvent event) {
        String acc = computeAccuracy();
        getAccuracy.setText("<html>Accuracy:<br/>"+acc+"</html>");
        // do nothing
    }

    private String simpleEncoder(char ch) {
        if (ch==' ') return new String("&nbsp;");
        if (ch=='\n') return new String("<br/>");
        if (ch=='\t') return new String("&nbsp;&nbsp;&nbsp;&nbsp;");
        return new String(""+ch);
    }
    private boolean textProcess(KeyEvent event) {
        String tempStr;
        switch (event.getKeyCode()) {
            case KeyEvent.VK_BACK_SPACE:
                if (inputText.length()>0)
                    inputText = inputText.substring(0, inputText.length()-1);
                break;
            case KeyEvent.VK_TAB:
                inputText += "\t";
                break;
            case KeyEvent.VK_ENTER:
                inputText += "\n";
                break;
            case KeyEvent.VK_UP:
                inputText += "↑";
                break;
            case KeyEvent.VK_DOWN:
                inputText += "↓";
                break;
            case KeyEvent.VK_LEFT:
                inputText += "←";
                break;
            case KeyEvent.VK_RIGHT :
                inputText += "→";
                break;
            default:
                tempStr = new String(""+event.getKeyChar());
                inputText += (capital?tempStr.toUpperCase():tempStr.toLowerCase());
        }
        tempStr = new String("");
        final int max_charNum = 300;
        for (int i=inputText.length()>max_charNum?inputText.length()-max_charNum:0; i<context.length() && i<inputText.length()+30; ++i) {
            if(i<inputText.length()) {
                if (inputText.charAt(i)!=context.charAt(i)) {
                    tempStr += "<font color=\"red\">";
                    char ch = context.charAt(i);
                    tempStr += simpleEncoder( (ch==' '||ch=='\n')?'_':ch );
                    if (ch=='\n') tempStr += simpleEncoder('\n');
                    tempStr += "</font>";
                } else {
                    tempStr += "<font color=\"green\">";
                    tempStr += simpleEncoder(context.charAt(i));
                    tempStr += "</font>";
                }
            } else {
                tempStr += simpleEncoder(context.charAt(i));
            }
            if (i!=0&&i%80==0) tempStr+="-<br/>";
        }
        typeIn.setText(inputText);
        sampleText.setText("<html><div>"+tempStr+"</div></html>");
        verticalSample.setValue( verticalSample.getMaximum() );
        return !(inputText.length() > context.length() || 
                (inputText.length()>0 &&
                 inputText.charAt(inputText.length()-1)!=
                 context.charAt(inputText.length()-1) ) );
    }
    private String computeAccuracy() {
        int wrong=0;
        for (int i=0; i<context.length() && i<inputText.length(); ++i)
            if (inputText.charAt(i)!=context.charAt(i))
                ++wrong;
        wrong += (inputText.length()<context.length()?context.length()-inputText.length():0);
        return String.format("%d / %d", (context.length()-wrong), context.length());
    }
}
