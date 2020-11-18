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

    public void setNumber(String number){
        this.number = number;
    }
    public String getNumber(){
        return number;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getHeight(){
        return height;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }
    public void setHasVehicle(boolean hasVehicle){
        this.hasVehicle = hasVehicle;
    }
    public boolean isHasVehicle(){
        return hasVehicle;
    }
    public void setSpecial(boolean isSpecial){
        this.isSpecial = isSpecial;
    }
    public boolean isSpecial(){
        return isSpecial;
    }
}