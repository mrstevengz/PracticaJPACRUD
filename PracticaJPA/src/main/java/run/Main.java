package run;

import entities.Autor;
import services.dao.MyDao;
import services.interfaces.ICRUD;

import java.util.List;

public class Main {
    public static final ICRUD dao = new MyDao();

    public static void insertarAutor() {
        Autor autor = new Autor();
        autor.setNombre("Steven Sequeira Reyes");
        autor.setNacionalidad("Nicaraguense");
        dao.insert(autor);

        Autor autor2 = new Autor();
        autor2.setNombre("Oscar Sequeira Reyes");
        autor2.setNacionalidad("Nicaraguense");
        dao.insert(autor2);
    }

    public static void listarAutores() {
        System.out.println("Listado de Autores:");
        List<Autor> autores = dao.getAll("autores.All", Autor.class);
        autores.forEach(autor -> System.out.println(autor.getNombre()));
    }

    public static void editarAutor(){
        Autor a = new Autor();
        a = dao.findById(1, Autor.class);
        a.setNacionalidad("Estadounidense");
        dao.update(a);
    }

    public static void eliminarAutor(){
        Autor a = new Autor();
        a = dao.findById(2, Autor.class);
        dao.delete(a);
    }

    public static void main(String[] args) {
        insertarAutor();
        listarAutores();
        editarAutor();
        listarAutores();
        eliminarAutor();
        listarAutores();
    }


}
