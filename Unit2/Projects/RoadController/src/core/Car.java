package core;

public class Car {
    public String number;
    public int height;
    public double weight;
    public boolean hasVehicle;
    public boolean isSpecial;

    public String toString() {
        // Переменная типа String зависищая от свойства класса isSpecial
        // Если isSpecial = true, то СПЕЦТРАНСПОРТ, иначе обычное авто
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "Обычное авто";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}