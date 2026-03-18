public class ProvaOperatori {
    public static void main(String[] args){
        float num = 3.14f;
        num -= .14;
        num += 1;
        num *= 42;
        num /= 123.456789;

        System.out.println(num);

        int numero = 10;
        System.out.println(numero++);   //qui PRIMA stampa DOPO incrementa
        //ora numero vale 11.
        System.out.println(++numero);   //qui PRIMA incrementa DOPO stampa

        //###############OPERATORI DI CONFRONTO#####################

        int x=1, y=2, z=3;
        System.out.println(x==y);
        System.out.println(x!=z);
        System.out.println(z>-x);
        System.out.println(y<10*x);
        //sotto: logicamente equivalente ad "IMPLICA". esempio a caso!
        System.out.println(!(x==y) || (y==z)); 
        System.out.println((x!=z) && (y-1==z+1));
    }
}
