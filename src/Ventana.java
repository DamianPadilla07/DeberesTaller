import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextArea txtCodigo;
    private JButton btnComprobarButton;

    public Ventana() {
        btnComprobarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Pila pilas = new Pila();
                String texto= txtCodigo.getText();

                for(int i=0; i <texto.length()-1;i++ ){
                    char letra = texto.charAt(i);
                    if (letra=='(' || letra=='{'|| letra=='[' ){
                        pilas.insertar(String.valueOf(letra));

                    }else {
                        if (letra==')'){
                            char salida= pilas.extraer().charAt(0);
                            JOptionPane.showMessageDialog(null, salida);
                            return;
                        }else {
                            if (letra==')') {
                                char salida = pilas.extraer().charAt(0);
                                JOptionPane.showMessageDialog(null, "Codigo incorrecto");
                                return;
                            }
                        }
                    }
                }
                if (pilas.esVacia()){
                    JOptionPane.showMessageDialog(null, "El codigo esta correcto");
                }else{
                    JOptionPane.showMessageDialog(null, "El codigo esta incorrcto");
                }


            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
