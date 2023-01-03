import java.awt.*;
import java.net.URI;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {

        LocalTime time = LocalTime.of(8,00);

        Timer timer =new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                sendMessage("Good morning :)");
            }
        };

        timer.scheduleAtFixedRate(task,time.toNanoOfDay(),24*60*60*1000);

    }
    public  static void sendMessage (String message){

        try {

            URI whatsaapWeb = new URI("https://web.whatsapp.com/send?text=" + message);

            Desktop desktop = Desktop.getDesktop();
            desktop.browse(whatsaapWeb);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
