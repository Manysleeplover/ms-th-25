package ru.romanov.tutorial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {
    public static void main(String[] args) {
        /**       НЕИНТЕРЕСНЫЕ МЕТОДЫ
         *  CopyOnWriteArraySet() - создает пустой Set
         *  CopyOnWriteArraySet(Collection<? extend E> c) - создает set, содержащиий все элементы указанной коллекции.
         *  forEach(Consumer<? super> action) -выполняет заданное действие до тех пор, пока не завершит или Exc.
         *  Эта коллекция лучше всего подходит для read-only операций, коллекций, которые достаточно малы, чтобы их
         *  скопировать, если произайдут изменяющие операции.
         *  Итераторы не поддерживают операцию remove() UnsupportedOperationException
         */
        List<String> list = new ArrayList<>();
        list.add("Прохор ");
        list.add("Георгий");
        list.add("Михаил" );
        CopyOnWriteArraySet<String> cowSet = new CopyOnWriteArraySet<>(list);

        System.out.println("Цикл с измением");

        Iterator<String> itr = cowSet.iterator();
        int cnt = 0;
        while (itr.hasNext()) {
            String name = itr.next();
            System.out.println("  " + name);
            if (++cnt == 2) {
                cowSet.add("Павел");
                name += " Иванович";
            }
        }

        System.out.println("\nЦикл без измения");
        itr = cowSet.iterator();
        while (itr.hasNext()) {
            String name = itr.next();
            System.out.println("  " + name);
        }
    }
}
