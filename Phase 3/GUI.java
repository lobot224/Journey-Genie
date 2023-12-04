import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;
import java.awt.print.*;


public class GUI extends JFrame {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private List<String> selectedLocations;
    public int budgetAmount; 

    public Container getContentPane() {
        return super.getContentPane();

    }
    public Container getCardPanel() {
        return getCardPanel();
    }
    public GUI() {
        frame = new JFrame("JourneyGenius");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        selectedLocations = new ArrayList<>();

        createStartScreen();
        createSelectionScreen();
        createInfoScreen();
        createInfo2Screen();
        createInfo3Screen();
        createInfo4Screen(); 
        createInfo5Screen();
        createInfo6Screen();
        createInfo7Screen();
        createFinishScreen();
        createListScreen();
        createBudgetScreen(); 

        frame.add(cardPanel);
        frame.setVisible(true);
    }

    private void createStartScreen() {
        JPanel startScreen = new JPanel(new BorderLayout());
    
        // Title label
        JLabel titleLabel = new JLabel("JourneyGenius");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
    
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city = JOptionPane.showInputDialog(frame, "Enter the city you want to visit:");
                if (city != null && !city.isEmpty()) {
                    System.out.println("City selected: " + city);
                    cardLayout.show(cardPanel, "budgetScreen");
                } else {
                    JOptionPane.showMessageDialog(frame, "City is required. Please enter a city name.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    
        JButton aboutUsButton = new JButton("About Us");
        aboutUsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "We are a group of software and computer engineers who are passionate about creating simple solutions for common problems! \nWe created TravelGenius because we recognized a shared challenge among travelers: planning a trip can be time-consuming and overwhelming. \nTravelGenius aims to simplify the process by organizing the travel plans by itself. \nWe hope you enjoy using our app!​", "About Us", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(frame, "Do you want to exit the program?", "Exit Program", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(startButton);
        buttonPanel.add(aboutUsButton);
        buttonPanel.add(exitButton);
    
        startScreen.add(titleLabel, BorderLayout.NORTH);
        startScreen.add(buttonPanel, BorderLayout.CENTER);
    
        cardPanel.add(startScreen, "startScreen");
    }
//in progress 
private void createBudgetScreen() {
    JPanel budgetScreen = new JPanel(new BorderLayout());

    // Title label
    JLabel titleLabel = new JLabel("Budget Your Trip!");
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    titleLabel.setFont(new Font("Serif", Font.BOLD, 24));

    // Add a label to specify that the user needs to enter an integer value
    JLabel instructionLabel = new JLabel("Please enter your budget:");
    instructionLabel.setHorizontalAlignment(SwingConstants.CENTER);
    budgetScreen.add(instructionLabel, BorderLayout.NORTH);

    final JTextField textField = new JTextField();
    textField.setPreferredSize(new Dimension(150, 30)); // Adjust the size as needed
    JButton submitButton = new JButton("Submit");

    submitButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String input = textField.getText().trim();

        if (input.isEmpty()) {
            // Display an error message for empty input
            JOptionPane.showMessageDialog(null, "Please enter a valid budget.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                // Parse the text field input to an integer
                double budgetAmount = Double.parseDouble(input);
                System.out.println("Entered budget: " + budgetAmount);
                // Update your tokens variable here

                // Switch to the 'selectionScreen'
                CardLayout cl = (CardLayout) (cardPanel.getLayout());
                cl.show(cardPanel, "selectionScreen");
            } catch (NumberFormatException ex) {
                // Handle the case where the input was not a valid number
                JOptionPane.showMessageDialog(null, "Please enter a valid number for the budget.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
});


    JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    inputPanel.add(textField);
    
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.add(submitButton);

    budgetScreen.add(titleLabel, BorderLayout.NORTH);
    budgetScreen.add(inputPanel, BorderLayout.CENTER);
    budgetScreen.add(buttonPanel, BorderLayout.SOUTH);

    cardPanel.add(budgetScreen, "budgetScreen");
}



    private void createSelectionScreen() {
        JPanel selectionScreen = new JPanel(new BorderLayout());
    
        JButton selectionButton = new JButton("Downtown Dallas"); //First selection 
        selectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "infoScreen");
            }
        });
    
        JButton selectionButton2 = new JButton("The Eye"); // Second selection 
        selectionButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "info2Screen");
            }
        });

            JButton selectionButton3 = new JButton("State Fair"); // Third selection
            selectionButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "info3Screen");
            }
        });

        JButton selectionButton4 = new JButton("UTD"); // Fourth selection
            selectionButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "info4Screen");
            }
        });

        JButton selectionButton5 = new JButton("Dallas Art Museum"); // Fifth selection
            selectionButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "info5Screen");
            }
        });

        JButton selectionButton6 = new JButton("Reunion Tower"); // Sixth selection
            selectionButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "info6Screen");
            }
        });

        JButton selectionButton7 = new JButton("Six Flags"); // Sixth selection (Final for now)
            selectionButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "info7Screen");
            }
        });
    
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(selectionButton);
        buttonPanel.add(selectionButton2);
        buttonPanel.add(selectionButton3); 
        buttonPanel.add(selectionButton4);
        buttonPanel.add(selectionButton5);
        buttonPanel.add(selectionButton6);
        buttonPanel.add(selectionButton7);
    
        JButton finishButton = new JButton("Finish");
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!selectedLocations.isEmpty()) {
                    cardLayout.show(cardPanel, "listScreen");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select at least one location to visit.", "Error", JOptionPane.WARNING_MESSAGE);
                }
                            System.out.println("Selected Locations: " + selectedLocations); // Print the selected locations to the console
            }
        });
    
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(frame, "Do you want to save your progress?", "Save Progress?", JOptionPane.YES_NO_CANCEL_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    // Save progress
                    // Save logic to be implemented later, likely a simple local .txt file to read from 
                }
                if (choice != JOptionPane.CANCEL_OPTION) {
                    selectedLocations.clear();
                    cardLayout.show(cardPanel, "startScreen");
                }
            }
        });
    
        selectionScreen.add(buttonPanel, BorderLayout.CENTER);
        selectionScreen.add(finishButton, BorderLayout.NORTH);
        selectionScreen.add(exitButton, BorderLayout.SOUTH);
        cardPanel.add(selectionScreen, "selectionScreen");
    }

    /* 
     * Our first attraction: Downtown Dallas
     */

    private void createInfoScreen() {
        JPanel infoScreen = new JPanel(new BorderLayout());
    
        JLabel titleLabel = new JLabel("Downtown Dallas");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
        JPanel contentPanel = new JPanel(new BorderLayout());
    
        // Create a panel for the image
        JPanel imagePanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("attraction.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imagePanel.add(imageLabel);
    
        // Create a panel for the text
        JPanel textPanel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea("Downtown Dallas is the vibrant heart of the city, filled with a unique blend of skyscrapers, historic landmarks, and bustling city life. It’s a must-visit for any traveler!\n\nHere are some highlights you can expect when you visit:\n> Attractions: Downtown Dallas is home to a wide range of attractions, from the stunning architecture of the skyscrapers to the historic landmarks that tell the story of the city’s past. Don’t miss out on family-friendly attractions like the Perot Museum of Nature and Science.\n> Dining: Downtown Dallas offers a diverse culinary scene, with everything from upscale dining to food trucks. Whether you’re in the mood for Texan mainstays like tacos, steak and barbecue or internationally-inspired dishes like Laotian boat noodles, ceviche and sashimi, there’s an unforgettable meal waiting for you.\n> Shopping: From high-end boutiques to local markets, shopping in Downtown Dallas is a treat. You’ll find everything from fashion and accessories to home goods and souvenirs.\n> Events: Downtown Dallas hosts a variety of events throughout the year, including concerts, festivals, and cultural celebrations. Be sure to check out the local calendar for upcoming events during your visit.\n\nWhether you’re a first-time visitor or a seasoned traveler, Downtown Dallas offers an enriching and inspiring experience. So why wait? Plan your visit today!"        );
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textPanel.add(textArea);
    
        // Create a panel for buttons in the EAST region
        JPanel buttonPanel = new JPanel();
        JButton backButton1 = new JButton("Back");
        backButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "selectionScreen");
            }
        });
         JButton bookButton1 = new JButton("Book");
        bookButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedLocations.size() < 4) {
                    String locationName = "Downtown Dallas"; // Replace with the actual location name
                    if (bookButton1.getText().equals("Book")) {
                        bookButton1.setText("Unbook");
                        selectedLocations.add(locationName);
                    } else {
                        bookButton1.setText("Book");
                        selectedLocations.remove(locationName);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You have reached the maximum booking limit (4 items).", "Booking Limit Exceeded", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        buttonPanel.add(backButton1); // Add the Back button to the buttonPanel
        buttonPanel.add(bookButton1);
    
        // Add the image and text panels to the content panel
        contentPanel.add(imagePanel, BorderLayout.WEST);
        contentPanel.add(textPanel, BorderLayout.CENTER);
    
        // Add the button panel to the content panel
        contentPanel.add(buttonPanel, BorderLayout.EAST);
    
        infoScreen.add(titleLabel, BorderLayout.NORTH);
        infoScreen.add(contentPanel, BorderLayout.CENTER);
        cardPanel.add(infoScreen, "infoScreen");
    }
    
    
    
    
    /* 
     * Our second attraction: The Dallas Eye
     */

    private void createInfo2Screen() {
        JPanel info2Screen = new JPanel(new BorderLayout());
    
        JLabel titleLabel = new JLabel("The Dallas Eye");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
        JPanel contentPanel = new JPanel(new BorderLayout());
    
        // Create a panel for the image
        JPanel imagePanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("attraction2.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imagePanel.add(imageLabel);
    
        // Create a panel for the text
        JPanel textPanel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea("The Eye is a unique art installation located in downtown Dallas, Texas. This three-story gleaming orb rests in the lush garden off Main Street and is hard to miss!\n" + //
                "\n" + //
                "Here are some highlights you can expect when you visit:\n" + //
                "> The Sculpture: The Eye is a 30-foot-tall sculpture created by artist Tony Tasset in 2007. It’s modeled after Tasset’s own eye and is made of fiberglass. The big eyeball spent a few years in storage, made a brief appearance in St. Louis, and was finally brought to Texas in 2013.\n" + //
                "> Location: The Eye is located outside of the swanky Joule Hotel in downtown Dallas. It’s turned into a big hit on social media and is one of the city’s most distinctive landmarks.\n" + //
                "> Significance: While the artist denies any deep symbolism behind the work, the plot of land The Eye sits on does have historic significance. What used to stand where the Eyeball now sits is probably Dallas’ first skyscraper, the Praetorian Building.\n" + //
                "\n" + //
                "Whether you’re a local or a tourist, the Eye offers an intriguing and memorable experience. So why wait? Plan your visit today!");
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textPanel.add(textArea);
    
        // Create a panel for buttons in the EAST region
        JPanel buttonPanel = new JPanel();
        JButton backButton2 = new JButton("Back");
        backButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "selectionScreen");
            }
        });
        
        JButton bookButton2 = new JButton("Book");
        bookButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedLocations.size() < 4) {
                    String locationName = "The Eye"; // Replace with the actual location name
                    if (bookButton2.getText().equals("Book")) {
                        bookButton2.setText("Unbook");
                        selectedLocations.add(locationName);
                    } else {
                        bookButton2.setText("Book");
                        selectedLocations.remove(locationName);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You have reached the maximum booking limit (4 items).", "Booking Limit Exceeded", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        buttonPanel.add(backButton2); // Add the Back button to the buttonPanel
        buttonPanel.add(bookButton2);
    
        // Add the image and text panels to the content panel
        contentPanel.add(imagePanel, BorderLayout.WEST);
        contentPanel.add(textPanel, BorderLayout.CENTER);
    
        // Add the button panel to the content panel
        contentPanel.add(buttonPanel, BorderLayout.EAST);
    
        info2Screen.add(titleLabel, BorderLayout.NORTH);
        info2Screen.add(contentPanel, BorderLayout.CENTER);
        cardPanel.add(info2Screen, "info2Screen");
    }
    
/*
 * Our third attraction: The Dallas State Fair
 */
    
    private void createInfo3Screen() {
        JPanel info3Screen = new JPanel(new BorderLayout());
    
        JLabel titleLabel = new JLabel("The Dallas State Fair");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
        JPanel contentPanel = new JPanel(new BorderLayout());
    
        // Create a panel for the image
        JPanel imagePanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("attraction3.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imagePanel.add(imageLabel);
    
        // Create a panel for the text
        JPanel textPanel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea("The State Fair of Texas is a grand annual event held in Dallas, Texas. It’s a celebration of all things Texan and offers a variety of attractions for visitors of all ages.\n\nHere are some highlights you can expect when you visit:\n> Attractions: The fair offers a wide range of attractions, from thrilling rides and games to live music and performances. There’s something for everyone!\n> Food: Texas is known for its food, and the State Fair is no exception. From classic fair food like corn dogs and funnel cakes to unique culinary creations, there’s plenty to satisfy your taste buds.\n> Exhibits: The fair features a variety of exhibits that showcase the best of Texas. From agriculture and livestock to art and culture, there’s always something new to learn.\n> Events: The State Fair hosts a number of events throughout its run, including concerts, competitions, and special themed days.\n\nWhether you’re a first-time visitor or a seasoned fair-goer, the State Fair of Texas offers an enriching and fun-filled experience. So why wait? Plan your visit today!");
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textPanel.add(textArea);
    
        // Create a panel for buttons in the EAST region
        JPanel buttonPanel = new JPanel();
        JButton backButton3 = new JButton("Back");
        backButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "selectionScreen");
            }
        });
    
        JButton bookButton3 = new JButton("Book");
        bookButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedLocations.size() < 4) {
                    String locationName = "The State Fair"; // Replace with the actual location name
                    if (bookButton3.getText().equals("Book")) {
                        bookButton3.setText("Unbook");
                        selectedLocations.add(locationName);
                    } else {
                        bookButton3.setText("Book");
                        selectedLocations.remove(locationName);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You have reached the maximum booking limit (4 items).", "Booking Limit Exceeded", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        buttonPanel.add(backButton3); // Add the Back button to the buttonPanel
        buttonPanel.add(bookButton3);
    
        // Add the image and text panels to the content panel
        contentPanel.add(imagePanel, BorderLayout.WEST);
        contentPanel.add(textPanel, BorderLayout.CENTER);
    
        // Add the button panel to the content panel
        contentPanel.add(buttonPanel, BorderLayout.EAST);
    
        info3Screen.add(titleLabel, BorderLayout.NORTH);
        info3Screen.add(contentPanel, BorderLayout.CENTER);
        cardPanel.add(info3Screen, "info3Screen");
    }
/*
* Our fourth attraction: The University of Texas at Dallas 
*/    

    private void createInfo4Screen() {
        JPanel info4Screen = new JPanel(new BorderLayout());
    
        JLabel titleLabel = new JLabel("The University of Texas at Dallas");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
        JPanel contentPanel = new JPanel(new BorderLayout());
    
        // Create a panel for the image
        JPanel imagePanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("attraction4.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imagePanel.add(imageLabel);
    
        // Create a panel for the text
        JPanel textPanel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea("The University of Texas at Dallas (UT Dallas) is a public research university in Richardson, Texas, a suburb of Dallas. It is the largest public university in the Dallas area and a hub of education, innovation, and culture.\n" + //
                "\n" + //
                "Here are some highlights you can expect when you visit:\n" + //
                "> Timing of Arrival: The immigration regulations allow F-1 and J-1 students to enter the United States no earlier than 30 days prior to the start date on the I-20 or DS-2019. Consider dates of all required orientations (International Student Orientation, TA/RA Orientation or Academic Orientation) when choosing the appropriate arrival date.\n" + //
                "> What to Pack: The weather in Texas changes with the seasons. It is very hot during the summer (highs around 100 degrees Fahrenheit/37 degrees Celsius), and cold in the winter (lows around 32 degrees Fahrenheit/0 degrees Celsius). While there is no formal dress code at U.S. universities, most students dress casually, such as jeans and shirts. It is recommended that you bring at least one semi-formal outfit.\n" + //
                "> Traveling to Dallas, Texas: There are many available options to travel to campus. Please note that effective May 12, 2023, noncitizen nonimmigrant air passengers no longer need to show proof of being fully vaccinated with an accepted COVID-19 vaccine to board a flight to the United States.\n" + //
                "\n" + //
                "Whether you’re a prospective student planning your education, a researcher seeking collaboration, or a visitor looking to explore the campus, UT Dallas offers an enriching and inspiring experience. So why wait? Plan your visit today!");
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textPanel.add(textArea);
    
        // Create a panel for buttons in the EAST region
        JPanel buttonPanel = new JPanel();
        JButton backButton4 = new JButton("Back");
        backButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "selectionScreen");
            }
        });
    
        JButton bookButton4 = new JButton("Book");
        bookButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedLocations.size() < 4) {
                    String locationName = "The University of Texas at Dallas"; 
                    if (bookButton4.getText().equals("Book")) {
                        bookButton4.setText("Unbook");
                        selectedLocations.add(locationName);
                    } else {
                        bookButton4.setText("Book");
                        selectedLocations.remove(locationName);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You have reached the maximum booking limit (4 items).", "Booking Limit Exceeded", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        buttonPanel.add(backButton4); 
        buttonPanel.add(bookButton4);
    
        // Add the image and text panels to the content panel
        contentPanel.add(imagePanel, BorderLayout.WEST);
        contentPanel.add(textPanel, BorderLayout.CENTER);
    
        // Add the button panel to the content panel
        contentPanel.add(buttonPanel, BorderLayout.EAST);
    
        info4Screen.add(titleLabel, BorderLayout.NORTH);
        info4Screen.add(contentPanel, BorderLayout.CENTER);
        cardPanel.add(info4Screen, "info4Screen");
    }
    
/* 
 * Our fifth attraction, The Dallas Art Museusm 
 */

    private void createInfo5Screen() {
        JPanel info5Screen = new JPanel(new BorderLayout());
    
        JLabel titleLabel = new JLabel("Dallas Art Museum");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
        JPanel contentPanel = new JPanel(new BorderLayout());
    
        // Create a panel for the image
        JPanel imagePanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("attraction5.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imagePanel.add(imageLabel);
    
        // Create a panel for the text
        JPanel textPanel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea("The Dallas Museum of Art is a renowned art museum located in the heart of the Dallas Arts District. It’s a must-visit for any art enthusiast!\n" + //
                "\n" + //
                "The museum, which dates back to 1903, has grown from a small group of art aficionados at the Dallas Public Library into a 370,000-square-foot space that houses a vast and diverse collection of artworks.\\n" + //
                "\n" + //
                "Here are some highlights you can expect when you visit:\n" + //
                "> Permanent Collections: The museum’s permanent collections span 5,000 years of history and a full range of world cultures, including the arts of Africa, Oceania, and the Americas; American painting, sculpture, and decorative arts; contemporary art; European painting, sculpture, and decorative arts; and more.\n" + //
                "> Rotating Exhibits: The museum regularly hosts rotating exhibits from around the world, offering visitors a chance to experience new and exciting works of art.\n" + //
                "> Educational Programs: The Dallas Museum of Art is committed to education and offers a variety of programs for visitors of all ages. From lectures and concerts to family activities and more, there’s always something happening at the museum.\n" + //
                "> Community Outreach: The museum is deeply involved in the community and strives to make art accessible to everyone through its outreach efforts.\n" + //
                "\n" + //
                "Whether you’re a first-time visitor or a seasoned art enthusiast, the Dallas Museum of Art offers an enriching and inspiring experience. So why wait? Plan your visit today!");
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textPanel.add(textArea);
    
        // Create a panel for buttons in the EAST region
        JPanel buttonPanel = new JPanel();
        JButton backButton5 = new JButton("Back");
        backButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "selectionScreen");
            }
        });
    
        JButton bookButton5 = new JButton("Book");
        bookButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedLocations.size() < 4) {
                    String locationName = "The Dallas Museum of Art"; 
                    if (bookButton5.getText().equals("Book")) {
                        bookButton5.setText("Unbook");
                        selectedLocations.add(locationName);
                    } else {
                        bookButton5.setText("Book");
                        selectedLocations.remove(locationName);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You have reached the maximum booking limit (4 items).", "Booking Limit Exceeded", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        buttonPanel.add(backButton5); // Add the Back button to the buttonPanel
        buttonPanel.add(bookButton5);
    
        // Add the image and text panels to the content panel
        contentPanel.add(imagePanel, BorderLayout.WEST);
        contentPanel.add(textPanel, BorderLayout.CENTER);
    
        // Add the button panel to the content panel
        contentPanel.add(buttonPanel, BorderLayout.EAST);
    
        info5Screen.add(titleLabel, BorderLayout.NORTH);
        info5Screen.add(contentPanel, BorderLayout.CENTER);
        cardPanel.add(info5Screen, "info5Screen");
    }


/*
 * Sixth info screen: Reunion Tower
 */
    
    private void createInfo6Screen() {
        JPanel info6Screen = new JPanel(new BorderLayout());
    
        JLabel titleLabel = new JLabel("Reunion Tower");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
        JPanel contentPanel = new JPanel(new BorderLayout());
    
        // Create a panel for the image
        JPanel imagePanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("attraction6.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imagePanel.add(imageLabel);
    
        // Create a panel for the text
        JPanel textPanel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea("Reunion Tower is an iconic Dallas landmark that offers panoramic 360-degree views of the Dallas skyline. Located next to the Hyatt Regency Dallas, the Reunion Tower GeO-Deck offers an indoor/outdoor observation deck and unique entertaining spaces. It’s a great place to visit with family, friends, a group or your sweetheart to create unforgettable memories at 470 feet in the air!\n\nThe tower is open from 12:30 pm to 7:30 pm from Monday to Friday, 1:00 pm to 8:30 pm on Saturday and Sunday. The address is 300 Reunion Blvd E, Dallas, TX, 75207 and you can contact them at (214) 296-9950.\n\nThere are several ticket options available:\n> General Admission: This ticket gives you access to the GeO-Deck/Observation deck/observation deck. General admission includes a souvenir digital photo and access to telescopes on the outdoor viewing area.\n> Guided Tours: Learn about Reunion Tower from one of their expertly trained Ambassadors. This one-hour long VIP experience includes a guided 30-minute tour and 30-minutes of exploration on their GeO-Deck.\n> Two Views One Price Day + Night Ticket: Visit during the day and come back at night to experience the city lights.\n> Discounted Group Tickets: Reunion Tower offers discounted rates to groups who want to experience the breathtaking 360-degree panoramic views from 470 feet in the air on the indoor/outdoor GeO-Deck.\n> Dallas CityPass: Save 47% on admission to the GeO-Deck plus 3 more top attractions.\n> Pogo Pass: Your one-stop for all things fun! Visit 20+ DFW locations for family fun. Pogo Pass includes access to Reunion Tower, Fort Worth Zoo, Texas Discovery Gardens, Dallas Wings games and much more.\n\nWhether you visit at day or at night, Reunion Tower offers a stunning and breathtaking 360-degree panoramic view of the city that has to be seen to be believed. So why wait? Plan your visit today!");
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setAutoscrolls(true);
        textPanel.add(textArea);
    
        // Create a panel for buttons in the EAST region
        JPanel buttonPanel = new JPanel();
        JButton backButton6 = new JButton("Back");
        backButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "selectionScreen");
            }
        });
    
        JButton bookButton6 = new JButton("Book");
        bookButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedLocations.size() < 4) {
                    String locationName = "Reunion Tower";
                    if (bookButton6.getText().equals("Book")) {
                        bookButton6.setText("Unbook");
                        selectedLocations.add(locationName);
                    } else {
                        bookButton6.setText("Book");
                        selectedLocations.remove(locationName);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You have reached the maximum booking limit (4 items).", "Booking Limit Exceeded", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        buttonPanel.add(backButton6); // Add the Back button to the buttonPanel
        buttonPanel.add(bookButton6);
    
        // Add the image and text panels to the content panel
        contentPanel.add(imagePanel, BorderLayout.WEST);
        contentPanel.add(textPanel, BorderLayout.CENTER);
    
        // Add the button panel to the content panel
        contentPanel.add(buttonPanel, BorderLayout.EAST);
    
        info6Screen.add(titleLabel, BorderLayout.NORTH);
        info6Screen.add(contentPanel, BorderLayout.CENTER);
        cardPanel.add(info6Screen, "info6Screen");
    }
    
    /*
    * Seventh info screen: Six Flags
    */
    
    private void createInfo7Screen() {
        JPanel info7Screen = new JPanel(new BorderLayout());
    
        JLabel titleLabel = new JLabel("Six Flags");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
        JPanel contentPanel = new JPanel(new BorderLayout());
    
        // Create a panel for the image
        JPanel imagePanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("attraction7.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imagePanel.add(imageLabel);
    
        // Create a panel for the text
        JPanel textPanel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea("Six flags is a world of thrill and excitement! Experience the ultimate adventure with our heart-pounding roller coasters, family-friendly attractions, and live entertainment.\nWith a variety of rides catering to every level of adrenaline seeker, delicious dining options, and captivating shows, there's something for everyone.\nCome and discover why Six Flags is the ultimate destination for unforgettable experiences and endless entertainment!");
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setAutoscrolls(true);
        textPanel.add(textArea);
    
        // Create a panel for buttons in the EAST region
        JPanel buttonPanel = new JPanel();
        JButton backButton6 = new JButton("Back");
        backButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "selectionScreen");
            }
        });
    
        JButton bookButton6 = new JButton("Book");
        bookButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedLocations.size() < 4) {
                    String locationName = "Six Flags";
                    if (bookButton6.getText().equals("Book")) {
                        bookButton6.setText("Unbook");
                        selectedLocations.add(locationName);
                    } else {
                        bookButton6.setText("Book");
                        selectedLocations.remove(locationName);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You have reached the maximum booking limit (4 items).", "Booking Limit Exceeded", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        buttonPanel.add(backButton6); // Add the Back button to the buttonPanel
        buttonPanel.add(bookButton6);
    
        // Add the image and text panels to the content panel
        contentPanel.add(imagePanel, BorderLayout.WEST);
        contentPanel.add(textPanel, BorderLayout.CENTER);
    
        // Add the button panel to the content panel
        contentPanel.add(buttonPanel, BorderLayout.EAST);
    
        info7Screen.add(titleLabel, BorderLayout.NORTH);
        info7Screen.add(contentPanel, BorderLayout.CENTER);
        cardPanel.add(info7Screen, "info7Screen");
    }


    private void createFinishScreen() {
        JPanel finishScreen = new JPanel(new BorderLayout());

        JButton finishButton = new JButton("Finish");
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!selectedLocations.isEmpty()) {
                    cardLayout.show(cardPanel, "listScreen");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select at least one location to visit.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        finishScreen.add(finishButton, BorderLayout.CENTER);
        cardPanel.add(finishScreen, "finishScreen");
    }

    private void createListScreen() {
        JPanel listScreen = new JPanel(new BorderLayout());
    
        JTextArea listTextArea = new JTextArea(10, 40);
        listTextArea.setEditable(false);
        JScrollPane listScrollPane = new JScrollPane(listTextArea);
    
        JButton updateButton = new JButton("Update List");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!selectedLocations.isEmpty()) {
                    StringBuilder listText = new StringBuilder("Selected Locations:\n");
                    for (String location : selectedLocations) {
                        listText.append(location).append("\n");
                    }
                    listTextArea.setText(listText.toString());
                    JOptionPane.showMessageDialog(frame, "Update Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    listTextArea.setText("");
                    JOptionPane.showMessageDialog(frame, "No locations selected.", "Information", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    
        JButton returnButton = new JButton("Return to Selection");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "selectionScreen");
            }
        });
    
        JButton printButton = new JButton("Print");
printButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printable() {
            public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
                if (page > 0) { // We have only one page, and 'page' is zero-based
                    return NO_SUCH_PAGE;
                }

                // User (0,0) is typically outside the imageable area, so we must
                // translate by the X and Y values in the PageFormat to avoid clipping
                Graphics2D g2d = (Graphics2D)g;
                g2d.translate(pf.getImageableX(), pf.getImageableY());

                // Now print the itinerary to the printer
                // itineraryPanel is the component you want to print
                listTextArea.printAll(g);

                return PAGE_EXISTS;
            }
        });

        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                /* The job did not successfully complete */
            }
        }
    }
});

    
        JButton saveAndQuitButton = new JButton("Save and Quit");
        saveAndQuitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    
        listScreen.add(listScrollPane, BorderLayout.CENTER);
        listScreen.add(updateButton, BorderLayout.NORTH);
        listScreen.add(returnButton, BorderLayout.WEST);
        listScreen.add(printButton, BorderLayout.SOUTH);
        listScreen.add(saveAndQuitButton, BorderLayout.EAST);
    
        cardPanel.add(listScreen, "listScreen");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }



}