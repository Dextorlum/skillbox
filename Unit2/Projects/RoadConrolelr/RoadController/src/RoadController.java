import core.*;
import core.Camera;

import java.util.Scanner;

public class RoadController
{
    //Переменная
    private static double passengerCarMaxWeight = 3500.0; // kg
    //Переменная
    private static int passengerCarMaxHeight = 2000; // mm
    //Переменная
    private static int controllerMaxHeight = 3500; // mm

    //Переменная
    private static int passengerCarPrice = 100; // RUB
    //Переменная
    private static int cargoCarPrice = 250; // RUB
    //Переменная
    private static int vehicleAdditionalPrice = 200; // RUB

    public static void main(String[] args)
    {
        System.out.println("Сколько автомобилей сгенерировать?");

        //Переменная
        Scanner scanner = new Scanner(System.in);
        //Переменная
        int carsCount = scanner.nextInt();

        for(int i = 0; i < carsCount; i++)
        {
            //Переменная
            Car car = Camera.getNextCar();
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                openWay();
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            //Переменная
            int price = calculatePrice(car);
            if(price == -1) {
                continue;
            }

            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car)
    {

        //Переменная
        int carHeight = car.height;
        //Переменная
        int price = 0;
        if (carHeight > controllerMaxHeight)
        {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        }
        else if (carHeight > passengerCarMaxHeight)
        {
            //Переменная
            double weight = car.weight;
            //Грузовой автомобиль
            if (weight > passengerCarMaxWeight)
            {
                price = cargoCarPrice;
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice;
                }
            }
            //Легковой автомобиль
            else {
                price = passengerCarPrice;
            }
        }
        else {
            price = passengerCarPrice;
        }
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay()
    {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason)
    {
        System.out.println("Проезд невозможен: " + reason);
    }
}