
import java.util.*;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    void display() {
        System.out.println("ID: " + id +
                " | Name: " + name +
                " | Age: " + age +
                " | Disease: " + disease);
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    void display() {
        System.out.println("ID: " + id +
                " | Name: " + name +
                " | Specialization: " + specialization);
    }
}

class Appointment {
    int patientId;
    int doctorId;
    String date;

    Appointment(int patientId, int doctorId, String date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    void display() {
        System.out.println("Patient ID: " + patientId +
                " | Doctor ID: " + doctorId +
                " | Date: " + date);
    }
}

public class HospitalManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findPatient(id) != null) {
            System.out.println("Patient ID already exists!");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients.add(new Patient(id, name, age, disease));

        System.out.println("Patient Added Successfully!");
    }

    static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findDoctor(id) != null) {
            System.out.println("Doctor ID already exists!");
            return;
        }

        System.out.print("Enter Doctor Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();

        doctors.add(new Doctor(id, name, specialization));

        System.out.println("Doctor Added Successfully!");
    }

    static Patient findPatient(int id) {
        for (Patient p : patients) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }

    static Doctor findDoctor(int id) {
        for (Doctor d : doctors) {
            if (d.id == id) {
                return d;
            }
        }
        return null;
    }

    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No Patients Found!");
            return;
        }

        System.out.println("\n--- Patient Details ---");

        for (Patient p : patients) {
            p.display();
        }
    }

    static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No Doctors Found!");
            return;
        }

        System.out.println("\n--- Doctor Details ---");

        for (Doctor d : doctors) {
            d.display();
        }
    }

    static void bookAppointment() {
        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();

        System.out.print("Enter Doctor ID: ");
        int did = sc.nextInt();
        sc.nextLine();

        Patient p = findPatient(pid);
        Doctor d = findDoctor(did);

        if (p == null || d == null) {
            System.out.println("Invalid Patient or Doctor ID!");
            return;
        }

        System.out.print("Enter Appointment Date: ");
        String date = sc.nextLine();

        appointments.add(new Appointment(pid, did, date));

        System.out.println("Appointment Booked Successfully!");
    }

    static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No Appointments Found!");
            return;
        }

        System.out.println("\n--- Appointment Details ---");

        for (Appointment a : appointments) {
            a.display();
        }
    }

    static void generateBill() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        Patient p = findPatient(id);

        if (p == null) {
            System.out.println("Patient Not Found!");
            return;
        }

        System.out.print("Enter Consultation Fee: ");
        double consultation = sc.nextDouble();

        System.out.print("Enter Medicine Charges: ");
        double medicine = sc.nextDouble();

        System.out.print("Enter Room Charges: ");
        double room = sc.nextDouble();

        double total = consultation + medicine + room;

        System.out.println("\n======= HOSPITAL BILL =======");
        System.out.println("Patient Name: " + p.name);
        System.out.println("Patient ID: " + p.id);
        System.out.println("Consultation Fee: Rs. " + consultation);
        System.out.println("Medicine Charges: Rs. " + medicine);
        System.out.println("Room Charges: Rs. " + room);
        System.out.println("-----------------------------");
        System.out.println("Total Bill: Rs. " + total);
        System.out.println("=============================");
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("   HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. View Patients");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Generate Bill");
            System.out.println("8. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addPatient();
                    break;

                case 2:
                    addDoctor();
                    break;

                case 3:
                    viewPatients();
                    break;

                case 4:
                    viewDoctors();
                    break;

                case 5:
                    bookAppointment();
                    break;

                case 6:
                    viewAppointments();
                    break;

                case 7:
                    generateBill();
                    break;

                case 8:
                    System.out.println("Thank You!");
                    System.out.println("Hospital System Closed.");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 8);

        sc.close();
    }
}
