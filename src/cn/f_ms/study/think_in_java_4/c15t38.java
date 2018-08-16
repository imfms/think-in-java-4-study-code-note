package cn.f_ms.study.think_in_java_4;

class c15t38 {

    static class Coffee {

    }

    static class Decorator extends Coffee {
        private Coffee coffee;

        Decorator(Coffee coffee) {
            this.coffee = coffee;
        }
    }

    static class Milk extends Decorator {

        Milk(Coffee coffee) {
            super(coffee);
        }

        public void milk() {

        }
    }

    static class Foam extends Decorator {

        Foam(Coffee coffee) {
            super(coffee);
        }

        public void foam() {

        }
    }

    static class Chocolate extends Decorator {

        Chocolate(Coffee coffee) {
            super(coffee);
        }

        public void chocolate() {

        }
    }

    public static void main(String[] args) {
        Coffee coffee = new Coffee();

        new Milk(coffee).milk();
        new Foam(coffee).foam();
        new Chocolate(coffee).chocolate();
    }

}
