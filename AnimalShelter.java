import java.util.*;
import java.lang.*;

class Animal
{
  String name;   
  int order;
  
  Animal(String name)
  {
      this.name = name;
  }
  
  public void setOrder(int order)
  {
      this.order = order;
  }
  
  public boolean isOlderThan(Animal a)
  {
      return this.order < a.order;
  }
}

class Dog extends Animal{
    
    Dog(String name)
    {
        super(name);
    }
} 

class Cat extends Animal{
    
    Cat(String name)
    {
        super(name);
    }
}

public class AnimalShelter{
    
    // Not using just one queue as it less efficient
    
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    
    public int order;
    
    public void enqueue(Animal a)
    {
        order++;
        if(a != null && a instanceof Dog)
        {
            dogs.add((Dog)a);
        }
        else if(a != null && a instanceof Cat)
        {
            cats.add((Cat)a);
        }
        a.setOrder(order);
    }
    
    public Animal dequeueAny()
    {
        if(dogs.size() == 0 && cats.size() != 0)
        {
            return cats.remove();
        }
        
        if(cats.size() == 0 && dogs.size() != 0)
        {
            return dogs.remove();
        }
        
        if((dogs.peek()).isOlderThan(cats.peek()))
        {
            return dogs.remove();
        }
        
        return cats.remove();
        
    }
    
    public Dog dequeueDog()
    {
        if(dogs == null || dogs.size() == 0)
        {
            return null;
        }
        return dogs.remove();
    }
    
    public Cat dequeueCat()
    {
        if(cats == null || cats.size() == 0)
        {
            return null;
        }
        return cats.remove();
    }
    
    public static void main(String[] args)
    {
        AnimalShelter as = new AnimalShelter();
        
        as.enqueue(new Dog("Tom"));
        as.enqueue(new Cat("Wheezy"));
        as.enqueue(new Dog("Timmy"));
        as.enqueue(new Dog("Tiffy"));
        as.enqueue(new Cat("Lola"));
        
        Animal a = as.dequeueCat();
        System.out.println("Dequeued " + a.name);
        
        a = as.dequeueAny();
        System.out.println("Dequeued " + a.name);
        
        a = as.dequeueCat();
        System.out.println("Dequeued " + a.name);
        
        a = as.dequeueDog();
        System.out.println("Dequeued " + (a == null?null : a.name));
    }
}
