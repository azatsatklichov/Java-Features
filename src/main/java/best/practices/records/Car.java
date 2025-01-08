package best.practices.records;

import java.time.LocalDate;

record Car(String model, LocalDate producedDate, String vin) {
}
