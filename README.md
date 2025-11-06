# Film Equipment Rental System

A desktop-based Film Equipment Rental System built in Java Swing. This application provides a graphical user interface (GUI) for managing an inventory of film equipment, registering clients, and processing rental and return transactions.

This project was developed using the **Apache NetBeans IDE**, uses **Apache Ant** as its build tool, and connects to a **MySQL** database.

## Key Features

* **Login System:** A secure login window for staff/administrators.
* **Main Menu:** A central dashboard for navigating the system's different modules after logging in.
* **Client Registration:** A form for adding new clients (renters) to the system.
* **Equipment Management:** Allows staff to add, update, and manage the full inventory of available film equipment.
* **Rent Equipment:** A dedicated form to process equipment rentals. This includes selecting a client, choosing equipment, and setting rental/due dates.
* **Return Equipment:** A form to manage the return of rented items, updating their status and availability in the inventory.

## Technology Stack
* **Language:** Java
* **Framework:** Java Swing (for the GUI)
* **Database:** MySQL (identified by `mysql-connector-j-9.2.0.jar`)
* **Libraries:** JCalendar 1.4 (for date-picking)
* **Build Tool:** Apache Ant (identified by `build.xml`)
* **IDE:** Apache NetBeans (identified by `nbproject/project.xml`)

## Getting Started

### Prerequisites
* Java Development Kit (JDK) 8 or higher
* Apache NetBeans IDE (recommended)
* A running MySQL database server

### Running the Project

1.  **Clone the Repository**
    ```bash
    git clone https://github.com/aldrieBQRN/filmEquipment.git
    ```
2.  **Open in NetBeans**
    * Open Apache NetBeans.
    * Go to `File` > `Open Project...`.
    * Navigate to and select the `filmEquipment` root folder (which contains the `nbproject` directory).

3.  **Database & Libraries Setup (CRUCIAL)**
    * **Database:** This project requires a MySQL database. You must create the database and the necessary tables (for users, clients, equipment, rentals, etc.).
    * Check the source code (especially `Login.java`, `rentEquip.java`, etc.) for the JDBC connection string, database name, and table structures.
    * **Libraries:** The required `.jar` files (`mysql-connector` and `jcalendar`) are in the `lib/` folder. Ensure your NetBeans project has correctly referenced them. If not, right-click the "Libraries" folder in the project tree and select "Add JAR/Folder".

4.  **Build and Run**
    * Right-click on the `filmEquipment` project in the NetBeans project explorer.
    * Select **"Clean and Build"**. This will compile the code and create a runnable `.jar` file in the `dist/` directory.
    *
