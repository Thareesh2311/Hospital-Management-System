import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Parent Class
class Person {

    protected int id;
    protected String name;
    protected int age;

    public Person(int id, String name, int age) {

        this.id = id;
        this.name = name;
        this.age = age;
    }
}

// Patient Class
class Patient extends Person {

    private String disease;
    private double bill;

    public Patient(int id, String name,
                   int age, String disease) {

        super(id, name, age);

        this.disease = disease;
        this.bill = 0;
    }

    public void addBill(double amount) {

        bill += amount;
    }

    public int getId() {

        return id;
    }

    public String displayPatient() {

        return "===== PATIENT DETAILS =====\n\n" +
                "Patient ID : " + id + "\n" +
                "Name       : " + name + "\n" +
                "Age        : " + age + "\n" +
                "Disease    : " + disease + "\n" +
                "Bill       : ₹" + bill;
    }

    public double getBill() {

        return bill;
    }
}

// Doctor Class
class Doctor extends Person {

    private String specialization;

    public Doctor(int id, String name,
                  int age, String specialization) {

        super(id, name, age);

        this.specialization = specialization;
    }

    public String displayDoctor() {

        return "===== DOCTOR DETAILS =====\n\n" +
                "Doctor ID      : " + id + "\n" +
                "Name           : " + name + "\n" +
                "Age            : " + age + "\n" +
                "Specialization : " + specialization;
    }
}

// Main GUI Class
public class HospitalManagementGUI extends JFrame
        implements ActionListener {

    // ArrayLists
    ArrayList<Patient> patients =
            new ArrayList<>();

    ArrayList<Doctor> doctors =
            new ArrayList<>();

    // Labels
    JLabel titleLabel,
            idLabel,
            nameLabel,
            ageLabel,
            diseaseLabel,
            specializationLabel,
            feeLabel;

    // TextFields
    JTextField idField,
            nameField,
            ageField,
            diseaseField,
            specializationField,
            feeField;

    // Buttons
    JButton addPatientButton,
            addDoctorButton,
            showPatientsButton,
            showDoctorsButton,
            appointmentButton,
            billButton;

    // TextArea
    JTextArea resultArea;

    public HospitalManagementGUI() {

        // Frame Settings
        setTitle("Hospital Management System");

        setSize(850, 750);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(
                new Color(240, 248, 255));

        // Title
        titleLabel = new JLabel(
                "HOSPITAL MANAGEMENT SYSTEM");

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 28));

        titleLabel.setBounds(180, 20, 500, 40);

        add(titleLabel);

        // ID
        idLabel = new JLabel("ID:");

        idLabel.setBounds(50, 100, 100, 30);

        idLabel.setFont(
                new Font("Arial", Font.PLAIN, 18));

        add(idLabel);

        idField = new JTextField();

        idField.setBounds(200, 100, 220, 30);

        add(idField);

        // Name
        nameLabel = new JLabel("Name:");

        nameLabel.setBounds(50, 150, 100, 30);

        nameLabel.setFont(
                new Font("Arial", Font.PLAIN, 18));

        add(nameLabel);

        nameField = new JTextField();

        nameField.setBounds(200, 150, 220, 30);

        add(nameField);

        // Age
        ageLabel = new JLabel("Age:");

        ageLabel.setBounds(50, 200, 100, 30);

        ageLabel.setFont(
                new Font("Arial", Font.PLAIN, 18));

        add(ageLabel);

        ageField = new JTextField();

        ageField.setBounds(200, 200, 220, 30);

        add(ageField);

        // Disease
        diseaseLabel = new JLabel("Disease:");

        diseaseLabel.setBounds(50, 250, 100, 30);

        diseaseLabel.setFont(
                new Font("Arial", Font.PLAIN, 18));

        add(diseaseLabel);

        diseaseField = new JTextField();

        diseaseField.setBounds(200, 250, 220, 30);

        add(diseaseField);

        // Specialization
        specializationLabel =
                new JLabel("Specialization:");

        specializationLabel.setBounds(
                50, 300, 150, 30);

        specializationLabel.setFont(
                new Font("Arial", Font.PLAIN, 18));

        add(specializationLabel);

        specializationField = new JTextField();

        specializationField.setBounds(
                200, 300, 220, 30);

        add(specializationField);
        feeLabel = new JLabel("Consultation Fee:");

        feeLabel.setBounds(50, 350, 170, 30);

        feeLabel.setFont(
                new Font("Arial", Font.PLAIN, 18));

        add(feeLabel);

        feeField = new JTextField();

        feeField.setBounds(200, 350, 220, 30);

        add(feeField);

        addPatientButton =
                new JButton("Register Patient");

        addPatientButton.setBounds(
                500, 100, 220, 40);

        addPatientButton.addActionListener(this);

        add(addPatientButton);

        addDoctorButton =
                new JButton("Add Doctor");

        addDoctorButton.setBounds(
                500, 160, 220, 40);

        addDoctorButton.addActionListener(this);

        add(addDoctorButton);

        showPatientsButton =
                new JButton("Show Patients");

        showPatientsButton.setBounds(
                500, 220, 220, 40);

        showPatientsButton.addActionListener(this);

        add(showPatientsButton);

        showDoctorsButton =
                new JButton("Show Doctors");

        showDoctorsButton.setBounds(
                500, 280, 220, 40);

        showDoctorsButton.addActionListener(this);

        add(showDoctorsButton);

        appointmentButton =
                new JButton("Book Appointment");

        appointmentButton.setBounds(
                500, 340, 220, 40);

        appointmentButton.addActionListener(this);

        add(appointmentButton);

        billButton =
                new JButton("Generate Bill");

        billButton.setBounds(
                500, 400, 220, 40);

        billButton.addActionListener(this);

        add(billButton);

        resultArea = new JTextArea();

        resultArea.setBounds(
                50, 470, 700, 180);

        resultArea.setFont(
                new Font("Monospaced",
                        Font.BOLD, 15));

        resultArea.setEditable(false);

        add(resultArea);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            if(e.getSource() == addPatientButton) {

                int id =
                        Integer.parseInt(
                                idField.getText());

                String name =
                        nameField.getText();

                int age =
                        Integer.parseInt(
                                ageField.getText());

                String disease =
                        diseaseField.getText();

                Patient patient =
                        new Patient(id, name,
                                age, disease);

                patients.add(patient);

                resultArea.setText(
                        "Patient Registered Successfully!");
            }
            else if(e.getSource()
                    == addDoctorButton) {

                int id =
                        Integer.parseInt(
                                idField.getText());

                String name =
                        nameField.getText();

                int age =
                        Integer.parseInt(
                                ageField.getText());

                String specialization =
                        specializationField.getText();

                Doctor doctor =
                        new Doctor(id, name,
                                age, specialization);

                doctors.add(doctor);

                resultArea.setText(
                        "Doctor Added Successfully!");
            }
            else if(e.getSource()
                    == showPatientsButton) {

                String data = "";

                for(Patient p : patients) {

                    data += p.displayPatient()
                            + "\n\n";
                }

                resultArea.setText(data);
            }
            else if(e.getSource()
                    == showDoctorsButton) {

                String data = "";

                for(Doctor d : doctors) {

                    data += d.displayDoctor()
                            + "\n\n";
                }

                resultArea.setText(data);
            }

            else if(e.getSource()
                    == appointmentButton) {

                int patientId =
                        Integer.parseInt(
                                idField.getText());

                double fee =
                        Double.parseDouble(
                                feeField.getText());

                boolean found = false;

                for(Patient p : patients) {

                    if(p.getId() == patientId) {

                        p.addBill(fee);

                        found = true;

                        resultArea.setText(
                                "Appointment Booked!\n" +
                                "Consultation Fee Added.");
                    }
                }

                if(!found) {

                    resultArea.setText(
                            "Patient Not Found!");
                }
            }
            else if(e.getSource()
                    == billButton) {

                int patientId =
                        Integer.parseInt(
                                idField.getText());

                boolean found = false;

                for(Patient p : patients) {

                    if(p.getId() == patientId) {

                        resultArea.setText(
                                "Total Bill : ₹"
                                        + p.getBill());

                        found = true;
                    }
                }

                if(!found) {

                    resultArea.setText(
                            "Patient Not Found!");
                }
            }

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Please Enter Valid Details!");
        }
    }

    public static void main(String[] args) {

        new HospitalManagementGUI();
    }
}