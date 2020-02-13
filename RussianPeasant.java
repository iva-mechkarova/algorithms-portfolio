import java.lang.*;

public class RussianPeasant
{
    public static void main(String[] args)
    {
        RussianPeasant r = new RussianPeasant();

        final long startTime = System.currentTimeMillis();
        System.out.println(r.RussianMultiply(233, 100000));
        final long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("the time taken " + elapsedTime);
    }

    public int RussianMultiply(int n, int m)
    {
        int accumulator = 0;

        while(n!=0)
        {
            if(n%2 != 0)
            {
                accumulator += m;
            }

            n = n/2;
            m = m*2;
        }

        return accumulator;
    }
}
