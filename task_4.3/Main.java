/*
Создать абстрактный класс Animal с характеристиками животного.
Создать класс Horse который наследуется от Animal,в классе Horse реализовать метод public void run(){ System.out.println("Игого, я поскакал(а)"); }
Создать класс Pegasus который наследуется от Horse,в классе Pegasus реализовать метод public void fly(){ System.out.println("Игого, я полетел(а)"); }
Создать объект лошади и вызвать метод run();
Создать объект пегаса и вызвать метод fly();
*/

public class Main{
    public static void main(String[] args) {
        Horse appleHorse = new Horse("Яблочко", 5, "Конь в яблоках");
        appleHorse.run();
        Pegasus unicornPegasus = new Pegasus("Единорожка",12,"Радужный");
        unicornPegasus.fly();
         } }

        abstract class Animal  {
            protected String name;
            protected int age;
            protected String color;

            public Animal(String name, int age, String color) {
                this.name = name;
                this.age = age;
                this.color = color;
            }
            
            public String getName() {return name;}
            public void setName(String name) { }
            public int getAge() { return age; }
            public void setAge(int age) { this.age = age; }
            public String getColor() { return color; }
            public void setColor(String color) { this.color = color; }
        }
            class Horse extends Animal {

                public Horse(String name, int age, String color) {
                    super(name, age, color);
                }

                public void run(){
                System.out.println(this.name+": Игого, я поскакал(а)"); }
            }

            class Pegasus extends Horse {
            public Pegasus(String name, int age, String color){
                super(name,age,color);
            }

                public void fly(){
                    System.out.println(name+": Игого, я полетел(а)"); }
            }
