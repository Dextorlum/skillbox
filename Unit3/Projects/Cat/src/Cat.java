
public class Cat
{
    public static final int LEGS_COUNT = 4;
    public static final int EYES_COUNT = 2;
    public static final int MIN_WEIGHT = 1000;
    public static final int MAX_WEIGHT = 1000;

    public static int totalCount;

    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private String name;

    private Color color;

    private double eatWeight;

    public static int getCount(){
        return totalCount;
    }

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        totalCount = totalCount + 1;
    }

    public Cat(String name, double weight)
    {
        this();
        this.name = name;
        this.weight = weight;

    }
    public Cat(String name, double weight, double originWeight,
               double minWeight, double maxWeight, Color color)
    {   this.name = name;
        this.weight = weight;
        this.originWeight = originWeight;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.color = color;
        totalCount = totalCount + 1;
    }

    public String getName(){
     return name;
    }

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
        eatWeight = eatWeight + amount;
    }
    public double getEatWeight()
    {
        return eatWeight;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            totalCount = totalCount - 1;
            return "Dead";
        }
        else if(weight > maxWeight) {
            totalCount = totalCount - 1;
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    public void pee(){
        weight = weight - weight/100*10;
    }

    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return color;
    }

    public Cat copyCat(){
        return new Cat(name, weight, originWeight, minWeight,maxWeight, color);
    }
}