package ejercicio.socket.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cliente1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;
        
        int contador = 0;

        try {
            Socket sc = new Socket(HOST, PUERTO);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            do{
                String respuesta = JOptionPane.showInputDialog("Ingrese un número: ");
                int respuestaInt = Integer.parseInt(respuesta);
                
                if (respuestaInt>12 ) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número entre 1 y 12");
                }else if(respuestaInt<=12){
                    out.writeUTF(respuesta);
                    String mensaje = in.readUTF();
                    
                    if (mensaje == "ganador"){
                        JOptionPane.showMessageDialog(null, "Has adivinado el número");
                    }else if (mensaje == "mayor"){
                        JOptionPane.showMessageDialog(null, "El número es mayor");
                    }else if (mensaje == "menor"){
                        JOptionPane.showMessageDialog(null, "El número es menor");
                    }
                    contador = contador+1;
                }
            }while(contador!=10);
            
            
            
        
        
            /*out.writeUTF("Hola mundo desde el cliente");
            String mensaje = in.readUTF();

            System.out.println(mensaje);
            sc.close();*/

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
