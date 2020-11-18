public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;
        System.out.println(sumDigits(1234));
    }

    public static Integer sumDigits(Integer number)
    {   int sum = 0;
        for (int i = 0; i  < number.toString().length(); i++)
        {   
            //sum = sum + Character.getNumericValue(number.toString().charAt(i));
            sum = sum + Integer.parseInt(String.valueOf(number.toString().charAt(i)));
        }
        return sum;
    }
}
