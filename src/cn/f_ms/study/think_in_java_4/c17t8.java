package cn.f_ms.study.think_in_java_4;

class c17t8 {

    static class Link<E> {

        public Link() {}
        public Link(E e, Link<E> next) {
            this.e = e;
            this.next = next;
        }

        E e;
        Link<E> next;
    }

    static class Iterator<E> {

        private Link<E> current;

        public Iterator(Link<E> link) {
            this.current = link;
        }

        boolean hasNext() {
            return current.next != null;
        }

        E next() {
            current = current.next;
            return current.e;
        }

        void add(E e) {
            current.next = new Link<>(e, current.next);
            current = current.next;
        }

        void remove() {
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
    }

    static class List<E> {
        Link<E> first = new Link<>();

        Iterator<E> iterator() {
            return new Iterator<>(first);
        }
    }

    public static void main(String[] args) {

        List<Integer> list = new List<>();

        Iterator<Integer> iterator = list.iterator();

        for (int i = 0; i < 10; i++) {
            iterator.add(i);
        }

        iterator = list.iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 5) {
                iterator.add(10);
            }
            // System.out.println(next);
        }

        iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
