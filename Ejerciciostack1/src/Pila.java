import java.util.Stack;

public class Pila {
    private Stack<String> coleccion ;

    public Pila(){
        coleccion = new Stack<String>();
    }
    public void push(String dato) throws Exception{

        if(dato == null || dato.trim().isEmpty()){
            throw new Exception("Necesitas ingresar algo en el texto");
        }
        coleccion.push(dato);

    }

    public String pop() throws Exception{
        if(coleccion.empty())
            throw new Exception("Error en metod pop, LA PILA EST AVACIA");
        return coleccion.pop();
    }

    public String cima() throws Exception{
        if(coleccion.empty())
            throw new Exception("Error en metod cima, LA PILA EST AVACIA");
        return coleccion.peek();
    }

    public boolean search(String elemento) {
        return coleccion.contains(elemento);
    }

    public int size (){
        return coleccion.size();
    }
    @Override
    public String toString() {
        StringBuilder listado = new StringBuilder();
        for (int i = coleccion.size()-1; i>= 0; i--){
            listado.append(coleccion.get(i)+"\n");
        }
        return listado.toString();
    }
}
