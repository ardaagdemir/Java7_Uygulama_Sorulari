package repository;

import entity.Product;

import java.util.List;

public interface ICrud <T>{
    //gerekli metotlar yazılacak
    //ilgili claslara gönderilecek

    void getAll();
    void save(T t);
    void update(T t);
    void saveAll(List<T> t);
    void delete(int t);
    void getById(int t);

}
