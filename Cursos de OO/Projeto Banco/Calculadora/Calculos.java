package Calculadora;

public class Calculos {
    
    public void realizarCalculos(int min, int sec){
        int total = (min*60) + sec; 
        double restoO25 = (((total * 400)/100)%60);
        int O25 = (((total * 400)/100)/60);
        System.out.println("Esse vídeo na velocidade 0.25X = "+O25+":"+restoO25);
        double restoO5 = (((total * 200)/100)%60);
        int O5 = (((total * 200)/100)/60);
        System.out.println("Esse vídeo na velocidade 0.5X = "+O5+":"+restoO5);
        double restoO75 = (((total * 125)/100)%60);
        int O75 = (((total * 125)/100)/60);
        System.out.println("Esse vídeo na velocidade 0.75X = "+O75+":"+restoO75);
        System.out.println("Esse vídeo na velocidade 1.0X = "+min+":"+sec);
        double restoI25 = (((total * 75)/100)%60);
        int I25 = (((total * 75)/100)/60);
        System.out.println("Esse vídeo na velocidade 0.75X = "+I25+":"+restoI25);
        double restoI5 = (((total * 50)/100)%60);
        int I5 = (((total * 50)/100)/60);
        System.out.println("Esse vídeo na velocidade 0.75X = "+I5+":"+restoI5);
        double restoI75 = (((total * 25)/100)%60);
        int I75 = (((total * 25)/100)/60);
        System.out.println("Esse vídeo na velocidade 0.75X = "+I75+":"+restoI75);
        double restoA = (((total * 2)/100)%60);
        int A = (((total * 50)/100)/60);
        System.out.println("Esse vídeo na velocidade 0.75X = "+A+":"+restoA);
    }
}
