package za.ac.cput.repository;

public interface IRepository <T, ID>
{
    T create(T entity);
    T findById(ID id);
    T update(T entity);
    void delete(T entity);
}
