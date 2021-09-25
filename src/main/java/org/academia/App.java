package org.academia;

import org.academia.Model.Books;
import org.academia.Service.BookService;
import org.academia.Service.BookServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class App {
    public static void main( String[] args ) throws ParseException {
        List<Books> listBook;
        Books libroAux;
        AbstractApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        BookService book = appContext.getBean(BookServiceImpl.class);

        listBook = book.getBooksService();
        System.out.println("Lista de Libros:");
        for (Books libro: listBook) {
            System.out.println("Titulo: " + libro.getTitle());
            System.out.println("Total de paginas: " + libro.getTotalPages());
            System.out.println("Raiting (1-10): " + libro.getRating());
            System.out.println("ISBN: " + libro.getIsbn());
            System.out.println("Fecha de Publicacion: " + libro.getPublishedDate() + "\n");
        }

        System.out.println("\nAgregando libro nuevo...");

        Books libro = new Books( 6L, "Con los pies en la tierra y la cabeza en las estrellas", 300, 10,
                "ISBN 13: 9788428511777", LocalDate.now());
        book.saveService(libro);

        System.out.println("Cantidad de libros: (Actualizado): " + book.getCountBookService() + "\n");

        listBook = book.getBooksService();
        System.out.println("Lista de Libros:");
        for (Books libro2: listBook) {
            System.out.println("Titulo: " + libro2.getTitle());
            System.out.println("Total de paginas: " + libro2.getTotalPages());
            System.out.println("Raiting (1-10): " + libro2.getRating());
            System.out.println("ISBN: " + libro2.getIsbn());
            System.out.println("Fecha de Publicacion: " + libro2.getPublishedDate() + "\n");
        }

        System.out.println("\nEliminando libro bookId:1 100 Años de Soledad...");
        book.deleteService(1L);

        System.out.println("Cantidad de libros: (Actualizado): " + book.getCountBookService() + "\n");

        listBook = book.getBooksService();
        System.out.println("Lista de Libros:");
        for (Books libro3: listBook) {
            System.out.println("Titulo: " + libro3.getTitle());
            System.out.println("Total de paginas: " + libro3.getTotalPages());
            System.out.println("Raiting (1-10): " + libro3.getRating());
            System.out.println("ISBN: " + libro3.getIsbn());
            System.out.println("Fecha de Publicacion: " + libro3.getPublishedDate() + "\n");
        }

        System.out.println("Actualizando libro bookId: 3 nuevo raiting: 10 (El principito): ");
        book.updateService(10, new Long(3));

        System.out.println("\nBusqueda libro bookId: 3 (El principito) ");
        libroAux = book.searchService(new Long(3));
        System.out.println("Titulo: " + libroAux.getTitle());
        System.out.println("Total de paginas: " + libroAux.getTotalPages());
        System.out.println("Raiting (1-10): " + libroAux.getRating());
        System.out.println("ISBN: " + libroAux.getIsbn());
        System.out.println("Fecha de Publicacion: " + libroAux.getPublishedDate() + "\n");

        (appContext).close();
    }


}
