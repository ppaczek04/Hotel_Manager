package org.example.lab.agh.command_package;

import org.example.lab.agh.model_package.Guest;
import org.example.lab.agh.model_package.Hotel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.lab.agh.model_package.Room;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 */
public class SaveCommand implements Command{
    private Hotel tempHotel;

    /**
     * @param hotel gygug
     */
    public SaveCommand(Hotel hotel) {
        this.tempHotel = hotel;
    }

    /**
     * Executes the command to save the current guest state to an Excel file.
     */
    @Override
    public void execute() {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Guest State");

            int rowIndex = 0; // Zaczynamy od pierwszego wiersza

            // Pobierz listę kluczy (pokoi)
            List<Integer> keys = tempHotel.getRoomsMap().keys();
            for (Integer roomKey : keys) {
                Room room = tempHotel.getRoomsMap().get(roomKey);
                for (Guest guest : room.getRoomRegisteredGuests()) {
                    Row row = sheet.createRow(rowIndex++);
                    row.createCell(0).setCellValue(room.getRoomNumber());
                    row.createCell(1).setCellValue(guest.getName());
                    row.createCell(2).setCellValue(guest.getSurname());
                    row.createCell(3).setCellValue(guest.getPESEL());
                    row.createCell(4).setCellValue(
                            room.getCheckinDate() != null ? room.getCheckinDate().toString() : "N/A"
                    );
                    row.createCell(5).setCellValue(
                            room.getCheckoutDate() != null ? room.getCheckoutDate().toString() : "N/A"
                    );
                }
            }

            // Nadpisz plik guests_state.xlsx
            try (FileOutputStream fos = new FileOutputStream("main/src/main/resources/guests_state.xlsx")) {
                workbook.write(fos);
                System.out.println("Guest state saved successfully!");
            }

        } catch (IOException e) {
            System.err.println("Error saving guest state: " + e.getMessage());
        }
    }
}