import java.lang.*;

public class RussianPeasant
{
    public static void main(String[] args)
    {
        RussianPeasant r = new RussianPeasant();

        final long startTime = System.currentTimeMillis();
        System.out.println(r.RussianMultiply(233, 100000)); //Input different sizes for numbers to record time taken
        final long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("the time taken " + elapsedTime);
    }

    /*Method to find product of two numbers using russian peasant algorithm*/
    public int RussianMultiply(int n, int m)
    {
        int accumulator = 0; //Initialize accumulator to 0

        //Keep looping until n reaches 0
        while(n!=0)
        {
        	//If n is an odd number add m to the accumulator
            if(n%2 != 0)
            {
                accumulator += m;
            }

            n = n/2;
            m = m*2;
        }

        return accumulator; //Returns the product of n and m
    }
}
