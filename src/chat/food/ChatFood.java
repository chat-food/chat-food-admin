/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.food;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 *
 * @author Laboratorio
 */
public class ChatFood extends JDesktopPane{

        
        private JFrame cadRestaurante;
    
        public void abrirCadRestaurante(){
            if(cadRestaurante==null){
                cadRestaurante = new TelaCadastro();
                cadRestaurante.setVisible(true);
                add(cadRestaurante);
            }
        }

        public void fecharCadCliente(){
            cadRestaurante=null;
        }
  
        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            // TODO code application logic here
            TelaDetalhesPedido p = new TelaDetalhesPedido();
            p.setVisible(true);
        }
}
