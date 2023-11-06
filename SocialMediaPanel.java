import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SocialMediaPanel extends JFrame {
    private DefaultListModel<User> friendListModel;
    private JList<User> friendList;
    private JTextField friendNameField;
    private JButton addButton;

    public SocialMediaPanel(List<User> users) {
        friendListModel = new DefaultListModel<>();
        friendList = new JList<>(friendListModel);
        friendNameField = new JTextField(20);
        addButton = new JButton("Add Friend");

        for (User user : users) {
            friendListModel.addElement(user);
        }

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newFriendName = friendNameField.getText().trim();
                if (!newFriendName.isEmpty()) {
                    User newFriend = new User(newFriendName);
                    friendListModel.addElement(newFriend);
                }
                friendNameField.setText("");
            }
        });

        setLayout(new FlowLayout());
        add(new JLabel("My Friends:"));
        add(friendList);
        add(new JLabel("Add Friend:"));
        add(friendNameField);
        add(addButton);

        setTitle("Social Media Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
