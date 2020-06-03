package question69;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Vector;

public class Question {
    public static void main (String[] args) {
        Integer a = new Integer(2);
        Integer b = new Integer(2);
        System.out.println(a.hashCode() == b.hashCode() );
        Object c = new Object();
        Object d = new Object();
        System.out.println(c.hashCode()==d.hashCode());

    }
}
