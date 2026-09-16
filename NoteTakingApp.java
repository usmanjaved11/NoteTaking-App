import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

// -------------------- Note Class --------------------
class Note {
    private String title;
    private String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    // Getter
    public String getContent() {
        return content;
    }

    // Setter
    public void setContent(String content) {
        this.content = content;
    }

    // Show title in JList
    public String toString() {
        return title;
    }
}

// -------------------- Main App Class --------------------
public class NoteTakingApp extends JFrame {

    // GUI Components
    private JTextField titleField;
    private JTextArea contentArea;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton loadButton;

    private DefaultListModel<Note> listModel;
    private JList<Note> noteList;

    // Store notes
    private ArrayList<Note> notes;

    // File name
    private final String FILE_NAME = "notes.txt";

    // Constructor
    public NoteTakingApp() {

        notes = new ArrayList<>();

        setTitle("Note Taking App");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ---------------- Left Panel ----------------
        listModel = new DefaultListModel<>();
        noteList = new JList<>(listModel);

        JScrollPane listScroll = new JScrollPane(noteList);
        listScroll.setPreferredSize(new Dimension(200, 500));

        add(listScroll, BorderLayout.WEST);

        // ---------------- Center Panel ----------------
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        titleField = new JTextField();
        titleField.setFont(new Font("Arial", Font.BOLD, 18));

        contentArea = new JTextArea();
        contentArea.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane textScroll = new JScrollPane(contentArea);

        centerPanel.add(titleField, BorderLayout.NORTH);
        centerPanel.add(textScroll, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        // ---------------- Bottom Panel ----------------
        JPanel buttonPanel = new JPanel();

        saveButton = new JButton("Save Note");
        deleteButton = new JButton("Delete Note");
        loadButton = new JButton("Load Notes");

        buttonPanel.add(saveButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(loadButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // ---------------- Button Actions ----------------

        // Save Note
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String title = titleField.getText();
                String content = contentArea.getText();

                if (title.isEmpty() || content.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter title and content");
                    return;
                }

                Note note = new Note(title, content);

                notes.add(note);
                listModel.addElement(note);

                saveNotesToFile();

                titleField.setText("");
                contentArea.setText("");

                JOptionPane.showMessageDialog(null,
                        "Note Saved Successfully!");
            }
        });

        // Delete Note
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int index = noteList.getSelectedIndex();

                if (index != -1) {

                    notes.remove(index);
                    listModel.remove(index);

                    saveNotesToFile();

                    titleField.setText("");
                    contentArea.setText("");

                    JOptionPane.showMessageDialog(null,
                            "Note Deleted!");
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "Please select a note");
                }
            }
        });

        // Load Notes
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadNotesFromFile();
            }
        });

        // Show selected note
        noteList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                Note selectedNote = noteList.getSelectedValue();

                if (selectedNote != null) {
                    titleField.setText(selectedNote.getTitle());
                    contentArea.setText(selectedNote.getContent());
                }
            }
        });

        // Load notes automatically
        loadNotesFromFile();

        setVisible(true);
    }

    // ---------------- Save Notes ----------------
    private void saveNotesToFile() {

        try {

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(FILE_NAME));

            for (Note note : notes) {

                writer.write(note.getTitle());
                writer.newLine();

                writer.write(note.getContent());
                writer.newLine();

                writer.write("-----");
                writer.newLine();
            }

            writer.close();

        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error saving notes");
        }
    }

    // ---------------- Load Notes ----------------
    private void loadNotesFromFile() {

        notes.clear();
        listModel.clear();

        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader(FILE_NAME));

            String title;

            while ((title = reader.readLine()) != null) {

                String content = reader.readLine();

                reader.readLine(); // skip -----

                Note note = new Note(title, content);

                notes.add(note);
                listModel.addElement(note);
            }

            reader.close();

        }
        catch (IOException e) {

            JOptionPane.showMessageDialog(null,
                    "No saved notes found");
        }
    }

    // ---------------- Main Method ----------------
    public static void main(String[] args) {

        new NoteTakingApp();
    }
}