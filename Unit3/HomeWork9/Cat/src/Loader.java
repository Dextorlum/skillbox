
public class Loader
{
    public static void main(String[] args)
    {
        Cat murka = new Cat("Мурка", 1000);
        murka.setColor(Color.BLACK);
        System.out.println(murka.getWeight());
        System.out.println(murka.getColor());
        Cat copyMurka = murka.copyCat();
        System.out.println("Копия мурки - "+copyMurka.getName());
        System.out.println("Копия мурки - "+copyMurka.getWeight());
        System.out.println("Копия мурки - "+copyMurka.getColor());


        Cat gaf = getKitten("Гаф", 1100);
        System.out.println(gaf.getWeight());
        System.out.println(gaf.getName());

    }

    private static Cat getKitten(String name, double weight) {
      return new Cat(name, weight);
    }
}