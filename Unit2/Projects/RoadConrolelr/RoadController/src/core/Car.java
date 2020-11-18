package core;

public class Car
{
    //Переменная
    public String number;
    //Переменная
    public int height;
    //Переменная
    public double weight;
    //Переменная
    public boolean hasVehicle;
    //Переменная
    public boolean isSpecial;

    public String toString()
    {
        //Переменная
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}