package org.iesbelen.genericos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bag<T> {
    List<T> lista = new ArrayList<T>();
    public Bag() {}

    public void add(T e){
       lista.add(e);
    }

    public int getCount(){
        int cont=0;
        for (T t : lista) {
            if (t == lista.get((Integer) t)) {
                cont++;
            }
        }
        return cont;
    }

    public void remove(T e){
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i) == e){
                lista.remove(i);
            }
        }
    }

    public int size(){
        return lista.size();
    }
    public Set<T> uniqueSet(){
        Set<T> set = new HashSet<T>();
        set.addAll(lista);
        return set;
    }

    @Override
    public String toString() {
        for (T t : lista) {
            return t.toString();
        }
        return "";
    }





}
