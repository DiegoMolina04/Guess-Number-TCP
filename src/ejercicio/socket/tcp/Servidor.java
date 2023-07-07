package ejercicio.socket.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {

        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        final int puerto = 5000;

        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");
            
            sc = servidor.accept();
            System.out.println("Cliente conectado");

            while (true) {
                
                
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                int aleatorio = (int) (Math.random() * (12 - 1) + 1);

                String mensaje = in.readUTF();
                int mensajeInt = Integer.parseInt(mensaje);
                
                if(aleatorio == mensajeInt){
                    String var0 = "ganador";
                    out.writeUTF(var0);
                }else if (mensajeInt > aleatorio){
                    String var1 = "mayor";
                    out.writeUTF(var1);
                }else if (mensajeInt < aleatorio){
                    String var2 = "menor";
                    out.writeUTF(var2);
                }

                /*System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                
                String mensaje = in.readUTF();
                System.out.println(mensaje);
                
                out.writeUTF("Hola mundo desde el servidor");
                sc.close();
                System.out.println("Cliente desconectado");*/
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
