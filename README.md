# Description
Welcome to **Textual Hotel Manager**  Maven app which takes care of checkin-checkout guests operations.
Our app enables text-service for customers who want to choose and book a room in our hotel.
Main objects of our app are: hotel, guest, room.   Configuration of hotel and its available rooms is loaded from dedicated Excel (.xlsx) file.
Guests-related data and their booked rooms info is stored in second dedicated Excel room.  
**Enjoy using my application!**

# Usage tutorial
Our app starts by running file **App** from `main/src/main/java/App` directory.  
Hotel configuration (that can be customised) is automatically loaded
from file: `main/src/main/resources/hotel_data.xlsx`.  
Data about current hotel guests and room availability is automatically loaded
from file: `main/src/main/resources/guests_state.xlsx`. 

User will be asked to choose the command that he/she wants to execute.  
Commands available are:  
- prices - lists all room in the hotel with their prices displayed.  
- view - asks user about the room number of the room which details he\she wants to be displayed.
- checkin - user chooses the room that we want to book and then asks  about number, date and data of guests we want to register in.
- checkout - opposite to check in, user chooses the room that he want to register out of (guests inside) and calculate the final price of transaction.
- list - lists all rooms and their data including info about guests residing in (if they do)
- save - it saves current state of guests-residing-in-rooms to the Excel file, which will be loaded next time our app is run.
- exit - closes te app (it does not include saving data about new-session guests!).

# Documentation and SonarQube report:
Project documentation is saved in: `Javadoc/target/site/apidocs/index.html` file.  
SonarQube report in PDF format is saved in `sonar-cube/reportSonarQube.pdf` file.

# Tools used
Whole project was built using Maven Tool.
Others tools which were used include:
- SonarQube
- Jacoco
- Junit Jupiter with Mockito library
- Apache POI
- Javadoc

# Credits
- Contributor: [ppaczek04](https://github.com/ppaczek04)
