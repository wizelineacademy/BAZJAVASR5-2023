# Módulos

# :hammer_and_wrench:  Requisitos

- Java 9+
- IDE
    * [Visual Studio Code](https://code.visualstudio.com/download)
    * [IntelliJ](https://www.jetbrains.com/idea/download)

# :pencil: Actividad

## Módulos de Java

Supongamos que estás construyendo una aplicación para una biblioteca y necesitas administrar libros y usuarios. Crea dos
módulos llamados "book" y "user", donde el módulo "book" se encargará de administrar la lógica relacionada con los
libros, y el módulo "user" se encargará de administrar la lógica relacionada con los usuarios.

1. Crea un nuevo proyecto Java y organiza tus archivos de la siguiente manera:
```bash
   src/  
   ├── book  
   │   ├── module-info.java  
   │   └── com/example/book  
   │       └── Book.java  
   └── user  
       ├── module-info.java   
       └── com/example/user  
           └── User.java
```
2. En el módulo "book", define el archivo module-info.java con la siguiente estructura:
```java
module book {
    exports com.example.book;
}
```
3. Dentro del paquete com.example.book, crea la clase Book en el archivo Book.java:
```   java 
package com.example.book;

public class Book {
private String title;
private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}
```
4. En el módulo "user", define el archivo module-info.java con la siguiente estructura:
```java
module user {
   requires book;
   exports com.example.user;
}
```
5. Dentro del paquete com.example.user, crea la clase User en el archivo User.java:
```java
package com.example.user;

import com.example.book.Book;

public class User {
   private String name;
   private Book borrowedBook;

   public User(String name) {
      this.name = name;
   }

   public void borrowBook(Book book) {
      borrowedBook = book;
      System.out.println(name + " has borrowed the book.");
   }

   public void displayBorrowedBookInfo() {
      if (borrowedBook != null) {
         System.out.println("Borrowed Book Info:");
         borrowedBook.displayInfo();
      } else {
         System.out.println(name + " has not borrowed any book.");
      }
   }
}
```
6. Finalmente, en la clase principal de tu proyecto, crea una instancia de Book y User para probar la funcionalidad:
```java
import com.example.book.Book;
import com.example.user.User;

public class Main {
   public static void main(String[] args) {
      Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald");
      User user = new User("John");

      user.borrowBook(book);
      user.displayBorrowedBookInfo();
   }

}
```

Con esto, has creado dos módulos independientes, "book" y "user", que pueden ser compilados y ejecutados por separado.
El módulo "user" depende del módulo "book" y puede utilizar la clase Book en su implementación. Esto te permite
organizar y encapsular la funcionalidad de cada módulo de forma modular y reutilizable.