import java.math.*;
import java.util.*;
import java.math.BigInteger;

public class PowerFunction{
    public int pow(int x, int n, int d) {

    	if(x==0)
    		return 0;
    	else if(x>100000 || n > 100000){
    		BigInteger a1,b1,c1,d1;
    		a1=BigInteger.valueOf(x);
    		b1=BigInteger.valueOf(n);
    		c1=BigInteger.valueOf(d);
    		d1=a1.modPow(b1,c1);

    		return d1.intValue();

    	}
        int val= findPower(x,n);
        if(val<0)
        	return d+(int)(val%(long)d);
        else
        	return Math.abs((int)(val%d));
    }
    
    int findPower(int x, int n){
    	if (x==0)
    		return 0;
        if(n==0){
            return 1;
        }


        int  temp = findPower(x,n/2);
        if(n%2==0){
            return temp*temp;
        }
        
        else{
            if(n>0){
                return x*temp*temp;
            }
            else{
                return (temp*temp)/x;
            }
        }
        
    }
    public static void main(String[] args) {
    	PowerFunction obj= new PowerFunction();
    	System.out.println(obj.pow(-1,1,20));
    }
}
