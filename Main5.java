public class Main5 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.showFavoriteToy();
        
        Bird bird = new Bird();
        bird.eat();
        bird.showWingSpan();
    }
}


class Pet {
    
    void eat() {
        System.out.println("eating...");
    }
}

class Dog extends Pet {
    
    void showFavoriteToy() {
        System.out.println("Stick");
    }
}

class Bird extends Pet {
   
    void showWingSpan() {
        System.out.println("Wing span...");
    }
}


