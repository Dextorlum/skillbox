public class main {
    public static void main(String[] args) {
        int vasyaAge = 99;
        int mashaAge = 1000;
        int mishaAge = 66;

        int minAge = -1;
        int middleAge = -1;
        int maxAge = -1;

        if (vasyaAge > mashaAge && vasyaAge > mishaAge) {
         maxAge = vasyaAge;
        }
        if (vasyaAge < mashaAge && vasyaAge < mishaAge) {
            minAge = vasyaAge;
        }
        if (mashaAge > vasyaAge && mashaAge > mishaAge) {
            maxAge = mashaAge;
        }
        if (mashaAge < vasyaAge && mashaAge < mishaAge) {
            minAge = mashaAge;
        }
        if (mishaAge > mashaAge && mishaAge > mashaAge){
            maxAge = mishaAge;
        }
        if (mishaAge < mashaAge && mishaAge < vasyaAge) {
            minAge = mishaAge;
        }
        if (vasyaAge < maxAge && vasyaAge > minAge) {
            middleAge = vasyaAge;
        }
        if (mashaAge < maxAge && mashaAge > minAge){
            middleAge = mashaAge;
        }
        if (mishaAge < maxAge && mishaAge > minAge) {
            middleAge = mishaAge;
        }


        System.out.println("Minimal Age: "+minAge);
        System.out.println("Middle Age: "+middleAge);
        System.out.println("Maximum Age: "+maxAge);

    }
}
