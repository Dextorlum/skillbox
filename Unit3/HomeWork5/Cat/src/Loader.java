
public class Loader
{
    public static void main(String[] args)
    {
        Cat murka = new Cat("Мурка", 1000);

        System.out.println(murka.getWeight());

        Cat gaf = getKitten("Гаф", 1100);
        System.out.println(gaf.getWeight());
        System.out.println(gaf.getName());

    }

    private static Cat getKitten(String name, double weight) {
      return new Cat(name, weight);
    }
}