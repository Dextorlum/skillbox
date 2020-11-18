
public class Loader
{
    public static void main(String[] args)
    {
        Cat murka = new Cat();
        Cat musya = new Cat();
        Cat kusya = new Cat();
        Cat mur = new Cat();

        System.out.println(Cat.getCount());
        System.out.println(murka.getWeight());
        System.out.println(musya.getWeight());
        System.out.println(kusya.getWeight());
        System.out.println(mur.getWeight());

        murka.feed(10.0);
        musya.feed(10.0);

        System.out.println();

        System.out.println(murka.getWeight());
        System.out.println(musya.getWeight());

        System.out.println("Кормим мурку");
        while (murka.getStatus() != "Exploded"){
            murka.feed(1000.0);
        }

        System.out.println(murka.getStatus());


        while (musya.getStatus() != "Dead"){
            musya.meow();
        }

        System.out.println(musya.getStatus());

        System.out.println(Cat.getCount());

//        System.out.println("Начальный вес = "+murka.getWeight());
//
//        murka.feed(150.0);
//        murka.pee();
//
//        System.out.println(murka.getWeight());
//        System.out.println(murka.getEatWeight());



    }
}