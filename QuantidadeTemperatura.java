import java.util.Scanner;

public class QuantidadeTemperatura {
    static double Celsiuskelvin (double x){ return x + 273.15;
    }
    static double CelsiusFahrenheit (double x){ return (x*1.8) + 32;
    }
    static double FahrenheitCelsius (double x) { return (x-32)/1.8;
    }
    static  double FahrenheitKelvin (double x){ return  (x-32)/1.8 + 273;
    }
    static double KelvinCelsius (double x){ return x- 273.15;
    }
    static  double KelvinFahrenheit (double x){ return ((x - 273.15) * 1.8) + 32;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean unidadeok = false;
        String temperatura2 = "";
        String temperatura = "";
        double soma1 = 0;
        double soma2 = 0;
        double resultado = 0;


        System.out.println("Quantas temperaturas voce gostaria de transformar?");
        int quantidade = scan.nextInt();
        scan.nextLine();

        do {
            System.out.println("Qual unidade de temperatura original? (celsius, kelvin ou fahrenheit?");
            temperatura = scan.nextLine();
            if(!temperatura.equalsIgnoreCase("celsius") && !temperatura.equalsIgnoreCase("kelvin") && !temperatura.equalsIgnoreCase("fahrenheit")){
                System.out.println("unidade invalida");
                continue;
            }

            System.out.println("Para qual unidade de temperatura voce quer transformar: (celsius, kelvin ou fahrenheit?");
            temperatura2 = scan.nextLine();
            if((!temperatura2.equalsIgnoreCase("celsius") && !temperatura2.equalsIgnoreCase("kelvin") && !temperatura2.equalsIgnoreCase("fahrenheit") || temperatura2.equalsIgnoreCase(temperatura))){
                System.out.println("unidade invalida");
                continue;
            }
            unidadeok = true;
        }while(unidadeok == false);

        for (int i = 0; i < quantidade; i++){
            System.out.println("Qual temperatura voce quer transformar?");
            double temp = scan.nextDouble();

            soma1 += temp;


            if(temperatura.equalsIgnoreCase("celsius")){
                if (temperatura2.equalsIgnoreCase("fahrenheit")) {
                    resultado = CelsiusFahrenheit(temp);
                } else {
                    resultado = Celsiuskelvin(temp);
                }
            } else if (temperatura.equalsIgnoreCase("fahrenheit")) {
                if (temperatura2.equalsIgnoreCase("celsius")) {
                    resultado = FahrenheitCelsius(temp);
                }else{
                    resultado = FahrenheitKelvin(temp);
                }
            }
            else {
                if (temperatura2.equalsIgnoreCase("celsius")){
                    resultado= KelvinCelsius(temp);
                }else {
                    resultado = KelvinFahrenheit(temp);
                }
            }

            soma2 += resultado;

            System.out.println(temp + " " + temperatura + " em "+ temperatura2+ " = "+resultado);
        }
        double media = soma1/quantidade;
        double media2 = soma2/quantidade;
        System.out.println("A media das temperaturas de entrada:  " + media);
        System.out.println( "A media das temperaturas de saída " + media2);

        scan.close();
    }
}