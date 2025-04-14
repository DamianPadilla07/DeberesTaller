import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextField textTexto;
    private JButton btnPush;
    private JButton btnPop;
    private JTextArea txtMostrar;
    private JLabel lblTexto;
    private JButton butCima;
    private JButton butSearch;
    private  Pila data = new Pila();

    //desupues de lo grafico SIEMPRE HAY QUE CREAR EL CONSTRUCTOR
    public Ventana() {

        btnPush.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //estamos tomando lo que esta insertando y s ealmacena en data
               try {
                   int Control = data.size();
                   if (data.size()<10){
                       data.push(textTexto.getText());
                       txtMostrar.setText(data.toString());
                   }else {
                       JOptionPane.showMessageDialog(null, "Solo puedes agregar 10 Elementos");
                   }
               }catch (Exception ex) {
                   // Manejar la excepción, si ocurre, y mostrar el mensaje
                   JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
               }



            }
        });
        btnPop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //para controlar los errores meto toda  es aparte del codigo en un try / catch
                try {
                    String eliminado = data.pop();
                    JOptionPane.showMessageDialog(null, "Elimino: " + eliminado);
                    txtMostrar.setText(data.toString());
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        butCima.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cima = data.cima();
                    JOptionPane.showMessageDialog(null, "Peek o cima: "+ cima);
                    txtMostrar.setText(data.toString());

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        butSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    //Solo agrego una nueva validacion=  que haya ingresado algo en el cuadro de texto
                    String elementoBuscado = textTexto.getText().trim();
                    if (elementoBuscado.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Ingrese un elemento dentro del cuadro de texto");
                        return;
                    }
                    // continuo con el proceso del botton
                        boolean encontrado = data.search(elementoBuscado);
                    if (encontrado){
                        JOptionPane.showMessageDialog(null, "El elemento '" + elementoBuscado + "' está en la pila.");
                    } else {
                        JOptionPane.showMessageDialog(null, "El elemento '" + elementoBuscado + "' NO está en la pila.");

                    }

            }
        });
    }

    //Tercer paso importante de nunca olvidar GENERAR FORMAIN

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
