package org.example.lab.agh;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.lab.agh.command_package.Command;
import org.example.lab.agh.command_package.ExitCommand;
import org.example.lab.agh.command_package.PricesCommand;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 */
public class App {
    /**
     *
     */
    private final Hotel ourHotel;
    /**
     *
     */
    private final MyMap<String, PricesCommand> commandsMap = new MyMap<>();

    /**
     *
     */
    public App() {
        Hotel tempHotel = null;
        try (InputStream fis = getClass().getClassLoader().getResourceAsStream("hotel_data.xlsx");
             // Plik Excel znajduje się w poprawnym miejscu w strukturze projektu, ale problem polega na sposobie jego odczytu.
             // Gdy uruchamiasz aplikację, ścieżka src/main/resources/hotel_data.xlsx nie jest dostępna jako ścieżka systemowa w czasie wykonywania,
             // ponieważ Maven kopiuje zawartość folderu src/main/resources do folderu target/classes podczas procesu budowania.
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Row hotelInfoRow = sheet.getRow(1);

            String hotelName = hotelInfoRow.getCell(0).getStringCellValue();
            int floorNumber = (int) getNumericValue(hotelInfoRow.getCell(1));
            int roomsPerFloor = (int) getNumericValue(hotelInfoRow.getCell(2));

            tempHotel = new Hotel(hotelName, floorNumber, roomsPerFloor); //tutaj tworzymy hotel z wczytanymi parametrami

            for (int i = 3; i <= sheet.getLastRowNum(); i++) { // Iteracja od 3, bo tu sie zaczynaja dane o hotelu
                Row roomRow = sheet.getRow(i);
                int roomNumber = (int) getNumericValue(roomRow.getCell(0));
                double pricePerNight = getNumericValue(roomRow.getCell(1));
                int maxGuests = (int) getNumericValue(roomRow.getCell(2));

                Room room = new Room(roomNumber, pricePerNight, maxGuests);
                tempHotel.getRoomsMap().put(roomNumber, room); //tutaj dodajemy kolejne pokoje z wczytanymi parametrami do hotelu
            }

        } catch (IOException e) {
            System.err.println("Error reading the Excel file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Data error: " + e.getMessage());
        }

        this.ourHotel = tempHotel != null ? tempHotel : new Hotel("Default Hotel", 1, 1);
    }

    /**
     * @param cell gyguguy
     * @return
     */
    // Helper method to handle numeric values or string-to-numeric conversion
    private double getNumericValue(Cell cell) {
        if (cell.getCellType() == CellType.NUMERIC) {
            return cell.getNumericCellValue();
        } else if (cell.getCellType() == CellType.STRING) {
            try {
                return Double.parseDouble(cell.getStringCellValue());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid numeric value in cell: " + cell.getAddress());
            }
        } else {
            throw new IllegalArgumentException("Unexpected cell type in cell: " + cell.getAddress());
        }
    }

    /**
     *
     */
    public void runApp(){
        System.out.println("===============Welcome to Textual Hotel Manager!===============");
        Scanner mainScanner = new Scanner(System.in);
        CommandFactory commandFactory = new CommandFactory();

        while(true){

            System.out.print("Choose the command {prices, view, checkin, checkout, list, save, exit}: ");
            String userChoice = mainScanner.nextLine().trim().toLowerCase();
            Command chosenCommand= commandFactory.getCommand(userChoice, ourHotel, mainScanner);
            chosenCommand.execute();
            if (chosenCommand instanceof ExitCommand) {break;}

        }
        mainScanner.close();
    }

    /**
     * @param args ygyugyuguygu
     */
    public static void main(String[] args) {
        new App().runApp();
    }
}