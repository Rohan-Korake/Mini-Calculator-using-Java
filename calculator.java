import java.util.Scanner;
import java.math.*;
class Proceed 
{
    int count=0;
    double value[];
    String operator[];
    void Input()
    {
        int i=0,j=0;
        value=new double[100];     
        operator=new String[100];
        Scanner objv=new Scanner(System.in);
        Scanner objo=new Scanner(System.in);
        boolean validOperator=false;
        do
        {
            count++;
            System.out.print("Enter the value : ");
            value[i]=objv.nextDouble();
            i++;
            while (!validOperator) 
            {
                System.out.print("Enter the operator : ");
                operator[j]=objo.nextLine();
                switch (operator[j]) 
                {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case "%":
                    case "=":
                    validOperator=true;
                        break;
                
                    default:
                    System.out.println("Invlid operator!!!");
                        break;
                }   
            }
            j++;
            validOperator=false;
        }while(!operator[j-1].equals("="));
    }

    void calculate() 
    {
        double total = value[0]; 
        for (int i = 1; i < count; i++) 
        {
            String op=operator[i-1];
            switch(op) 
            {
                case "+":
                    total += value[i];
                    break;

                case "-":
                    total -= value[i];
                    break;

                case "*":
                    total *= value[i];
                    break;

                case "/":
                    if (value[i] != 0)
                    {
                        total /= value[i];
                    }
                    else 
                    {
                        System.out.println("Cannot divide by zero.");
                        return;
                    }
                    break;
                
                case "%":
                    total%=value[i];
                    break;

                default:
                    System.out.println("Invalid operator!!");
                    return;
            }
        }
        for(int i=0;i<count;i++)
        {
            System.out.print(value[i]+" "+operator[i]+" ");
        }
        System.out.print(" "+total);
    }
}

public class calculator 
{
    public static void main(String[] args) 
    {
        Proceed pr=new Proceed();
        pr.Input();
        pr.calculate();
    }
}