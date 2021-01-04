public class Friend implements Comparable<Friend>
{
    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public synchronized void throwBallTo(Friend catcher)  {
        try {
            wait();
            System.out.format("%s: %s кинул мне мяч!%n", catcher.getName(), this.name);
            catcher.throwBallTo(this);
            notify();

        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public int compareTo(Friend o) {
        return this.getName().compareTo(o.getName());
    }
}
